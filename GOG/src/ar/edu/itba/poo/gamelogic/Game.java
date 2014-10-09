package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;

import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.worldlogic.TileMap;

//TODO: MAKE SINGLETON

public class Game {
	
	private static Game instance = null;
	
	private String name;
	
	private Character character;
	private ArrayList<Creature> creatures;
	
	private TileMap map;
	
	private Game(){
		this.name = "Player";
	}
	
	public static Game getInstance(){
		
		if (instance == null){
			instance = new Game();
		}
		return instance;
	}
	
	public Character getCharacter(){
		return this.character;
	}
	//startTileMap
	//startPlayer
}
