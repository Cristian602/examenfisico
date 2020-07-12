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
@Table (name="examenMedico")
public class Examen_Medico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7787996725651776476L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sec_examenMedico")
	@GenericGenerator(name = "sec_examenMedico", strategy = "native")
	@Column (name="id_examenMedico")
	private int id;
	
	@Column (name="examen")
	private int id_examen;
	
	@Column (name="medico")
	private int id_medico;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_examen() {
		return id_examen;
	}

	public void setId_examen(int id_examen) {
		this.id_examen = id_examen;
	}

	public int getId_medico() {
		return id_medico;
	}

	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}
}
