package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.dao.AmbitoDAO;
import ar.edu.unnoba.poo2018.model.Ambito;
import ar.edu.unnoba.poo2018.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class AmbitoBacking implements Serializable, CRUDBacking<Ambito> {

    private static final Logger logger = Logger.getLogger(AmbitoBacking.class.getName());

    private Ambito ambito;

    @EJB
    private URLMap urlMap;

    @EJB
    private AmbitoDAO ambitoDAO;

    @PostConstruct
    public void init(){
        this.ambito = new Ambito();
    }

    @Override
    public String create() {
        try {
            ambitoDAO.create(ambito);
            return URLMap.getIndexAmbitos() + URLMap.getFacesRedirect();
        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update() {
        try {
            ambitoDAO.update(ambito);
            return URLMap.getIndexAmbitos() + URLMap.getFacesRedirect();
        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Ambito entity) {
        try {
            ambitoDAO.delete(entity);
        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public List<Ambito> getAll() {
        try {
            return ambitoDAO.getAllAmbitos();
        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
