package ar.edu.unnoba.poo2018.converter;

import ar.edu.unnoba.poo2018.model.Ambito;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Ambito.class)
public class AmbitoConverter extends AbstractConverter<Ambito> {
    @Override
    public String getDAOName() {
        return "AmbitoDAO";
    }
}
