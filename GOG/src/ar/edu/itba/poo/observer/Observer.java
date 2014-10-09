package ar.edu.itba.poo.observer;

public interface Observer<T extends Observable> {
	
	public void handleUpdate(T data);
}
