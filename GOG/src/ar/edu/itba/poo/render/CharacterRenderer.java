package ar.edu.itba.poo.render;

import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.slick.RPG;
import ar.edu.itba.poo.worldlogic.Dir;

public class CharacterRenderer{
	
	private Character player;
	private Appearance appear;
	

	public CharacterRenderer(Character character) {
		player = character;
		appear = new Appearance("data/red2.png", 16, 24);
		
	}

	public void render(){
		int X = player.getPos().getX();
		int Y = player.getPos().getY();
		
		Dir dir = player.getHeading();
		appear.changeAnimation(dir);
		
		if(player.isMoving())
			appear.getWalk().draw((X-1)*RPG.SIZE, (Y-1)*RPG.SIZE+82);
		else
			appear.getStay().draw((X-1)*RPG.SIZE, (Y-1)*RPG.SIZE+82);
		
	}
	
	public Appearance getAppear() {
		return appear;
	}
}
