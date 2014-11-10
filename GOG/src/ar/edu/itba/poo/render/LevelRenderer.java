package ar.edu.itba.poo.render;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;

public class LevelRenderer {

	private static float DRAW_LVL_X = 705;
	private static float DRAW_LVL_Y = 10;
	private static float DRAW_EXP_X = 690;
	private static float DRAW_EXP_Y = 25;
	
	private static int level;
	private static int exp;
	private static int maxexp;

	public static void set(int level, int exp, int maxexp){
		LevelRenderer.level = level;
		LevelRenderer.exp = exp;
		LevelRenderer.maxexp = maxexp;
	}
	
	/**
	 * Draws the LevelProfile.
	 */
	public static void render(Graphics gr){
		
		gr.setColor(Color.white);
		gr.drawString("Level: <" + level + ">", DRAW_LVL_X, DRAW_LVL_Y);
		
		gr.drawString("EXP: <" + exp + "/" + maxexp + ">", DRAW_EXP_X, DRAW_EXP_Y);
	}

}
