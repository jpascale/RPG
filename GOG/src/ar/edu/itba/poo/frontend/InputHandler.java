package ar.edu.itba.poo.frontend;

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
	
	public static int NO_MANA = -1;
	
	public static String MSG_NO_SELECTED_THROW_ITEM = "No puedes tirar el item.";
	public static String MSG_ATTACK_CREATURE = "Has atacado a la criatura!";
	public static String MSG_DAMAGE_CREATURE = "Le has pegado a la criatura por ";
	public static String MSG_RECOVER_MANA = "Has recuperado tu mana.";
	public static String MSG_NOT_RECOVER_MANA = "No puedes meditar.";
	public static String MSG_EXCLAMATION = "!!!";
	public static String MSG_NO_MANA = "Necesitas meditar (Tecla M) para poder atacar";
	public static String MSG_DEAD_CREATURE = "Has matado a la criatura!";
	
	
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
					handleAttack(player);
					interval = 0;
				}
				
				else if (input.isKeyPressed(Input.KEY_M)){
					handleMeditate(player);
				}
				
				//Items
				else if(input.isKeyPressed(Input.KEY_A)){
					handleItemAction(player);
				}
				else if(input.isKeyPressed(Input.KEY_Q)){
					handleEquipmentAction(player);
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
	
	public static void handleAttack(Character player){
		int damage = player.attack();
		
		if (damage == NO_MANA){
			Console.add(MSG_NO_MANA);
		}
		if (damage > 0){
			Console.add(MSG_ATTACK_CREATURE);
			Console.add(MSG_DAMAGE_CREATURE + damage + MSG_EXCLAMATION);
		
		}
	}
	
	public static void handleMeditate(Character player){
		if (player.meditate())
			Console.add(MSG_RECOVER_MANA);
		else
			Console.add(MSG_NOT_RECOVER_MANA);
	}
	
	public static void handleItemAction(Character player){
		if (!player.itemAction())
			Console.add(MSG_NO_SELECTED_THROW_ITEM);
	}
	
	public static void handleEquipmentAction(Character player){
		player.getEquip().changeWeapon();
	}
	
	public static void handleDeadCreature(){
		Console.add(MSG_DEAD_CREATURE);
	}
}
