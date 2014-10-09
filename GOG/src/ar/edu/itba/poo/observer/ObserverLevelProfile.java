package ar.edu.itba.poo.observer;


import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.LevelProfile;

public class ObserverLevelProfile implements Observer<LevelProfile> {
	
	Game game;
	
	public ObserverLevelProfile(Game game){
		this.game = game;
	}
	
	@Override
	public void handleUpdate(LevelProfile data) {
		game.getCharacter().handleUpdateStats();
	}

}
