package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.Dir;

public class Wizard extends Strategy {
	
	private static String WIZARD_NAME = "Wizard";
	private static int WIZARD_HP_MODIF = 5;
	private static int WIZARD_MAN_MODIF = 10;
	
	public Wizard(int minHit, int maxHit) {
		super(WIZARD_NAME, WIZARD_HP_MODIF, WIZARD_MAN_MODIF, minHit, maxHit);
		// TODO Auto-generated constructor stub
	}

	//TODO Implement attack.
	@Override
	public void attack(Tile pos, Dir heading, Equipment equipment) {
		// TODO Auto-generated method stub
		
	}

}
