package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;
import java.util.Random;

import ar.edu.itba.poo.render.Appearance;
import ar.edu.itba.poo.slick.RPG;
import ar.edu.itba.poo.updater.Observable;
import ar.edu.itba.poo.updater.Observer;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.Trigger;

public class Alive implements Observable{
	
	private Dir heading;
	private Status status;
	private Tile pos;
	private ArrayList<Observer> observers;

	public Alive(int hp, int man, Tile pos) {
		try{
			this.heading = Dir.SOUTH;
			this.status = new Status(hp, man);
			this.setPos(pos);
			this.observers = new ArrayList<Observer>();
		} catch(Exception e){
			;
		}
	}
	
	public void move(Dir dir) throws EndOfMapException{
		
		Tile actual;
		Tile next;
		
		actual = this.getPos();
		
		setHeading(dir);
		
		//TODO: Exception?
		try {
			
			next = actual.getNext(dir);
				
			if ((next.legalPos()) && (next.getType() != Trigger.BLOCKED)){ //TODO:Change this
				this.setPos(next);
				actual.freeAlive();
			}
		} catch (Exception e){
			throw new EndOfMapException();
		}
		
		this.notifyObservers();
		
	}
		
	public void receiveAttack(int damage){
		status.receiveDamage(damage);
			
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public void setPos(Tile pos) {
		this.pos = pos;
		pos.setAlive(this);
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
		//Notify observers
	}

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
		for (Observer observer : observers) {
			observer.handleUpdate(this);
			
		}
	}
	
}
