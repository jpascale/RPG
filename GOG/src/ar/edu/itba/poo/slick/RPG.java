package ar.edu.itba.poo.slick;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import ar.edu.itba.poo.IO.GameIO;
import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.gamelogic.CreatureFactory;
import ar.edu.itba.poo.gamelogic.CreatureList;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.ItemFactory;
import ar.edu.itba.poo.handlers.CharacterMovementHandler;
import ar.edu.itba.poo.handlers.EquipmentHandler;
import ar.edu.itba.poo.handlers.LevelProfileHandler;
import ar.edu.itba.poo.handlers.StatusHandler;
import ar.edu.itba.poo.render.CharacterRenderer;
import ar.edu.itba.poo.render.CreatureRenderer;
import ar.edu.itba.poo.render.EquipmentRenderer;
import ar.edu.itba.poo.render.ItemRenderer;
import ar.edu.itba.poo.render.LevelRenderer;
import ar.edu.itba.poo.render.StatusRenderer;
import ar.edu.itba.poo.worldlogic.World;

public class RPG extends BasicGameState {

	public static final int SIZE = 16;
	
	Image background = null;
	
	private Game game;
	
	private World map;
	private GraphicMap graphicmap;
	private TiledMap tiledmap;
	
	private Music music;
	
	private Character player;
	
	private CreatureList creatures;
	
	private Console console;
	
	
	public RPG(String title) {
		super();
		try {
			//background = new Image("data/main.jpg");
		//Use "Exception" because it ends execution otherwise
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Could not find data/main.jpg");
		}
	}
	

	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		try {
			//TODO: Modularize this
			
			game = Game.getInstance();
			player = game.getCharacter();
			
			GameIO.setGame(game);
			
			//Start observing character data
			player.addObserver(new CharacterMovementHandler());
			player.getStatus().addObserver(new StatusHandler(player.getStatus()));
			player.getLvl().addObserver(new LevelProfileHandler());
			player.getEquip().addObserver(new EquipmentHandler());
			player.getEquip().addItem(ItemFactory.createItem("Nudillos", 1.0, null));
			
			console = new Console();
			Console.add("Bienvenido a Game of Games!");
	
			map = game.getWorld();
			map.getTile(3, 28 ).setItem(ItemFactory.createItem("Big Bad Blade", 5.0, map.getTile(3,28)));
			
			graphicmap = GraphicMap.getInstance();
			graphicmap.setWorldTriggers();
			
			tiledmap = graphicmap.getTiledMap();
			
			creatures = game.getCreatureList();
			creatures.add(CreatureFactory.createBoss1(map.getTile(35, 25)));
			creatures.add(CreatureFactory.createBoss2(map.getTile(6, 16)));
			creatures.add(CreatureFactory.createBoss3(map.getTile(35, 6)));

			player = game.getCharacter();
			
			music = new Music("data/b_jean.ogg");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
	
		if(!music.playing())
			music.loop() ;
		InputHandler.handleInput(container, delta, player);
		
			//TODO: Change this

			creatures.creatureFactory();
			creatures.removeBodies();
			creatures.creaturesAI(delta);
			
		
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics gr) throws SlickException {
		
		//if (background != null)
		//	gr.drawImage(background, 0, 0);
		
		console.draw();
		tiledmap.render(0, 90);
		ItemRenderer.render();
		CreatureRenderer.render();
		CharacterRenderer.render();
		StatusRenderer.render(gr);
		LevelRenderer.render(gr);
		//EquipmentRenderer.render(gr);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
