package ar.edu.itba.poo.gamelogic;

//TODO: Make Abstract
public class Item {
	
	private String name;
	private double modifier;
	
	public Item(String name, double modifier) {
		super();
		this.name = name;
		this.modifier = modifier;
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
	
	
}
