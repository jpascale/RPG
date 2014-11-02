package ar.edu.itba.poo.gamelogic.creatures;

import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.worldlogic.Tile;

public class Creature2 extends Creature {
	private static int HP = 60;
	private static int MAN = 0;
	private static int MINHIT = 6;
	private static int MAXHIT = 12;
	private static CreatureType CTYPE = CreatureType.CREATURE_2;

	public Creature2(Tile pos) {
		super(HP, MAN, pos, MINHIT, MAXHIT, CTYPE);
	}

}