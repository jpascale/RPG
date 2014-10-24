package ar.edu.itba.poo.worldlogic;
import ar.edu.itba.poo.gamelogic.Alive;
import ar.edu.itba.poo.gamelogic.Item;

public class Tile {
	
	//Tile position in space
	private int x;
	private int y;
	
	//Items or Alives in this position
	private Item item;
	private Alive alive;
	
	private Trigger trigger;
	
	
	public Tile(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.item = null;
		this.alive = null;
		
		this.trigger= Trigger.WALKABLE;
	}
	
	public Tile getNext(Dir dir) throws EndOfMapException{
		
		int x_delta = 0;
		int y_delta = 0;
		Tile next;
		
		switch(dir) {
			
			case NORTH:
				x_delta = 0;
				y_delta = -1;
				break;
				
			case SOUTH:
				x_delta = 0;
				y_delta = 1;
				break;
				
			case EAST:
				x_delta = 1;
				y_delta = 0;
				break;
				
			case WEST:
				x_delta = -1;
				y_delta = 0;
				break;
		}
		
		try{
			next = World.getInstance().getTile(this.x + x_delta, this.y + y_delta);
			return next;
		} catch (EndOfMapException e) {
			throw new EndOfMapException();
		}
		
	}
	
	/*
	 *	This method makes sense because a tile could be
	 *	Illegal for other reason than having an Alive.
	 */
	public boolean hasAlive(){
		return alive != null;
	}
	
	public boolean legalPos(){
		return !hasAlive();
	}
	
	public boolean hasItem(){
		return !(item == null);
	}
	
	/*
	 *		Getters & Setters
	 */
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
		//TODO: Notify.
	}

	public Trigger getType() {
		return trigger;
	}

	public void setType(Trigger trigger) {
		this.trigger = trigger;
	}

	public Alive getAlive() {
		return alive;
	}

	public void setAlive(Alive alive) {
		this.alive = alive;
	}
	
	public void freeAlive(){
		this.setAlive(null);
	}
	
}
