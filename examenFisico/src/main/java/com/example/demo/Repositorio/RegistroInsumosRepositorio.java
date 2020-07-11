package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.RegistroInsumos;

@Repository
public interface RegistroInsumosRepositorio extends JpaRepository<RegistroInsumos,Integer>{

}

