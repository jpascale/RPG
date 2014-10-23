package ar.edu.itba.poo.render;

import org.newdawn.slick.Image;

import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.slick.RPG;

public class ItemRenderer {
	
	private Image image;
	private Item item;

	public ItemRenderer(Image image, Item item) {
		this.image = image;
		this.item = item;
	}
	
	public void render(){
		int X = item.getPos().getX();
		int Y = item.getPos().getY();
		
		image.draw((X-1)*RPG.SIZE, (Y-1)*RPG.SIZE+90);
	}

}
