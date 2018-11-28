package model;

public class Pouzivatel {
	private int id;
	private String meno;
	private String priezvisko;
	private Adresa adresa;
	private String bankove_spojenie;
	private boolean zamestnany;
	private String rodneCislo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMeno() {
		return meno;
	}
	public void setMeno(String meno) {
		this.meno = meno;
	}
	public String getPriezvisko() {
		return priezvisko;
	}
	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public String getBankove_spojenie() {
		return bankove_spojenie;
	}
	public void setBankove_spojenie(String bankove_spojenie) {
		this.bankove_spojenie = bankove_spojenie;
	}
	public boolean isZamestnany() {
		return zamestnany;
	}
	public void setZamestnany(boolean zamestnany) {
		this.zamestnany = zamestnany;
	}
	public String getRodneCislo() {
		return rodneCislo;
	}
	public void setRodneCislo(String rodneCislo) {
		this.rodneCislo = rodneCislo;
	}
	
	public Pouzivatel(int id, String meno, String priezvisko, Adresa adresa, String bankove_spojenie,
			boolean zamestnany) {
		this.id = id;
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.adresa = adresa;
		this.bankove_spojenie = bankove_spojenie;
		this.zamestnany = zamestnany;
	}
	
	
	
}
