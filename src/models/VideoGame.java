package models;

import javax.persistence.Entity;

@Entity
public class VideoGame extends Eletronicos {
	
	private String midia;
	private String plataformaSuportada;

	public VideoGame() {
		super();
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public String getPlataformaSuportada() {
		return plataformaSuportada;
	}

	public void setPlataformaSuportada(String plataformaSuportada) {
		this.plataformaSuportada = plataformaSuportada;
	}

}
