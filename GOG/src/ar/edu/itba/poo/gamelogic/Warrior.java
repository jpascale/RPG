package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;

public class Warrior extends Type {

	private static String WARRIOR_NAME = "Warrior";
	private static int WARRIOR_HP_MODIF = 10;
	private static int WARRIOR_MAN_MODIF = 0;
	
	public Warrior(String name, int minHit, int maxHit) {
		super(WARRIOR_NAME, WARRIOR_HP_MODIF, WARRIOR_MAN_MODIF, minHit, maxHit);
	}

	@Override
	public void attack(Character attacker) {
		try {
			Dir heading = attacker.getHeading();
			Tile pos = attacker.getPos();
			
			if(pos.getNext(heading).hasAlive()){
				
				Alive target = pos.getNext(heading).getAlive();
						
				double weaponModifier = attacker.getEquip().getWeapon().getModifier();
				int damage = (int) Math.round(Alive.randInt(getMinHit(), getMaxHit()) * weaponModifier);
				
				target.receiveAttack(damage);
				
				if (target.getStatus().isDead()){
					//TODO: Give me experience
				}
			}
			else System.out.println("No se encuentra el objetivo para atacar");
			
		} catch (EndOfMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}

