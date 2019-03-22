package ar.edu.unnoba.poo2018.manager.impl;

import ar.edu.unnoba.poo2018.controller.ActividadCompuestaBacking;
import ar.edu.unnoba.poo2018.dao.ActividadCompuestaDAO;
import ar.edu.unnoba.poo2018.dao.ActividadDAO;
import ar.edu.unnoba.poo2018.dao.ActividadSimpleDAO;
import ar.edu.unnoba.poo2018.dao.ImpactoDAO;
import ar.edu.unnoba.poo2018.manager.ActividadManager;
import ar.edu.unnoba.poo2018.model.*;
import ar.edu.unnoba.poo2018.utils.ObjetivoPesoStrategy;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class ActividadManagerImpl implements ActividadManager {

    private static final Logger logger = Logger.getLogger(ActividadManagerImpl.class.getName());

    @EJB
    private ActividadDAO actividadDAO;

    @EJB
    private ActividadSimpleDAO actividadSimpleDAO;

    @EJB
    private ActividadCompuestaDAO actividadCompuestaDAO;

    @EJB
    private ImpactoDAO impactoDAO;

    @EJB(beanName = "simpleStrategy")
    private ObjetivoPesoStrategy simpleStrategy;

    @EJB(beanName = "compuestoStrategy")
    private ObjetivoPesoStrategy compuestoStrategy;


    @Override
    public void insertarActividad(AbstractActividad actividad) {
        try {
            actividadDAO.create(actividad);

        }catch (EJBException e){
            logger.log(Level.SEVERE,e.getMessage());
        }
    }

    @Override
    public AbstractActividad obtenerActividad(AbstractActividad actividad) {
        try {
            return actividadDAO.find(actividad.getId());

        }catch (EJBException e){
            logger.log(Level.SEVERE,e.getMessage());
        }
        return null;
    }

    @Override
    public AbstractActividad obtenerActividadById(Long id) {
        return actividadDAO.find(id);
    }

    @Override
    public void actualizarActividad(AbstractActividad actividad) {
        try {
            actividadDAO.update(actividad);

        }catch (EJBException e){
            logger.log(Level.SEVERE,e.getMessage());
        }


    }

    @Override
    public void borrarActividad(AbstractActividad actividad) {
        try {
            actividadDAO.delete(actividad);

        }catch (EJBException e){
            logger.log(Level.SEVERE,e.getMessage());
        }

    }

    @Override
    public List<AbstractActividad> obtenerActividades(){
        return actividadDAO.getAllActividades();
    }

    @Override
    public List<ActividadSimple> obtenerActividadesSimples() {
        return actividadSimpleDAO.getAllActividadesSimples();
    }

    @Override
    public List<ActividadCompuesta> obtenerActividadesCompuestas() {
        return actividadCompuestaDAO.getAllActividadesSimples();
    }

    @Override
    public Map<Objetivo, Double> getPeso(AbstractActividad actividad) {
        if (actividad instanceof ActividadSimple){
            return getPesoSimple(actividad.getImpactos());
        }

        return getPesoCompuesto(actividad.getImpactos());
    }

    @Override
    public Map<Objetivo, Double> getPeso(AbstractActividad actividad, Objetivo objetivo) {
        if (actividad instanceof ActividadSimple){
            return getPesoSimple(actividad.getImpactos(), objetivo);
        }

        return getPesoCompuesto(actividad.getImpactos(), objetivo);
    }

    @Override
    public Map<Objetivo, Double> getPeso(List<Impacto> impactos) {


        return getPesoCompuesto(impactos);
    }

    private Map<Objetivo, Double> getPesoSimple(List<Impacto> impactos){
        return simpleStrategy.calcularPeso(impactos, impactos.size());
    }

    private Map<Objetivo, Double> getPesoSimple(List<Impacto> impactos, Objetivo objetivo){
        return simpleStrategy.calcularPeso(impactos,objetivo);
    }

    private Map<Objetivo, Double> getPesoCompuesto(List<Impacto> impactos){
        Map<Objetivo, Double> objetivoPromedio =  new HashMap<>();
        for (Impacto impacto: impactos){
            Objetivo objetivoImpacto = impacto.getObjetivo();

            if (!objetivoPromedio.containsKey( objetivoImpacto )){
                // obtener todos los impactos con el mismo objetivo
                List<Impacto> ImpactosMismoObjetivo = impactos.stream()
                        .filter(impact-> impact.getObjetivo()==objetivoImpacto
                        ).collect(Collectors.toList());

                objetivoPromedio.putAll( compuestoStrategy.calcularPeso(ImpactosMismoObjetivo, impactos.size()));
                //TODO filtrar los impactos con el objetivo ya analizado
                impactos = impactos.stream()
                        .filter( impc -> impc.getObjetivo()!=objetivoImpacto )
                        .collect(Collectors.toList());
            }
        }
        return objetivoPromedio;

    }

    private Map<Objetivo, Double> getPesoCompuesto(List<Impacto> impactos, Objetivo objetivo){
        return compuestoStrategy.calcularPeso(impactos, objetivo);
    }
}
