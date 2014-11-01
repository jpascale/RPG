package ar.edu.itba.poo.handlers;

import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.render.ItemRenderer;

public class ItemObserver implements Observer<Item> {
	
	ItemRenderer renderer;
	
	public ItemObserver(Item data) {
		renderer = new ItemRenderer();
		handleUpdate(data);
	}
	@Override
	public void handleUpdate(Item data) {
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

}
