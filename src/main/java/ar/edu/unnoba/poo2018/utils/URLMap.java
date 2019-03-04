package ar.edu.unnoba.poo2018.utils;

// Deprecado en pos de usar/crear las constantes dentro de cada backing con su getter asi es accesible por EL :)

import javax.ejb.Stateless;
import java.io.Serializable;

//TODO : rehacer con request scope o null
@Stateless
public class URLMap implements Serializable {

    private static final String INDEX = "/index.xhtml";
    private static final String WELCOME = "/welcome.xhtml";

    // URLS para objetivos
    private static final String OBJETIVOS = "/objetivos/";
    private static final String INDEX_OBJETIVOS = OBJETIVOS + "index.xhtml";
    private static final String NEW_OBJETIVO = OBJETIVOS + "new.xhtml";
    private static final String EDIT_OBJETIVO = OBJETIVOS + "edit.xhtml";
    private static final String DETAIL_OBJETIVO = OBJETIVOS + "details.xhtml";

    // URLS para Actividades
    private static final String ACTIVIDADES_SIMPLES = "/actividades/simples/";
    private static final String INDEX_ACTIVIDADES = ACTIVIDADES_SIMPLES + "index.xhtml";
    private static final String NEW_ACTIVIDAD = ACTIVIDADES_SIMPLES + "new.xhtml";
    private static final String EDIT_ACTIVIDAD = ACTIVIDADES_SIMPLES + "edit.xhtml";
    private static final String DETAIL_ACTIVIDAD = ACTIVIDADES_SIMPLES + "details.xhtml";

    // URLS para usuarios
    private static final String USUARIOS = "/usuarios/";
    private static final String INDEX_USUARIOS = USUARIOS + "index.xhtml";
    private static final String NEW_USUARIO = USUARIOS + "new.xhtml";
    private static final String EDIT_USUARIO = USUARIOS + "edit.xhtml";
    private static final String DETAIL_USUARIO = USUARIOS + "details.xhtml";


    private static final String FACES_REDIRECT = "?faces-redirect=true";

    public String getINDEX() {
        return INDEX;
    }

    public String getWELCOME() {
        return WELCOME;
    }

    public String getOBJETIVOS() {
        return OBJETIVOS;
    }

    public String getIndexObjetivos() {
        return INDEX_OBJETIVOS;
    }

    public String getNewObjetivo() {
        return NEW_OBJETIVO;
    }

    public String getEditObjetivo() {
        return EDIT_OBJETIVO;
    }

    public String getDetailObjetivo() {
        return DETAIL_OBJETIVO;
    }

    public String getActividadesSimples() {
        return ACTIVIDADES_SIMPLES;
    }

    public String getIndexActividades() {
        return INDEX_ACTIVIDADES;
    }

    public String getNewActividad() {
        return NEW_ACTIVIDAD;
    }

    public String getEditActividad() {
        return EDIT_ACTIVIDAD;
    }

    public String getDetailActividad() {
        return DETAIL_ACTIVIDAD;
    }

    public String getUSUARIOS() {
        return USUARIOS;
    }

    public String getIndexUsuarios() {
        return INDEX_USUARIOS;
    }

    public String getNewUsuario() {
        return NEW_USUARIO;
    }

    public String getEditUsuario() {
        return EDIT_USUARIO;
    }

    public String getDetailUsuario() {
        return DETAIL_USUARIO;
    }

    public String getFacesRedirect() {
        return FACES_REDIRECT;
    }

}
