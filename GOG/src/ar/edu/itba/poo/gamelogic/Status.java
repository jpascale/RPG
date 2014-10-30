package ar.edu.itba.poo.gamelogic;

public class Status {
	
	private static int HP_DELTA_UP = 5;
	private static int MAN_DELTA_UP = 5;
	
	private int minhp;
	private int maxhp;
	private int minman;
	private int maxman;
	private boolean isdead;
	
	public Status(int hp, int man) {
		this.minhp = this.maxhp = hp;
		this.minman = this.maxman = man;
		this.isdead = false;
	}

	public boolean isDead(){
		return this.isdead;
	}
	
	public void receiveDamage(int damage) {
		
		if (damage >= minhp){
			minhp = 0;
			isdead = true;
		}
		else 
			minhp -= damage;
	}
	
	public void heal(){
		minhp = maxhp;
		minman = maxman;
		isdead = false;
	}
	public void loseMana(int mp){
		if(minman >= mp)
			minman-=mp;
	}
	
	public void updateNextLvlStatus(int hpmodif, int manmodif) {
		
		int hpdelta = Alive.randInt(hpmodif, hpmodif + HP_DELTA_UP);
		int mandelta = Alive.randInt(manmodif, manmodif + MAN_DELTA_UP) * 10;
		
		this.maxhp += hpdelta;
		this.minhp += hpdelta;
		
		this.maxman += mandelta;
		this.minman += mandelta;
				
		//TODO:Update visual
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
