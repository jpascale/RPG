package ar.edu.itba.poo.gamelogic;

import java.util.Random;

import ar.edu.itba.poo.slick.RPG;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.TileType;

public class Alive {
	
	private Dir heading;
	private Status status;
	private Tile pos;
	private Appearance appear;
	private boolean moving;

	public Alive(int hp, int man, Tile pos) {
		try{
			this.heading = Dir.NORTH;
			this.status = new Status(hp, man);
			this.setPos(pos);
		} catch(Exception e){
			;
		}
	}
	
	public void move(Dir dir) throws EndOfMapException{
		
		Tile actual;
		Tile next;
		
		actual = this.getPos();
		
		setHeading(dir);
		setMoving(true);
		
		//TODO: Exception?
		try {
			
			next = actual.getNext(dir);
				
			if ((next.legalPos()) && (next.getType() != TileType.BLOCKED)){
				this.setPos(next);
				actual.freeAlive();
			}
		} catch (Exception e){
			throw new EndOfMapException();
		}
		
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
		appear.changeAnimation(heading);
	}
	
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public Appearance getAppear() {
		return appear;
	}

	public void setAppear(Appearance appear) {
		this.appear = appear;
	}


	public void draw(){
		if(moving)
			appear.getWalk().draw((pos.getX()-1)*RPG.SIZE, (pos.getY()-1)*RPG.SIZE);
		else
			appear.getStay().draw((pos.getX()-1)*RPG.SIZE, (pos.getY()-1)*RPG.SIZE);
	}
	
}
