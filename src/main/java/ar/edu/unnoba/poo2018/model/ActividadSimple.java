package ar.edu.unnoba.poo2018.model;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import java.util.*;

@Entity()
@DiscriminatorValue("Actividad_Simple")
public class ActividadSimple extends AbstractActividad {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "actividad")
    @CascadeOnDelete
	private List<Impacto> impactos = new ArrayList<Impacto>();

    public ActividadSimple(String nombre, Date fechaInicio, Date fechaFin, String resolucion, String expediente,
                           Convocatoria convocatoria, LineaEstrategica linea,
                           Ambito ambito, List<Usuario> responsables) {
        super(nombre, fechaInicio, fechaFin, resolucion, expediente, convocatoria, linea, ambito, responsables);
    }

    public ActividadSimple(String nombre, Date fechaInicio, Date fechaFin, String resolucion, String expediente,
                           Convocatoria convocatoria, LineaEstrategica linea, Ambito ambito,
                           List<Usuario> responsables, List<Impacto> impactos) {
        super(nombre, fechaInicio, fechaFin, resolucion, expediente, convocatoria, linea, ambito, responsables);
        this.impactos = impactos;
    }

    public ActividadSimple(){}

    public void addImpacto(Impacto impacto){
		this.impactos.add(impacto);
	}

	public void removeImpacto(Impacto impacto){
        this.impactos.remove(impacto);
    }

	public List<Impacto> getImpactos() {
		return impactos;
	}

    public void setImpactos(List<Impacto> impactos) {
        this.impactos = impactos;
    }

	/*

	public Map<Objetivo, Integer> getPeso(){
        return objetivoPesoStrategy.calcularPeso(this.impactos);
    }

    @Override
    public Map<Objetivo, Integer> getPeso(Objetivo objetivo) {
        return objetivoPesoStrategy.calcularPeso(this.impactos, objetivo);
    }*/


}
