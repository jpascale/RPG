package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.gamelogic.creatures.Creature1;
import ar.edu.itba.poo.handlers.CreatureMovementHandler;
import ar.edu.itba.poo.handlers.ItemHandler;
import ar.edu.itba.poo.worldlogic.Tile;

public class ItemFactory {

	private static long itemID = 1;
	
	public static Item createItem(String name, double modifier, Tile tile){
		Item item = new Item(name, modifier, tile, itemID);
		ItemHandler observer = ItemHandler.getInstance();
		observer.addrenderer(item);
		item.addObserver(observer);
		itemID++;
		return item;
	}

}
