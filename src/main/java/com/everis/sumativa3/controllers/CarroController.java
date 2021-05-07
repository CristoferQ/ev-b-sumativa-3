package com.everis.sumativa3.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.sumativa3.models.Carro;
import com.everis.sumativa3.models.Producto;
import com.everis.sumativa3.services.CarroService;
import com.everis.sumativa3.services.ProductoService;

@Controller
@RequestMapping("/carro")
public class CarroController {
	@Autowired
	ProductoService productoService;
	@Autowired
	CarroService carroService;
	
	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		model.addAttribute("listaProductosCarro", carroService.findAll());
		return "carro.jsp";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping("/agregar/{id}")
	public String agregar(@PathVariable("id")Long id) {
		Producto producto = productoService.findById(id);
		Carro productoCarro = new Carro();
		productoCarro.setNombre(producto.getNombre());
		productoCarro.setPrecio(producto.getPrecio());
		carroService.save(productoCarro);
		return "redirect:/carro";
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id")Long id) {
		carroService.deleteById(id);
		return "redirect:/carro";
	}
}
