package ar.edu.itba.poo.slick;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameStateMachine extends StateBasedGame {

	public GameStateMachine(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new Menu());
		addState(new RPG("GOG"));
		addState(new Credits());
	}
	
}
