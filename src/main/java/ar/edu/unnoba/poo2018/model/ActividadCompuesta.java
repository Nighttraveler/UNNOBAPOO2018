package ar.edu.unnoba.poo2018.model;

import javax.persistence.*;
import java.util.*;

@Entity()
@DiscriminatorValue("Actividad_Compuesta")
@NamedQueries({
		@NamedQuery(name = "actividad.getAllCompuestas",
				query = "Select a From ActividadCompuesta a order by a.nombre")
})
public class ActividadCompuesta extends AbstractActividad{

	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "actividades_relacionadas",
			joinColumns = @JoinColumn(name = "actividad_compuesta_id"),
			inverseJoinColumns = @JoinColumn(name = "actividad_id")
	)
	private List<AbstractActividad> actividades = new ArrayList<AbstractActividad>();

	public ActividadCompuesta(String nombre, Date fechaInicio, Date fechaFin, String resolucion,
                              String expediente, Convocatoria convocatoria, LineaEstrategica linea,
                              Ambito ambito, List<Usuario> responsables) {
		super(nombre, fechaInicio, fechaFin, resolucion, expediente, convocatoria, linea, ambito, responsables);
	}

	public ActividadCompuesta(String nombre, Date fechaInicio, Date fechaFin, String resolucion,
                              String expediente, Convocatoria convocatoria, LineaEstrategica linea,
                              Ambito ambito, List<Usuario> responsables, List<AbstractActividad> actividades) {
		super(nombre, fechaInicio, fechaFin, resolucion, expediente, convocatoria, linea, ambito, responsables);
		this.actividades = actividades;
	}

	public ActividadCompuesta(){}

	public void addActividad(AbstractActividad a) {
		actividades.add(a);
	}

	public void removeActividad(AbstractActividad a) {
		actividades.remove(a);
	}

	public List<AbstractActividad> getActividades(){
		return actividades;
	}

	public void setActividades(List<AbstractActividad> actividades) {
		this.actividades = actividades;
	}

	@Override
	public List<Impacto> getImpactos() {

        List<Impacto> impactos = new ArrayList<>();

        for(AbstractActividad actividad: this.actividades){
            impactos.addAll( actividad.getImpactos());
        }

        return impactos;
    }

    /*

    MOVIDO A ACTIVIDAD MANAGER
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
    }*/
/*
	@Override
	public Map<Objetivo, Integer> getPeso(Objetivo objetivo) {
		return objetivoPesoStrategy.calcularPeso(this.getImpactos(), objetivo);
	}*/

}
