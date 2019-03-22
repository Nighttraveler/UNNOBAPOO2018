package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.dao.ImpactoDAO;
import ar.edu.unnoba.poo2018.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.manager.ActividadManager;
import ar.edu.unnoba.poo2018.model.*;
import ar.edu.unnoba.poo2018.utils.JSFUtils;
import ar.edu.unnoba.poo2018.utils.URLMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractActividadBacking implements Serializable, CRUDBacking<AbstractActividad> {

    private List<Long> responsablesIds;

    @PostConstruct
    public void init(){
        responsablesIds =  new ArrayList<>();
    }

    @EJB
    private URLMap urlMap;

    @EJB
    private ActividadManager actividadManager;

    @EJB
    private UsuarioDAO usuarioDAO;


    @EJB
    private ImpactoDAO impactoDAO;

    @Override
    public String retrieve() {
        return null;
    }


    public void delete(AbstractActividad entity) {
        try{
            actividadManager.borrarActividad(entity);
        }catch(Exception e){
            JSFUtils.createFacesMessage(
                    String.format("Ocurrio un Error al intertar borrar '%s', Verifique que no es parte de una actividad compuesta."
                            ,entity.getNombre())
            );
        }
    }

    @Override
    public List<AbstractActividad> getAll() {
        return actividadManager.obtenerActividades();
    }

/*    public Map<Objetivo, Double> objetivoDoubleMap(){
        return actividadManager.getPeso(impactoDAO.getAllImpactos());
    }*/

    public List<ActividadSimple> getAllSimples() {
        return actividadManager.obtenerActividadesSimples();
    }

    public List<ActividadCompuesta> getAllCompuestas() {
        return actividadManager.obtenerActividadesCompuestas();
    }

    public void agregarResponsables(AbstractActividad actividad){

        if(actividad.getResponsables()==null){
            actividad.setResponsables(new ArrayList<>());
        }
        responsablesIds.forEach(
                id -> {
                    Usuario usuario = usuarioDAO.find(id);
                    if (!actividad.getResponsables().contains(usuario)){
                        actividad.addUsuario(usuario);
                    }
                }
        );
        responsablesIds = new ArrayList<>();
    }

    public void quitarResponsable(Usuario usuario, AbstractActividad actividad){
        actividad.removeUsuario(usuario);
    }

    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }

    public List<Long> getResponsablesIds() {
        return responsablesIds;
    }

    public void setResponsablesIds(List<Long> responsablesIds) {
        this.responsablesIds = responsablesIds;
    }

    public ActividadManager getActividadManager() {
        return actividadManager;
    }

    public ImpactoDAO getImpactoDAO() {
        return impactoDAO;
    }

    public void setImpactoDAO(ImpactoDAO impactoDAO) {
        this.impactoDAO = impactoDAO;
    }
}
