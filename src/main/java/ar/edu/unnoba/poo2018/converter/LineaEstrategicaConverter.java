package ar.edu.unnoba.poo2018.converter;

import ar.edu.unnoba.poo2018.model.LineaEstrategica;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = LineaEstrategica.class)
public class LineaEstrategicaConverter extends AbstractConverter<LineaEstrategica> {

    @Override
    public String getDAOName() {
        return "LineaEstrategicaDAO";
    }
}
