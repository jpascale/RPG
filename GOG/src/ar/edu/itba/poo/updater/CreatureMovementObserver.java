package ar.edu.itba.poo.updater;

import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureList;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.render.CreatureRenderer;

public class CreatureMovementObserver implements Observer<Creature> {
	
	CreatureRenderer renderer;

	public CreatureMovementObserver(int posX, int posY, CreatureType ctype) {
		renderer = new CreatureRenderer(posX, posY, ctype);
	}

	@Override
	public void handleUpdate(Creature data) {
		renderer.setDir(data.getHeading());
		renderer.setX(data.getPos().getX());
		renderer.setY(data.getPos().getY());
		renderer.setDead(data.getStatus().isDead());
		
	}

}
