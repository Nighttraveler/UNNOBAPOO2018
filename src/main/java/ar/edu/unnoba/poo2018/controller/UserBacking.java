/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unnoba.poo2018.controller;

import ar.edu.unnoba.poo2018.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.model.Usuario;
import ar.edu.unnoba.poo2018.utils.JSFUtils;
import ar.edu.unnoba.poo2018.utils.URLMap;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


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

    @EJB
    private URLMap urlMap;
    
    @Inject
    private SessionBacking sessionBacking;
    
    private List<Usuario> getUsers(){
        return userDao.getAllUsers();
    }


    public String create(){
        try{
            userDao.create(user);
            return urlMap.getIndexUsuarios() + URLMap.getFacesRedirect();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public String retrieve() {
        return null;
    }

    @Override
    public String update(){
        try{
            userDao.update(user);
            return urlMap.getIndexUsuarios() + URLMap.getFacesRedirect();
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

    @Override
    public List<Usuario> getAll() {
        return getUsers();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }


    public URLMap getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(URLMap urlMap) {
        this.urlMap = urlMap;
    }
}
