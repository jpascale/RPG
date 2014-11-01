package ar.edu.itba.poo.slick;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.gamelogic.Creature;
import ar.edu.itba.poo.gamelogic.CreatureList;
import ar.edu.itba.poo.gamelogic.CreatureType;
import ar.edu.itba.poo.gamelogic.Item;
import ar.edu.itba.poo.gamelogic.Warrior;
import ar.edu.itba.poo.gamelogic.Wizard;
import ar.edu.itba.poo.handlers.LevelProfileHandler;
import ar.edu.itba.poo.render.CharacterRenderer;
import ar.edu.itba.poo.render.CreatureRenderer;
import ar.edu.itba.poo.render.ItemRenderer;
import ar.edu.itba.poo.render.LevelRenderer;
import ar.edu.itba.poo.render.StatusRenderer;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.worldlogic.World;

public class RPG extends BasicGameState {

	public static final int SIZE = 16;
	
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
			
			console = new Console();
			Console.add("Juego comenzado");
			
			map = World.getInstance();
			map.getTile(35, 6).setItem(new Item("Espada Magica", 5.0, map.getTile(35,6)));
			map.getTile(10, 23).setItem(new Item("Palo Loco", 5.0, map.getTile(10,23)));
			
			graphicmap = GraphicMap.getInstance();
			graphicmap.setWorldTriggers();
			
			tiledmap = graphicmap.getTiledMap();
			
			player = new Character(map.getTile(3, 23));
			player.setStrategy(new Warrior(2, 5));
			
			creatures = new CreatureList();
			
			player.getLvl().addObserver(new LevelProfileHandler());
			
			//music = new Music("data/b_jean.ogg");
			//music.loop();
			
			
		} catch (EndOfMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
	
		InputHandler.handleInput(container, delta, player);
		
			//TODO: Change this
			creatures.removeBodies();
			creatures.creatureFactory();
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
