package ar.edu.itba.poo.gamelogic.creatures;

import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.gamelogic.Wizard;
import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.worldlogic.Tile;

public class Boss3 extends Creature {
	private static int HP = 5000;
	private static int MAN = 0;
	private static int MINHIT = 25;
	private static int MAXHIT = 30;
	private static CreatureType CTYPE = CreatureType.BOSS_3;

	public Boss3(Tile pos, long ID) {
		super(HP, MAN, pos, MINHIT, MAXHIT, CTYPE, ID);
	}

	@Override
	public boolean receiveAttack(int damage) {
		
		super.receiveAttack(damage);
		
		if(this.getStatus().isDead()){
			Game.getInstance().setEndgame(true);
			return true;
		}
		return false;
	}
	

}