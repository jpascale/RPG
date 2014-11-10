package ar.edu.itba.poo.slick;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

import ar.edu.itba.poo.IO.GameIO;
import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.gamelogic.CreatureFactory;
import ar.edu.itba.poo.gamelogic.CreatureList;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.ItemFactory;
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
			background = new Image("data/main.jpg");
		//Use "Exception" because it ends execution otherwise
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Could not find data/main.jpg");
		}
	}
	

	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		try {
			
			game = Game.getInstance();
			
			GameIO.setGame(game);
			
			console = new Console();
			Console.add("Bienvenido a Game of Games!");
	
			map = game.getWorld();
			
			graphicmap = GraphicMap.getInstance();
			graphicmap.setWorldTriggers();
			
			tiledmap = graphicmap.getTiledMap();
			 
			
			music = new Music("data/b_jean.ogg");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		
		player = game.getCharacter();
		creatures = game.getCreatureList();
		
		if(!music.playing())
			music.loop() ;
		InputHandler.handleInput(container, delta, player);

			creatures.creatureFactory();
			creatures.removeBodies();
			creatures.creaturesAI(delta);
			
			if(game.isEndgame()){
				sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
				
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics gr) throws SlickException {
		
		if (background != null)
			background.draw(0, 0, 820, 570);
		
		console.draw();
		tiledmap.render(0, 90);
		ItemRenderer.render();
		CreatureRenderer.render();
		CharacterRenderer.render();
		StatusRenderer.render(gr);
		LevelRenderer.render(gr);
		EquipmentRenderer.render(gr);
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
