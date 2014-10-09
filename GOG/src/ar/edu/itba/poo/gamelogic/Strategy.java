package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.Dir;

public abstract class Strategy{
	
	String name;
	private int minHit;
	private int maxHit;
	
	private final double hpmodif;
	private final double manmodif;
	
	public Strategy(String name, double hpmodif, double manmodif){
		this.name = name;
		this.hpmodif = hpmodif;
		this.manmodif = manmodif;
	}
	
	/*
	 *		Getters & Setters
	 */
	
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
	
	public int getHpmodif() {
		return minHit;
	}
	public int getManmodif() {
		return minHit;
	}
	
	public abstract void attack(Tile pos, Dir heading, Equipment equipment);
}
