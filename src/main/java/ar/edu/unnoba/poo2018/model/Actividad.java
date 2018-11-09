package ar.edu.unnoba.poo2018.model;

import ar.edu.unnoba.poo2018.utils.ObjetivoPesoStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class Actividad {

    // ---------------------------------------------- Atributos
	
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private String resolucion;
	private String expediente;
	private Convocatoria convocatoria;
	private LineaEstrategica linea;
	private Ambito ambito;
	private List<Usuario> responsables = new ArrayList<>();
	private ObjetivoPesoStrategy objetivoPesoStrategy;

	//----------------------------------------------- Constructores


    public Actividad(String nombre, Date fechaInicio, Date fechaFin, String resolucion,
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
	
	public abstract List<Impacto> getImpactos();

	public abstract Map<Objetivo, Integer> getPeso();
	public abstract Map<Objetivo, Integer> getPeso(Objetivo objetivo);
	 
}
