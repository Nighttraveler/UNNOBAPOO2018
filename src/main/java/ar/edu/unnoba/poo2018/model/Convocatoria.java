package ar.edu.unnoba.poo2018.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Convocatorias")
@NamedQueries(
		@NamedQuery(
				name = "Convocatoria.getAll",
				query = "select c from Convocatoria c")
)
public class Convocatoria extends AbstractEntity{

	@NotNull
	private String nombre;
	private String descripcion;

    public Convocatoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Convocatoria(){}

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
