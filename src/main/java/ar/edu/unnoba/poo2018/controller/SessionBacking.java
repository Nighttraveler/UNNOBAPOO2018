package ar.edu.unnoba.poo2018.controller;


import ar.edu.unnoba.poo2018.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.model.Usuario;
import ar.edu.unnoba.poo2018.utils.URLMap;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

import static ar.edu.unnoba.poo2018.utils.URLMap.FACES_REDIRECT;
import static ar.edu.unnoba.poo2018.utils.URLMap.INDEX;
import static ar.edu.unnoba.poo2018.utils.URLMap.WELCOME;

@Named
@SessionScoped
public class SessionBacking implements Serializable {

    private String email;
    private String password;

    private Usuario usuario = null;

    @EJB
    private UsuarioDAO usuarioDAO;

    public String login(){
        usuario = usuarioDAO.findByEmailAndPassword(this.email, this.password);

        return (usuario!=null) ? WELCOME + FACES_REDIRECT : null;
    }

    public String logout(){
        this.usuario = null;
        this.email = null;
        this.password = null;

        return INDEX +  FACES_REDIRECT;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
