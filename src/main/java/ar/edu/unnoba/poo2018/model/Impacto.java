package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Impactos")
public class Impacto extends AbstractEntity{

	private Objetivo objetivo;
	private int peso;

	public Impacto(int peso, Objetivo objetivo) {
		this.peso = peso;
		this.objetivo = objetivo;
	}

	public Impacto(){}

	public Impacto(int peso) {
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}
	
}
