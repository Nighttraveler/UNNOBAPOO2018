package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.dao.ObjetivoDAO;
import ar.edu.unnoba.poo2018.manager.ActividadManager;
import ar.edu.unnoba.poo2018.model.AbstractActividad;
import ar.edu.unnoba.poo2018.model.ActividadSimple;
import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.Objetivo;
import ar.edu.unnoba.poo2018.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Named
@ViewScoped
public class ActividadBacking implements Serializable, CRUDBacking<AbstractActividad> {

    private static final Logger logger = Logger.getLogger(ActividadBacking.class.getName());

    private ActividadSimple actividad;
    private Impacto impacto;

    @PostConstruct
    public void init(){
        this.actividad = new ActividadSimple();
        this.impacto = new Impacto();
    }

    @EJB
    private URLMap urlMap;

    @EJB
    private ActividadManager actividadManager;

    @EJB
    private ObjetivoDAO objetivoDAO;

    public void agregarImpacto(){

        if(this.actividad.getImpactos()==null){
            this.actividad.setImpactos(new ArrayList<Impacto>());
        }
        this.actividad.getImpactos().add(impacto);
        impacto = new Impacto();
    }

    public List<Objetivo> getObjetivos(){
        return objetivoDAO.getAllobjetivos();
    }

    public void quitarImpacto(Impacto impacto){
        this.actividad.getImpactos().remove(impacto);
    }

    @Override
    public String create(){
        try{
            actividadManager.insertarActividad(actividad);
            return urlMap.getIndexActividades() + urlMap.getFacesRedirect();
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public String update(){
        try{
            actividadManager.actualizarActividad(actividad);
            return urlMap.getIndexActividades() + urlMap.getFacesRedirect();
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public String read() {
        return null;
    }

    @Override
    public void delete(AbstractActividad entity) {
        actividadManager.borrarActividad(entity);
    }

    @Override
    public List<AbstractActividad> getAll() {
        return actividadManager.obtenerActividades();
    }

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

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
