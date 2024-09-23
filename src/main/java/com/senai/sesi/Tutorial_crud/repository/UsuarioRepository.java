package com.senai.sesi.Tutorial_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.sesi.Tutorial_crud.model.usuario;

public interface UsuarioRepository extends JpaRepository<usuario,Integer> {

}
