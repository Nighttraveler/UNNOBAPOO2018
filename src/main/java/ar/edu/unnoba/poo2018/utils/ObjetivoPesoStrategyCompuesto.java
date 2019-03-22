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
    public Map<Objetivo, Double> calcularPeso(List<Impacto> impactos, int pesototal) {
        HashMap<Objetivo, Double> asd = new HashMap<>();

        int pesos = 0;

        for (Impacto impacto: impactos){
               pesos += impacto.getPeso();
        }
        Objetivo o = impactos.get(0).getObjetivo();
        asd.put(o,  (double) pesos/ pesototal);
        return asd;

    }

    @Override
    public Map<Objetivo, Double> calcularPeso(List<Impacto> impactos, Objetivo objetivo) {
        HashMap<Objetivo, Double> asd = new HashMap<>();

        int pesos = 0;

        for (Impacto impacto: impactos){
            if (impacto.getObjetivo() == objetivo){
                pesos += impacto.getPeso();
            }
        }
        Objetivo o = impactos.get(0).getObjetivo();
        asd.put(o, (double) pesos);
        return asd;

    }
}
