package ar.edu.itba.poo.gamelogic;

import java.util.Random;

public class Warrior extends Strategy {

	public Warrior() {
		// TODO Auto-generated constructor stub
	}
	
	//TODO attack needs modifier from Character.Inventory.Item.
	@Override
	public void attack(Alive alive) {
		alive.receiveAttack(randInt(this.getMinHit(),this.getMaxHit()));
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}

