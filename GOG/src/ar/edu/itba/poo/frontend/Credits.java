package ar.edu.itba.poo.frontend;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Credits extends BasicGameState {

	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {

	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			container.exit();
		}
		
		if(input.isKeyPressed(Input.KEY_ENTER)){
			container.exit();
		}

	}
	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics gr)
			throws SlickException {
			gr.setColor(Color.white);
			gr.drawString("Felicitaciones, has ganado el juego!!!", 250, 250);
			gr.drawString("Presione Enter para salir del juego.", 250, 300);

	}

	@Override
	public int getID() {
		return 2;
	}

}
