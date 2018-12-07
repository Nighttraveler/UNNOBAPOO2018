package ar.edu.unnoba.poo2018.converter;

import ar.edu.unnoba.poo2018.model.Objetivo;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Objetivo.class)
public class ObjetivoConverter extends AbstractConverter<Objetivo> {
    @Override
    public String getDAOName() {
        return "ObjetivoDAO";
    }
}
