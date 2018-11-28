package model;

import java.util.ArrayList;

public class Zamestnanie {
	private int id;
	private int zamestnanec_id;
	private int tarifa;
	private ArrayList<Ziadost> ziadosti;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getZamestnanec_id() {
		return zamestnanec_id;
	}
	public void setZamestnanec_id(int zamestnanec_id) {
		this.zamestnanec_id = zamestnanec_id;
	}
	public int getTarifa() {
		return tarifa;
	}
	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}
	public ArrayList<Ziadost> getZiadosti() {
		return ziadosti;
	}
	public void setZiadosti(ArrayList<Ziadost> ziadosti) {
		this.ziadosti = ziadosti;
	}
	public Zamestnanie(int id, int zamestnanec_id, int tarifa, ArrayList<Ziadost> ziadosti) {
		super();
		this.id = id;
		this.zamestnanec_id = zamestnanec_id;
		this.tarifa = tarifa;
		this.ziadosti = ziadosti;
	}
	
	
}
