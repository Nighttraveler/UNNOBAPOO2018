package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.*;
import ar.edu.unnoba.poo2018.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


@Named
@ViewScoped
public class ActividadBacking extends AbstractActividadBacking {

    private static final Logger logger = Logger.getLogger(ActividadBacking.class.getName());

    private ActividadSimple actividad;
    private Impacto impacto;


    @PostConstruct
    public void init(){
        this.actividad = new ActividadSimple();
        this.impacto = new Impacto();
        super.init();
    }

    public void agregarImpacto(){

        if(this.actividad.getImpactos()==null){
            this.actividad.setImpactos(new ArrayList<>());
        }
        this.actividad.addImpacto(impacto);
        impacto = new Impacto();
    }

    public void quitarImpacto(Impacto impacto){
        this.actividad.removeImpacto(impacto);}

    public ActividadSimple getActividad() {
        return actividad;
    }

    public void setActividad(ActividadSimple actividad) {
        this.actividad = actividad;
    }

    public Impacto getImpacto() {
        return impacto;
    }

    public void setImpacto(Impacto impacto) {
        this.impacto = impacto;
    }

    @Override
    public String create() {
        try{
            super.getActividadManager().insertarActividad(actividad);
            return URLMap.getIndexActividades() + URLMap.getFacesRedirect();
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public String update() {
        try{
            super.getActividadManager().actualizarActividad(actividad);
            return URLMap.getIndexActividades() + URLMap.getFacesRedirect();
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

/*    public Map<Objetivo, Double> objetivoDoubleMap(){
        return super.getActividadManager().getPeso(super.getImpactoDAO().getAllImpactos());
    }*/
}
