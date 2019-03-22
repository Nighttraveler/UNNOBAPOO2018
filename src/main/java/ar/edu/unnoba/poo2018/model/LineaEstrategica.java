package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "LineaEstrategicas")
@NamedQueries(
		@NamedQuery(
				name = "LineaEstrategica.getAll",
				query = "select l from LineaEstrategica l")
)
public class LineaEstrategica extends AbstractEntity{

	private String nombre;
	private String descripcion;

	public LineaEstrategica(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public LineaEstrategica(){}

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
