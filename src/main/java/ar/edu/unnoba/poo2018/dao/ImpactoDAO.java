package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Impacto;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ImpactoDAO extends AbstractDAO<Impacto>  {

    public ImpactoDAO (){
        super(Impacto.class);
    }

    public List<Impacto> getAllImpactos(){
        return getAll();
    }

    @Override
    protected List<Impacto> getAll() {
        Query query =  em.createNamedQuery("Impacto.getAll");
        return query.getResultList();
    }
}
