package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;

import ar.edu.itba.poo.handlers.Observable;
import ar.edu.itba.poo.handlers.Observer;

public class LevelProfile implements Observable {
	
	public static int MAX_LVL = 47;
	public static int EXP_CONST = 50;
	
	ArrayList<Observer> observers;
	
	private int level;
	
	private int exp;
	private int maxexp;
	
	public LevelProfile(){
		observers = new ArrayList<Observer>();
		
		this.level = 1;
		this.exp = 0;
		this.maxexp = EXP_CONST;
	}
	
	public void levelUp(){
		if (this.level != MAX_LVL) {
			this.level++;
			this.exp = 0;
			this.maxexp = EXP_CONST * this.level;
			
			//Level up, time to update stats!
			notifyObservers();
		}
	}
	
	public void gainExp(int exp){

			
			//Leveling up many times with much exp
			while (this.maxexp - this.exp <= exp){
				exp -= (this.maxexp - this.exp);
				levelUp();
			}
			
			if (this.level != MAX_LVL)
				this.exp += exp;
			
			//TODO: notify observer
		
	}
	
	/*
	 *		Observer methods
	 */
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		
		for (Observer ob : this.observers){
			ob.handleUpdate(this);
		}
	}
	
	
	/*
	 *		Getters & Setters
	 */

	public int getLevel() {
		return level;
	}

	public int getExp() {
		return exp;
	}

	public int getMaxexp() {
		return maxexp;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setMaxexp(int maxexp) {
		this.maxexp = maxexp;
	}

	
}
