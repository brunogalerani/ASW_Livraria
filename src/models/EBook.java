package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EBook extends Livro {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double tamanhoArquivo;
	private String formato;

	public EBook() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTamanhoArquivo() {
		return tamanhoArquivo;
	}

	public void setTamanhoArquivo(double tamanhoArquivo) {
		this.tamanhoArquivo = tamanhoArquivo;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

}
