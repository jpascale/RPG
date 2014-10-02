package ar.edu.itba.poo.gamelogic;

public class Strategy {
	
	private int minHit;
	private int maxHit;
	
	public Strategy(){
		
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
	
}
