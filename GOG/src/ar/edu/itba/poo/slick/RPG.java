package ar.edu.itba.poo.slick;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.gamelogic.Warrior;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.NoSuchTileException;
import ar.edu.itba.poo.worldlogic.TileMap;

public class RPG extends BasicGame {

	public static final int SIZE = 16;
	public static int MOVE_INTERVAL = 150; // 0.15 seconds
	
	private TiledMap visualmap;
	private TileMap logicmap;
	private ar.edu.itba.poo.gamelogic.Character player;
	private int interval = 0;	
	
	public RPG(String title) {
		super(title);
	}

	public void init(GameContainer container) throws SlickException {
		try {
			visualmap = new TiledMap("data/map2.tmx");
			logicmap = TileMap.getInstance();
			logicmap.fillmaptype(visualmap);
			player = new Character(logicmap.getTile(2, 2));
			player.setStrategy(new Warrior("Patas Locas", 2, 5));
			player.getEquip().setWeapon(new Item("Nudillos",1.0));
		} catch (NoSuchTileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(GameContainer container, int delta) throws SlickException {
		
		Input input = container.getInput();
	
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			container.exit();	
		}
		
		interval += delta;
		
		if (interval >= MOVE_INTERVAL){
			try {
				if (input.isKeyDown(Input.KEY_UP)){
					player.move(Dir.NORTH);
					interval = 0;
				}
				else if (input.isKeyDown(Input.KEY_DOWN)){
					player.move(Dir.SOUTH);
					interval = 0;
				}
				else if (input.isKeyDown(Input.KEY_LEFT)){
					player.move(Dir.WEST);
					interval = 0;
				}
				else if (input.isKeyDown(Input.KEY_RIGHT)){
					player.move(Dir.EAST);
					interval = 0;
				}
				else if (input.isKeyPressed(Input.KEY_LSHIFT)){
					player.attack();
					interval = 0;
				}
				else
					player.setMoving(false);
				
			} catch (EndOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			player.getAppear().getWalk().update(MOVE_INTERVAL/4);
			
			if (interval >= MOVE_INTERVAL)
				interval = MOVE_INTERVAL;
		}
		
	}
	
	public void render(GameContainer container, Graphics gr) throws SlickException {
		visualmap.render(0, 0);
		player.draw();
		
	}

}
