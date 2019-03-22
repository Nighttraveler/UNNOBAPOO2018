package ar.edu.unnoba.poo2018.utils;

import ar.edu.unnoba.poo2018.model.Impacto;
import ar.edu.unnoba.poo2018.model.Objetivo;

import java.util.List;
import java.util.Map;

public interface ObjetivoPesoStrategy {

   Map<Objetivo, Double> calcularPeso(List<Impacto> impactos, int pesoTotal);

   Map<Objetivo, Double> calcularPeso(List<Impacto> impactos, Objetivo objetivo);

}
