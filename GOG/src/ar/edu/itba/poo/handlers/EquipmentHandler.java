package ar.edu.itba.poo.handlers;

import java.util.ArrayList;

import ar.edu.itba.poo.gamelogic.Equipment;
import ar.edu.itba.poo.render.EquipmentRenderer;

public class EquipmentHandler implements Observer<Equipment> {
	
	public EquipmentHandler() {
		
	}

	/**
	 * Notifies the EquipmentRenderer the changes 
	 * in the Equipment. 
	 * 
	 * @param data Equipment;
	 */
	@Override
	public void handleUpdate(Equipment data) {
		ArrayList<String> names;
		int equipped;
		
		names = data.getItemNames();
		equipped = data.getItemSlot(data.getWeapon());
		
		EquipmentRenderer.setItemName(names);
		EquipmentRenderer.setEquipedItem(equipped);
	}

}
