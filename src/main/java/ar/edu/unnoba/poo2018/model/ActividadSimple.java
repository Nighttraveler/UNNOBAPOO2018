package ar.edu.unnoba.poo2018.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActividadSimple extends Actividad {

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

    public void addImpacto(Impacto impacto){
		this.impactos.add(impacto);
	}

	public void removeImpacto(Impacto impacto){
        this.impactos.remove(impacto);
    }

	public List<Impacto> getImpactos() {
		return impactos;
	}

    /**
     * @return el promedio del peso de los impactos
     */
	public double getPeso(){
        double pesos = this.impactos.stream().mapToInt(Impacto::getPeso).sum();
        double promedio = pesos/this.impactos.size();
        return promedio;
    }

}
