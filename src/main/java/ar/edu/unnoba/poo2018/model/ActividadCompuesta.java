package ar.edu.unnoba.poo2018.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActividadCompuesta extends Actividad {

	private List<Actividad> actividades = new ArrayList<Actividad>();

	public ActividadCompuesta(String nombre, Date fechaInicio, Date fechaFin, String resolucion,
                              String expediente, Convocatoria convocatoria, LineaEstrategica linea,
                              Ambito ambito, List<Usuario> responsables) {
		super(nombre, fechaInicio, fechaFin, resolucion, expediente, convocatoria, linea, ambito, responsables);
	}

	public ActividadCompuesta(String nombre, Date fechaInicio, Date fechaFin, String resolucion,
                              String expediente, Convocatoria convocatoria, LineaEstrategica linea,
                              Ambito ambito, List<Usuario> responsables, List<Actividad> actividades) {
		super(nombre, fechaInicio, fechaFin, resolucion, expediente, convocatoria, linea, ambito, responsables);
		this.actividades = actividades;
	}

	public void addActividad(Actividad a) {
		actividades.add(a);
	}

	public void removeActividad(Actividad a) {
		actividades.remove(a);
	}

	public List<Actividad> getActividades(){
		return actividades;
	}

	@Override
	public List<Impacto> getImpactos() {

        List<Impacto> impactos = new ArrayList<>();

        for(Actividad actividad : this.actividades){
            impactos.addAll( actividad.getImpactos());
        }

        return impactos;
    }

    /**
     * @return el promedio de la sumatoria de promedios pertenecientes
     *          a la actividad compuesta
     */
    @Override
    public double getPeso() {
        double pesos = 0;
        for (Actividad actividad: this.actividades){
            pesos += actividad.getPeso();
        }
        double promedio = pesos / this.actividades.size();
        return promedio;
    }


}
