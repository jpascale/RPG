package ar.edu.itba.poo.gamelogic;

import java.io.Serializable;
import java.util.ArrayList;

import ar.edu.itba.poo.handlers.Observable;
import ar.edu.itba.poo.handlers.Observer;

public class LevelProfile implements Observable, Serializable{
	
	private ArrayList<Observer> observers;
	
	public static int MAX_LVL = 20;
	public static int EXP_CONST = 50;
	
	private transient Character character;
	
	private int level;
	
	private int exp;
	private int maxexp;
	
	
	public LevelProfile(Character character){	
		
		this.observers = new ArrayList<Observer>();
		
		this.character = character;
		
		this.level = 1;
		this.exp = 0;
		this.maxexp = EXP_CONST;
	}
	
	public void levelUp(){
		
		if (this.level != MAX_LVL) {
			
			this.level++;
			this.exp = 0;
			this.maxexp = EXP_CONST * this.level;
				
			int hpmodif = character.getType().getHpmodif();
			int manmodif = character.getType().getManmodif();
			int classmanmodif = character.getType().getClassManModif();
				
			character.getStatus().updateNextLvlStatus(hpmodif, manmodif, classmanmodif);
			character.getStatus().heal();
			
			character.getType().updateLevelUpHit();
			
			//Not notifying because gainExp will do it
			
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
			
			notifyObservers();
		
	}
	
	/*
	 *		Observer methods
	 */

	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
		notifyObservers();
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);		
	}

	@Override
	public void notifyObservers() {
		
		for(Observer ob : this.observers){
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
	public void setCharacter(Character character){
		this.character = character;
	}
	
}
