package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.handlers.CharacterMovementHandler;
import ar.edu.itba.poo.handlers.StatusHandler;
import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;


public class Character extends Alive implements Combat{

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
	
	//TODO: Manage errors
	public void itemAction(){
		if (this.getPos().hasItem()){
			Item item = this.getPos().getItem();
			this.equip.addItem(item);
			this.getPos().setItem(null);
			Console.add("Has levantado el arma " + item.getName());
		}
		else if(!equip.throwableWeapon())
			Console.add("No tiene un arma seleccionada para tirar");
		else{
			Item weapon = equip.getWeapon();
			this.getPos().setItem(weapon);
			weapon.setPos(this.getPos());
			weapon.notifyObservers();
			equip.changeWeapon();
			equip.removeItem(weapon);
			Console.add("Has tirado el arma " + weapon.getName());
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
		this.getStatus().heal();
				
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
	

	@Override
	public void attack() {
			type.attack(this);
	}

}