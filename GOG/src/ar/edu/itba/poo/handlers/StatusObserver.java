package ar.edu.itba.poo.handlers;

import ar.edu.itba.poo.render.StatusRenderer;
import ar.edu.itba.poo.slick.Console;
import ar.edu.itba.poo.gamelogic.Character;
import ar.edu.itba.poo.gamelogic.Status;

public class StatusObserver implements Observer<Character> {
	
	StatusRenderer renderer;

	public StatusObserver(Character data) {
		Status status = data.getStatus();
		renderer = new StatusRenderer(status.getMinhp(), status.getMaxhp(), status.getMinman(), status.getMaxman());
	}

	@Override
	public void handleUpdate(Character data) {
		renderer.setMaxhp(data.getStatus().getMaxhp());
		renderer.setMinhp(data.getStatus().getMinhp());
		renderer.setMaxmp(data.getStatus().getMaxman());
		renderer.setMinmp(data.getStatus().getMinman());
	}

}
