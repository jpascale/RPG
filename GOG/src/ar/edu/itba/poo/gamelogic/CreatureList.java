package ar.edu.itba.poo.gamelogic;

import java.util.HashSet;

import ar.edu.itba.poo.handlers.CreatureFactory;

public class CreatureList {
	
	private static int CREATURE_NUMBER = 5;
	
	private Game game;
	private HashSet<Creature> creatureList;
	
	public CreatureList(Game game) {
		this.game = game;
		this.creatureList = new HashSet<Creature>();
	}
	
	/**
	 * Checks the creatureList for dead creatures and removes them from the array.
	 * @return 
	 */
	public void removeBodies(){
		Creature dead = null;
		for(Creature creature : creatureList){
			if(creature.getStatus().isDead())
				dead = creature;
		}
		remove(dead);
	}
	
	/**
	 * Checks the number of each type of creature in the list and
	 * creates more creatures if needed.
	 * @return 
	 */
	public void creatureFactory(){
		int creature1 = 0;
		int creature2 = 0;
		int creature3 = 0;
		int X, Y;
		
		for (Creature creature : creatureList) {
			if(creature.getType()==CreatureType.CREATURE_1)
				creature1++;
			else if(creature.getType()==CreatureType.CREATURE_2)
				creature2++;
			else if(creature.getType()==CreatureType.CREATURE_3)
				creature3++;
		}
		for (; creature1 <= CREATURE_NUMBER; creature1++) {
			X = Game.randInt(7, 39);
			Y = Game.randInt(22, 29);
			add(CreatureFactory.createCreature1(game.getWorld().getTile(X, Y)));	
		}
		
		for (; creature2 <= CREATURE_NUMBER; creature2++) {
			X = Game.randInt(12, 39);
			Y = Game.randInt(12, 20);
			add(CreatureFactory.createCreature2(game.getWorld().getTile(X, Y)));
		}
		
		for (; creature3 <= CREATURE_NUMBER; creature3++) {
			X = Game.randInt(2, 30);
			Y = Game.randInt(2, 9);
			add(CreatureFactory.createCreature3(game.getWorld().getTile(X, Y)));
		}
	}
	/**
	 * Calls the AI method for each of the creatures in the list.
	 * @param delta (time since last update)
	 * @return 
	 */
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

	public HashSet<Creature> getCreatureList() {
		return creatureList;
	}
}
