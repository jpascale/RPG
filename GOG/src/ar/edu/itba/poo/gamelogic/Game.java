package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;

//import ar.edu.itba.poo.updater.StatsLevelUpUpdater;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.World;

//TODO: MAKE SINGLETON

public class Game {
	
	public static int START_X = 3;
	public static int START_Y = 23;

	private static World map;
	
	private static Game instance = null;
	
	private String name;
	
	private Character character;
	private CreatureList creatures;
		
	
	private Game() {
		
		//Player name
		this.name = "Player";

		/*
		 *		World
		 */
		//Map with no triggers
		map = World.getInstance();
		
		
		/*
		 *		Create Character
		 */
		
		try {
			
			character = new Character(map.getTile(START_X, START_Y));
			character.setStrategy(new Warrior(2, 5));
			character.getEquip().setWeapon(new Item("Nudillos","data/pokeball.png", 1.0, map.getTile(1, 1)));
			
		} catch (EndOfMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setCharacter(Character character) {
		this.character = character;
	}
	
	public World getWorld(){
		return map;
	}
	
}
