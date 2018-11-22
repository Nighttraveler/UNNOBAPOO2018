package ar.edu.unnoba.poo2018.utils;

import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.Objetivo;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless(name = "compuestoStrategy")
public class ObjetivoPesoStrategyCompuesto implements ObjetivoPesoStrategy {

    @Override
    public Map<Objetivo, Integer> calcularPeso(List<Impacto> impactos) {
        HashMap<Objetivo, Integer> asd = new HashMap<>();

        Integer pesos = 0;

        for (Impacto impacto: impactos){
               pesos += impacto.getPeso();
        }
        Objetivo o = impactos.get(0).getObjetivo();
        asd.put(o, pesos/ impactos.size());
        return asd;

    }

    @Override
    public Map<Objetivo, Integer> calcularPeso(List<Impacto> impactos, Objetivo objetivo) {
        HashMap<Objetivo, Integer> asd = new HashMap<>();

        Integer pesos = 0;

        for (Impacto impacto: impactos){
            if (impacto.getObjetivo() == objetivo){
                pesos += impacto.getPeso();
            }
        }

        Objetivo o = impactos.get(0).getObjetivo();
        asd.put(o, pesos);
        return asd;

    }
}
