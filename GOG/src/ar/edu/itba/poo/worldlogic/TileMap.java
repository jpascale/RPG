package ar.edu.itba.poo.worldlogic;

// TileMap - Singleton

public class TileMap {
	
	private static TileMap instance = null;
	
	private Tile first;
	
	
	private TileMap(){
		
		//TODO: Create tilemap algorithm
	}
	
	public TileMap getInstance(){
		if (instance == null){
			instance = new TileMap();
		}
		
		return instance;
	}
}
