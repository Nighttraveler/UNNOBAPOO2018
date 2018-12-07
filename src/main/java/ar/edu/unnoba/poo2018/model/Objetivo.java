package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Objetivos")
@NamedQueries(
		@NamedQuery(
				name = "Objetivo.getAll",
				query = "select o from Objetivo o")
)
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
