package ar.edu.itba.poo.slick;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.Trigger;
import ar.edu.itba.poo.worldlogic.World;

// GraphicMap - class World's frontend extension

public class GraphicMap {
	
	private static GraphicMap instance = null;
	private static String MAP_PATH = "data/map2.tmx";
	
	private World map;
	
	//Slick's graphic map
	private TiledMap tiledmap;

	private GraphicMap(){
		map = World.getInstance();
		
		try {
			this.tiledmap = new TiledMap(MAP_PATH);
		} catch (SlickException e) {
			// TODO: Raise error
			e.printStackTrace();
		}
		
	}
	
	public void setWorldTriggers(){
		
		int x_tiles = map.getDimX();
		int y_tiles = map.getDimY();

		for(int x = 1; x <= x_tiles; x++){
			for (int y = 1; y <= y_tiles; y++){
				
				int tileid = tiledmap.getTileId(x - 1, y - 1, 0);
				String value = tiledmap.getTileProperty(tileid, "type", "false");
				
				Tile tile = map.getTile(x, y);
				
				if (tile != null){
					switch (value){
						case "walkable":
							tile.setType(Trigger.WALKABLE);
							break;
						case "blocked":
							tile.setType(Trigger.BLOCKED);
							break;
						case "water":
							tile.setType(Trigger.WATER);
							break;
					}
				}
			}
		}
	}
	
	public static GraphicMap getInstance(){
		if (instance == null){
			instance = new GraphicMap();
		}
		
		return instance;
	}
	
	public TiledMap getTiledMap(){
		return this.tiledmap;
	}

}
