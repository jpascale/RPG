package ar.edu.itba.poo.worldlogic;

//TODO: Ask if is not ugly
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
			
			default: //WEST
				ret = EAST;
				break;
		}
		
		return ret;
		
	}
} 
