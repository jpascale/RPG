package ar.edu.itba.poo.gamelogic;

import java.io.ObjectInputStream.GetField;

import ar.edu.itba.poo.handlers.CharacterMovementHandler;
import ar.edu.itba.poo.handlers.EquipmentHandler;
import ar.edu.itba.poo.handlers.LevelProfileHandler;
import ar.edu.itba.poo.handlers.StatusHandler;
import ar.edu.itba.poo.worldlogic.World;

public class GameFactory {
	
	public static void gameInitializer(Classes characterclass){
		Game game = Game.getInstance();
		Character player = game.getCharacter();
		World map = game.getWorld();
		
		if(characterclass == Classes.WARRIOR)
			player.setStrategy(new Warrior(5, 8));
		else{
			player.setStrategy(new Wizard(3, 5));
			player.getStatus().setMaxman(70);
			player.getStatus().setMinman(70);
			player.getStatus().notifyObservers();
		}
		
		player.addObserver(new CharacterMovementHandler());
		player.getStatus().addObserver(new StatusHandler(player.getStatus()));
		player.getLvl().addObserver(new LevelProfileHandler());
		player.getEquip().addObserver(new EquipmentHandler());
		player.getEquip().addItem(ItemFactory.createItem("Nudillos", 1.0, null));
		
		game.setBoss1dead(false);
		game.setBoss2dead(false);
		game.setEndgame(false);
		
		game.getCreatureList().add(CreatureFactory.createBoss1(map.getTile(35, 25)));
		game.getCreatureList().add(CreatureFactory.createBoss2(map.getTile(6, 16)));
		game.getCreatureList().add(CreatureFactory.createBoss3(map.getTile(35, 6)));
		
		map.getTile(3, 28 ).setItem(ItemFactory.createItem("Big Bad Blade", 5.0, map.getTile(3,28)));
	}
	

}
