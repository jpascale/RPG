package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;

import ar.edu.itba.poo.slick.Console;

//TODO
public class Equipment {
	
	public static int MAX_INVENTORY_SLOTS = 10;
	
	private ArrayList<Item> slots;
	private Item weapon;
	
	
	public Equipment() {
		weapon = new Item("Nudillos", 1.0, null);
		slots = new ArrayList<Item>();
		slots.add(0, weapon);
	}

	public void addItem(Item item){
		
		if (! (slots.size() - 1 >= MAX_INVENTORY_SLOTS)){
			slots.add(item);
			weapon = item;
			//TODO: Notify;
		}
	}

	public void removeItem(Item item) {
		if(slots.indexOf(item)!=0)
			slots.remove(item);
	}
	
	public void changeWeapon(){
		int index = slots.indexOf(weapon)+1;
		
		try {
			weapon = slots.get(index);
		} catch (IndexOutOfBoundsException e) {
			weapon = slots.get(0);
		}
		Console.add("Estas usando " + weapon.getName() + " como arma");
	}
	
	public boolean throwableWeapon(){
		return (slots.indexOf(weapon) != 0);
	}
	/*
	 *		Getters & Setters
	 */
	
	
	public Item getWeapon() {
		return weapon;
	}
	
	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}
	
	
	
}
