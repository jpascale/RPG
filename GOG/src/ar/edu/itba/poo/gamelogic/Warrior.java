package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.TileMap.Dir;

public class Warrior extends Strategy {

	private static String WARRIOR_NAME = "Warrior";
	private static int WARRIOR_HP_MODIF = 10;
	private static int WARRIOR_MAN_MODIF = 0;
	
	public Warrior(String name) {
		super(WARRIOR_NAME, WARRIOR_HP_MODIF, WARRIOR_MAN_MODIF);
	}

	@Override
	public void attack(Tile pos, Dir heading, Equipment equipment) {
		try {
			if(!pos.getNext(heading).legalPos()){
				double weaponModifier = equipment.getWeapon().getModifier();
				int damage = (int) Math.round(Alive.randInt(super.getMinHit(),super.getMaxHit())*weaponModifier);
				pos.getNext(heading).getAlive().receiveAttack(damage);
			}
			else{
				;//TODO if there is no creature.
			}
		} catch (EndOfMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}

