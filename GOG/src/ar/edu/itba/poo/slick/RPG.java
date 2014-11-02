package ar.edu.itba.poo.slick;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.gamelogic.CreatureList;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.gamelogic.creatures.Boss1;
import ar.edu.itba.poo.gamelogic.creatures.Boss2;
import ar.edu.itba.poo.gamelogic.creatures.Boss3;
import ar.edu.itba.poo.handlers.CharacterMovementObserver;
import ar.edu.itba.poo.handlers.LevelProfileHandler;
import ar.edu.itba.poo.handlers.StatusObserver;
import ar.edu.itba.poo.render.CharacterRenderer;
import ar.edu.itba.poo.render.CreatureRenderer;
import ar.edu.itba.poo.render.ItemRenderer;
import ar.edu.itba.poo.render.LevelRenderer;
import ar.edu.itba.poo.render.StatusRenderer;
import ar.edu.itba.poo.worldlogic.World;

public class RPG extends BasicGameState {

	public static final int SIZE = 16;
	
	private Game game;
	
	private World map;
	private GraphicMap graphicmap;
	private TiledMap tiledmap;
	
	//private Music music;
	
	private Character player;
	
	private CreatureList creatures;
	
	private Console console;
	
	
	public RPG(String title) {
		super();
	}
	

	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		try {
			//TODO: Modularize this
			
			game = Game.getInstance();
			player = game.getCharacter();
			
			//Start observing character data
			player.addObserver(new CharacterMovementObserver());
			player.getStatus().addObserver(new StatusObserver(player.getStatus()));
			player.getLvl().addObserver(new LevelProfileHandler());
			player.getEquip().addItem(new Item("Nudillos", 1.0, null));
			
			console = new Console();
			Console.add("Bienvenido a Game of Games!");
	
			map = game.getWorld();
			map.getTile(35, 6).setItem(new Item("Espada Magica", 5.0, map.getTile(35,6)));
			map.getTile(10, 23).setItem(new Item("Palo Loco", 5.0, map.getTile(10,23)));

			
			graphicmap = GraphicMap.getInstance();
			graphicmap.setWorldTriggers();
			
			tiledmap = graphicmap.getTiledMap();
			
			creatures = game.getCreatureList();
			creatures.add(new Boss1(map.getTile(35, 25)));
			creatures.add(new Boss2(map.getTile(7, 16)));
			creatures.add(new Boss3(map.getTile(35, 6)));

			player = game.getCharacter();
			
			//music = new Music("data/b_jean.ogg");
			//music.loop();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
	
		InputHandler.handleInput(container, delta, player);
		
			//TODO: Change this

			//creatures.creatureFactory();
			creatures.removeBodies();
			creatures.creaturesAI(delta);
			
		
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics gr) throws SlickException {
		
		console.draw();
		tiledmap.render(0, 90);
		ItemRenderer.render();
		CreatureRenderer.render();
		CharacterRenderer.render();
		StatusRenderer.render(gr);
		LevelRenderer.render(gr);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
