package ar.edu.itba.poo.handlers;

import ar.edu.itba.poo.gamelogic.LevelProfile;
import ar.edu.itba.poo.handlers.Observer;
import ar.edu.itba.poo.render.LevelRenderer;

public class LevelProfileHandler implements Observer<LevelProfile>{

	public LevelProfileHandler() {
		super();
	}
	
	@Override
	public void handleUpdate(LevelProfile data) {
		LevelRenderer.set(data.getLevel(), data.getExp(), data.getMaxexp());
	}

}
