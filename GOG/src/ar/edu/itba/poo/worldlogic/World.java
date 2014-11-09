package ar.edu.itba.poo.worldlogic;

import ar.edu.itba.poo.gamelogic.Game;



public class World {
	
	private static World instance = null;
	
	private static int X_TILES = 40;
	private static int Y_TILES = 30;
	
	private Tile[][] map;
	
	
	private World(){
		
		map = new Tile[X_TILES][Y_TILES];
		
		for (int x = 0; x < X_TILES; x++){
			for (int y = 0; y < Y_TILES; y++){
				
				map[x][y] = new Tile(x + 1, y + 1);
				
			}
		}
	}
	
	
	public static World getInstance(){
		
		if (instance == null){
			instance = new World();
		}
		
		return instance;
	}
	
	
	//TODO: Complete doc
	
	/**
	 * Returns a Tile object that represents one position in the world.
	 * <p>
	 * This method always returns immediately, whether or not the 
	 * tile exists.
	 * 
	 * @param  x position
	 * @param  y position
	 * @throws		
	 * @return	
	 * @see ar.itba.edu.poo.gamelogic.Tile
	 */
	
	public Tile getTile(int x, int y){
		
		if (x > X_TILES || y > X_TILES)
			return null;
		
		return this.map[x - 1][y - 1];
	}
	
	public int getDimX(){
		return X_TILES;
	}
	public int getDimY(){
		return Y_TILES;
	}
}