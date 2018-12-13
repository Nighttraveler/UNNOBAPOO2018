package ar.edu.unnoba.poo2018.dao;

import ar.edu.unnoba.poo2018.model.Impacto;

import javax.ejb.Stateless;

@Stateless
public class ImpactoDAO extends AbstractDAO<Impacto>  {

    public ImpactoDAO (){
        super(Impacto.class);
    }
}
