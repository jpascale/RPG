package ar.edu.itba.poo.gamelogic;

import java.util.LinkedList;

public class DrawableList<T extends Drawable> implements Drawable {
	
	private LinkedList<T> drawableList;
	
	public DrawableList() {
		super();
		this.drawableList = new LinkedList<T>();
	}

	public void draw() {
		for(T drawable : drawableList){
			  drawable.draw();
		}
	}
	
	public void add(T drawable){
		drawableList.add(drawable);
	}
	
	public void remove(T drawable){
		drawableList.remove(drawable);
	}

	public LinkedList<T> getDrawableList() {
		return drawableList;
	}
	
	

}
