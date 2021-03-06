package ar.edu.itba.poo.creatures;


import ar.edu.itba.poo.gamelogic.Classes;
import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.ItemFactory;
import ar.edu.itba.poo.worldlogic.Tile;

public class Boss1 extends Creature {
	private static int HP = 150;
	private static int MAN = 0;
	private static int MINHIT = 9;
	private static int MAXHIT = 12;
	private static CreatureType CTYPE = CreatureType.BOSS_1;

	public Boss1(Tile pos, long ID) {
		
		super(HP, MAN, pos, MINHIT, MAXHIT, CTYPE, ID);
		
		if(Game.getInstance().getCharacter().getType().getClassType() == Classes.WIZARD)
			this.setItem(ItemFactory.createItem("Rod of Awesomeness", 2.0, null));
		else
			this.setItem(ItemFactory.createItem("Stick of Manliness", 2.0, null));
	}
	
	@Override
	public boolean receiveAttack(int damage) {
		
		super.receiveAttack(damage);
		
		if(this.getStatus().isDead()){
			Game.getInstance().setBoss1dead(true);
			return true;
		}
		return false;
	}

}