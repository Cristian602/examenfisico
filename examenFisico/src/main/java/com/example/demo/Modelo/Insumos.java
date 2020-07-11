package com.example.demo.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="insumos")

public class Insumos {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name="id_insumos")
	private int id;
	@Column (name="nombre")
	private String nombre;
	@Column (name="descripcion")
	private String descripcion;
	@Column (name="fecha")
	private String fecha;
	@Column (name="cantidad")
	private int cantidad;
	@Column (name="preciounitario")
	private float preciounitario;
	@Column (name="id_proveedor")
	private int id_proveedor;
	
	public int getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPreciounitario() {
		return preciounitario;
	}
	public void setPreciounitario(float preciounitario) {
		this.preciounitario = preciounitario;
	}
	
}
