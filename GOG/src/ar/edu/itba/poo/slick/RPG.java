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
import ar.edu.itba.poo.handlers.CharacterMovementObserver;
import ar.edu.itba.poo.handlers.LevelProfileHandler;
import ar.edu.itba.poo.handlers.StatusObserver;
import ar.edu.itba.poo.render.CharacterRenderer;
import ar.edu.itba.poo.render.CreatureRenderer;
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
			
			console = new Console();
			Console.add("Bienvenido a Game of Games!");
			
			map = game.getWorld();
			
			graphicmap = GraphicMap.getInstance();
			graphicmap.setWorldTriggers();
			
			tiledmap = graphicmap.getTiledMap();
			
			creatures = game.getCreatureList();

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

			creatures.creatureFactory();
			creatures.removeBodies();
			creatures.creaturesAI(delta);
			
		
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics gr) throws SlickException {
		
		console.draw();
		tiledmap.render(0, 90);
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
