package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;

import ar.edu.itba.poo.updater.StatsLevelUpUpdater;
import ar.edu.itba.poo.worldlogic.NoSuchTileException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.World;

//TODO: MAKE SINGLETON

public class Game {
	
	private static Game instance = null;
	
	private String name;
	
	private Character character;
	private ArrayList<Creature> creatures;
	
	private World map;
	
	public static int START_X = 2;
	public static int START_Y = 2;
	
	private Game(){
		this.name = "Player";
	}
	
	public static Game getInstance(){
		
		if (instance == null){
			instance = new Game();
		}
		return instance;
	}
	
	private void reviveCharacter() throws NoSuchTileException{
		Tile start = map.getTile(START_X, START_Y);
		
		character.getPos().freeAlive();
		character.setPos(start);
		start.setAlive(character);
		character.getStatus().heal();
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
	
	public void startTileMap() throws SlickException{
		this.map = World.getInstance();
	}
	//startTileMap
	//startPlayer
}
