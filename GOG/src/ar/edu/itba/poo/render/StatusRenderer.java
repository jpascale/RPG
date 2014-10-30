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
	private static int posX = 480;
	private static int posYhp = 15;
	private static int posYmp = 30;
	
	public StatusRenderer(int minhp, int maxhp, int minmp, int maxmp) {
		StatusRenderer.minhp = minhp;
		StatusRenderer.maxhp = maxhp;
		StatusRenderer.minmp = minmp;
		StatusRenderer.maxmp = maxmp;
	}
	
	public static void render(Graphics gr){
		gr.setColor(Color.red);
		gr.drawRect(posX, posYhp, LENGTH, HEIGHT);
		gr.fillRect(posX, posYhp, LENGTH, HEIGHT);
		
		gr.setColor(Color.orange);
		gr.drawRect(posX, posYhp,((minhp*LENGTH) / maxhp), HEIGHT);
		gr.fillRect(posX, posYhp,((minhp*LENGTH) / maxhp), HEIGHT);
		
		gr.drawString(minhp + "/" + maxhp, posX+LENGTH, posYhp);
		
		gr.setColor(Color.blue);
		gr.drawRect(posX, posYmp, LENGTH, HEIGHT);
		gr.fillRect(posX, posYmp, LENGTH, HEIGHT);
		
		gr.setColor(Color.cyan);
		gr.drawRect(posX, posYmp,((minmp*LENGTH) / maxmp), HEIGHT);
		gr.fillRect(posX, posYmp,((minmp*LENGTH) / maxmp), HEIGHT);
		
		gr.drawString(minmp + "/" + maxmp, posX+LENGTH, posYmp);
		
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
