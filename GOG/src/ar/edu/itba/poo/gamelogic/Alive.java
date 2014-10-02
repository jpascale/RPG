package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.Tile;

public abstract class Alive {
	
	private Status status;
	private Tile pos;

	
	public Alive() {
		
	}
	
	public void moveNorth(){
		
	}
	
	public void moveSouth(){
		
	}
	
	public void moveEast(){
		
	}
	
	public void moveWest(){
		
	}
	
	public abstract void strategicAttack(Alive alive);
	
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

	public void setPos(Tile pos) {
		this.pos = pos;
	}
	
	
	
	
}
