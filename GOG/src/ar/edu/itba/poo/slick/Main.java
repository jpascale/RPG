package ar.edu.itba.poo.slick;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) throws SlickException {
		RPG rpg = new RPG("GOG");
		AppGameContainer gc = new AppGameContainer(rpg);
		
		gc.setDisplayMode(640, 570, false);
		gc.setTargetFrameRate(60);
		gc.setShowFPS(false);
		gc.start();
		
	}

}
