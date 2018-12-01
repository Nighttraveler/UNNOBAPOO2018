package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Usuario;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario>{

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario findByEmailAndPassword(String email, String password){
        Query query = em.createNamedQuery("Usuario.findByEmailAndPassword");
        query.setParameter("email",email);
        query.setParameter("password", password);
        Usuario user = null;
        try{
            user = (Usuario) query.getSingleResult();
        }catch(NoResultException nre){
            System.out.println(nre.getMessage());
        }
        return user;
    }
}
