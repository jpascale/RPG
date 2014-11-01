package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.Tile;

//TODO: Make Abstract
public class Item {
	
	private String name;
	private double modifier;
	private Tile pos;
	
	public Item(String name, double modifier, Tile tile) {
			this.name = name;
			this.modifier = modifier;
			this.pos = tile; 
		
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
	
	
}
