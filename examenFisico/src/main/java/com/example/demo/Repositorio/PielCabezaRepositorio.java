package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.PielCabeza;


@Repository
public interface PielCabezaRepositorio extends JpaRepository<PielCabeza,Integer>{

}

