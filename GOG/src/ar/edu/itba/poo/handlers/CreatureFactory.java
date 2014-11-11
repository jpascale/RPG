package ar.edu.itba.poo.handlers;

import ar.edu.itba.poo.creatures.Boss1;
import ar.edu.itba.poo.creatures.Boss2;
import ar.edu.itba.poo.creatures.Boss3;
import ar.edu.itba.poo.creatures.Creature1;
import ar.edu.itba.poo.creatures.Creature2;
import ar.edu.itba.poo.creatures.Creature3;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.worldlogic.Tile;

public class CreatureFactory {
	
	private static long creatureID = 1;
	
	public static Creature1 createCreature1(Tile pos){
		Creature1 creature = new Creature1(pos, creatureID);
		CreatureMovementHandler observer = CreatureMovementHandler.getInstance();
		observer.addrenderer(pos.getX(), pos.getY(), CreatureType.CREATURE_1, creatureID);
		creature.addObserver(observer);
		creatureID++;
		return creature;
	}
	
	public static Creature2 createCreature2(Tile pos){
		Creature2 creature = new Creature2(pos, creatureID);
		CreatureMovementHandler observer = CreatureMovementHandler.getInstance();
		observer.addrenderer(pos.getX(), pos.getY(), CreatureType.CREATURE_2, creatureID);
		creature.addObserver(observer);
		creatureID++;
		return creature;
	}
	
	public static Creature3 createCreature3(Tile pos){
		Creature3 creature = new Creature3(pos, creatureID);
		CreatureMovementHandler observer = CreatureMovementHandler.getInstance();
		observer.addrenderer(pos.getX(), pos.getY(), CreatureType.CREATURE_3, creatureID);
		creature.addObserver(observer);
		creatureID++;
		return creature;
	}
	
	public static Boss1 createBoss1(Tile pos){
		Boss1 creature = new Boss1(pos, creatureID);
		CreatureMovementHandler observer = CreatureMovementHandler.getInstance();
		observer.addrenderer(pos.getX(), pos.getY(), CreatureType.BOSS_1, creatureID);
		creature.addObserver(observer);
		creatureID++;
		return creature;
	}
	
	public static Boss2 createBoss2(Tile pos){
		Boss2 creature = new Boss2(pos, creatureID);
		CreatureMovementHandler observer = CreatureMovementHandler.getInstance();
		observer.addrenderer(pos.getX(), pos.getY(), CreatureType.BOSS_2, creatureID);
		creature.addObserver(observer);
		creatureID++;
		return creature;
	}
	
	public static Boss3 createBoss3(Tile pos){
		Boss3 creature = new Boss3(pos, creatureID);
		CreatureMovementHandler observer = CreatureMovementHandler.getInstance();
		observer.addrenderer(pos.getX(), pos.getY(), CreatureType.BOSS_3, creatureID);
		creature.addObserver(observer);
		creatureID++;
		return creature;
	}
	

}
