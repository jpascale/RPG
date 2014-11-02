package ar.edu.itba.poo.handlers;

import ar.edu.itba.poo.render.StatusRenderer;
import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.gamelogic.Status;

public class StatusHandler implements Observer<Status> {
	
	StatusRenderer renderer;

	public StatusHandler(Status data) {
		renderer = new StatusRenderer(data.getMinhp(), data.getMaxhp(), data.getMinman(), data.getMaxman());
	}

	@Override
	public void handleUpdate(Status data) {
		renderer.setMaxhp(data.getMaxhp());
		renderer.setMinhp(data.getMinhp());
		renderer.setMaxmp(data.getMaxman());
		renderer.setMinmp(data.getMinman()); 
	}

}
