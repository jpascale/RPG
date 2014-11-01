package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.Trigger;

public class Wizard extends Type {
	
	private static String WIZARD_NAME = "Wizard";
	private static int WIZARD_HP_MODIF = 5;
	private static int WIZARD_MAN_MODIF = 10;
	private static int WIZARD_CLASS_MAN_MODIF = 1;
	private static int MAGIC_USE = 5;
	
	public Wizard(int minHit, int maxHit) {
		super(WIZARD_NAME, WIZARD_HP_MODIF, WIZARD_MAN_MODIF, minHit, maxHit, WIZARD_CLASS_MAN_MODIF);
		// TODO Auto-generated constructor stub
	}

	//TODO Implement attack.
	@Override
	public void attack(Character attacker) {
		try {
			if(attacker.getStatus().getMinman() >= MAGIC_USE){
				Dir heading = attacker.getHeading();
				Tile pos = attacker.getPos();
				Tile posnext = pos.getNext(heading);
				
				Boolean attacked = false;
				for (int i = 0; i < 5 && attacked == false; i++) {
					
					if(posnext.hasAlive()){
						
						Alive target = posnext.getAlive();
								
						double weaponModifier = attacker.getEquip().getWeapon().getModifier();
						int damage = (int) Math.round(Alive.randInt(getMinHit(), getMaxHit()) * weaponModifier);
						
						Console.add("Has atacado a la criatura");
						target.receiveAttack(damage);
						attacker.getStatus().loseMana(MAGIC_USE);
						attacked = true;
						
						if (target.getStatus().isDead()){
							attacker.gainExp(Alive.calculateExp(target)); //TODO: Give me experience
						}
					}
					else if(posnext.getType()!=Trigger.BLOCKED){
						pos = posnext;
						posnext = pos.getNext(heading);
					}
					else
						attacked = true;
				}
				if(attacked == false)
					Console.add("No se encuentra el objetivo para atacar");
			}
			else Console.add("No tiene el mana suficiente para atacar");
			
		} catch (EndOfMapException e) {
			e.printStackTrace();
		}
	}
}
