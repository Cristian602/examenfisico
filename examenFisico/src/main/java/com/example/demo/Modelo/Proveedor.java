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
@Table (name="proveedor")

public class Proveedor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6485315290675282887L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO, generator = "sec_prov")
	@GenericGenerator(name = "sec_prov", strategy = "native")
	@Column (name="id_proveedor")
	private int id;
	@Column (name="nombre")
	private String nombre;
	@Column (name="direccion")
	private String direccion;
	@Column (name="descripcion")
	private String descripcion;
	@Column (name="telefono")
	private String telefono;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
