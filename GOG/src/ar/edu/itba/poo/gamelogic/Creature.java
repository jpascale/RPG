package ar.edu.itba.poo.gamelogic;

public class Creature extends Alive {
	
	private Item item;
	private int exp;
	private int gold;
	
	public Creature(){
		
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
