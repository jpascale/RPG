package ar.edu.itba.poo.frontend;

import org.newdawn.slick.AppGameContainer;

import ar.edu.itba.poo.gamelogic.Game;

public class Main {

	public static void main(String[] args) {
		
		//Backend Loads
		Game game = Game.getInstance();
		
		//Let's play!
		GameStateMachine gamefront = new GameStateMachine("GOG");
		
		AppGameContainer gc;
		try {
			gc = new AppGameContainer(gamefront);
			gc.setDisplayMode(820, 570, false);
			gc.setTargetFrameRate(60);
			gc.setShowFPS(false);
			gc.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
