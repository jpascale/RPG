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
	public static String MSG_DAMAGE_CREATURE = "Le has pegado a la criatura por ";
	public static String MSG_RECOVER_MANA = "Has recuperado tu mana.";
	public static String MSG_NOT_RECOVER_MANA = "No puedes meditar.";
	
	
	public static void handleInput(GameContainer container, int delta, Character player){
		
		Input input = container.getInput();
		
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			container.exit();
		}
		
		interval += delta;
		
		if (interval >= ACTION_INTERVAL){

			//Move
				if (input.isKeyDown(Input.KEY_UP)){
					handleMove(player, Dir.NORTH);
					interval = 0;
				}
				else if (input.isKeyDown(Input.KEY_DOWN)){
					handleMove(player, Dir.SOUTH);
					interval = 0;
				}
				else if (input.isKeyDown(Input.KEY_LEFT)){
					handleMove(player, Dir.WEST);
					interval = 0;
				}
				else if (input.isKeyDown(Input.KEY_RIGHT)){
					handleMove(player, Dir.EAST);
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
				
				else if (input.isKeyPressed(Input.KEY_M)){
					if (player.meditate())
						Console.add(MSG_RECOVER_MANA);
					else
						Console.add(MSG_NOT_RECOVER_MANA);
				}
				
				//Items
				else if(input.isKeyPressed(Input.KEY_A)){
					if (!player.itemAction())
						Console.add(MSG_NO_SELECTED_THROW_ITEM);
				}
				else if(input.isKeyPressed(Input.KEY_Q)){
					player.getEquip().changeWeapon();
				}
				
				// Save
				else if(input.isKeyPressed(Input.KEY_1)){
					GameIO.saveGame(GameSlot.SLOT_1);
				}
				else if(input.isKeyPressed(Input.KEY_2)){
					GameIO.saveGame(GameSlot.SLOT_2);
				}
				else if(input.isKeyPressed(Input.KEY_3)){
					GameIO.saveGame(GameSlot.SLOT_1);
				}

				//Cheat
				else if(input.isKeyPressed(Input.KEY_Z)){
					player.getStatus().heal();
					player.notifyObservers();
				}
				
				else
					handleStopMove();
				
			
			if (interval >= ACTION_INTERVAL)
				interval = ACTION_INTERVAL;
			
		}
		
	}
	
	public static void handleMove(Character player, Dir dir){
		player.move(dir);
		CharacterRenderer.setMoving(true);
	}
	public static void handleStopMove(){
		CharacterRenderer.setMoving(false);
	}
	
}
