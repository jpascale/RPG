package ar.edu.itba.poo.IO;

public enum GameSlot {
	
	SLOT_1,
	SLOT_2,
	SLOT_3;

	public static String SLOT1_DIR = "data/slot1.gog";
	public static String SLOT2_DIR = "data/slot2.gog";
	public static String SLOT3_DIR = "data/slot3.gog";
	
	public static String SLOT1_NAME = "Slot 1";
	public static String SLOT2_NAME = "Slot 2";
	public static String SLOT3_NAME = "Slot 3";
	
	public String getStreamDir(){

		String ret;
		
		switch (this){

			case SLOT_1:
				ret = SLOT1_DIR;
				break;
			
			case SLOT_2:
				ret = SLOT2_DIR;
				break;
				
			case SLOT_3:
				ret = SLOT3_DIR;
				break;
				
			default:
				ret = "dump.gog";
				break;
		}
		
		return ret;
	}
	
	public String getName(){

		String ret;
		
		switch (this){

			case SLOT_1:
				ret = SLOT1_NAME;
				break;
			
			case SLOT_2:
				ret = SLOT2_NAME;
				break;
				
			case SLOT_3:
				ret = SLOT3_NAME;
				break;
				
			default:
				ret = SLOT1_NAME;
				break;
		}
		
		return ret;
	}
	
}
