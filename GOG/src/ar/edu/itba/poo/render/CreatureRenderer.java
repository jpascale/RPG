package ar.edu.itba.poo.render;

import java.util.HashMap;

import org.newdawn.slick.Image;

import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureList;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.slick.RPG;
import ar.edu.itba.poo.worldlogic.Dir;

public class CreatureRenderer {
	
	private HashMap<CreatureType, SpriteImages> appearanceMap;
	private CreatureList creatures;

	public CreatureRenderer(CreatureList creaturelist) {
		appearanceMap = new HashMap<CreatureType, SpriteImages>();
		appearanceMap.put(CreatureType.CREATURE_1, new SpriteImages("data/nido/down.png", "data/nido/up.png", "data/nido/left.png", "data/nido/right.png"));
		appearanceMap.put(CreatureType.CREATURE_2, new SpriteImages("data/whirl/down.png", "data/whirl/up.png", "data/whirl/left.png", "data/whirl/right.png"));
		appearanceMap.put(CreatureType.BOSS_1, new SpriteImages("data/qbone/down.png", "data/qbone/up.png", "data/qbone/left.png", "data/qbone/right.png"));
		
		creatures = creaturelist;
		
	}

	public void render(){
		
		for (Creature creature : creatures.getCreatureList()) {
			
			int X = creature.getPos().getX();
			int Y = creature.getPos().getY();
			Dir dir = creature.getHeading();
			
			Image creatureImage = appearanceMap.get(creature.getType()).getDirection(dir);
			creatureImage.draw((X-1)*RPG.SIZE, (Y-1)*RPG.SIZE+90);
		}
	}
}
