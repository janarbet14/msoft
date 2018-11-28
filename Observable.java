package application;

public interface Observable {
	public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers(Object msg);
	
}
