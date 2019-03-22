package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.AbstractActividad;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ActividadDAO extends AbstractDAO<AbstractActividad> {

    public ActividadDAO() {
        super(AbstractActividad.class);
    }

    public AbstractActividad findByName(){
        return null;
    }

    public List<AbstractActividad> getAllActividades(){
        return getAll();
    }

    @Override
    protected List<AbstractActividad> getAll() {
        Query query = em.createNamedQuery("actividad.getAll");
        return query.getResultList();
    }
}
