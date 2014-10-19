package ar.edu.itba.poo.gamelogic;

public class CreatureList extends DrawableList<Creature> {
	
	public void removeBodies(){
		for(Creature drawable : super.getDrawableList()){
			if(drawable.getStatus().isDead())
				super.remove(drawable);
		}
	}
}
