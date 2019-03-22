package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.dao.ObjetivoDAO;
import ar.edu.unnoba.poo2018.model.Objetivo;
import ar.edu.unnoba.poo2018.utils.JSFUtils;
import ar.edu.unnoba.poo2018.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class ObjetivoBacking implements Serializable, CRUDBacking<Objetivo> {

    private static final Logger logger = Logger.getLogger(ObjetivoBacking.class.getName());

    @EJB
    private ObjetivoDAO objetivoDAO;

    @EJB
    private URLMap urlMap;

    private Objetivo objetivo;

    private String nombre;

    @PostConstruct
    public void init(){
        this.objetivo = new Objetivo();
        this.nombre = null;

    }

    @Override
    public String create() {
        try {
            objetivo.setNombre(this.nombre);
            objetivoDAO.create(objetivo);
            return urlMap.getIndexObjetivos() + URLMap.getFacesRedirect();
        }catch (EJBException e){
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update() {
        try {
            objetivoDAO.update(objetivo);
            return urlMap.getIndexObjetivos() + URLMap.getFacesRedirect();
        }catch (EJBException e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Objetivo entity) {
        try{
            objetivoDAO.delete(entity);
        } catch (EJBException e){
            logger.log(Level.SEVERE, e.getMessage());
            JSFUtils.createFacesMessage(
                    String.format("Se produjo un error al intentar borrar '%s', Por favor verifique que no hay actividades relacionadas a el.",
                            entity.getNombre()));
        }

    }

    @Override
    public List<Objetivo> getAll() {
        try {
            return objetivoDAO.getAllobjetivos();

        }catch (EJBException e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
