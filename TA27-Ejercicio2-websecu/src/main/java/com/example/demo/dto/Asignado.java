package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Asignado_A")//en caso que la tabala sea diferente
public class Asignado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	@ManyToOne
    @JoinColumn(name = "cientifico")
	Cientificos cientificos;
	 
	@ManyToOne
    @JoinColumn(name = "proyecto")
	Proyecto proyecto;
		

	//Constructores
		
	public Asignado() {

	}

	public Asignado(int id, Cientificos cientificos, Proyecto proyecto) {
		this.id = id;
		this.cientificos = cientificos;
		this.proyecto = proyecto;
	}



	//Getters y Setters
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cientificos getCientificos() {
		return cientificos;
	}

	public void setCientificos(Cientificos cientificos) {
		this.cientificos = cientificos;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
		
	@Override
	public String toString() {
		return "Asignado [id=" + id + ", cientificos=" + cientificos + ", proyecto=" + proyecto + "]";
	}

}
