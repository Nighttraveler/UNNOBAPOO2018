package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.ActividadCompuesta;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ActividadCompuestaDAO extends AbstractDAO<ActividadCompuesta>{

    public ActividadCompuestaDAO() {
        super(ActividadCompuesta.class);
    }

    public List<ActividadCompuesta> getAllActividadesSimples(){
        return getAll();
    }

    @Override
    protected List<ActividadCompuesta> getAll() {
        Query query = em.createNamedQuery("actividad.getAllCompuestas");
        return query.getResultList();
    }
}
