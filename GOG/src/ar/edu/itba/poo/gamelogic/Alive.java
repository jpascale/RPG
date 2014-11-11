package ar.edu.itba.poo.gamelogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import ar.edu.itba.poo.handlers.Observable;
import ar.edu.itba.poo.handlers.Observer;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.Trigger;

public class Alive implements Observable, Serializable{
	
	private HashSet<Observer> observers = null;
	
	private Dir heading;
	private Status status;
	private Tile pos;
	private boolean swims;

	public Alive(int hp, int man, Tile pos) {
	
			this.heading = Dir.SOUTH;
			this.status = new Status(hp, man);
			this.setPos(pos);
			this.swims = false;
	}
	
	/**
	 * Moves the alive to the next tile in the direction given.
	 * @param direction;
	 */
	public void move(Dir dir){
		
		Tile actual;
		Tile next;
		
		actual = this.getPos();
		
		setHeading(dir);
			
			next = actual.getNext(dir);
				
			if (next != null && next.legalPos()){
				if((next.getType() == Trigger.WALKABLE) ||
						((next.getType() == Trigger.WATER) && this.checkSwims())){
					this.setPos(next);
					actual.freeAlive();
				}
			}
		this.notifyObservers();
		
	}
		
	public boolean receiveAttack(int damage){
		return status.receiveDamage(damage);
	
	}
	
	
	public void setPos(Tile pos) {
		this.pos = pos;
		pos.setAlive(this);
	}
	
	/**
	 * Calculates the experience an Alive gives to the 
	 * attacker when dying. 
	 * 
	 * @param alive
	 * @return exp
	 */
	public static int calculateExp(Alive alive){
		
		int maxhp = alive.getStatus().getMaxhp();
		int maxman = alive.getStatus().getMaxman();
		
		return (maxhp + (int)((maxhp * maxman) / (maxhp + maxman)));
	}
	
	/*
	 * 		Observer methods
	 */
	
	@Override
	public void addObserver(Observer observer) {
		
		if (observers == null)
			observers = new HashSet<Observer>();
		
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.handleUpdate(this);
			
		}
	}
	
	/*
	 *		Getters & Setters
	 */
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Tile getPos() {
		return pos;
	}
	
	public Dir getHeading() {
		return this.heading;
	}
	
	public void setHeading(Dir heading){
		this.heading = heading;
		notifyObservers();
	}
	
	public boolean checkSwims() {
		return swims;
	}
	
	public void setSwims(boolean swims) {
		this.swims = swims;
	}
}