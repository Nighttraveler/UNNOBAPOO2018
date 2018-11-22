package ar.edu.unnoba.poo2018.manager.impl;

import ar.edu.unnoba.poo2018.dao.ActividadDAO;
import ar.edu.unnoba.poo2018.manager.ActividadManager;
import ar.edu.unnoba.poo2018.model.AbstractActividad;
import ar.edu.unnoba.poo2018.model.ActividadSimple;
import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.Objetivo;
import ar.edu.unnoba.poo2018.utils.ObjetivoPesoStrategy;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class ActividadManagerImpl implements ActividadManager {

    @EJB
    ActividadDAO actividadDAO;

    @EJB(beanName = "simpleStrategy")
    ObjetivoPesoStrategy simpleStrategy;

    @EJB(beanName = "compuestoStrategy")
    ObjetivoPesoStrategy compuestoStrategy;


    @Override
    public void insertarActividad(AbstractActividad actividad) {
        try {
            actividadDAO.create(actividad);

        }catch (EJBException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public AbstractActividad obtenerActividad(AbstractActividad actividad) {
        try {
            return actividadDAO.find(actividad.getId());

        }catch (EJBException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizarActividad(AbstractActividad actividad) {
        try {
            actividadDAO.update(actividad);

        }catch (EJBException e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void borrarActividad(AbstractActividad actividad) {
        try {
            actividadDAO.delete(actividad);

        }catch (EJBException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Map<Objetivo, Integer> getPeso(AbstractActividad actividad) {
        if (actividad instanceof ActividadSimple){
            return getPesoSimple(actividad.getImpactos());
        }

        return getPesoCompuesto(actividad.getImpactos());
    }

    @Override
    public Map<Objetivo, Integer> getPeso(AbstractActividad actividad, Objetivo objetivo) {
        if (actividad instanceof ActividadSimple){
            return getPesoSimple(actividad.getImpactos(), objetivo);
        }

        return getPesoCompuesto(actividad.getImpactos(), objetivo);
    }

    private Map<Objetivo, Integer> getPesoSimple(List<Impacto> impactos){
        return simpleStrategy.calcularPeso(impactos);
    }

    private Map<Objetivo, Integer> getPesoSimple(List<Impacto> impactos, Objetivo objetivo){
        return simpleStrategy.calcularPeso(impactos,objetivo);
    }

    private Map<Objetivo, Integer> getPesoCompuesto(List<Impacto> impactos){
        Map<Objetivo, Integer> objetivoPromedio =  new HashMap<>();
        for (Impacto impacto: impactos){
            Objetivo objetivoImpacto = impacto.getObjetivo();

            if (!objetivoPromedio.containsKey( objetivoImpacto )){
                // obtener todos los impactos con el que tengan el mismo objetivo
                List<Impacto> ImpactosMismoObjetivo = impactos.stream()
                        .filter(impact-> impact.getObjetivo()==objetivoImpacto
                        ).collect(Collectors.toList());

                objetivoPromedio.putAll( compuestoStrategy.calcularPeso(ImpactosMismoObjetivo));
                //TODO filtrar los impactos con el objetivo ya analizado
                impactos = impactos.stream()
                        .filter( impc -> impc.getObjetivo()!=objetivoImpacto )
                        .collect(Collectors.toList());
            }
        }
        return objetivoPromedio;

    }

    private Map<Objetivo, Integer> getPesoCompuesto(List<Impacto> impactos, Objetivo objetivo){
        return compuestoStrategy.calcularPeso(impactos, objetivo);
    }
}
