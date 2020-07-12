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
@Table (name="neurologico")

public class Neurologico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4796804841830591770L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "sec_neuro")
	@GenericGenerator(name = "sec_neuro", strategy = "native")
	@Column (name="id_neurologico")
	private int id;
	@Column (name="examen")
	private int examen;
	
	public int getExamen() {
		return examen;
	}
	public void setExamen(int examen) {
		this.examen = examen;
	}
	@Column (name="estado_conciencia")
	private String conciencia;
	@Column (name="pares_craneales")
	private String pares;
	@Column (name="motor")
	private String motor;
	@Column (name="sensitivo")
	private String sensitivo;
	@Column (name="signos_meningeos")
	private String meningeos;
	@Column (name="personalidad")
	private String personalidad;
	@Column (name="marcha")
	private String marcha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getConciencia() {
		return conciencia;
	}
	public void setConciencia(String conciencia) {
		this.conciencia = conciencia;
	}
	public String getPares() {
		return pares;
	}
	public void setPares(String pares) {
		this.pares = pares;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getSensitivo() {
		return sensitivo;
	}
	public void setSensitivo(String sensitivo) {
		this.sensitivo = sensitivo;
	}
	public String getMeningeos() {
		return meningeos;
	}
	public void setMeningeos(String meningeos) {
		this.meningeos = meningeos;
	}
	public String getPersonalidad() {
		return personalidad;
	}
	public void setPersonalidad(String personalidad) {
		this.personalidad = personalidad;
	}
	public String getMarcha() {
		return marcha;
	}
	public void setMarcha(String marcha) {
		this.marcha = marcha;
	}
	
	
}
