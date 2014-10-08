package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.observer.Observer;

public class Character extends Alive implements Observer{

	private static int CHAR_INITIAL_HP = 50;
	private static int CHAR_INITIAL_MAN = 0;
	
	private LevelProfile lvl;
	private Inventory inventory;
	private Strategy strategy;
	
	public Character(int x, int y) {
		
		super(CHAR_INITIAL_HP, CHAR_INITIAL_MAN, x, y);
		this.lvl = new LevelProfile();
		this.inventory = new Inventory();
	}
	
	public void pickUp(){
		if (this.getPos().hasItem()){
			this.inventory.addItem(this.getPos().getItem());
			this.getPos().setItem(null);
		}
		//TODO si no hay item para levantar (exception? JP:SI)
	}
	//revisar
	public void throwItem(Item item){
		
		if (!this.getPos().hasItem()){
			this.getPos().setItem(item);
			inventory.removeItem(item);
		}
		//TODO si no hay item para tirar o ya hay un item en el lugar  (exception? JP: SI)
	}

	public void strategicAttack(Alive alive) {
		
	}
	
	public void gainExp(int exp){
		this.lvl.gainExp(exp);
	}
	
	/* 
	 *		Observer methods
	 */
	
	public void handleUpdate(Object data){
		
		if (data instanceof LevelProfile)
			handleUpdateStats((LevelProfile)data);
	}
	
	public void handleUpdateStats(LevelProfile data){
		
		int hpmodif = this.getStrategy().getHpmodif();
		int manmodif = this.getStrategy().getManmodif();
		
		this.getStatus().updateNextLvlStatus(hpmodif, manmodif);
				
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