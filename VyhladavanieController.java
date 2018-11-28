package controller;

import java.util.ArrayList;

import application.Observable;
import application.Observer;
import model.Adresa;
import model.Pouzivatel;
import view.VyhladavanieForm;

public class VyhladavanieController implements Observer, Observable{
	private ArrayList<Pouzivatel> data = new ArrayList<Pouzivatel>();
	public Pouzivatel vyhPouzivatel;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public VyhladavanieForm vyhForm;
	
	public VyhladavanieForm getVyhForm() {
		return vyhForm;
	}

	public void setVyhForm(VyhladavanieForm vyhForm) {
		this.vyhForm = vyhForm;
	}

	public VyhladavanieController() {
		this.data.add(new Pouzivatel(1, "Jan", "Arbet",
				new Adresa("Vy�n� fabriky", 16, "Liptovsk� Hr�dok", "033 01", "Slovensk� republika"), "123", false));
		this.data.add(new Pouzivatel(2, "Frantisek", "Mrkva",
				new Adresa("Vy�n� fabriky", 25, "Liptovsk� Mikul�", "033 02", "Slovensk� republika"), "223", false));
		this.data.add(new Pouzivatel(3, "Michal", "Arbet",
				new Adresa("Vy�n� fabriky", 15, "Praha", "033 03", "�esk� republika"), "124", false));
		this.data.add(new Pouzivatel(4, "Jan", "XXX",
				new Adresa("Vy�n� fabriky", 556, "Liptovsk� Hr�dok", "033 04", "Slovensk� republika"), "153", false));
		this.data.add(new Pouzivatel(5, "Jan", "ZZZ",
				new Adresa("Vy�n� fabriky", 66, "Liptovsk� Hr�dok", "033 05", "Slovensk� republika"), "163", false));
	}

	public void vyhladaj(String type, String str) {
		this.vyhPouzivatel=null;
		for (Pouzivatel pouzivatel : data) {
			if(type.equals("ID")) {
				if(pouzivatel.getId()==Integer.parseInt(str)) {
					this.vyhPouzivatel=pouzivatel;
				}
			}
			if(type.equals("Rodn� ��slo")) {
				if(pouzivatel.getRodneCislo().equals(str)) this.vyhPouzivatel=pouzivatel;
			}
		}
	}

	@Override
	public void update(String o, Object arg) {
		System.out.println("Vyhladavanie controller");
		
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
