package ar.edu.itba.poo.gamelogic.creatures;

import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.worldlogic.Tile;

public class Creature1 extends Creature {
	
	private static int HP = 30;
	private static int MAN = 0;
	private static int MINHIT = 1;
	private static int MAXHIT = 6;
	private static CreatureType CTYPE = CreatureType.CREATURE_1;

	public Creature1(Tile pos, long ID) {
		super(HP, MAN, pos, MINHIT, MAXHIT, CTYPE, ID);
	}

}
