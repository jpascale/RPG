package ar.edu.itba.poo.main;
import ar.edu.itba.poo.gamelogic.*;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.TileMap;
import ar.edu.itba.poo.worldlogic.TileMap.Dir;

public class Main {

	public static void main(String[] args) {
		
		
		//*********************************************************************************
		// Tile Test - OK
		//*********************************************************************************
		
		TileMap map = TileMap.getInstance();
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
		
		//*********************************************************************************
		//		Movement Test - OK
		//*********************************************************************************
		
//		Alive asd = new Alive();
//		
//		try{
//			asd.setPos(map.getTile(8, 8));
//			System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			
//			asd.move(Dir.NORTH);
//			System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			
//			asd.move(Dir.EAST);
//			System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			
//			asd.move(Dir.WEST);
//			System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			
//			asd.move(Dir.SOUTH);
//			System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			
//			for ( ; ; asd.move(Dir.NORTH))
//				System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			
//		} catch (Exception e) {
//			System.out.println("End of map");
//		}
		
		//*********************************************************************************
		//		Level Profile - OK
		//*********************************************************************************
		
//		LevelProfile lvl = new LevelProfile();
//		System.out.println("Level: " + lvl.getLevel() + ": " + lvl.getExp() + "/" + lvl.getMaxexp());
//		lvl.gainExp(30);
//		System.out.println(lvl.getLevel() + ": " + lvl.getExp() + "/" + lvl.getMaxexp());
//		lvl.gainExp(1000);
//		System.out.println(lvl.getLevel() + ": " + lvl.getExp() + "/" + lvl.getMaxexp());
//		lvl.gainExp(10000);
//		System.out.println(lvl.getLevel() + ": " + lvl.getExp() + "/" + lvl.getMaxexp());
//		lvl.gainExp(100000);
//		System.out.println(lvl.getLevel() + ": " + lvl.getExp() + "/" + lvl.getMaxexp());
	}

}
