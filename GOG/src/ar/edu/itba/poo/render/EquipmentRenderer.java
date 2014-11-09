package ar.edu.itba.poo.render;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class EquipmentRenderer {
	
	private static ArrayList<String> itemNames;
	private static int equippedItem;

	private static int POSX = 640;
	private static int POSY = 90;
	private static int Y_SEPARATION = 15;
	
	/**
	 * Draws the Equipment and which of the items is equipped
	 * @param gr
	 */
	public static void render(Graphics gr){
		gr.setColor(Color.white);
		int i = 0;
		for (String name : itemNames) {
			if(equippedItem == i)
				gr.drawString(name + "  E", POSX, POSY + i*Y_SEPARATION);
			else
				gr.drawString(name, POSX, POSY + i*Y_SEPARATION);
			i++;
		}		
	}
	
	public static void setItemName(ArrayList<String> itemNames) {
		EquipmentRenderer.itemNames = itemNames;
	}

	public static void setEquipedItem(int equipedItem) {
		EquipmentRenderer.equippedItem = equipedItem;
	}
}
