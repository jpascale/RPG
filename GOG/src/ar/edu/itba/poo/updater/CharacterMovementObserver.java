package ar.edu.itba.poo.updater;

import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.render.CharacterRenderer;

public class CharacterMovementObserver implements Observer<Character> {

	CharacterRenderer renderer;
	
	public CharacterMovementObserver() {
		renderer = new CharacterRenderer();
	}
	
	@Override
	public void handleUpdate(Character data) {
		renderer.setDir(data.getHeading());
		renderer.setX(data.getPos().getX());
		renderer.setY(data.getPos().getY());
		
	}

}
