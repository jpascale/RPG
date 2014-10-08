package ar.edu.itba.poo.gamelogic;

import java.util.Random;

public class Warrior extends Strategy {

	public Warrior() {
		// TODO Auto-generated constructor stub
	}
	
	//TODO attack needs modifier from Character.Inventory.Item.
	@Override
	public void attack(Alive alive) {
		alive.receiveAttack(Alive.randInt(this.getMinHit(),this.getMaxHit()));
	}
	
}

