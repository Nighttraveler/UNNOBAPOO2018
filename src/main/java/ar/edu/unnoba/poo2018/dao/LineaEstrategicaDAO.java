package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.LineaEstrategica;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class LineaEstrategicaDAO extends AbstractDAO<LineaEstrategica> {

    public LineaEstrategicaDAO(){
        super(LineaEstrategica.class);
    }

    public List<LineaEstrategica> getAllLineasEstrategicas(){
        return getAll();
    }

    @Override
    protected List<LineaEstrategica> getAll() {
        Query query =  em.createNamedQuery("LineaEstrategica.getAll");
        return query.getResultList();
    }
}
