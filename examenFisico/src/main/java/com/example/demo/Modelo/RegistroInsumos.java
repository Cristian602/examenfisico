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
@Table (name="registroinsumos")

public class RegistroInsumos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2155817881480155796L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "sec_regInsumos")
	@GenericGenerator(name = "sec_regInsumos", strategy = "native")
	@Column (name="id_registroinsumos")
	private int id;
	@Column (name="insumos")
	private int insumos;
	@Column (name="cantidad")
	private int cantidad;
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
		return cantidad;
	}
	public void setDescripcion(int descripcion) {
		this.cantidad = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
