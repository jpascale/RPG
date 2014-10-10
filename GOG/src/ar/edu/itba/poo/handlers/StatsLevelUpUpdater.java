package ar.edu.itba.poo.handlers;


import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.LevelProfile;

public class StatsLevelUpUpdater implements Observer<LevelProfile> {
	
	Game game;
	
	public StatsLevelUpUpdater(Game game){
		this.game = game;
	}
	
	@Override
	public void handleUpdate(LevelProfile data) {
		game.getCharacter().handleUpdateStats(data);
	}

}
