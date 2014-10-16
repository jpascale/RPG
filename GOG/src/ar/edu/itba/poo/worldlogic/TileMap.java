package ar.edu.itba.poo.worldlogic;

import org.newdawn.slick.tiled.TiledMap;

// TileMap - Singleton

public class TileMap {
	
	private static TileMap instance = null;
	
	private static int X_TILES = 40;
	private static int Y_TILES = 30;
	
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
	
	//TODO Check how to mix it up with the constructor without
	//     compromising the singleton
	public void fillmaptype(TiledMap tmap){
		if (instance != null){
			for (int x = 0; x < X_TILES; x++){
				for (int y = 0; y < Y_TILES; y++){
				
					int tileID = tmap.getTileId(x, y, 0);
					String value = tmap.getTileProperty(tileID, "type", "false");
               
					switch (value){
                		case "walkable":
                			map[x][y].setType(TileType.WALKABLE);
                			break;
                		case "blocked":
                			map[x][y].setType(TileType.BLOCKED);
                			break;
                		case "water":
                			map[x][y].setType(TileType.WATER);
                			break;
					}
				}
			}
		}	
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