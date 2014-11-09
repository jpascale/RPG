package ar.edu.itba.poo.render;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class StatusRenderer {
	
	private static int minhp;
	private static int maxhp;
	private static int minmp;
	private static int maxmp;
	
	private static int LENGTH = 100;
	private static int HEIGHT = 10;
	private static int posX = 670;
	private static int posYhp = 400;
	private static int posYmp = posYhp + 30;
	
	public StatusRenderer(int minhp, int maxhp, int minmp, int maxmp) {
		StatusRenderer.minhp = minhp;
		StatusRenderer.maxhp = maxhp;
		StatusRenderer.minmp = minmp;
		StatusRenderer.maxmp = maxmp;
	}
	
	/**
	 * Draws the Status (HP, MP).
	 */
	public static void render(Graphics gr){
		gr.setColor(Color.red);
		gr.drawRect(posX, posYhp, LENGTH, HEIGHT);
		gr.fillRect(posX, posYhp, LENGTH, HEIGHT);
		
		gr.setColor(Color.orange);
		gr.drawRect(posX, posYhp,((minhp * LENGTH) / maxhp), HEIGHT);
		gr.fillRect(posX, posYhp,((minhp * LENGTH) / maxhp), HEIGHT);
		
		gr.setColor(Color.white);
		gr.drawString(minhp + "/" + maxhp, posX + 30, posYhp - 4);
		
		gr.setColor(Color.blue);
		gr.drawRect(posX, posYmp, LENGTH, HEIGHT);
		gr.fillRect(posX, posYmp, LENGTH, HEIGHT);
		
		if (minmp != 0){
			gr.setColor(Color.cyan);
			gr.drawRect(posX, posYmp,((minmp * LENGTH) / maxmp), HEIGHT);
			gr.fillRect(posX, posYmp,((minmp * LENGTH) / maxmp), HEIGHT);
		}
		gr.setColor(Color.white);
		gr.drawString(minmp + "/" + maxmp, posX + 40, posYmp - 4);
		
	}
	
	public void setMinhp(int minhp) {
		this.minhp = minhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public void setMinmp(int minmp) {
		this.minmp = minmp;
	}

	public void setMaxmp(int maxmp) {
		this.maxmp = maxmp;
	}

}
