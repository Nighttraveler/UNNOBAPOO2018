package ar.edu.unnoba.poo2018.model;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Actividades")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Actividad_Tipo", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
		@NamedQuery(name = "actividad.getAll",
				query = "Select a From AbstractActividad a order by a.nombre")
})
public abstract class AbstractActividad extends AbstractEntity {

    // ---------------------------------------------- Atributos
	@NotNull
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private String resolucion;
	private String expediente;

    @ManyToOne(fetch = FetchType.LAZY)
	private Convocatoria convocatoria;

    @ManyToOne(fetch = FetchType.LAZY)
	private LineaEstrategica linea;

    @ManyToOne(fetch = FetchType.LAZY)
	private Ambito ambito;

    @ManyToMany
    @JoinTable(name = "actividad_usuario",
                joinColumns = @JoinColumn(name = "actividad_id"),
                inverseJoinColumns= @JoinColumn(name = "usuario_id")
    )
	private List<Usuario> responsables = new ArrayList<>();

	//----------------------------------------------- Constructores


    public AbstractActividad(String nombre, Date fechaInicio, Date fechaFin, String resolucion,
                     String expediente, Convocatoria convocatoria,
                     LineaEstrategica linea, Ambito ambito, List<Usuario> responsables) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.resolucion = resolucion;
        this.expediente = expediente;
        this.convocatoria = convocatoria;
        this.linea = linea;
        this.ambito = ambito;
        this.responsables = responsables;
    }

    public AbstractActividad(){}

	// ---------------------------------------------- Getters & Setters

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	
	public String getExpediente() {
		return expediente;
	}
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	
	public Convocatoria getConvocatoria() {
		return convocatoria;
	}
	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}
	
	public LineaEstrategica getLinea() {
		return linea;
	}
	public void setLinea(LineaEstrategica linea) {
		this.linea = linea;
	}
	
	public Ambito getAmbito() {
		return ambito;
	}
	public void setAmbito(Ambito ambito) {
		this.ambito = ambito;
	}
	
	public void addUsuario(Usuario user) {
		responsables.add(user);
	}
	public void removeUsuario(Usuario user) {
		responsables.remove(user);
	}
	public List<Usuario> getResponsables(){
		return responsables;
	}
	public void setResponsables(List<Usuario> responsables) {
		this.responsables = responsables;
	}

	public abstract List<Impacto> getImpactos();

}
