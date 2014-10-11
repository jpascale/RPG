package ar.edu.itba.poo.main;
import ar.edu.itba.poo.gamelogic.*;
import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.updater.StatsLevelUpUpdater;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.worldlogic.TileMap;

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
//		
//		Alive asd = new Alive(20, 100, 8, 8);
//		
//		try{
//			System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			
//			asd.move(Dir.NORTH);
//			System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			System.out.println(asd.getPos().getAlive() == null);
//			System.out.println(map.getTile(8, 8).getAlive() == null);
//			System.out.println(asd.getHeading());
//			
//			asd.move(Dir.EAST);
//			System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			System.out.println(asd.getPos().getAlive() == null);
//			System.out.println(map.getTile(8, 7).getAlive() == null);
//			System.out.println(asd.getHeading());
//			
//			asd.move(Dir.WEST);
//			System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			System.out.println(asd.getPos().getAlive() == null);
//			System.out.println(map.getTile(9, 7).getAlive() == null);
//			System.out.println(asd.getHeading());
//			
//			asd.move(Dir.SOUTH);
//			System.out.println(asd.getPos().getX() + ";" + asd.getPos().getY());
//			System.out.println(asd.getPos().getAlive() == null);
//			System.out.println(map.getTile(9, 8).getAlive() == null);
//			System.out.println(asd.getHeading());
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
	
		Game game = Game.getInstance();
		//game.set (...)
		//game.setCharacter(...);
		
		
		//game.setObserverLevelProfile(new StatsLevelUpUpdater(game));
		
		
		//*********************************************************************************
		//		Attack Test - Not done
		//*********************************************************************************
		/*
		Character player = new Character(4,4);
		player.setStrategy(new Warrior("Paladin", 5, 13));
		player.getEquip().setItem(new Item("Nudillos",1.0));
		
		Creature bicho = new Creature(50,0,5,5, 5, 10);
		
		try {
			player.move(Dir.EAST);
			System.out.println(player.getPos().getX() + ";" + player.getPos().getY());
			player.move(Dir.SOUTH);
			System.out.println(player.getPos().getX() + ";" + player.getPos().getY());
			System.out.println("HP bicho: " + bicho.getStatus().getMaxhp());
			player.attack();
			System.out.println("HP bicho: " + bicho.getStatus().getMaxhp());
		} catch (EndOfMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println(Dir.SOUTH.getOpposite());
		System.out.println(Dir.NORTH.getOpposite());
		System.out.println(Dir.WEST.getOpposite());
		System.out.println(Dir.EAST.getOpposite());
	}


	
}
