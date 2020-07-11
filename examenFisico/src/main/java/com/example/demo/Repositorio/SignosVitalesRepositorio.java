package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.SignosVitales;


@Repository
public interface SignosVitalesRepositorio extends JpaRepository<SignosVitales,Integer>{

}
