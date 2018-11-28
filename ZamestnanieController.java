package controller;


import java.util.ArrayList;
import application.Observable;
import application.Observer;
import view.VyhladavanieForm;
import view.ZamestnanieForm;


public class ZamestnanieController implements Observer, Observable {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	public VyhladavanieController vyhController;
	public VyhladavanieForm vyhForm;
	public ZamestnanieForm zamForm;
	
	public VyhladavanieController getVyhController() {
		return vyhController;
	}

	public void setVyhController(VyhladavanieController vyhController) {
		this.vyhController = vyhController;
	}

	public VyhladavanieForm getVyhForm() {
		return vyhForm;
	}

	public void setVyhForm(VyhladavanieForm vyhForm) {
		this.vyhForm = vyhForm;
	}
	
	public ZamestnanieForm getZamForm() {
		return zamForm;
	}

	public void setZamForm(ZamestnanieForm zamForm) {
		this.zamForm = zamForm;
	}


	@Override
	public void update(String o, Object msg) {
		System.out.println("update    "+this.getClass().getName() + "    " + msg);
		
		if(msg.equals("Zobraz zamForm")) {
			this.zamForm.vytvor();
			this.zamForm.zobraz();
		}
		
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers(Object msg) {
		for (Observer ob : observers) {
			System.out.println("Notifying Observers from" + this.getClass().getName());
			ob.update(this.toString(),msg);
		}
		
	}
	
	
}
