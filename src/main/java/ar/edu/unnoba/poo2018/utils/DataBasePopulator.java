package ar.edu.unnoba.poo2018.utils;

import ar.edu.unnoba.poo2018.dao.UsuarioDAO;
import ar.edu.unnoba.poo2018.model.Usuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DataBasePopulator {

    @EJB
    private UsuarioDAO usuarioDAO;

    public void createUsers(int userQuantity){

        for (int i = 0; i < userQuantity ; i++) {
            Usuario usuario = new Usuario();
            usuario.setNombre("Usuario "+ i);
            usuario.setEmail("usuario"+ i+ "@mail.com");
            usuario.setPassword("1234");
            usuario.setAdministrador(i%2==0);
            usuarioDAO.create(usuario);
            System.out.println("creado el usuario nro"+ i);

        }
    }
}
