package ar.edu.itba.poo.render;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ar.edu.itba.poo.worldlogic.Dir;

public class SpriteImages {
	
	private Image down;
	private Image up;
	private Image left;
	private Image right;
	
	public SpriteImages(String down, String up, String left, String right) {
		
		try {
			this.down = new Image(down);
			this.up = new Image(up);
			this.left = new Image(left);
			this.right = new Image(right);
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Image getDirection(Dir dir){
		
		switch(dir) {
			
		case SOUTH:
			return down;
			
		case EAST:
			return right;
			
		case WEST:
			return left;
			
		case NORTH:
			return up;
		}
		return down;
	}
	
	

}
