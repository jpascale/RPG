package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;
import ar.edu.itba.poo.gamelogic.Character;

//TODO: MAKE SINGLETON

public class Game {
	
	private static Game instance = null;
	Character character;
	ArrayList<Creature> creatures;
	
	private Game(){
		
	}
	
	public static Game getInstance(){
		
		if (instance == null){
			instance = new Game();
		}
		return instance;
	}
	//setPlayer
}
