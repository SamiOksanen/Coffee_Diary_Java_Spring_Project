package fi.hh.coffeediary.bean;

import java.sql.Date;

public class Kahvi {
	
	private int id;
	private int maara;
	private Date paiva;
	
	public Kahvi(int id, int maara, Date paiva) {
		super();
		this.id = id;
		this.maara = maara;
		this.paiva = paiva;
	}
	public Kahvi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaara() {
		return maara;
	}
	public void setMaara(int maara) {
		this.maara = maara;
	}
	public Date getPaiva() {
		return paiva;
	}
	public void setPaiva(Date paiva) {
		this.paiva = paiva;
	}
	
	@Override
	public String toString() {
		return "Kahvi [id=" + id + ", maara=" + maara + ", paiva=" + paiva + "]";
	}

}
