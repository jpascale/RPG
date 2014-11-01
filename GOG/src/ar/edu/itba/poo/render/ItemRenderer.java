package ar.edu.itba.poo.render;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.slick.RPG;

public class ItemRenderer {
	
	private static ArrayList<ItemRenderer> renders = new ArrayList<ItemRenderer>();
	private static Image image;
	
	private int X, Y;
	private boolean renderable;

	public ItemRenderer() {
		try {
			this.image = new Image("data/pokeball.png");
			renders.add(this);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
