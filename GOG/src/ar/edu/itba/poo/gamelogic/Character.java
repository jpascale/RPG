package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.updater.CharacterMovementObserver;
import ar.edu.itba.poo.updater.StatusObserver;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;


public class Character extends Alive implements Combat{

	private static int CHAR_INITIAL_HP = 50;
	private static int CHAR_INITIAL_MAN = 0;
	
	private LevelProfile lvl;
	private Inventory inventory;
	private Type type;
	private Equipment equip;
	
	public Character(Tile pos) {
		
		super(CHAR_INITIAL_HP, CHAR_INITIAL_MAN, pos);
		this.lvl = new LevelProfile(this);
		this.inventory = new Inventory();
		this.equip = new Equipment();
		this.addObserver(new CharacterMovementObserver());
		this.addObserver(new StatusObserver(this));
		Game.getInstance().setCharacter(this);
	}
	
	//TODO: Manage errors
	public void pickUp(){
		if (this.getPos().hasItem()){
			this.inventory.addItem(this.getPos().getItem());
			this.getPos().setItem(null);
		}
	}
	//TODO: Manage errors
	public void throwItem(Item item){
		
		if (!this.getPos().hasItem()){
			this.getPos().setItem(item);
			inventory.removeItem(item);
		}
		
	}
	
	public void gainExp(int exp){
		this.lvl.gainExp(exp);
	}
	
	@Override
	public void receiveAttack(int damage) {
		super.receiveAttack(damage);
		if(this.getStatus().isDead()){
			try {
				Game.getInstance().reviveCharacter();
			} catch (EndOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyObservers();
	}

	
	/* 
	 *		Observer methods
	 */
	
	public void handleUpdateStats(){
		
		int hpmodif = this.getType().getHpmodif();
		int manmodif = this.getType().getManmodif();
		int classmanmodif = this.getType().getClassManModif();
		
		this.getStatus().updateNextLvlStatus(hpmodif, manmodif, classmanmodif);
		notifyObservers();
				
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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
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

	@Override
	public void attack() {
			type.attack(this);
	}

}