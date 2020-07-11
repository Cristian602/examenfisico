package com.example.demo.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="medidasantropometricas")

public class MedidasAntropometricas {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name="id_antropometricas")
	private int id;
	@Column (name="examen")
	private int examen;
	
	public int getExamen() {
		return examen;
	}
	public void setExamen(int examen) {
		this.examen = examen;
	}
	@Column (name="talla")
	private float talla;
	@Column (name="peso")
	private float peso;
	@Column (name="imc")
	private float imc;
	@Column (name="estado_nutricional")
	private String nutricional;
	@Column (name="aspecto_general")
	private String general;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public float getTalla() {
		return talla;
	}
	public void setTalla(float talla) {
		this.talla = talla;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getImc() {
		return imc;
	}
	public void setImc(float imc) {
		this.imc = imc;
	}
	public String getNutricional() {
		return nutricional;
	}
	public void setNutricional(String nutricional) {
		this.nutricional = nutricional;
	}
	public String getGeneral() {
		return general;
	}
	public void setGeneral(String general) {
		this.general = general;
	}
	
}
