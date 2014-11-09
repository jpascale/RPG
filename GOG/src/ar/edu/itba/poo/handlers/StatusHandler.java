package ar.edu.itba.poo.handlers;

import ar.edu.itba.poo.gamelogic.Status;
import ar.edu.itba.poo.render.StatusRenderer;

public class StatusHandler implements Observer<Status> {
	
	StatusRenderer renderer;

	public StatusHandler(Status data) {
		renderer = new StatusRenderer(data.getMinhp(), data.getMaxhp(), data.getMinman(), data.getMaxman());
	}
	
	/**
	 * Notifies the StatusRenderer the change 
	 * in HP and Mana of the Character. 
	 * 
	 * @param data Character;
	 */
	@Override
	public void handleUpdate(Status data) {
		renderer.setMaxhp(data.getMaxhp());
		renderer.setMinhp(data.getMinhp());
		renderer.setMaxmp(data.getMaxman());
		renderer.setMinmp(data.getMinman()); 
	}

}
