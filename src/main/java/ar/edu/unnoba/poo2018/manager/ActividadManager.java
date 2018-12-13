package ar.edu.unnoba.poo2018.manager;

import ar.edu.unnoba.poo2018.model.AbstractActividad;
import ar.edu.unnoba.poo2018.model.Objetivo;

import java.util.List;
import java.util.Map;

public interface ActividadManager {

    void insertarActividad( AbstractActividad actividad);

    AbstractActividad obtenerActividad( AbstractActividad actividad);

    void actualizarActividad(AbstractActividad actividad);

    void borrarActividad(AbstractActividad actividad);

    List<AbstractActividad> obtenerActividades();

    Map<Objetivo, Integer> getPeso(AbstractActividad actividad);

    Map<Objetivo, Integer> getPeso(AbstractActividad actividad,Objetivo objetivo);

}
