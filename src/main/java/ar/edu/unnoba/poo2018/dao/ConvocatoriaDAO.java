package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Convocatoria;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ConvocatoriaDAO extends AbstractDAO<Convocatoria> {

    public ConvocatoriaDAO(){
        super(Convocatoria.class);
    }

    public List getAllConvocatorias(){
        return getAll();
    }

    @Override
    protected List<Convocatoria> getAll() {
        Query query =  em.createNamedQuery("Convocatoria.getAll");
        return query.getResultList();
    }
}
