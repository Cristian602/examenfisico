package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Insumos;

@Repository
public interface InsumosRepositorio extends JpaRepository<Insumos,Integer>{

}
