package ar.edu.unnoba.poo2018.converter;


import ar.edu.unnoba.poo2018.model.ActividadSimple;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ActividadSimple.class)
public class ActividadSimpleConverter extends AbstractConverter<ActividadSimple>{
    @Override
    public String getDAOName() {
        return "ActividadSimpleDAO";
    }
}
