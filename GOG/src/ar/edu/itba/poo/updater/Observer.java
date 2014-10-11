package ar.edu.itba.poo.updater;


public interface Observer<T extends Observable> {
	
	public void handleUpdate(T data);
}
