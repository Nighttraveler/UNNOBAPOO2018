package ar.edu.unnoba.poo2018.converter;

import ar.edu.unnoba.poo2018.model.AbstractActividad;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = AbstractActividad.class)
public class ActividadConverter extends AbstractConverter<AbstractActividad> {
    @Override
    public String getDAOName() {
        return "ActividadDAO";
    }
}
