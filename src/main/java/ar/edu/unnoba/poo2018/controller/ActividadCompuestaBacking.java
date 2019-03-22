package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.model.AbstractActividad;
import ar.edu.unnoba.poo2018.model.ActividadCompuesta;
import ar.edu.unnoba.poo2018.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class ActividadCompuestaBacking extends AbstractActividadBacking {

    private static final Logger logger = Logger.getLogger(ActividadCompuestaBacking.class.getName());

    private ActividadCompuesta actividad;
    private List<Long> actividadesIds;

    @PostConstruct
    public void init(){
        super.init();
        actividadesIds = new ArrayList<>();
        actividad = new ActividadCompuesta();
    }

    @Override
    public String create() {
        try{
            super.getActividadManager().insertarActividad(actividad);
            return URLMap.getIndexActividadesCompuestas() + URLMap.getFacesRedirect();
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public String update() {
        try{
            super.getActividadManager().actualizarActividad(actividad);
            return URLMap.getIndexActividadesCompuestas() + URLMap.getFacesRedirect();
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void agregarActividades(){
        if(this.actividad.getActividades()==null){
            this.actividad.setActividades(new ArrayList<>());

        }
        actividadesIds.forEach(
                id -> {
                    AbstractActividad actividadTemp = super.getActividadManager().obtenerActividadById(id);
                    if (!this.actividad.getActividades().contains(actividadTemp)){
                        this.actividad.addActividad(actividadTemp);
                    }
                }
        );
        actividadesIds = new ArrayList<>();
    }

    public void quitarActividad(AbstractActividad actividad){
        this.actividad.removeActividad(actividad);
    }

    public List<Long> getActividadesIds() {
        return actividadesIds;
    }

    public void setActividadesIds(List<Long> actividadesIds) {
        this.actividadesIds = actividadesIds;
    }

    public ActividadCompuesta getActividad() {
        return actividad;
    }

    public void setActividad(ActividadCompuesta actividad) {
        this.actividad = actividad;
    }
}
