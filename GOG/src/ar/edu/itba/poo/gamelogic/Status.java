package ar.edu.itba.poo.gamelogic;

import java.io.Serializable;
import java.util.HashSet;

import ar.edu.itba.poo.handlers.Observable;
import ar.edu.itba.poo.handlers.Observer;

public class Status implements Observable, Serializable{
	
	private HashSet<Observer> observers = null;
	
	private static int HP_DELTA_UP = 5;
	private static int MAN_DELTA_UP = 5;
	
	private int minhp;
	private int maxhp;
	private int minman;
	private int maxman;
	private boolean isdead;
	
	public Status(int hp, int man) {
		this.observers = new HashSet<Observer>();
		
		this.minhp = this.maxhp = hp;
		this.minman = this.maxman = man;
		this.isdead = false;
	}
	
	public boolean receiveDamage(int damage) {

		if (damage >= minhp){
			minhp = 0;
			isdead = true;
		}
		else 
			minhp -= damage;
		
		notifyObservers();
		
		return isdead;
	}
	
	public void heal(){
		minhp = maxhp;
		minman = maxman;
		isdead = false;
		notifyObservers();
	}
	
	public void meditate(){
		minman = maxman;
		notifyObservers();
	}
	
	public void loseMana(int mp){
		if(minman >= mp)
			minman -= mp;
		notifyObservers();
	}
	
	public void updateNextLvlStatus(int hpmodif, int manmodif, int classmanmodif) {
		
		int hpdelta = Game.randInt(hpmodif, hpmodif + HP_DELTA_UP);
		int mandelta = Game.randInt(manmodif, manmodif + MAN_DELTA_UP) * 10 * classmanmodif;
		
		this.maxhp += hpdelta;
		this.minhp += hpdelta;
		
		this.maxman += mandelta;
		this.minman += mandelta;
				
		notifyObservers();
	}
	
	@Override
	public void addObserver(Observer observer) {
		
		if (observers == null)
			observers = new HashSet<Observer>();
			
		observers.add(observer);
		notifyObservers();
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer ob: observers){
			ob.handleUpdate(this);
		}
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
	
	public boolean isDead(){
		return this.isdead;
	}
}