package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;

public class Inventory {

	public static int MAX_INVENTORY_SLOTS = 10;
	
	private int gold;
	ArrayList<Item> slots;
	
	public Inventory(){
		
	}
	
	/*
	 *		getSlot: Returns Item in the specified inventory slot
	 */
	public Item getSlot(int index) throws EmptySlotException{
		
		Item item;
		
		try{
			item = this.slots.get(index);
			return item;
		}
		catch (IndexOutOfBoundsException e){
			throw new EmptySlotException();
		}
		
	}
	
}