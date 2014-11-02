package ar.edu.itba.poo.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ar.edu.itba.poo.gamelogic.*;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.Character;


public class GameIO {
	
	private static String SPLIT = "!¬";
	private static String END = "%&/\n";
	public static Game game;

	public static void setGame(Game game){
		GameIO.game = game;
	}
	
	public static void saveGame(){
		
	Character character = game.getCharacter();
	
		
		try {
			 
			StringBuffer bff = new StringBuffer();
			
			File file = new File("save.gog");
 
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);			
			
			/*
			 * 		Save Character
			 */
			
			//Heading
			bff.append(character.getHeading() + END);
			bw.write(bff.toString());
			
			//status
			bff = new StringBuffer();
			Status st = character.getStatus();
			bff.append(st.getMinhp() + SPLIT);
			bff.append(st.getMaxhp() + SPLIT);
			bff.append(st.getMinman() + SPLIT);
			bff.append(st.getMaxman() + SPLIT);
			bff.append(st.isDead() + SPLIT);
			bff.append(END);
			
			bw.write(bff.toString());
			
			//POS
			
			
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
