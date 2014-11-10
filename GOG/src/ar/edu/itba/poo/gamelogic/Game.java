package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.World;
//import ar.edu.itba.poo.updater.StatsLevelUpUpdater;

//TODO: MAKE SINGLETON

public class Game {
	
	public static int START_X = 3;
	public static int START_Y = 23;

	private static World map;
	
	private static Game instance = null;
	
	private String name;
	
	private Character character;
	private CreatureList creatures;
	
	private boolean boss1dead = false;
	private boolean boss2dead = false;
	private boolean endgame = false;
		
	
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
			character = new Character(map.getTile(START_X, START_Y));
		
		/*
		 *		Create creatures
		 */
		creatures = new CreatureList(this);
		
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

	public void reviveCharacter() {
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
	
	public CreatureList getCreatureList(){
		return creatures;
	}
	
	public boolean isBoss1dead() {
		return boss1dead;
	}

	public void setBoss1dead(boolean boss1dead) {
		this.boss1dead = boss1dead;
	}

	public boolean isBoss2dead() {
		return boss2dead;
	}

	public void setBoss2dead(boolean boss2dead) {
		this.boss2dead = boss2dead;
	}

	public boolean isEndgame() {
		return endgame;
	}

	public void setEndgame(boolean endgame) {
		this.endgame = endgame;
	}
	
}
