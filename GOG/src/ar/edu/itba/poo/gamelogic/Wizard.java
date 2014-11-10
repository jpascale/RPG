package ar.edu.itba.poo.gamelogic;

import java.io.Serializable;

import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.Trigger;

public class Wizard extends Type implements Serializable{
	
	private static String WIZARD_NAME = "Wizard";
	
	private static int WIZARD_HP_MODIF = 5;
	private static int WIZARD_MAN_MODIF = 10;
	private static int WIZARD_CLASS_MAN_MODIF = 1;
	private static int MAGIC_USE = 5;
	
	public static int NO_MANA = -1;
	
	private static int WIZARD_DELTA_SPELL_UP = 6;
	
	public Wizard(int minHit, int maxHit) {
		super(Classes.WIZARD, WIZARD_HP_MODIF, WIZARD_MAN_MODIF, minHit, maxHit, WIZARD_CLASS_MAN_MODIF);
	}

	/**
	 * Checks 5 tiles around in the characters direction until an alive its found and attacks it.
	 * @param attacker Character
	 */
	@Override
	public int attack(Character attacker) {

		if(attacker.getStatus().getMinman() >= MAGIC_USE){
			Dir heading = attacker.getHeading();
			Tile pos = attacker.getPos();
			Tile posnext = pos.getNext(heading);

			Boolean attacked = false;
			for (int i = 0; i < 5 && attacked == false; i++) {

				if(posnext.hasAlive()){

					Alive target = posnext.getAlive();

					double weaponModifier = attacker.getEquip().getWeapon().getModifier();
					int damage = (int) Math.round(Game.randInt(getMinHit(), getMaxHit()) * weaponModifier);

					target.receiveAttack(damage);
					attacker.getStatus().loseMana(MAGIC_USE);
					attacked = true;

					if (target.getStatus().isDead()){
						attacker.gainExp(Alive.calculateExp(target)); 
					}
					
					return damage;
				}
				else if(posnext.getType()!=Trigger.BLOCKED){
					pos = posnext;
					posnext = pos.getNext(heading);
				}
				else
					break;
			}
			if(attacked == false)
				return 0;
		}

		return NO_MANA;
	}

	@Override
	public void updateLevelUpHit(){
		this.setMaxHit(this.getMaxHit() + WIZARD_DELTA_SPELL_UP);
		this.setMinHit(this.getMinHit() + WIZARD_DELTA_SPELL_UP);
	}
}
