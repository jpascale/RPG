package ar.edu.itba.poo.slick;

import ar.edu.itba.poo.IO.GameIO;
import ar.edu.itba.poo.IO.GameSlot;
import ar.edu.itba.poo.gamelogic.Game;
import ar.edu.itba.poo.render.CharacterRenderer;
import ar.edu.itba.poo.worldlogic.Dir;
import ar.edu.itba.poo.gamelogic.Character;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public abstract class InputHandler {
	
	private static Game game = Game.getInstance();

	public static int ACTION_INTERVAL = 150; // 0.15 seconds
	private static int interval = 0;
	
	public static String MSG_NO_SELECTED_THROW_ITEM = "No puedes tirar el item.";
	public static String MSG_ATTACK_CREATURE = "Has atacado a la criatura!";
	public static String MSG_DAMAGE_CREATURE = "Le haz pegado a la criatura por ";
	
	
	public static void handleInput(GameContainer container, int delta, Character player){
		
		Input input = container.getInput();
		//Character player = game.getCharacter();
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			container.exit();
		}
		
		interval += delta;
		
		if (interval >= ACTION_INTERVAL){

			//Move
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
				
				//Attack
				else if (input.isKeyPressed(Input.KEY_SPACE)){
					int damage = player.attack();
					
					if (damage > 0){
						Console.add(MSG_ATTACK_CREATURE);
						Console.add(MSG_DAMAGE_CREATURE + damage + "!!!");
					}
					
					interval = 0;
				}
				
				//Items
				else if(input.isKeyPressed(Input.KEY_A)){
					if (!player.itemAction())
						Console.add(MSG_NO_SELECTED_THROW_ITEM);
				}
				else if(input.isKeyPressed(Input.KEY_Q)){
					player.getEquip().changeWeapon();
				}
				
				//TODO: CHANGE
				else if(input.isKeyPressed(Input.KEY_Y)){
					GameIO.saveGame(GameSlot.SLOT_1);
				}
				else if(input.isKeyPressed(Input.KEY_H)){
					GameIO.loadGame(GameSlot.SLOT_1);
				}
				
				//Cheat
				else if(input.isKeyPressed(Input.KEY_Z)){
					player.getStatus().heal();
					player.notifyObservers();
				}
				
				else
					CharacterRenderer.setMoving(false);
				
			
			if (interval >= ACTION_INTERVAL)
				interval = ACTION_INTERVAL;
			
		}
		
	}
}
