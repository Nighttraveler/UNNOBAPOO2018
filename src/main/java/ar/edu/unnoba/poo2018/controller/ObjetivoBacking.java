package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.dao.ObjetivoDAO;
import ar.edu.unnoba.poo2018.model.Objetivo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static ar.edu.unnoba.poo2018.utils.URLMap.FACES_REDIRECT;

@Named
@ViewScoped
public class ObjetivoBacking implements Serializable, CRUDBacking<Objetivo> {



    // URLS para objetivos
    private static final String OBJETIVOS = "/objetivos/";
    private final String INDEX_OBJETIVOS = OBJETIVOS + "index.xhtml";
    private final String NEW_OBJETIVO = OBJETIVOS + "new.xhtml";
    private final String EDIT_OBJETIVO = OBJETIVOS + "edit.xhtml";
    private final String DETAIL_OBJETIVO = OBJETIVOS + "details.xhtml";

    @EJB
    private ObjetivoDAO objetivoDAO;

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
            return INDEX_OBJETIVOS + FACES_REDIRECT;
        }catch (EJBException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String read() {
        return null;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public void delete(Objetivo entity) {

    }

    @Override
    public List<Objetivo> getAll() {
        return objetivoDAO.getAllobjetivos();
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

    public String getINDEX_OBJETIVOS() {
        return INDEX_OBJETIVOS;
    }

    public String getNEW_OBJETIVO() {
        return NEW_OBJETIVO;
    }

    public String getEDIT_OBJETIVO() {
        return EDIT_OBJETIVO;
    }

    public String getDETAIL_OBJETIVO() {
        return DETAIL_OBJETIVO;
    }
}
