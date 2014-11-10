package ar.edu.itba.poo.gamelogic;

import java.io.Serializable;

import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.Tile;

public class Warrior extends Type implements Serializable{

	private static int WARRIOR_HP_MODIF = 10;
	private static int WARRIOR_MAN_MODIF = 0; 
	private static int WARRIOR_CLASS_MAN_MODIF = 0;
	
	private static int WARRIOR_DELTA_HIT_UP = 10; 
	
	public Warrior(int minHit, int maxHit) {
		super(Classes.WARRIOR, WARRIOR_HP_MODIF, WARRIOR_MAN_MODIF, minHit, maxHit, WARRIOR_CLASS_MAN_MODIF);
	}
	
	/**
	 * Attacks the next tile, the direction the character is, if it contains an alive.
	 * @param attacker Character
	 */
	@Override
	public int attack(Character attacker) {

		Dir heading = attacker.getHeading();
		Tile pos = attacker.getPos();

		if(pos.getNext(heading).hasAlive()){

			Alive target = pos.getNext(heading).getAlive();

			double weaponModifier = attacker.getEquip().getWeapon().getModifier();
			int damage = (int) Math.round(Alive.randInt(getMinHit(), getMaxHit()) * weaponModifier);

			
			target.receiveAttack(damage);

			if (target.getStatus().isDead()){
				attacker.gainExp(Alive.calculateExp(target));
			}
			
			return damage;
			
		} else 
			return 0;
			
	}
	
	@Override
	public void updateLevelUpHit(){
		this.setMaxHit(this.getMaxHit() + WARRIOR_DELTA_HIT_UP);
		this.setMinHit(this.getMinHit() + WARRIOR_DELTA_HIT_UP);
	}
	
}

