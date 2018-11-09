package ar.edu.unnoba.poo2018.model;

import ar.edu.unnoba.poo2018.utils.ObjetivoPesoStrategy;
import ar.edu.unnoba.poo2018.utils.ObjetivoPesoStrategyCompuesto;

import java.util.*;
import java.util.stream.Collectors;

public class ActividadCompuesta extends Actividad {

	private List<Actividad> actividades = new ArrayList<Actividad>();
	private ObjetivoPesoStrategy objetivoPesoStrategy = new ObjetivoPesoStrategyCompuesto();

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
     * @return Map<Objetivo, promedio> con el promedio para dicho objetivo de la instancia actividad actual
     */
    @Override
    public Map<Objetivo, Integer> getPeso() {
        Map<Objetivo, Integer> objetivoPromedio =  new HashMap<>();
        List<Impacto> impactos =  this.getImpactos();
        for (Impacto impacto: impactos){
            Objetivo objetivoImpacto = impacto.getObjetivo();

            if (!objetivoPromedio.containsKey( objetivoImpacto )){
                // obtener todos los impactos con el que tengan el mismo objetivo
                List<Impacto> ImpactosMismoObjetivo = impactos.stream()
						.filter(impact-> impact.getObjetivo()==objetivoImpacto
                ).collect(Collectors.toList());

				objetivoPromedio.putAll( objetivoPesoStrategy.calcularPeso(ImpactosMismoObjetivo));
				//TODO filtrar los impactos con el objetivo ya analizado
				impactos = impactos.stream()
						.filter( impc -> impc.getObjetivo()!=objetivoImpacto )
						.collect(Collectors.toList());
            }
        }
        return objetivoPromedio;
    }

	@Override
	public Map<Objetivo, Integer> getPeso(Objetivo objetivo) {
		return objetivoPesoStrategy.calcularPeso(this.getImpactos(), objetivo);
	}

}
