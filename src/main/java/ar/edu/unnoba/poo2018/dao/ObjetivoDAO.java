package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Objetivo;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ObjetivoDAO extends AbstractDAO<Objetivo> {

    public ObjetivoDAO(){
        super(Objetivo.class);
    }

    public List getAllobjetivos(){
        Query query =  em.createNamedQuery("Objetivo.getAll");
        return query.getResultList();
    }
}
