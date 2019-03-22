package ar.edu.unnoba.poo2018.dao;


import ar.edu.unnoba.poo2018.model.ActividadSimple;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ActividadSimpleDAO extends AbstractDAO<ActividadSimple>{

    public ActividadSimpleDAO() {
        super(ActividadSimple.class);
    }

    public List<ActividadSimple> getAllActividadesSimples(){
        return getAll();
    }

    @Override
    protected List<ActividadSimple> getAll() {
        Query query = em.createNamedQuery("actividad.getAllSimples");
        return query.getResultList();
    }
}
