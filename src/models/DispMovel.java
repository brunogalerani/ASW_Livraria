package models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class DispMovel extends Eletronicos {

	private boolean touchScreen;
	private double tamanhoTela;
	private String tipoChip;
	private int quantidadeChip;
	private String tecnologiaSuportada;
	private String resolucao;

	public DispMovel() {
		super();
	}

	public boolean isTouchScreen() {
		return touchScreen;
	}

	public void setTouchScreen(boolean touchScreen) {
		this.touchScreen = touchScreen;
	}

	public double getTamanhoTela() {
		return tamanhoTela;
	}

	public void setTamanhoTela(double tamanhoTela) {
		this.tamanhoTela = tamanhoTela;
	}

	public String getTipoChip() {
		return tipoChip;
	}

	public void setTipoChip(String tipoChip) {
		this.tipoChip = tipoChip;
	}

	public int getQuantidadeChip() {
		return quantidadeChip;
	}

	public void setQuantidadeChip(int quantidadeChip) {
		this.quantidadeChip = quantidadeChip;
	}

	public String getTecnologiaSuportada() {
		return tecnologiaSuportada;
	}

	public void setTecnologiaSuportada(String tecnologiaSuportada) {
		this.tecnologiaSuportada = tecnologiaSuportada;
	}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

}
