package ar.edu.unnoba.poo2018.utils;

import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.Objetivo;

import java.util.List;
import java.util.Map;

public interface ObjetivoPesoStrategy {

   Map<Objetivo, Integer> calcularPeso(List<Impacto> impactos);

   Map<Objetivo, Integer> calcularPeso(List<Impacto> impactos, Objetivo objetivo);

}
