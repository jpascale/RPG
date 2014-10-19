package ar.edu.itba.poo.gamelogic;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ar.edu.itba.poo.slick.RPG;
import ar.edu.itba.poo.worldlogic.Tile;

//TODO: Make Abstract
public class Item implements Drawable{
	
	private String name;
	private Image image;
	private double modifier;
	private Tile pos;
	
	public Item(String name, String ref, double modifier, Tile tile) {
		super();
		try {
			this.name = name;
			this.image = new Image(ref);
			this.modifier = modifier;
			this.pos = tile;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	@Override
	public void draw() {
		image.draw((pos.getX()-1)*RPG.SIZE, (pos.getY()-1)*RPG.SIZE);
	}
	
	
}
