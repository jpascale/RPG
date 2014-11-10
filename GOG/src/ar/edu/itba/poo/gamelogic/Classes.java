package ar.edu.itba.poo.gamelogic;

public enum Classes {
	
	WARRIOR,
	WIZARD;

	public static String WARRIOR_NAME = "Warrior";
	public static String WIZARD_NAME = "Wizard";
	
	public String getString(){
		
		String ret = null;
		
		switch (this){
		
			case WARRIOR:
				ret = WARRIOR_NAME;
				break;
				
			case WIZARD:
				ret = WIZARD_NAME;
				break;
		}
		
		return ret;
	}
		
	}

