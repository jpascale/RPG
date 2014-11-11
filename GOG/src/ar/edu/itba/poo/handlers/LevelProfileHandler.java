package ar.edu.itba.poo.handlers;

import java.io.Serializable;

import ar.edu.itba.poo.gamelogic.LevelProfile;
import ar.edu.itba.poo.render.LevelRenderer;

public class LevelProfileHandler implements Observer<LevelProfile>, Serializable{

	public LevelProfileHandler() {
		super();
	}
	
	/**
	 * Notifies the LevelRenderer the change 
	 * level and exp. 
	 * 
	 * @param data LevelProfile;
	 */
	@Override
	public void handleUpdate(LevelProfile data) {
		LevelRenderer.set(data.getLevel(), data.getExp(), data.getMaxexp());
	}

}
