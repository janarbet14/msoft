package model;

public class Adresa {
	private String ulica;
	private int popis_cislo;
	private String obec;
	private String PSC;
	private String stat;
	
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public int getPopis_cislo() {
		return popis_cislo;
	}
	public void setPopis_cislo(int popis_cislo) {
		this.popis_cislo = popis_cislo;
	}
	public String getObec() {
		return obec;
	}
	public void setObec(String obec) {
		this.obec = obec;
	}
	public String getPSC() {
		return PSC;
	}
	public void setPSC(String pSC) {
		PSC = pSC;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	
	public Adresa(String ulica, int popis_cislo, String obec, String pSC, String stat) {
		super();
		this.ulica = ulica;
		this.popis_cislo = popis_cislo;
		this.obec = obec;
		PSC = pSC;
		this.stat = stat;
	}
	
	
}
