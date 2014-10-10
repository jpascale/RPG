package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;

import ar.edu.itba.poo.handlers.StatsLevelUpUpdater;
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
	
	public void setObserverLevelProfile(StatsLevelUpUpdater observer){
		getCharacter().getLvl().addObserver(observer);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void startTileMap(){
		this.map = TileMap.getInstance();
	}
	//startTileMap
	//startPlayer
}
