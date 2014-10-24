package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;

public class Creature extends Alive implements Combat {
	
	private Item item;
	//private int exp;
	//private int gold;
	private int minHit;
	private int maxHit;
	private CreatureType type;
	
	public Creature(int hp, int man, Tile pos, int minHit, int maxHit, CreatureType ctype){
		super(hp, man, pos);
		this.minHit = minHit;
		this.maxHit = maxHit;
		this.type = ctype;
	}
	
	public void throwItem(){
		if (!this.getPos().hasItem()){
			this.getPos().setItem(item);
			item = null;
		}
	}
	
	@Override
	public void attack() {
		try {
			Tile posNext = this.getPos().getNext(this.getHeading());
			
			if(posNext.getAlive() != null){
				int damage = Alive.randInt(getMinHit(),getMaxHit());
				posNext.getAlive().receiveAttack(damage);
			}
			else{
				;//TODO if there is no creature.
			}
		} catch (EndOfMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
	}
	
	/*
	 *		Getters & Setters
	 */

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

//	public int getExp() {
//		return exp;
//	}
//
//	public void setExp(int exp) {
//		this.exp = exp;
//	}
//
//	public int getGold() {
//		return gold;
//	}
//
//	public void setGold(int gold) {
//		this.gold = gold;
//	}

	public int getMinHit() {
		return minHit;
	}

	public void setMinHit(int minHit) {
		this.minHit = minHit;
	}

	public int getMaxHit() {
		return maxHit;
	}

	public void setMaxHit(int maxHit) {
		this.maxHit = maxHit;
	}
	
	public CreatureType getType() {
		return type;
	}

	public void setType(CreatureType type) {
		this.type = type;
	}

	@Override
	public void receiveAttack(int damage) {
		super.receiveAttack(damage);
		Console.add("Has sacado " + damage + " puntos de vida.");
		if(this.getStatus().isDead()){
			//TODO notify observer to remove from frontend.
			this.getPos().freeAlive();
			Console.add("La criatura ha muerto.");
		}
	}
	
}
