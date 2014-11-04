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
	private static ArrayList<CreatureRenderer> renders = new ArrayList<CreatureRenderer>();
	
	private int X, Y, offsetX, offsetY;
	private Dir dir;
	private CreatureType type;
	private boolean dead;
	private long ID;

	public CreatureRenderer(int posX, int posY, CreatureType ctype, long ID) {
		appearanceMap = new HashMap<CreatureType, SpriteImages>();
		appearanceMap.put(CreatureType.CREATURE_1, new SpriteImages("data/nido/down.png", "data/nido/up.png", "data/nido/left.png", "data/nido/right.png"));
		appearanceMap.put(CreatureType.CREATURE_2, new SpriteImages("data/whirl/down.png", "data/whirl/up.png", "data/whirl/left.png", "data/whirl/right.png"));
		appearanceMap.put(CreatureType.CREATURE_3, new SpriteImages("data/qbone/down.png", "data/qbone/up.png", "data/qbone/left.png", "data/qbone/right.png"));
		appearanceMap.put(CreatureType.BOSS_1, new SpriteImages("data/hoot/down.png", "data/hoot/up.png", "data/hoot/left.png", "data/hoot/right.png"));
		appearanceMap.put(CreatureType.BOSS_2, new SpriteImages("data/feral/down.png", "data/feral/up.png", "data/feral/left.png", "data/feral/right.png"));
		appearanceMap.put(CreatureType.BOSS_3, new SpriteImages("data/typh/down.png", "data/typh/up.png", "data/typh/left.png", "data/typh/right.png"));
		
		this.X = posX;
		this.Y = posY;
		this.dir = Dir.SOUTH;
		this.type = ctype;
		this.dead = false;
		this.ID = ID;
		
		if(ctype == CreatureType.BOSS_1){
			this.offsetX = this.offsetY = -8;
		}
		else if(ctype == CreatureType.BOSS_2){
			this.offsetX =-8;
			this.offsetY =-16;
		}
		else if(ctype == CreatureType.BOSS_3){
			this.offsetX =-8;
			this.offsetY =-16;
		}
		else
			this.offsetX = this.offsetY = 0;
			
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
	
	public static void addRenderer(CreatureRenderer renderer){
		renders.add(renderer);
	}
	
	public static CreatureRenderer getRenderer(long creatureID){
		for (CreatureRenderer render : renders) {
			if(render.ID == creatureID)
				return render;
		}
		return null;
	}
	
	public static void render(){
		CreatureRenderer dead = null;
		for (CreatureRenderer render : renders) {
			if(render.dead)
				dead = render;
			else{
				Image creatureImage = appearanceMap.get(render.type).getDirection(render.dir);
				creatureImage.draw((render.X-1)*RPG.SIZE + render.offsetX, (render.Y-1)*RPG.SIZE+90 + render.offsetY);
			}
		}
		renders.remove(dead);
	}
}
