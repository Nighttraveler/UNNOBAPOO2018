package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.dao.ConvocatoriaDAO;
import ar.edu.unnoba.poo2018.model.Convocatoria;
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
public class ConvocatoriaBacking implements Serializable, CRUDBacking<Convocatoria> {

    private static final Logger logger = Logger.getLogger(ConvocatoriaBacking.class.getName());

    private Convocatoria convocatoria;

    @EJB
    private URLMap urlMap;

    @EJB
    private ConvocatoriaDAO convocatoriaDAO;

    @PostConstruct
    public void init(){
        this.convocatoria = new Convocatoria();
    }

    @Override
    public String create() {
        try {
            convocatoriaDAO.create(convocatoria);
            return URLMap.getIndexConvocatorias() + URLMap.getFacesRedirect();
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
            convocatoriaDAO.update(convocatoria);
            return URLMap.getIndexConvocatorias() + URLMap.getFacesRedirect();
        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Convocatoria entity) {
        try {
            convocatoriaDAO.delete(entity);
        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public List<Convocatoria> getAll() {
        try {
            return convocatoriaDAO.getAllConvocatorias();
        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }

    public ConvocatoriaDAO getConvocatoriaDAO() {
        return convocatoriaDAO;
    }

    public void setConvocatoriaDAO(ConvocatoriaDAO convocatoriaDAO) {
        this.convocatoriaDAO = convocatoriaDAO;
    }
}
