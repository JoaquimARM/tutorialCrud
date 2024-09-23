package com.senai.sesi.Tutorial_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.senai.sesi.Tutorial_crud.repository.UsuarioRepository;


@Controller
public class usuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario")
	public String listarUsuario(Model modelo) {
		modelo.addAttribute("usuarios",usuarioRepository.findAll());
 		return "usuario";
	}
	
	
	
}
