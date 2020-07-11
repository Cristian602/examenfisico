package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Corporal;


@Repository
public interface CorporalRepositorio extends JpaRepository<Corporal,Integer>{

}
