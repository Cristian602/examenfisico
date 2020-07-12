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
@Table (name="pielcabeza")

public class PielCabeza implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -165110487688752003L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "sec_pyc")
	@GenericGenerator(name = "sec_pyc", strategy = "native")
	@Column (name="id_pielcabeza")
	private int id;
	@Column (name="examen")
	private int examen;
	
	public int getExamen() {
		return examen;
	}
	public void setExamen(int examen) {
		this.examen = examen;
	}
	@Column (name="ojos")
	private String ojos;
	@Column (name="cabeza")
	private String cabeza;
	@Column (name="cuello_tiroides")
	private String tiroides;
	@Column (name="cuello_arterias_carotidas")
	private String carotidas;
	@Column (name="turgor_elasticidad_piel")
	private String turgor;
	@Column (name="pelo_unias")
	private String pelo;
	@Column (name="oidos")
	private String oidos;
	@Column (name="nariz")
	private String nariz;
	@Column (name="color_piel")
	private String piel;
	@Column (name="boca")
	private String boca;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOjos() {
		return ojos;
	}
	public void setOjos(String ojos) {
		this.ojos = ojos;
	}
	public String getCabeza() {
		return cabeza;
	}
	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}
	public String getTiroides() {
		return tiroides;
	}
	public void setTiroides(String tiroides) {
		this.tiroides = tiroides;
	}
	public String getCarotidas() {
		return carotidas;
	}
	public void setCarotidas(String carotidas) {
		this.carotidas = carotidas;
	}
	public String getTurgor() {
		return turgor;
	}
	public void setTurgor(String turgor) {
		this.turgor = turgor;
	}
	public String getPelo() {
		return pelo;
	}
	public void setPelo(String pelo) {
		this.pelo = pelo;
	}
	public String getOidos() {
		return oidos;
	}
	public void setOidos(String oidos) {
		this.oidos = oidos;
	}
	public String getNariz() {
		return nariz;
	}
	public void setNariz(String nariz) {
		this.nariz = nariz;
	}
	public String getPiel() {
		return piel;
	}
	public void setPiel(String piel) {
		this.piel = piel;
	}
	public String getBoca() {
		return boca;
	}
	public void setBoca(String boca) {
		this.boca = boca;
	}
	
}
