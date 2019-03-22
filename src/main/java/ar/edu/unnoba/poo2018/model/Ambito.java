package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Ambitos")
@NamedQueries(
		@NamedQuery(
				name = "Ambito.getAll",
				query = "select a from Ambito a")
)
public class Ambito extends AbstractEntity {

	private String nombre;
	private String descripcion;

	public Ambito(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Ambito(){}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
