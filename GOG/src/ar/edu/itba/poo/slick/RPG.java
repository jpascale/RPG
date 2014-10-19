package ar.edu.itba.poo.slick;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

public class RPG extends BasicGame {

	private static final int SIZE = 16;
	public static int MOVE_INTERVAL = 150; // 0.15 seconds
	
	private TiledMap map;
	private SpriteSheet sheet;
	private Image character;
	private int interval = 0;	

	private int x;
	private int y;
	
	public RPG(String title) {
		super(title);
	}

	public void init(GameContainer container) throws SlickException {
		map = new TiledMap("data/map2.tmx");
		sheet = new SpriteSheet("data/red2.png", 16, 24);
		character = sheet.getSprite(0, 0);
		x = 2;
		y = 2;
	}

	public void update(GameContainer container, int delta) throws SlickException {
		
		Input input = container.getInput();
	
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			container.exit();	
		}
		
		interval += delta;
		
		if (interval >= MOVE_INTERVAL){
			if (input.isKeyDown(Input.KEY_UP)){
				character = sheet.getSprite(0, 3);
				y--;
				interval = 0;
			}
			else if (input.isKeyDown(Input.KEY_DOWN)){
				character = sheet.getSprite(0, 0);
				y++;
				interval = 0;
			}
			else if (input.isKeyDown(Input.KEY_LEFT)){
				character = sheet.getSprite(0, 1);
				x--;
				interval = 0;
			}
			else if (input.isKeyDown(Input.KEY_RIGHT)){
				character = sheet.getSprite(0, 2);
				x++;
				interval = 0;
			}
			
			if (interval >= MOVE_INTERVAL)
				interval = MOVE_INTERVAL;
		}
		
	}
	
	public void render(GameContainer container, Graphics gr) throws SlickException {
		map.render(0, 0);
		character.draw(SIZE*x, 100+SIZE*y);
		
	}

}
