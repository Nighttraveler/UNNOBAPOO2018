package ar.edu.unnoba.poo2018.utils;

import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.Objetivo;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless(name = "simpleStrategy")
public class ObjetivoPesoStrategySimple implements ObjetivoPesoStrategy {


    @Override
    public Map<Objetivo, Double> calcularPeso(List<Impacto> impactos, int pesototal) {
        HashMap<Objetivo,Double> objetivoPeso =  new HashMap<>();

        for (Impacto impacto : impactos){
            objetivoPeso.put(impacto.getObjetivo(),(double) impacto.getPeso());

        }

        return objetivoPeso;
    }

    @Override
    public Map<Objetivo, Double> calcularPeso(List<Impacto> impactos, Objetivo objetivo) {
        HashMap<Objetivo,Double> objetivoPeso =  new HashMap<>();

        for (Impacto impacto: impactos){
            if (impacto.getObjetivo() == objetivo){
                objetivoPeso.put(objetivo, (double) impacto.getPeso());
            }
        }
        return objetivoPeso;
    }
}
