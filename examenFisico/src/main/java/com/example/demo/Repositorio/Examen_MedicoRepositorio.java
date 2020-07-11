package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Examen_Medico;


@Repository
public interface Examen_MedicoRepositorio extends JpaRepository<Examen_Medico,Integer>{

}
