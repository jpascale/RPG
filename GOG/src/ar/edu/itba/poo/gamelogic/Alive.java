package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.TileMap.Dir;

public class Alive {
	
	private Dir heading;
	private Status status;
	private Tile pos;

	public Alive() {
		
	}
	
	public void move(Dir dir) throws EndOfMapException{
		
		Tile next;
		
		//TODO: Personalized exception 
		try {
			next = pos.getNext(dir);
			this.pos = next;
		} catch (Exception e){
			throw new EndOfMapException();
		}
		
		this.heading = dir;
	}
		
	void receiveAttack(int damage){
		status.receiveDamage(damage);
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

	public void setPos(Tile pos) {
		this.pos = pos;
	}
	
	public Dir getHeading() {
		return this.heading;
	}
	
	public void setHeading(Dir heading){
		this.heading = heading;
	}
	
}
