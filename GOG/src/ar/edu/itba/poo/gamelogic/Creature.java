package ar.edu.itba.poo.gamelogic;

import org.newdawn.slick.SlickException;

import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;

public class Creature extends Alive implements Combat {
	
	private Item item;
	private int exp;
	private int gold;
	private int minHit;
	private int maxHit;
	
	public Creature(int hp, int man, Tile pos, int minHit, int maxHit){
		super(hp, man, pos);
		this.minHit = minHit;
		this.maxHit = maxHit;
		this.setAppear(new Appearance("data/red2.png", 16, 24));
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
		} catch (SlickException e) {
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
	
	@Override
	public void receiveAttack(int damage) {
		super.receiveAttack(damage);
		System.out.println("Has sacado " + damage + " puntos de vida.");
		if(this.getStatus().isDead()){
			//TODO notify observer to remove from frontend.
			this.getPos().freeAlive();
			System.out.println("La criatura ha muerto.");
		}
	}
	
}
