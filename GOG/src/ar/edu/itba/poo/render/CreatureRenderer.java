package ar.edu.itba.poo.render;

import java.util.ArrayList;
import java.util.HashMap;

import org.newdawn.slick.Image;

import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureList;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.slick.RPG;
import ar.edu.itba.poo.worldlogic.Dir;

public class CreatureRenderer {
	
	private static HashMap<CreatureType, SpriteImages> appearanceMap;
	private static ArrayList<CreatureRenderer> renders;
	
	private int X, Y;
	private Dir dir;
	private CreatureType type;
	private boolean dead;

	public CreatureRenderer(int posX, int posY, CreatureType ctype) {
		appearanceMap = new HashMap<CreatureType, SpriteImages>();
		appearanceMap.put(CreatureType.CREATURE_1, new SpriteImages("data/nido/down.png", "data/nido/up.png", "data/nido/left.png", "data/nido/right.png"));
		appearanceMap.put(CreatureType.CREATURE_2, new SpriteImages("data/whirl/down.png", "data/whirl/up.png", "data/whirl/left.png", "data/whirl/right.png"));
		appearanceMap.put(CreatureType.BOSS_1, new SpriteImages("data/qbone/down.png", "data/qbone/up.png", "data/qbone/left.png", "data/qbone/right.png"));
		
		this.X = posX;
		this.Y = posY;
		this.dir = Dir.SOUTH;
		this.type = ctype;
		this.dead = false;
		if(renders == null)
			renders = new ArrayList<CreatureRenderer>();
		CreatureRenderer.renders.add(this);
		
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public void setX(int x) {
		X = x;
	}

	public void setY(int y) {
		Y = y;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}
	
	public static void render(){
		CreatureRenderer dead = null;
		for (CreatureRenderer render : renders) {
			if(render.dead)
				dead = render;
			else{
				Image creatureImage = appearanceMap.get(render.type).getDirection(render.dir);
				creatureImage.draw((render.X-1)*RPG.SIZE, (render.Y-1)*RPG.SIZE+90);
			}
		}
		renders.remove(dead);
	}
}
