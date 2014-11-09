package ar.edu.itba.poo.handlers;

import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.render.ItemRenderer;

public class ItemHandler implements Observer<Item> {
	
	static ItemHandler instance;

	public static ItemHandler getInstance() {
		if(instance == null)
			instance = new ItemHandler();
		return instance;
	}
	
	/**
	 * Notifies the CharacterRenderer if the item
	 * should be rendered and over which tile. 
	 * 
	 * @param data Item;
	 */
	@Override
	public void handleUpdate(Item data) {
		ItemRenderer renderer = ItemRenderer.getRenderer(data.getID());
		
		if(data.getPos()==null){
			renderer.setRenderable(false);
			renderer.setX(-1);
			renderer.setY(-1);
		}
		else{
			renderer.setRenderable(true);
			renderer.setX(data.getPos().getX());
			renderer.setY(data.getPos().getY());
		}
	}
	
	public void addrenderer(Item data){
		ItemRenderer.addRenderer(new ItemRenderer(data.getID()));
		handleUpdate(data);
	}
}
