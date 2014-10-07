package ar.edu.itba.poo.gamelogic;

public class Character extends Alive {

	private LevelProfile lvl;
	private Inventory inventory;
	private Strategy strategy;
	
	public Character() {
		super();
		this.lvl = new LevelProfile();
		// TODO Auto-generated constructor stub
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
			inventory.slots.remove(item);
		}
		//TODO si no hay item para tirar o ya hay un item en el lugar  (exception? JP: SI)
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