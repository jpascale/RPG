package ar.edu.itba.poo.worldlogic;

public enum Dir {
	
		NORTH,
		SOUTH,
		EAST,
		WEST;
		
	public Dir getOpposite(){
		Dir ret;
		
		switch (this){
		
			case NORTH:
				ret = SOUTH;
				break;
				
			case SOUTH:
				ret = NORTH;
				break;
			
			case EAST:
				ret = WEST;
				break;
			
			case WEST:
				ret = EAST;
				
			default:
				ret = NORTH;
				break;
		}
		
		return ret;
		
	}
} 
