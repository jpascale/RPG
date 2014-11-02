package ar.edu.itba.poo.slick;

import java.io.ObjectInputStream.GetField;

import ar.edu.itba.poo.IO.GameIO;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.render.CharacterRenderer;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.worldlogic.EndOfMapException;
import ar.edu.itba.poo.gamelogic.Character;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public abstract class InputHandler {
	
	private static Game game = Game.getInstance();

	public static int ACTION_INTERVAL = 150; // 0.15 seconds
	private static int interval = 0;
	
	
	public static void handleInput(GameContainer container, int delta, Character player){
		
		Input input = container.getInput();
		//Character player = game.getCharacter();
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			container.exit();
		}
		
		interval += delta;
		
		if (interval >= ACTION_INTERVAL){
			try {
				if (input.isKeyDown(Input.KEY_UP)){
					CharacterRenderer.setMoving(true);
					player.move(Dir.NORTH);
					interval = 0;
				}
				else if (input.isKeyDown(Input.KEY_DOWN)){
					CharacterRenderer.setMoving(true);
					player.move(Dir.SOUTH);
					interval = 0;
				}
				else if (input.isKeyDown(Input.KEY_LEFT)){
					CharacterRenderer.setMoving(true);
					player.move(Dir.WEST);
					interval = 0;
				}
				else if (input.isKeyDown(Input.KEY_RIGHT)){
					CharacterRenderer.setMoving(true);
					player.move(Dir.EAST);
					interval = 0;
				}
				else if (input.isKeyPressed(Input.KEY_SPACE)){
					player.attack();
					interval = 0;
				}
				else if(input.isKeyPressed(Input.KEY_A)){
					player.itemAction();
				}
				else if(input.isKeyPressed(Input.KEY_Q)){
					player.getEquip().changeWeapon();
				}
				else if(input.isKeyPressed(Input.KEY_Y)){
					GameIO.saveGame();
				}
				//Para probar mapa
				
				else if (input.isKeyPressed(Input.KEY_M)){
					Console.add("Mi posicion es " + player.getPos().getX() + " " + player.getPos().getY());
					interval = 0;
				}
				
				else if(input.isKeyPressed(Input.KEY_S)){
					Console.add("HP: " + player.getStatus().getMinhp() + "/" + player.getStatus().getMaxhp() + "; Lvl: " + player.getLvl().getLevel() + "; Exp: " + player.getLvl().getExp() + "/ "+ player.getLvl().getMaxexp()); 
				}
				
				else if(input.isKeyPressed(Input.KEY_Z)){
					player.getStatus().heal();
					player.notifyObservers();
				}
				
				else
					CharacterRenderer.setMoving(false);
				
			} catch (EndOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (interval >= ACTION_INTERVAL)
				interval = ACTION_INTERVAL;
			
		}
		
	}
}
