package ar.edu.itba.poo.gamelogic;

import java.io.Serializable;


public abstract class Type implements Serializable{
	
	private int minHit;
	private int maxHit;
	
	private final double hpmodif;
	private final double manmodif;
	
	private int classmanmodif;
	private Classes classtype;
	
	
	public Type (Classes type, double hpmodif, double manmodif, int minHit, int maxHit, int classmanmodif){
		
		this.classtype = type;
		this.hpmodif = hpmodif;
		this.manmodif = manmodif;
		this.minHit = minHit;
		this.maxHit = maxHit;
		this.classmanmodif = classmanmodif;
	}
	
	
	public abstract int attack(Character attacker);
	
	public abstract void updateLevelUpHit();

	
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
	public int getClassManModif(){
		return classmanmodif;
	}
	public Classes getClassType() {
		return classtype;
	}
	

}
