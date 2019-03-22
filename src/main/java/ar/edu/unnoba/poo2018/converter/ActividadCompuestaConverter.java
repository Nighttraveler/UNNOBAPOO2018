package ar.edu.unnoba.poo2018.converter;

import ar.edu.unnoba.poo2018.model.ActividadCompuesta;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ActividadCompuesta.class)
public class ActividadCompuestaConverter extends AbstractConverter<ActividadCompuesta> {
    @Override
    public String getDAOName() {
        return "ActividadCompuestaDAO";
    }
}
