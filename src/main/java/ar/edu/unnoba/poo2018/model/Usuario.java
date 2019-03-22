package ar.edu.unnoba.poo2018.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuarios")
@NamedQueries({
		@NamedQuery(
			name = "Usuario.findByEmailAndPassword",
			query = "select u from Usuario u where u.email = :email and u.password = :password"
		),
		@NamedQuery(
			name="Usuario.getAll",
			query = "select u from Usuario u")
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

	@ManyToMany
	@JoinTable(name = "actividad_usuario",
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns= @JoinColumn(name = "actividad_id")
	)
	private List<AbstractActividad> actividades = new ArrayList<>();

    public Usuario(){

	}

	public Usuario(String nombre, String password, boolean administrador, String email) {
		this.nombre = nombre;

	    this.password = password;

		this.administrador = administrador;

		this.email = email;
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

	public List<AbstractActividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<AbstractActividad> actividades) {
		this.actividades = actividades;
	}
}
