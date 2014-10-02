package ar.edu.itba.poo.gamelogic;

public class Status {
	
	private int minhp;
	private int maxhp;
	private int minman;
	private int maxman;
	private boolean isdead;
	
	public Status(){
		
	}

	public boolean isDead(){
		return this.isdead;
	}

	/*
	 *		Getters & Setters
	 */

	public int getMinhp() {
		return minhp;
	}

	public int getMaxhp() {
		return maxhp;
	}

	public int getMinman() {
		return minman;
	}

	public int getMaxman() {
		return maxman;
	}

	public void setMinhp(int minhp) {
		this.minhp = minhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public void setMinman(int minman) {
		this.minman = minman;
	}

	public void setMaxman(int maxman) {
		this.maxman = maxman;
	}
	
}
