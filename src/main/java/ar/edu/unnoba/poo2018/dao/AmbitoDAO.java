package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Ambito;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AmbitoDAO extends AbstractDAO<Ambito> {

    public AmbitoDAO() {
        super(Ambito.class);
    }

    public List<Ambito> getAllAmbitos(){
        return getAll();
    }

    @Override
    protected List<Ambito> getAll() {
        Query query =  em.createNamedQuery("Ambito.getAll");
        return query.getResultList();
    }
}
