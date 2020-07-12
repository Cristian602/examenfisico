package com.example.demo.Modelo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="examen")

public class Examen implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3530730821450626280L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sec_examen")
	@GenericGenerator(name = "sec_examen", strategy = "native")
	@Column (name="id_examen")
	private int id;
	@Column (name="paciente")
	private int paciente;
	@Column (name="caso")
	private int caso;
	@Column (name="precio")
	private float precio;
	@Column (name="fecha")
	private String fecha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPaciente() {
		return paciente;
	}
	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}
	public int getCaso() {
		return caso;
	}
	public void setCaso(int caso) {
		this.caso = caso;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
