package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.TileMap.Dir;

public class Creature extends Alive implements Combat {
	
	private Item item;
	private int exp;
	private int gold;
	private int minHit;
	private int maxHit;
	
	public Creature(int hp, int man, int x, int y){
		super(hp, man, x, y);
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
	public void attack(Tile pos, Dir heading, Equipment equipment) {
		try {
			if(!pos.getNext(heading).legalPos()){
				pos.getNext(heading).getAlive().receiveAttack((int) Math.round(Alive.randInt(this.getMinHit(),this.getMaxHit())*equipment.getWeapon().getModifier()));
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
	
}
