package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Neurologico;


@Repository
public interface NeurologicoRepositorio extends JpaRepository<Neurologico,Integer>{

}
