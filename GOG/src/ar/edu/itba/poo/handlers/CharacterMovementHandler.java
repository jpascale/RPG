package ar.edu.itba.poo.handlers;

import java.io.Serializable;

import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.render.CharacterRenderer;

public class CharacterMovementHandler implements Observer<Character>, Serializable {

	CharacterRenderer renderer;
	
	public CharacterMovementHandler() {
		renderer = new CharacterRenderer();
	}
	
	/**
	 * Notifies the CharacterRenderer the change 
	 * in position and heading of the Character. 
	 * 
	 * @param data Character;
	 */
	
	@Override
	public void handleUpdate(Character data) {
		renderer.setDir(data.getHeading());
		renderer.setX(data.getPos().getX());
		renderer.setY(data.getPos().getY());
		
	}

}
