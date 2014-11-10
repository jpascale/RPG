package ar.edu.itba.poo.render;

import java.io.Serializable;

import org.newdawn.slick.GameContainer;

import ar.edu.itba.poo.frontend.InputHandler;
import ar.edu.itba.poo.frontend.RPG;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.worldlogic.Dir;

public class CharacterRenderer implements Serializable{
	
	private static String APPEAR_PATH = "data/red2.png";
	private static Appearance appear = new Appearance(APPEAR_PATH, 16, 24);;
	
	private static int X, Y;
	private static Dir dir;
	private static boolean moving;
	

	public CharacterRenderer() {
		X = Game.START_X;
		Y = Game.START_Y;
		dir = Dir.SOUTH;
		
	}
	
	/**
	 * Draws the Character.
	 */
	public static void render(){
		appear.changeAnimation(dir);
		appear.getWalk().update(InputHandler.ACTION_INTERVAL);;
		
		if(moving)
			appear.getWalk().draw((X-1)*RPG.SIZE, (Y-1)*RPG.SIZE+82);
		else
			appear.getStay().draw((X-1)*RPG.SIZE, (Y-1)*RPG.SIZE+82);
		
	}
	
	public Appearance getAppear() {
		return appear;
	}

	public void setX(int x) {
		X = x;
	}

	public void setY(int y) {
		Y = y;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public static void setMoving(boolean moving) {
		CharacterRenderer.moving = moving;
	}
}
