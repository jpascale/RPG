package ar.edu.itba.poo.handlers;

import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.render.CharacterRenderer;

public class CharacterMovementHandler implements Observer<Character> {

	CharacterRenderer renderer;
	
	public CharacterMovementHandler() {
		renderer = new CharacterRenderer();
	}
	
	@Override
	public void handleUpdate(Character data) {
		renderer.setDir(data.getHeading());
		renderer.setX(data.getPos().getX());
		renderer.setY(data.getPos().getY());
		
	}

}
