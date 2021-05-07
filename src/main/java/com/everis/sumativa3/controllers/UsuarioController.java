package com.everis.sumativa3.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.sumativa3.models.Usuario;
import com.everis.sumativa3.services.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("/registro")
	public String registro() {
		return "registro.jsp";
	}
	@RequestMapping("/registrar")
	public String registrar(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("vip") String vip) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		if(vip.equals("0")) {
			usuario.setVip(false);
		}else {
			usuario.setVip(true);
		}
		usuario = usuarioService.registrar(usuario);
		return "redirect:/";
	}
	@PostMapping("/ingresar")
	public String logear(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session, Model model) {
		if (usuarioService.autenticacion(email, password)) {
			Usuario usuario = usuarioService.findByEmail(email);
			session.setAttribute("registrado", 1);
			if(usuario.isVip()) {
				session.setAttribute("rol", "vip");
			}else {
				session.setAttribute("rol", "normal");
			}
			return "redirect:/categoria";
		}else {
			session.setAttribute("registrado", 0);
			return "redirect:/";
		}
	}
	@GetMapping("/ingresar")
	public String getIngresar() {
		return "redirect:/";
	}
	@RequestMapping("/desloguearse")
	public String desloguearse(HttpSession session) {
		session.setAttribute("rol", "");
		session.setAttribute("registrado", 0);
		return "redirect:/";
	}
}
