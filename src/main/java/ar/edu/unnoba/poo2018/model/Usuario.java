package ar.edu.unnoba.poo2018.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario extends AbstractEntity {


    @Column(name = "nombre")
	private String nombre;

    @Column(name = "clave")
	private String clave;

    @Column(name = "administrador")
	private boolean administrador;

    public Usuario(){

	}

	public Usuario(String nombre, String clave, boolean administrador) {
		this.nombre = nombre;

	    this.clave = clave;

		this.administrador = administrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
}
