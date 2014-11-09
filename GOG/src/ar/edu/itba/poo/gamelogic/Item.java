package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;

import ar.edu.itba.poo.handlers.ItemHandler;
import ar.edu.itba.poo.handlers.Observable;
import ar.edu.itba.poo.handlers.Observer;
import ar.edu.itba.poo.worldlogic.Tile;

public class Item implements Observable{
	
	private String name;
	private double modifier;
	private Tile pos;
	private ArrayList<Observer> observers;
	private long ID;
	
	public Item(String name, double modifier, Tile tile, long ID) {
		this.name = name;
		this.modifier = modifier;
		this.pos = tile; 
		this.ID = ID;
	}

	/*
	 *		Getters & Setters
	 */
	
	public double getModifier() {
		return modifier;
	}

	public String getName() {
		return name;
	}

	public Tile getPos() {
		return pos;
	}

	public void setPos(Tile pos) {
		this.pos = pos;
	}
	
	public long getID() {
		return ID;
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
