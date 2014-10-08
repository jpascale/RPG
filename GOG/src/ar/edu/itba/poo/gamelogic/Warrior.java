package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.TileMap.Dir;

public class Warrior extends Strategy {

	public Warrior() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(Tile pos, Dir heading, Equipment equipment) {
		try {
			if(!pos.getNext(heading).legalPos()){
				pos.getNext(heading).getAlive().receiveAttack((int) Math.round(Alive.randInt(this.getMinHit(),this.getMaxHit())*equipment.getWeapon().getModifier()));
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

