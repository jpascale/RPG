package ar.edu.itba.poo.handlers;

import java.util.ArrayList;

import ar.edu.itba.poo.gamelogic.Equipment;
import ar.edu.itba.poo.render.EquipmentRenderer;

public class EquipmentHandler implements Observer<Equipment> {
	
	private EquipmentRenderer renderer;
	
	public EquipmentHandler() {
		renderer = new EquipmentRenderer();
	}

	@Override
	public void handleUpdate(Equipment data) {
		ArrayList<String> names;
		int equipped;
		
		names = data.getItemNames();
		equipped = data.getItemSlot(data.getWeapon());
		
		renderer.setItemName(names);
		renderer.setEquipedItem(equipped);
	}

}
