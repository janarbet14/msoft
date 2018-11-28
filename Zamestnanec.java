package model;

public class Zamestnanec extends Pouzivatel {
	private int id_zamestnavatel;

	public Zamestnanec(int id, String meno, String priezvisko, Adresa adresa, String bankove_spojenie,
			boolean zamestnany, int id_zamestnavatel) {
		super(id, meno, priezvisko, adresa, bankove_spojenie, zamestnany);
		this.id_zamestnavatel = id_zamestnavatel;
	}

	public int getId_zamestnavatel() {
		return id_zamestnavatel;
	}

	public void setId_zamestnavatel(int id_zamestnavatel) {
		this.id_zamestnavatel = id_zamestnavatel;
	}

}
