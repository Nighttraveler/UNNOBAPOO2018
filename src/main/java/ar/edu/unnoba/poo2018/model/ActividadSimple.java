package ar.edu.unnoba.poo2018.model;

import ar.edu.unnoba.poo2018.utils.ObjetivoPesoStrategy;
import ar.edu.unnoba.poo2018.utils.ObjetivoPesoStrategySimple;

import java.util.*;

public class ActividadSimple extends Actividad {

	private List<Impacto> impactos = new ArrayList<Impacto>();
	private ObjetivoPesoStrategy objetivoPesoStrategy = new ObjetivoPesoStrategySimple();

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
     * @return un Map<Objetivo, peso>
     */
	public Map<Objetivo, Integer> getPeso(){
        return objetivoPesoStrategy.calcularPeso(this.impactos);
    }

    @Override
    public Map<Objetivo, Integer> getPeso(Objetivo objetivo) {
        return objetivoPesoStrategy.calcularPeso(this.impactos, objetivo);
    }


}
