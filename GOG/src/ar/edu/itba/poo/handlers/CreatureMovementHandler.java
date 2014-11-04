package ar.edu.itba.poo.handlers;

import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureList;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.render.CreatureRenderer;
import ar.edu.itba.poo.worldlogic.Tile;

public class CreatureMovementHandler implements Observer<Creature> {
	
	static CreatureMovementHandler instance;

	public static CreatureMovementHandler getInstance() {
		if(instance == null)
			instance = new CreatureMovementHandler();
		return instance;
	}

	@Override
	public void handleUpdate(Creature data) {
		CreatureRenderer renderer = CreatureRenderer.getRenderer(data.getID());
		renderer.setDir(data.getHeading());
		renderer.setX(data.getPos().getX());
		renderer.setY(data.getPos().getY());
		renderer.setDead(data.getStatus().isDead());
		
	}
	
	public void addrenderer(int posX, int posY, CreatureType ctype, long ID){
		CreatureRenderer.addRenderer(new CreatureRenderer(posX, posY, ctype, ID));
	}
	

}
