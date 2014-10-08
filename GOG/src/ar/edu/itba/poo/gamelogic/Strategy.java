package ar.edu.itba.poo.gamelogic;

public abstract class Strategy implements Combat {
	
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
	
	@Override
	public abstract void attack(Alive alive);

	
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
		
}
