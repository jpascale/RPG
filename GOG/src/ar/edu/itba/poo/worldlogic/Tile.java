package ar.edu.itba.poo.worldlogic;
import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.gamelogic.Alive;

public class Tile {
	
	//Tile position in space
	private int x;
	private int y;
	
	//Items or Alives in this position
	private Item item;
	private Alive alive;
	
	
	public Tile(int x, int y){
		this.x = x;
		this.y = y;
		
		this.item = null;
		this.alive = null;
	}
	
}
