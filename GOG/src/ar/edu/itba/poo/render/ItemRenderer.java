package ar.edu.itba.poo.render;

import java.util.HashSet;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ar.edu.itba.poo.slick.RPG;

public class ItemRenderer {
	
	private static HashSet<ItemRenderer> renders = new HashSet<ItemRenderer>();
	private static Image image;
	
	private int X, Y;
	private boolean renderable;
	private long ID;

	public ItemRenderer(long ID) {
		this.ID = ID;
		try {
			this.image = new Image("data/pokeball.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void addRenderer(ItemRenderer renderer){
		renders.add(renderer);
	}
	
	public static ItemRenderer getRenderer(long creatureID){
		for (ItemRenderer render : renders) {
			if(render.ID == creatureID)
				return render;
		}
		return null;
	}
	/**
	 * Draws the items.
	 */
	public static void render(){
		for (ItemRenderer item : renders) {
			if(item.renderable){
				image.draw((item.X-1)*RPG.SIZE, (item.Y-1)*RPG.SIZE+90);
			}
		}	
	}
	
	public void setRenderable(boolean renderable) {
		this.renderable = renderable;
	}

	public void setX(int x) {
		X = x;
	}

	public void setY(int y) {
		Y = y;
	}

}
