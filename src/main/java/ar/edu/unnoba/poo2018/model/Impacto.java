package ar.edu.unnoba.poo2018.model;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;

@Entity
@Table(name = "Impactos")
public class Impacto extends AbstractEntity{

	@ManyToOne
    @JoinColumn(name = "objetivo_id")
    @CascadeOnDelete
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
