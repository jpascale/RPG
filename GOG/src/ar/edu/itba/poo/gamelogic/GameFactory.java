package ar.edu.itba.poo.gamelogic;


public class GameFactory {

	String savedata = null;
	
	public GameFactory(Classes characterclass) {
		
	}
	
	public GameFactory(String savedata){
		this.savedata = savedata;
	}
	
	public static void gameInitializer(Classes characterclass){
		Game game = Game.getInstance();
		Character player = game.getCharacter();
		
	}
	

}
