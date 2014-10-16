package ar.edu.itba.poo.gamelogic;


public abstract class Type{
	
	private String name;
	private int minHit;
	private int maxHit;
	
	private final double hpmodif;
	private final double manmodif;
	
	
	public Type (String name, double hpmodif, double manmodif, int minHit, int maxHit){
		this.name = name;
		this.hpmodif = hpmodif;
		this.manmodif = manmodif;
		this.minHit = minHit;
		this.maxHit = maxHit;
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
	
	public abstract void attack(Character attacker); 
}
