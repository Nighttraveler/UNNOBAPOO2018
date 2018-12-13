/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.model.Usuario;
import ar.edu.unnoba.poo2018.utils.JSFUtils;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import static ar.edu.unnoba.poo2018.utils.URLMap.FACES_REDIRECT;

/**
 *
 * @author jpgm
 */
@Named
@ViewScoped
public class UserBacking implements Serializable, CRUDBacking<Usuario> {

    private Usuario user;
    
    @PostConstruct
    public void init(){
        this.user = new Usuario();
    }
    
    @EJB
    private UsuarioDAO userDao;
    
    @Inject
    private SessionBacking sessionBacking;
    
    private List<Usuario> getUsers(){
        return userDao.getAllUsers();
    }


    public String create(){
        try{
            userDao.create(user);
            return INDEX_USUARIOS + FACES_REDIRECT;
        }catch(Exception e){
            return null;
        }
    }


    public String read() {
        return null;
    }


    public String update(){
        try{
            userDao.update(user);
            return INDEX_USUARIOS + FACES_REDIRECT;
        }catch(Exception e){
            return null;
        }
    }


    public void delete(Usuario user){
        if(!sessionBacking.getUsuario().equals(user)){
            userDao.delete(user);
        }else{
            JSFUtils.createFacesMessage("No te podes borrar a vos mismo amigo");
        }
        
    }

    public List<Usuario> getAll() {
        return getUsers();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }


    // URLS para usuarios
    private static final String USUARIOS = "/usuarios/";
    private final String INDEX_USUARIOS = USUARIOS + "index.xhtml";
    private final String NEW_USUARIO = USUARIOS + "new.xhtml";
    private final String EDIT_USUARIO = USUARIOS + "edit.xhtml";
    private final String DETAIL_USUARIO = USUARIOS + "details.xhtml";

    public static String getUSUARIOS() {
        return USUARIOS;
    }

    public String getINDEX_USUARIOS() {
        return INDEX_USUARIOS;
    }

    public String getNEW_USUARIO() {
        return NEW_USUARIO;
    }

    public String getEDIT_USUARIO() {
        return EDIT_USUARIO;
    }

    public String getDETAIL_USUARIO() {
        return DETAIL_USUARIO;
    }
}
