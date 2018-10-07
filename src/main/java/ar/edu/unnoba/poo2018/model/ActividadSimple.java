package ar.edu.unnoba.poo2018.model;

import java.util.ArrayList;
import java.util.List;

public class ActividadSimple extends Actividad {
	
	private List<Impacto> impactos = new ArrayList<Impacto>();

	public void addImpacto(Impacto impacto){
		this.impactos.add(impacto);
	}

	public List<Impacto> getImpactos() {
		return impactos;
	}
}
