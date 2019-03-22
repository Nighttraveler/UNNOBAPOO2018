package ar.edu.unnoba.poo2018.model;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;

@Entity
@Table(name = "Impactos")
@NamedQueries(
		@NamedQuery(
				name = "Impacto.getAll",
				query = "select i from Impacto i")
)
public class Impacto extends AbstractEntity{

	@ManyToOne
    @JoinColumn(name = "objetivo_id")
    @CascadeOnDelete
	private Objetivo objetivo;



	private int peso;

	public Impacto(int peso, Objetivo objetivo) {
		this.peso = peso;
		this.objetivo = objetivo;
	}

	public Impacto(){}

	public Impacto(int peso) {
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		} else if (!(obj instanceof AbstractEntity)) {
			return false;
		}else if (obj instanceof Impacto){
			return ((Impacto) obj).getObjetivo() == this.getObjetivo() && ((Impacto) obj).getPeso() == this.getPeso();
		}
		else if ( ((AbstractEntity) obj).getId() == null ){
			return false;
		}
		else return ((AbstractEntity) obj).getId().equals(this.getId());
	}
	
}
