package ar.edu.itba.poo.gamelogic;

public class Character extends Alive {

	private LevelProfile lvl;
	private Inventory inventory;
	private Strategy strategy;
	
	public Character() {
		// TODO Auto-generated constructor stub
	}
	
	public void pickUp(){
		
	}
	
	public void throwDown(){
		
	}

	public void strategicAttack(Alive alive) {
		
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

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}


}