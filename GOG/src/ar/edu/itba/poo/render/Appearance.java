package ar.edu.itba.poo.render;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import ar.edu.itba.poo.slick.InputHandler;
import ar.edu.itba.poo.slick.RPG;
import ar.edu.itba.poo.worldlogic.Dir;

public class Appearance {
	
	private SpriteSheet sheet;
	
	private Animation walk;
	private Image stay;
	
	private Animation animDown;
	private Animation animLeft;
	private Animation animRight;
	private Animation animUp;

	
	//TODO: Check throws SlickException
	public Appearance(String ref, int tw, int th){
		
		try {
			sheet = new SpriteSheet( ref, tw, th);
			animDown = new Animation(sheet, 0, 0, 3, 0, true, InputHandler.ACTION_INTERVAL/4, false);
			animLeft = new Animation(sheet, 0, 1, 3, 1, true, InputHandler.ACTION_INTERVAL/4, false);
			animRight = new Animation(sheet, 0, 2, 3, 2, true, InputHandler.ACTION_INTERVAL/4, false);
			animUp = new Animation(sheet, 0, 3, 3, 3, true, InputHandler.ACTION_INTERVAL/4, false);
			stay = sheet.getSprite(0, 0);
			walk = animDown;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void changeAnimation(Dir dir){
		switch(dir) {
			
		case SOUTH:
			walk = animDown;
			stay =	sheet.getSprite(0, 0);
			break;
			
		case EAST:
			walk = animRight;
			stay =	sheet.getSprite(0, 2);
			break;
			
		case WEST:
			walk = animLeft;
			stay = sheet.getSprite(0, 1);
			break;
			
		case NORTH:
			walk = animUp;
			stay = sheet.getSprite(0, 3);
			break;
		}
	}
	
	public Animation getWalk() {
		return walk;
	}

	public Image getStay() {
		return stay;
	}

}
