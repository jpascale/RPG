package ar.edu.itba.poo.gamelogic;

import java.util.LinkedList;

import ar.edu.itba.poo.gamelogic.creatures.Creature1;
import ar.edu.itba.poo.gamelogic.creatures.Creature2;
import ar.edu.itba.poo.gamelogic.creatures.Creature3;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.World;

public class CreatureList {
	
	private static int CREATURE_NUMBER = 5;
	
	private Game game;
	private LinkedList<Creature> creatureList;
	
	public CreatureList(Game game) {
		this.game = game;
		this.creatureList = new LinkedList<Creature>();
	}
	
	/* Checks the creatureList for dead creatures and removes them from the array.
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
	
	/* Checks the number of each type of creature in the list and
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
			X = Alive.randInt(7, 39);
			Y = Alive.randInt(22, 29);
			try {
				add(CreatureFactory.createCreature1(game.getWorld().getTile(X, Y)));
			} catch (EndOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		for (; creature2 <= CREATURE_NUMBER; creature2++) {
			X = Alive.randInt(12, 39);
			Y = Alive.randInt(12, 20);
			try {
				add(CreatureFactory.createCreature2(game.getWorld().getTile(X, Y)));
			} catch (EndOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		for (; creature3 <= CREATURE_NUMBER; creature3++) {
			X = Alive.randInt(2, 30);
			Y = Alive.randInt(2, 9);
			try {
				add(CreatureFactory.createCreature3(game.getWorld().getTile(X, Y)));
			} catch (EndOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	/* Calls the AI method for each of the creatures in the list.
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

	public LinkedList<Creature> getCreatureList() {
		return creatureList;
	}
}
