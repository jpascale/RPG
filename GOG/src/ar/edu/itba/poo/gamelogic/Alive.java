package ar.edu.itba.poo.gamelogic;

import java.util.Random;

import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.TileMap;
import ar.edu.itba.poo.worldlogic.Dir;

public class Alive {
	
	private Dir heading;
	private Status status;
	private Tile pos;

	public Alive(int hp, int man, int x, int y) {
		try{
			this.heading = Dir.NORTH;
			this.status = new Status(hp, man);
			this.setPos(TileMap.getInstance().getTile(x, y));
		} catch(Exception e){
			;
		}
	}
	
	public void move(Dir dir) throws EndOfMapException{
		
		Tile actual;
		Tile next;
		
		actual = this.getPos();
		
		this.heading = dir;
		
		//TODO: Exception?
		try {
			
			next = actual.getNext(dir);
				
			if (next.legalPos()){
				this.setPos(next);
				actual.freeAlive();
			}
		} catch (Exception e){
			throw new EndOfMapException();
		}
		
	}
		
	void receiveAttack(int damage){
		status.receiveDamage(damage);
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
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
		pos.setAlive(this);
	}
	
	public Dir getHeading() {
		return this.heading;
	}
	
	public void setHeading(Dir heading){
		this.heading = heading;
	}
	
}
