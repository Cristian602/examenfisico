package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Examen;

@Repository
public interface ExamenRepositorio extends JpaRepository<Examen,Integer>{

}
