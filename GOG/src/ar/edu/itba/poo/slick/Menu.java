package ar.edu.itba.poo.slick;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState {

	public Menu() {
		// TODO Auto-generated constructor stub
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
		if(input.isKeyPressed(Input.KEY_1)){
			sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		}

	}
	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(Color.white);
	    g.drawString("Main Menu", 50, 10);
	 
	    g.drawString("1. Play Game", 50, 100);
	    g.drawString("2. Load Game", 50, 120);
	    g.drawString("3. Quit", 50, 140);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
