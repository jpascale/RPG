package ar.edu.itba.poo.gamelogic;


public class ItemList extends DrawableList<Item> {
	
	public void removeBodies(){
		for(Item drawable : super.getDrawableList()){
			if(drawable.getPos() == null)
				super.remove(drawable);
		}
	}

}
