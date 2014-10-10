package ar.edu.itba.poo.gamelogic;


public class Character extends Alive implements Combat{

	private static int CHAR_INITIAL_HP = 50;
	private static int CHAR_INITIAL_MAN = 0;
	
	private LevelProfile lvl;
	private Inventory inventory;
	private Type type;
	private Equipment equip;
	
	public Character(int x, int y) {
		
		super(CHAR_INITIAL_HP, CHAR_INITIAL_MAN, x, y);
		this.lvl = new LevelProfile();
		this.inventory = new Inventory();
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
	
	/* 
	 *		Observer methods
	 */
	
	public void handleUpdateStats(LevelProfile data){
		
		int hpmodif = this.getType().getHpmodif();
		int manmodif = this.getType().getManmodif();
		
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

	public Type getType() {
		return type;
	}

	public void setStrategy(Type strategy) {
		this.type = type;
	}

	@Override
	public void attack() {
		type.attack(super.getPos(),super.getHeading(),equip);
		
	}


}