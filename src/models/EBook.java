package models;

import javax.persistence.Entity;

@Entity
public class EBook extends Livro {

	private double tamanhoArquivo;
	private String formato;

	public EBook() {
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
