package ar.edu.itba.poo.slick;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureList;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.gamelogic.Warrior;
import ar.edu.itba.poo.render.CharacterRenderer;
import ar.edu.itba.poo.render.CreatureRenderer;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.World;
import ar.edu.itba.poo.slick.GraphicMap;

public class RPG extends BasicGame {

	public static final int SIZE = 16;
	public static int MOVE_INTERVAL = 150; // 0.15 seconds
	private int interval = 0;
	
	private World map;
	private GraphicMap graphicmap;
	private TiledMap tiledmap;
	
	private Character player;
	private CharacterRenderer playerRenderer;
	
	private CreatureList creatures;
	private CreatureRenderer creatureRenderer;
	
	private Console console;
	
	
	public RPG(String title) {
		super(title);
	}
	

	public void init(GameContainer container) throws SlickException {
		try {
			//TODO: Modularize this
			
			console = new Console();
			Console.add("Juego comenzado");
			
			map = World.getInstance();
			
			graphicmap = GraphicMap.getInstance();
			graphicmap.setWorldTriggers();
			
			tiledmap = graphicmap.getTiledMap();
			
			player = new Character(map.getTile(3, 23));
			player.setStrategy(new Warrior("Patas Locas", 2, 5));
			player.getEquip().setWeapon(new Item("Nudillos","data/pokeball.png", 1.0, map.getTile(1, 1)));
			
			creatures = new CreatureList();
			creatures.add(new Creature(50, 0, map.getTile(10, 15), 2, 3, CreatureType.CREATURE_2));
			creatures.add(new Creature(50, 0, map.getTile(20, 15), 2, 3, CreatureType.CREATURE_2));
			creatures.add(new Creature(50, 0, map.getTile(35, 6), 2, 3, CreatureType.BOSS_1));
			creatures.add(new Creature(50, 0, map.getTile(35, 23), 2, 3, CreatureType.CREATURE_1));
			creatures.add(new Creature(50, 0, map.getTile(8, 23), 2, 3, CreatureType.CREATURE_1));
			
			playerRenderer = new CharacterRenderer(player);
			creatureRenderer = new CreatureRenderer(creatures);
			
		} catch (EndOfMapException e) {
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
				else if (input.isKeyPressed(Input.KEY_LCONTROL)){
					player.attack();
					interval = 0;
				}
				//Para probar mapa
				
				else if (input.isKeyPressed(Input.KEY_M)){
					Console.add("Mi posicion es " + player.getPos().getX() + " " + player.getPos().getY());
					interval = 0;
				}
				
				else
					player.setMoving(false);
				
			} catch (EndOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			playerRenderer.getAppear().getWalk().update(MOVE_INTERVAL/4);
			
			if (interval >= MOVE_INTERVAL)
				interval = MOVE_INTERVAL;
			
			//TODO: Change this
			creatures.removeBodies();
			
		}
	}
	
	public void render(GameContainer container, Graphics gr) throws SlickException {
		
		tiledmap.render(0, 90);
		creatureRenderer.render();
		playerRenderer.render();
		console.draw();
		
	}

}
