package ar.edu.itba.poo.frontend;

import java.io.File;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import ar.edu.itba.poo.IO.GameIO;
import ar.edu.itba.poo.IO.GameSlot;
import ar.edu.itba.poo.gamelogic.Classes;
import ar.edu.itba.poo.handlers.GameFactory;


public class Menu extends BasicGameState {
	
	Image land;
	File loadfile;
	int menutype = 0;
	private String[][] menu = { {"1. New Game","2. Load Game","3. Exit"}, 
								{"1. Warrior","2. Wizard", "3. Back"}, 
								{"1. File 1", "2. File 2", "3. File 3", "4. Back"} };
	
	
	public Menu(){
		try {
			land = new Image("data/bkg.jpg");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {

	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			container.exit();
		}
		
		if(menutype == 0){
			if(input.isKeyPressed(Input.KEY_1)){
				menutype = 1;
			}
			if(input.isKeyPressed(Input.KEY_2)){
				menutype = 2;
			}
			if(input.isKeyPressed(Input.KEY_3)){
				container.exit();
			}
		}
		if(menutype == 1){
			if(input.isKeyPressed(Input.KEY_1)){
				GameFactory.gameInitializer(Classes.WARRIOR);
				sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
			if(input.isKeyPressed(Input.KEY_2)){
				GameFactory.gameInitializer(Classes.WIZARD);
				sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
			if(input.isKeyPressed(Input.KEY_3)){
				menutype = 0;
			}
		}
		if(menutype == 2){
			if(input.isKeyPressed(Input.KEY_1)){
				loadfile = new File(GameSlot.SLOT1_DIR);
				if(loadfile.exists() && !loadfile.isDirectory()){ 
					GameIO.loadGame(GameSlot.SLOT_1);
					sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
				}
			}
			if(input.isKeyPressed(Input.KEY_2)){
				loadfile = new File(GameSlot.SLOT2_DIR);
				if(loadfile.exists() && !loadfile.isDirectory()){ 
					GameIO.loadGame(GameSlot.SLOT_2);
					sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
				}
			}
			if(input.isKeyPressed(Input.KEY_3)){
				loadfile = new File(GameSlot.SLOT3_DIR);
				if(loadfile.exists() && !loadfile.isDirectory()){ 
					GameIO.loadGame(GameSlot.SLOT_3);
					sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
				}
			}
			if(input.isKeyPressed(Input.KEY_4)){
				menutype = 0;
			}
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		land.draw(0, 0, 820, 570);
		
		g.setColor(Color.black);
	    g.drawString("Main Menu", 50, 130);
	    
	    int i = 0;
	    for (String strings : menu[menutype]) {
	    	g.drawString(strings, 60, 180 + 30*i);
	    	i++;
		}
	}

	@Override
	public int getID() {
		return 0;
	}

}
