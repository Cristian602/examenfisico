package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Proveedor;


@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor,Integer>{

}
