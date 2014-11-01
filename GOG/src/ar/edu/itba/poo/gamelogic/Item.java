package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.handlers.ItemObserver;
import ar.edu.itba.poo.handlers.Observable;
import ar.edu.itba.poo.handlers.Observer;
import ar.edu.itba.poo.worldlogic.Tile;

public class Item implements Observable{
	
	private String name;
	private double modifier;
	private Tile pos;
	private ItemObserver observer;
	
	public Item(String name, double modifier, Tile tile) {
			this.name = name;
			this.modifier = modifier;
			this.pos = tile; 
			this.addObserver(new ItemObserver(this));
		
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

	@Override
	public void addObserver(Observer observer) {
		this.observer = (ItemObserver) observer;
		
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observer = null;
		
	}

	@Override
	public void notifyObservers() {
		observer.handleUpdate(this);
		
	}
	
	
}
