package com.senai.sesi.Tutorial_crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.senai.sesi.Tutorial_crud.model.usuario;
import com.senai.sesi.Tutorial_crud.repository.UsuarioRepository;


@Controller
public class usuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/formulario")
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("usuario", new usuario());
		return "formulario";
	}
	
	@PostMapping("/salvarUsuario")
	public String salvarUsuario(@ModelAttribute usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/usuario";
		
	}
	
	@GetMapping("/usuario")
	public String listarUsuario(Model modelo) {
		modelo.addAttribute("usuarios",usuarioRepository.findAll());
 		return "usuario";
	}
	
	@GetMapping("removerUsuario/{id}")
	public String removerUsuario(@PathVariable int id) {
		usuarioRepository.deleteById(id);
		return "redirect:/usuario";
	}
	
	@GetMapping("editarUsuario/{id}")
	public String editarUsuario(@PathVariable int id,Model modelo){
		Optional<usuario> usuarioOpt = usuarioRepository.findById(id);
		if(usuarioOpt.isPresent()) {
			modelo.addAttribute("usuario",usuarioOpt.get());
			return "formulario";
		}else {
			return "redirect:/usuarios";
		}
	}
	
	
	
}
