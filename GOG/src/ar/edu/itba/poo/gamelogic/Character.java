package ar.edu.itba.poo.gamelogic;


import java.io.Serializable;

import ar.edu.itba.poo.worldlogic.Tile;


public class Character extends Alive implements Combat, Serializable {

	private static int CHAR_INITIAL_HP = 80;
	private static int CHAR_INITIAL_MAN = 0;
	
	private LevelProfile lvl;
	private Type type;
	private Equipment equip;
	

	public Character(Tile pos) {
		
		super(CHAR_INITIAL_HP, CHAR_INITIAL_MAN, pos);
		this.lvl = new LevelProfile(this);
		this.equip = new Equipment();
	}
	

	/**
	 * Picks up an item if its on the tile, else it throws down the equipped item. 
	 */
	public boolean itemAction(){
		
		boolean itemaction = false;
		if (this.getPos().hasItem()){
			
			Item item = this.getPos().getItem();
			this.equip.addItem(item);
			this.getPos().setItem(null);
			itemaction = true;
		}
		else if(!equip.throwableWeapon())
			itemaction = false;
		else{
			Item weapon = equip.getWeapon();
			
			this.getPos().setItem(weapon);
			weapon.setPos(this.getPos());
			weapon.notifyObservers();
			
			equip.changeWeapon();
			equip.removeItem(weapon);
			itemaction = true;
		}
		
		return itemaction;
	}
	
	public void gainExp(int exp){
		this.lvl.gainExp(exp);
	}
	
	/**
	 * Receives damage and revives the character if it dies.
	 * @param damage integer
	 */
	@Override
	public boolean receiveAttack(int damage) {
		
		boolean ret = false;
		
		super.receiveAttack(damage);
		
		if(this.getStatus().isDead()){
			Game.getInstance().reviveCharacter();
			ret = true;
		}
		notifyObservers();
		
		return ret;
	}

	
	/*
	 *		Getters & Setters
	 */
	
	public LevelProfile getLvl() {
		return lvl;
	}

	public void setLvl(LevelProfile lvl) {
		this.lvl = lvl;
	}

	public Type getType() {
		return type;
	}

	public void setStrategy(Type strategy) {
		this.type = strategy;
	}

	public Equipment getEquip() {
		return equip;
	}
	
	public void setLevelProfileCharacter(){
		lvl.setCharacter(this);
	}

	@Override
	public int attack() {
		return type.attack(this);
	}

}