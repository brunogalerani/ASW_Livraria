package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VideoGame extends Eletronicos {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
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
