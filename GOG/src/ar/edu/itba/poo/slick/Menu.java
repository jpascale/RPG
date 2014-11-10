package ar.edu.itba.poo.slick;

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
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.gamelogic.GameFactory;
import ar.edu.itba.poo.gamelogic.Warrior;
import ar.edu.itba.poo.gamelogic.Wizard;

public class Menu extends BasicGameState {
	
	Image land;
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
				GameIO.loadGame(GameSlot.SLOT_1);
				sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
			if(input.isKeyPressed(Input.KEY_2)){
				sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
			if(input.isKeyPressed(Input.KEY_3)){
				sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
			if(input.isKeyPressed(Input.KEY_4)){
				menutype = 0;
			}
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(land, 0, 0);
		
		g.setColor(Color.black);
	    g.drawString("Main Menu", 50, 10);
	    
	    int i = 0;
	    for (String strings : menu[menutype]) {
	    	g.drawString(strings, 50, 100 + 20*i);
	    	i++;
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
