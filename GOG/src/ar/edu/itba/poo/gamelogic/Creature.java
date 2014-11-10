package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.Tile;

public class Creature extends Alive implements Combat {
	
	private Item item;
	private int minHit;
	private int maxHit;
	private CreatureType type;
	private int actiontimer;
	private long ID;
	
	public Creature(int hp, int man, Tile pos, int minHit, int maxHit, CreatureType ctype, long ID){
		super(hp, man, pos);
		this.minHit = minHit;
		this.maxHit = maxHit;
		this.type = ctype;
		this.actiontimer = 0;
		this.ID = ID;
	}

	public void throwItem(){
		if (!this.getPos().hasItem() && (this.getItem() != null)){
			item.setPos(this.getPos());
			this.getPos().setItem(item);
			item.notifyObservers(); 
			item = null;
		}
	}
	
	@Override
	public int attack() {
		
		int damage = 0;
		Tile posNext = this.getPos().getNext(this.getHeading());
		
		if(posNext != null && posNext.getAlive() != null){
			damage = Game.randInt(getMinHit(),getMaxHit());
			posNext.getAlive().receiveAttack(damage);
		}
		
		return damage;
			
	}
	
	/**
	 * Simple AI for the creature. Receives the time passed since last update
	 * and moves the creature if its near the character or attacks it if its next to it.
	 * 
	 * @param delta (time passed from last update)
	 * @return 
	 */
	public void AI(int delta){
		actiontimer += delta;
		
		if(actiontimer >= 500){
		
			int distance = 6;
			Character player = Game.getInstance().getCharacter();
			int Xdiff = this.getPos().getX()-player.getPos().getX();
			int Ydiff = this.getPos().getY()-player.getPos().getY();

			if(Math.abs(Xdiff)<distance && Math.abs(Ydiff)<distance){
				if(Xdiff > 0)
					move(Dir.WEST);
				else if(Xdiff < 0)
					move(Dir.EAST);
				else if(Ydiff > 0)
					move(Dir.NORTH);
				else 
					move(Dir.SOUTH);
			}

			if(getPos().getNext(getHeading()).equals(player.getPos())){
				attack();
			}
			actiontimer = 0;
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
	
	public long getID() {
		return ID;
	}
	
	/**
	 * Receives damage and if the creature dies, it throws the item 
	 * and removes the creature from the map.
	 * 
	 * @param damage integer
	 * @return true if creature dies
	 */
	@Override
	public boolean receiveAttack(int damage) {
		
		boolean ret = false;
		
		super.receiveAttack(damage);
		
		if(this.getStatus().isDead()){
			this.notifyObservers();
			this.throwItem();
			this.getPos().freeAlive();
			ret = true;
		}
		
		return ret;
	}

}
