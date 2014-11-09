package ar.edu.itba.poo.gamelogic;

import java.io.Serializable;

import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.Tile;

public class Warrior extends Type implements Serializable{

	private static String WARRIOR_NAME = "Warrior";
	private static int WARRIOR_HP_MODIF = 10;
	private static int WARRIOR_MAN_MODIF = 0; 
	private static int WARRIOR_CLASS_MAN_MODIF = 0;
	
	public Warrior(int minHit, int maxHit) {
		super(WARRIOR_NAME, WARRIOR_HP_MODIF, WARRIOR_MAN_MODIF, minHit, maxHit, WARRIOR_CLASS_MAN_MODIF);
	}

	@Override
	public void attack(Character attacker) {

		Dir heading = attacker.getHeading();
		Tile pos = attacker.getPos();

		if(pos.getNext(heading).hasAlive()){

			Alive target = pos.getNext(heading).getAlive();

			double weaponModifier = attacker.getEquip().getWeapon().getModifier();
			int damage = (int) Math.round(Alive.randInt(getMinHit(), getMaxHit()) * weaponModifier);

			Console.add("Has atacado a la criatura");
			target.receiveAttack(damage);

			if (target.getStatus().isDead()){
				attacker.gainExp(Alive.calculateExp(target)); //TODO: Give me experience
			}
		}
		else Console.add("No se encuentra el objetivo para atacar");
			
	}
	
}

