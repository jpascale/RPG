package ar.edu.itba.poo.gamelogic.creatures;

import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.gamelogic.Wizard;
import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.worldlogic.Tile;

public class Boss2 extends Creature {
	private static int HP = 300;
	private static int MAN = 0;
	private static int MINHIT = 15;
	private static int MAXHIT = 18;
	private static CreatureType CTYPE = CreatureType.BOSS_2;

	public Boss2(Tile pos, long ID) {
		super(HP, MAN, pos, MINHIT, MAXHIT, CTYPE, ID);
	}

	@Override
	public void receiveAttack(int damage) {
		super.receiveAttack(damage);
		if(this.getStatus().isDead()){
			Game.getInstance().getCharacter().setSwims(true);
			Console.add("Has conseguido la balsa");
			Game.getInstance().setBoss2dead(true);
		}
	}
	

}