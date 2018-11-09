package ar.edu.unnoba.poo2018.utils;

import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.Objetivo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjetivoPesoStrategySimple implements ObjetivoPesoStrategy {


    @Override
    public Map<Objetivo, Integer> calcularPeso(List<Impacto> impactos) {
        HashMap<Objetivo,Integer> objetivoPeso =  new HashMap<>();

        for (Impacto impacto : impactos){
            objetivoPeso.put(impacto.getObjetivo(), impacto.getPeso());

        }

        return objetivoPeso;
    }

    @Override
    public Map<Objetivo, Integer> calcularPeso(List<Impacto> impactos, Objetivo objetivo) {
        HashMap<Objetivo,Integer> objetivoPeso =  new HashMap<>();

        for (Impacto impacto: impactos){
            if (impacto.getObjetivo() == objetivo){
                objetivoPeso.put(objetivo, impacto.getPeso());
            }
        }
        return objetivoPeso;
    }
}
