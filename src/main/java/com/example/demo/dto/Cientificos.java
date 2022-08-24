package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cientificos")//en caso que la tabla sea diferente
public class Cientificos {

	//Atributos de entidad estudiante
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int id;
		@Column(name = "dni")//no hace falta si se llama igual
		private String dni;
		@Column(name = "nomApels")//no hace falta si se llama igual
		private String nomApels;
		
		@OneToMany
	    @JoinColumn(name="id")
	    private List<Asignado> asignado;

		//Constructores
		
		public Cientificos() {

		}

		public Cientificos(int id, String dni, String nomApels, List<Asignado> asignado) {
			super();
			this.id = id;
			this.dni = dni;
			this.nomApels = nomApels;
			this.asignado = asignado;
		}

		//Getters y Setters
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getNomApels() {
			return nomApels;
		}

		public void setNomApels(String nomApels) {
			this.nomApels = nomApels;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado")
		public List<Asignado> getAsignado() {
			return asignado;
		}

		public void setAsignado(List<Asignado> asignado) {
			this.asignado = asignado;
		}
		
		//Metodo toString
		
		@Override
		public String toString() {
			return "Cientificos [id=" + id + ", dni=" + dni + ", nomApels=" + nomApels + ", asignado=" + asignado + "]";
		}

}