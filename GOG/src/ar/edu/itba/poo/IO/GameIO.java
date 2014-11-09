package ar.edu.itba.poo.IO;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ar.edu.itba.poo.gamelogic.*;
import ar.edu.itba.poo.gamelogic.Character;
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
			
			//World
			save.writeObject(game.getWorld());
			
			save.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadGame(GameSlot slot){
		
		try{
			FileInputStream file = new FileInputStream(slot.getStreamDir());
			ObjectInputStream load = new ObjectInputStream(file);
			
			Character character = (Character) load.readObject();
			game.setCharacter(character);
			
			World map = (World) load.readObject();
			game.setMap(map);
			load.close();
			
			//TODO: SET OBSERVERS
			
		}catch (IOException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
}
