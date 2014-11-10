package ar.edu.itba.poo.gamelogic;

import java.io.Serializable;


public abstract class Type implements Serializable{
	
	private String name;
	private int minHit;
	private int maxHit;
	
	private final double hpmodif;
	private final double manmodif;
	
	private int classmanmodif;
	private Classes strategytype;
	
	
	public Type (String name, double hpmodif, double manmodif, int minHit, int maxHit, int classmanmodif, Classes strategytype){
		this.name = name;
		this.hpmodif = hpmodif;
		this.manmodif = manmodif;
		this.minHit = minHit;
		this.maxHit = maxHit;
		this.classmanmodif = classmanmodif;
		this.strategytype = strategytype;
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
	public int getClassManModif(){
		return classmanmodif;
	}
	public Classes getType() {
		return strategytype;
	}
	

	public abstract void attack(Character attacker); 
	public abstract void updateLevelUpHit();

}
