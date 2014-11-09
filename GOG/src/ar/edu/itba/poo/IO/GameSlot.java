package ar.edu.itba.poo.IO;

public enum GameSlot {
	
	SLOT_1,
	SLOT_2,
	SLOT_3;

	public static String slot1_dir = "data/slot1.gog";
	public static String slot3_dir = "data/slot3.gog";
	public static String slot2_dir = "data/slot2.gog";
	
	public String getStreamDir(){

		String ret;
		
		switch (this){

			case SLOT_1:
				ret = slot1_dir;
				break;
			
			case SLOT_2:
				ret = slot2_dir;
				break;
				
			case SLOT_3:
				ret = slot3_dir;
				break;
				
			default:
				ret = "dump.gog";
				break;
		}
		
		return ret;
	}
	
}
