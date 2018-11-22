package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Objetivos")
public class Objetivo extends AbstractEntity{

	
	private String nombre;

	public Objetivo(String nombre) {
		this.nombre = nombre;
	}

	public Objetivo(){}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
