package ar.edu.itba.poo.worldlogic;

// TileMap - Singleton

public class TileMap {
	
	private static TileMap instance = null;
	
	private static int X_TILES = 16;
	private static int Y_TILES = 16;
	
	private Tile[][] map;
	
	
	private TileMap(){
		
		map = new Tile[X_TILES][Y_TILES];
		
		for (int x = 0; x < X_TILES; x++){
			for (int y = 0; y < Y_TILES; y++){
				
				map[x][y] = new Tile(x + 1, y + 1);

			}
		}
	}
	
	public static TileMap getInstance(){
		
		if (instance == null){
			instance = new TileMap();
		}
		
		return instance;
	}
	
	public enum Dir {
		NORTH,
		SOUTH,
		EAST,
		WEST
	}
	
	//TODO: Complete doc
	
	/**
	 * @param  x	
	 * @param  y	
	 * @throws		
	 * @return      specified tile
	 * @see         ar.itba.edu.poo.gamelogic.Tile
	 */
	
	public Tile getTile(int x, int y) throws NoSuchTileException{
		
		if (x > X_TILES || y > X_TILES)
			throw new NoSuchTileException();
		
		return this.map[x - 1][y - 1];
	}
}