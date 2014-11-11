package ar.edu.itba.poo.gamelogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import ar.edu.itba.poo.handlers.EquipmentHandler;
import ar.edu.itba.poo.handlers.ItemHandler;
import ar.edu.itba.poo.handlers.Observable;
import ar.edu.itba.poo.handlers.Observer;


//The characters inventory for weapon storing and selection.
//Has a maximum of 10 slots. First weapon added will be unremovable
//as will be the no weapon attack.
public class Equipment implements Observable, Serializable{
	
	public static int MAX_INVENTORY_SLOTS = 10;
	
	private ArrayList<Item> slots;
	private Item weapon;
	private transient HashSet<Observer> observers;
	
	
	public Equipment() {
		this.slots = new ArrayList<Item>();
		this.observers = new HashSet<Observer>();
	}

	public void addItem(Item item){
		
		if (! (slots.size() - 1 >= MAX_INVENTORY_SLOTS)){
			slots.add(item);
			weapon = item;
			item.setPos(null);
			item.notifyObservers();
			this.notifyObservers();
		}
	}

	public void removeItem(Item item) {
			slots.remove(item);
			this.notifyObservers();
	}
	
	/**
	 * Makes the character equip the next weapon in the inventory.
	 * 
	 * @return void
	 */
	public void changeWeapon(){
		int index = slots.indexOf(weapon)+1;
		
		try {
			weapon = slots.get(index);
		} catch (IndexOutOfBoundsException e) {
			weapon = slots.get(0);
		}
		this.notifyObservers();
	}
	
	public boolean throwableWeapon(){
		return (slots.indexOf(weapon) != 0);
	}
	
	public ArrayList<String> getItemNames(){
		ArrayList<String> names = new ArrayList<String>();
		for (Item each : slots) {
			names.add(each.getName());
		}
		return names;
	}
	public int getItemSlot(Item item){
		if (slots.contains(item))
			return slots.indexOf(item);
		else
			return -1;
	}
	
	public void loadEquipment(){
		observers = new HashSet<Observer>();
		observers.add(new EquipmentHandler());
		for (Item item : slots) {
			ItemHandler.getInstance().addrenderer(item);
		}
		this.notifyObservers();
	}
	
	public boolean containsItem(String name){
		for (Item item : slots) {
			if(item.getName().equals(name))
				return true;
		}
		return false;
		
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
	
	/*
	 *		Observable Methods
	 */
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);	
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.handleUpdate(this);
		}	
	}
	
	
	
}
