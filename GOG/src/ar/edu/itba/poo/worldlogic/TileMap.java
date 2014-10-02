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
			for (int y = 0; y > Y_TILES; y++){
				
				map[x][y] = new Tile(x + 1, y + 1);

			}
		}
	}
	
	public TileMap getInstance(){
		
		if (instance == null){
			instance = new TileMap();
		}
		
		return instance;
	}
}
