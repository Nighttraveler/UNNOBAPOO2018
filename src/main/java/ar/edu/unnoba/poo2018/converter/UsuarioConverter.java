package ar.edu.unnoba.poo2018.converter;

import ar.edu.unnoba.poo2018.model.Usuario;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter extends AbstractConverter<Usuario> {


    @Override
    public String getDAOName() {
        return "UsuarioDAO";
    }
}
