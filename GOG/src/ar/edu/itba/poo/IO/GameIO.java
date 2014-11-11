package ar.edu.itba.poo.IO;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.gamelogic.CreatureFactory;
import ar.edu.itba.poo.gamelogic.CreatureList;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.ItemFactory;
import ar.edu.itba.poo.handlers.StatusHandler;
import ar.edu.itba.poo.worldlogic.World;


public class GameIO {
	

	public static Game game;

	public static void setGame(Game game){
		GameIO.game = game;
	}
	
	public static void saveGame(GameSlot slot){
		
		Character character = game.getCharacter();
	
		
		try {

			FileOutputStream file = new FileOutputStream(slot.getStreamDir());
			ObjectOutputStream save = new ObjectOutputStream(file);
			
			//Character
			save.writeObject(character);
			
			//Booleans
			save.writeBoolean(game.isBoss1dead());
			save.writeBoolean(game.isBoss2dead());
			save.writeBoolean(game.isEndgame());
			
			save.writeLong(ItemFactory.getItemID());
			
			save.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadGame(GameSlot slot){
		
		try{
			FileInputStream file = new FileInputStream(slot.getStreamDir());
			ObjectInputStream load = new ObjectInputStream(file);
			
			Game game = Game.getInstance();
			Character character = (Character) load.readObject();
			game.setCharacter(character);
			
			World map = game.getWorld();
			
			boolean boss1dead = load.readBoolean();
			game.setBoss1dead(boss1dead);
			
			boolean boss2dead = load.readBoolean();
			game.setBoss2dead(boss2dead);
			
			boolean endgame = load.readBoolean();
			game.setEndgame(endgame);
			
			long itemid = load.readLong();
			ItemFactory.setItemID(itemid);
			
			load.close();
			
			character.getPos().setAlive(character);
			
			character.getStatus().addObserver(new StatusHandler(character.getStatus()));
			character.getEquip().loadEquipment();
			character.setLevelProfileCharacter();
			
			character.notifyObservers();
			character.getLvl().notifyObservers();
			character.getStatus().notifyObservers();
			
			game.setCreatures(new CreatureList(game));
			
			//Create Bosses
			if(!game.isBoss1dead())
				game.getCreatureList().add(CreatureFactory.createBoss1(map.getTile(35, 25)));
			
			if(!game.isBoss2dead())
				game.getCreatureList().add(CreatureFactory.createBoss2(map.getTile(6, 16)));
			
			game.getCreatureList().add(CreatureFactory.createBoss3(map.getTile(35, 6)));
			
			if(!character.getEquip().containsItem("Big Bad Blade"))
				map.getTile(3, 28 ).setItem(ItemFactory.createItem("Big Bad Blade", 5.0, map.getTile(3,28)));
			
			
		}catch (IOException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
}
