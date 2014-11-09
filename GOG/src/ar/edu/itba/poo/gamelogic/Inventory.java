package ar.edu.itba.poo.gamelogic;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {

	public static int MAX_INVENTORY_SLOTS = 10;
	
	private ArrayList<Item> slots;
	
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
	
	public void addItem(Item item){
		
		if (! (slots.size() - 1 >= MAX_INVENTORY_SLOTS)){
			slots.add(item);
			item.setPos(null);
			System.out.println("la pos del item es" + item.getPos());
			item.notifyObservers();
		}
	}

	public void removeItem(Item item) {
		slots.remove(item);
	}
	
}
