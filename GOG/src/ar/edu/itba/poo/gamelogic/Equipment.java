package ar.edu.itba.poo.gamelogic;

import java.util.ArrayList;

import ar.edu.itba.poo.handlers.EquipmentHandler;
import ar.edu.itba.poo.handlers.Observable;
import ar.edu.itba.poo.handlers.Observer;
import ar.edu.itba.poo.slick.Console;

//TODO
public class Equipment implements Observable{
	
	public static int MAX_INVENTORY_SLOTS = 10;
	
	private ArrayList<Item> slots;
	private Item weapon;
	private ArrayList<Observer> observers;
	
	
	public Equipment() {
		this.slots = new ArrayList<Item>();
		this.observers = new ArrayList<Observer>();
	}

	public void addItem(Item item){
		
		if (! (slots.size() - 1 >= MAX_INVENTORY_SLOTS)){
			slots.add(item);
			weapon = item;
			item.setPos(null);
			item.notifyObservers();
			this.notifyObservers();
			
			//TODO: Notify;
		}
	}

	public void removeItem(Item item) {
		if(slots.indexOf(item)!=0)
			slots.remove(item);
			this.notifyObservers();
	}
	
	public void changeWeapon(){
		int index = slots.indexOf(weapon)+1;
		
		try {
			weapon = slots.get(index);
		} catch (IndexOutOfBoundsException e) {
			weapon = slots.get(0);
		}
		this.notifyObservers();
		Console.add("Estas usando " + weapon.getName() + " como arma");
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
		return slots.indexOf(item);
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
