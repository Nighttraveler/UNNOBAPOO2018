package ar.edu.unnoba.poo2018.manager;

import ar.edu.unnoba.poo2018.model.*;

import java.util.List;
import java.util.Map;

public interface ActividadManager {

    void insertarActividad( AbstractActividad actividad);

    AbstractActividad obtenerActividad( AbstractActividad actividad);

    AbstractActividad obtenerActividadById( Long id);

    void actualizarActividad(AbstractActividad actividad);

    void borrarActividad(AbstractActividad actividad);

    List<AbstractActividad> obtenerActividades();

    List<ActividadSimple> obtenerActividadesSimples();

    List<ActividadCompuesta> obtenerActividadesCompuestas();

    Map<Objetivo, Double> getPeso(AbstractActividad actividad);

    Map<Objetivo, Double> getPeso(List<Impacto> impactos);

    Map<Objetivo, Double> getPeso(AbstractActividad actividad,Objetivo objetivo);

}
