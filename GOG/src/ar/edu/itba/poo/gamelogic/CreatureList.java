package ar.edu.itba.poo.gamelogic;

import java.util.LinkedList;

public class CreatureList {
	
	private LinkedList<Creature> creatureList;
	
	public CreatureList() {
		this.creatureList = new LinkedList<Creature>();
	}

	public void removeBodies(){
		Creature dead = null;
		for(Creature creature : creatureList){
			if(creature.getStatus().isDead())
				dead = creature;
		}
		remove(dead);
	}
	
	public void creaturesAI(int delta){
		for (Creature creature : creatureList) {
			creature.AI(delta);
		}
	}
	
	public void add(Creature creature){
		creatureList.add(creature);
	}
	
	public void remove(Creature creature){
		creatureList.remove(creature);
	}

	public LinkedList<Creature> getCreatureList() {
		return creatureList;
	}
}
