package ar.edu.unnoba.poo2018.model;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
@NamedQueries({
		@NamedQuery(name = "Usuario.findByEmailAndPassword",
				query = "select u from Usuario u where u.email = :email and u.password = :password"
		)
})
public class Usuario extends AbstractEntity {


    @Column(name = "nombre")
	private String nombre;

    @Column(name = "password")
	private String password;

    @Column(name = "administrador")
	private boolean administrador;

    @Column(name = "email")
    private String email;

    public Usuario(){

	}

	public Usuario(String nombre, String password, boolean administrador) {
		this.nombre = nombre;

	    this.password = password;

		this.administrador = administrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
