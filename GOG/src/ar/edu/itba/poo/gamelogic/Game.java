package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;

//import ar.edu.itba.poo.updater.StatsLevelUpUpdater;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.World;

//TODO: MAKE SINGLETON

public class Game {
	
	private static Game instance = null;
	
	private String name;
	
	private Character character;
	private CreatureList creatures;
	
	private World map;
	
	public static int START_X = 3;
	public static int START_Y = 23;
	
	private Game(){
		this.name = "Player";
	}
	
	public static Game getInstance(){
		
		if (instance == null){
			instance = new Game();
		}
		return instance;
	}
	
	public void setMap(World map) {
		this.map = map;
	}

	public void reviveCharacter() throws EndOfMapException{
		Tile start = map.getTile(START_X, START_Y);
		
		character.getPos().freeAlive();
		character.setPos(start);
		start.setAlive(character);
		character.getStatus().heal();
	}
	
	public Character getCharacter(){
		return this.character;
	}
	
	//public void setObserverLevelProfile(StatsLevelUpUpdater observer){
	//	getCharacter().getLvl().addObserver(observer);
	//}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setCharacter(Character character) {
		this.character = character;
	}
	
	public void startTileMap() throws SlickException{
		this.map = World.getInstance();
	}
	//startTileMap
	//startPlayer
}
