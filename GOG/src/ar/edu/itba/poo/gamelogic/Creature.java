package ar.edu.itba.poo.gamelogic;

import java.util.Random;

public class Creature extends Alive implements Combat {
	
	private Item item;
	private int exp;
	private int gold;
	
	public Creature(){
		
	}
	
	public void throwItem(){
		if (!this.getPos().hasItem()){
			this.getPos().setItem(item);
			item = null;
		}
		//TODO si no hay item para tirar o ya hay un item en el lugar  (exception?)
	}
	
	//TODO arreglar attack
	
	@Override
	public void attack(Alive alive) {
	//	alive.receiveAttack(randInt(this.getMinHit(),this.getMaxHit()));
	}
	/*
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	*/
	
	/*
	 *		Getters & Setters
	 */

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
}
