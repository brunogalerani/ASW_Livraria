package models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Eletronicos extends Produto {

	private String cor;
	private double altura;
	private double largura;
	private double profundidade;
	private double potencia;
	private int alimentacao;
	private double consumo;
	private String bateria;
	private LocalDate garantia;
	private String modelo;
	private String marca;
	private String fabricante;
	private double armazenamento;
	private double peso;

	public Eletronicos() {
		super();
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public int getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(int alimentacao) {
		this.alimentacao = alimentacao;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public String getBateria() {
		return bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	public LocalDate getGarantia() {
		return garantia;
	}

	public void setGarantia(LocalDate garantia) {
		this.garantia = garantia;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(double armazenamento) {
		this.armazenamento = armazenamento;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}
