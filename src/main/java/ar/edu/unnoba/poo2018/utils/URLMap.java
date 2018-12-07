package ar.edu.unnoba.poo2018.utils;

// Deprecado en pos de usar/crear las constantes dentro de cada backing con su getter asi es accesible por EL :)
@Deprecated
public final class URLMap {


    public static final String INDEX = "index";
    public static final String WELCOME = "welcome";

    // URLS para objetivos
    private static final String OBJETIVOS = "objetivos/";
    public static final String INDEX_OBJETIVOS = OBJETIVOS + "index";
    public static final String NEW_OBJETIVO = OBJETIVOS + "new";
    public static final String EDIT_OBJETIVO = OBJETIVOS + "edit";
    public static final String DETAIL_OBJETIVO = OBJETIVOS + "details";


    public static final String FACES_REDIRECT = "?faces-redirect=true";



    private URLMap() {
    }
}
