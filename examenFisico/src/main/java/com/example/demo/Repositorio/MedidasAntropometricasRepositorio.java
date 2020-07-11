package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.MedidasAntropometricas;

@Repository
public interface MedidasAntropometricasRepositorio extends JpaRepository<MedidasAntropometricas,Integer>{

}
