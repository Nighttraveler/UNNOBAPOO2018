package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Usuario;

import javax.ejb.Stateless;

@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario>{

    public UsuarioDAO() {
        super(Usuario.class);
    }
}
