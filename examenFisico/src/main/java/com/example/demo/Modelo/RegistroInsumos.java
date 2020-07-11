package com.example.demo.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="registroinsumos")

public class RegistroInsumos {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name="id_registroinsumos")
	private int id;
	@Column (name="insumos")
	private int insumos;
	
	@Column (name="cantidad")
	private int descripcion;
	@Column (name="codigo")
	private String codigo;
	@Column (name="preciototal")
	private float preciototal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public float getPreciototal() {
		return preciototal;
	}
	public void setPreciototal(float preciototal) {
		this.preciototal = preciototal;
	}
	public int getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
