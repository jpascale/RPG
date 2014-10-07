package ar.edu.itba.poo.gamelogic;

public class LevelProfile {
	
	public static int MAX_LVL = 47;
	public static int EXP_CONST = 50;
	
	private int level;
	
	private int exp;
	private int maxexp;
	
	public LevelProfile(){
		
		this.level = 1;
		this.exp = 0;
		this.maxexp = EXP_CONST;
	}
	
	public void levelUp(){
		if (this.level != MAX_LVL) {
			this.level++;
			this.exp = 0;
			this.maxexp = EXP_CONST * this.level;
			
			//TODO: Update stats (+ combo hit);
		}
	}
	
	public void gainExp(int exp){

			
			//Leveling up many times with much exp
			while (this.maxexp - this.exp <= exp){
				exp -= (this.maxexp - this.exp);
				levelUp();
			}
			
			if (this.level != MAX_LVL)
				this.exp += exp;
			
			//TODO: notify observer
		
	}
	
	/*
	 *		Getters & Setters
	 */

	public int getLevel() {
		return level;
	}

	public int getExp() {
		return exp;
	}

	public int getMaxexp() {
		return maxexp;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setMaxexp(int maxexp) {
		this.maxexp = maxexp;
	}
	
}
