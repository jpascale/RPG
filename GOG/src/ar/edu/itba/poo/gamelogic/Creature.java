package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.handlers.CreatureMovementHandler;
import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;

public class Creature extends Alive implements Combat {
	
	private Item item;
	private int minHit;
	private int maxHit;
	private CreatureType type;
	private int actiontimer;
	
	public Creature(int hp, int man, Tile pos, int minHit, int maxHit, CreatureType ctype){
		super(hp, man, pos);
		this.minHit = minHit;
		this.maxHit = maxHit;
		this.type = ctype;
		this.actiontimer = 0;
		this.addObserver(new CreatureMovementHandler(getPos().getX(), getPos().getY(), type));
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
			

			this.notifyObservers();
			this.getPos().freeAlive();
			Console.add("La criatura ha muerto.");
		}
	}
	public void AI(int delta){
		actiontimer += delta;
		if(actiontimer >= 500){
			try {
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
			} catch (EndOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			actiontimer = 0;
		}
	}
	
}
