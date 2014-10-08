package ar.edu.itba.poo.gamelogic;

import java.util.Random;

public class Warrior extends Strategy {

	private static String WARRIOR_NAME = "Warrior";
	private static int WARRIOR_HP_MODIF = 10;
	private static int WARRIOR_MAN_MODIF = 0;
	
	public Warrior(String name) {
		super(WARRIOR_NAME, WARRIOR_HP_MODIF, WARRIOR_MAN_MODIF);
	}
	
	//TODO attack needs modifier from Character.Inventory.Item.
	@Override
	public void attack(Alive alive) {
		alive.receiveAttack(Alive.randInt(this.getMinHit(),this.getMaxHit()));
	}
	
}

