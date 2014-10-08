package ar.edu.itba.poo.gamelogic;

public class Wizard extends Strategy {
	
	private static String WIZARD_NAME = "Wizard";
	private static int WIZARD_HP_MODIF = 5;
	private static int WIZARD_MAN_MODIF = 10;
	
	public Wizard() {
		super(WIZARD_NAME, WIZARD_HP_MODIF, WIZARD_MAN_MODIF);
		// TODO Auto-generated constructor stub
	}

	//TODO Implement attack.
	@Override
	public void attack(Alive alive) {
		// TODO Auto-generated method stub
		
	}

}
