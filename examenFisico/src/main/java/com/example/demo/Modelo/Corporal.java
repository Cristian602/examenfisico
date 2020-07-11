package com.example.demo.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="corporal")

public class Corporal {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name="id_corporal")
	private int id;
	
	@Column (name="examen")
	private int examen;
	
	@Column (name="torax_palpacion")
	private String tpalpaxion;
	@Column (name="torax_percusion")
	private String tpercusion;
	@Column (name="torax_auscultacion")
	private String tauscultacion;
	@Column (name="torax_inspeccion")
	private String tinspeccion;
	@Column (name="region_genital")
	private String genital;
	@Column (name="extremidades")
	private String extremidades;
	@Column (name="abdomen_palpacion")
	private String apalpaxion;
	@Column (name="abdomen_percusion")
	private String apercusion;
	@Column (name="abdomen_auscultacion")
	private String aauscultacion;
	@Column (name="abdomen_inspeccion")
	private String ainspeccion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getExamen() {
		return examen;
	}
	public void setExamen(int examen) {
		this.examen = examen;
	}
	public String getTpalpaxion() {
		return tpalpaxion;
	}
	public void setTpalpaxion(String tpalpaxion) {
		this.tpalpaxion = tpalpaxion;
	}
	public String getTpercusion() {
		return tpercusion;
	}
	public void setTpercusion(String tpercusion) {
		this.tpercusion = tpercusion;
	}
	public String getTauscultacion() {
		return tauscultacion;
	}
	public void setTauscultacion(String tauscultacion) {
		this.tauscultacion = tauscultacion;
	}
	public String getTinspeccion() {
		return tinspeccion;
	}
	public void setTinspeccion(String tinspeccion) {
		this.tinspeccion = tinspeccion;
	}
	public String getGenital() {
		return genital;
	}
	public void setGenital(String genital) {
		this.genital = genital;
	}
	public String getExtremidades() {
		return extremidades;
	}
	public void setExtremidades(String extremidades) {
		this.extremidades = extremidades;
	}
	public String getApalpaxion() {
		return apalpaxion;
	}
	public void setApalpaxion(String apalpaxion) {
		this.apalpaxion = apalpaxion;
	}
	public String getApercusion() {
		return apercusion;
	}
	public void setApercusion(String apercusion) {
		this.apercusion = apercusion;
	}
	public String getAauscultacion() {
		return aauscultacion;
	}
	public void setAauscultacion(String aauscultacion) {
		this.aauscultacion = aauscultacion;
	}
	public String getAinspeccion() {
		return ainspeccion;
	}
	public void setAinspeccion(String ainspeccion) {
		this.ainspeccion = ainspeccion;
	}
	
}
