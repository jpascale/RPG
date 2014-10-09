package ar.edu.itba.poo.gamelogic;

import ar.edu.itba.poo.worldlogic.Tile;
import ar.edu.itba.poo.worldlogic.Dir;

public interface Combat {
	
	public void attack(Tile pos, Dir heading, Equipment equipment);

}
