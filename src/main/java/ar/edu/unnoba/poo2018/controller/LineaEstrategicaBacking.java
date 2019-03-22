package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.dao.LineaEstrategicaDAO;
import ar.edu.unnoba.poo2018.model.LineaEstrategica;
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
public class LineaEstrategicaBacking implements Serializable, CRUDBacking<LineaEstrategica> {

    private static final Logger logger = Logger.getLogger(LineaEstrategicaBacking.class.getName());

    private LineaEstrategica lineaEstrategica;

    @PostConstruct
    public void init(){
        this.lineaEstrategica = new LineaEstrategica();
    }

    @EJB
    private LineaEstrategicaDAO lineaEstrategicaDAO;

    @EJB
    private URLMap urlMap;

    @Override
    public String create() {
        try {
            lineaEstrategicaDAO.create(lineaEstrategica);
            return URLMap.getIndexLineasEstrategicas() + URLMap.getFacesRedirect();
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
            lineaEstrategicaDAO.update(lineaEstrategica);
            return URLMap.getIndexLineasEstrategicas() + URLMap.getFacesRedirect();
        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(LineaEstrategica entity) {
        try {
            lineaEstrategicaDAO.update(entity);
        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public List<LineaEstrategica> getAll() {
        try {
            return lineaEstrategicaDAO.getAllLineasEstrategicas();
        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public LineaEstrategica getLineaEstrategica() {
        return lineaEstrategica;
    }

    public void setLineaEstrategica(LineaEstrategica lineaEstrategica) {
        this.lineaEstrategica = lineaEstrategica;
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
