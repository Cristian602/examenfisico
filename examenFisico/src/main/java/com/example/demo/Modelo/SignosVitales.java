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
@Table (name="signosvitales")

public class SignosVitales implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3814987552755572554L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "sec_signos")
	@GenericGenerator(name = "sec_signos", strategy = "native")
	@Column (name="id_vitales")
	private int id;
	@Column (name="examen")
	private int examen;
	
	public int getExamen() {
		return examen;
	}
	public void setExamen(int examen) {
		this.examen = examen;
	}
	@Column (name="presion_arterial")
	private String presion;
	@Column (name="frecuencia_respiratoria")
	private int respiracion;
	@Column (name="temperatura_axilar")
	private int axilar;
	@Column (name="frecuencia_cardiaca")
	private int cardiaca;
	@Column (name="sat_O2")
	private int satO2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPresion() {
		return presion;
	}
	public void setPresion(String presion) {
		this.presion = presion;
	}
	public int getRespiracion() {
		return respiracion;
	}
	public void setRespiracion(int respiracion) {
		this.respiracion = respiracion;
	}
	public int getAxilar() {
		return axilar;
	}
	public void setAxilar(int axilar) {
		this.axilar = axilar;
	}
	public int getCardiaca() {
		return cardiaca;
	}
	public void setCardiaca(int cardiaca) {
		this.cardiaca = cardiaca;
	}
	public int getSatO2() {
		return satO2;
	}
	public void setSatO2(int satO2) {
		this.satO2 = satO2;
	}
	
	
}
