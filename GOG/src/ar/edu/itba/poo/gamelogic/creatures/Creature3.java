package ar.edu.itba.poo.gamelogic.creatures;

import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.worldlogic.Tile;

public class Creature3 extends Creature {
	private static int HP = 90;
	private static int MAN = 0;
	private static int MINHIT = 13;
	private static int MAXHIT = 18;
	private static CreatureType CTYPE = CreatureType.CREATURE_3;

	public Creature3(Tile pos) {
		super(HP, MAN, pos, MINHIT, MAXHIT, CTYPE);
	}

}