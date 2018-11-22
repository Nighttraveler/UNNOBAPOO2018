package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.AbstractActividad;

import javax.ejb.Stateless;

@Stateless
public class ActividadDAO extends AbstractDAO<AbstractActividad> {

    public ActividadDAO() {
        super(AbstractActividad.class);
    }
}
