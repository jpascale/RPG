package ar.edu.itba.poo.slick;

import org.newdawn.slick.AppGameContainer;

public class Main {

	public static void main(String[] args) {
		GameStateMachine game = new GameStateMachine("GOG");
		AppGameContainer gc;
		try {
			gc = new AppGameContainer(game);
			gc.setDisplayMode(800, 570, false);
			gc.setTargetFrameRate(60);
			gc.setShowFPS(false);
			gc.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
