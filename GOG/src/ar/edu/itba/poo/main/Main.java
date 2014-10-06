package ar.edu.itba.poo.main;
import ar.edu.itba.poo.gamelogic.*;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.TileMap;
import ar.edu.itba.poo.worldlogic.TileMap.Dir;

public class Main {

	public static void main(String[] args) {
		
		
		//
		// Tile Test - OK
		//
		
//		TileMap map = TileMap.getInstance();
//		
//		try{
//			Tile tile = map.getTile(8,8);
//			System.out.println("(" + tile.getX() + "," + tile.getY() +")");
//			System.out.println("Get next NORTH");
//			tile = tile.getNext(Dir.NORTH);
//			System.out.println("(" + tile.getX() + "," + tile.getY() +")");
//			System.out.println("Get next EAST");
//			tile = tile.getNext(Dir.EAST);
//			System.out.println("(" + tile.getX() + "," + tile.getY() +")");
//			System.out.println("Get next SOUTH");
//			tile = tile.getNext(Dir.SOUTH);
//			System.out.println("(" + tile.getX() + "," + tile.getY() +")");
//			System.out.println("Get next WEST");
//			tile = tile.getNext(Dir.WEST);
//			System.out.println("(" + tile.getX() + "," + tile.getY() +")");
//			
//			System.out.println("Exception:");
//			for (; ; tile = tile.getNext(Dir.SOUTH))
//				System.out.println("1");
//			
//		} catch (Exception e) {
//			System.out.println("End of map");
//		}
	}

}
