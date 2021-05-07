package com.everis.sumativa3.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.sumativa3.models.Categoria;
import com.everis.sumativa3.models.Producto;
import com.everis.sumativa3.services.CategoriaService;
import com.everis.sumativa3.services.ProductoService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;
	
	private static final int cantidadCategorias = 3; //cantidad de elementos
	@RequestMapping("")
	public String indexCategoria(HttpSession session, Model model) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		model.addAttribute("listaCategorias", categoriaService.findAll());
		//esto es para paginacion
		Page<Categoria> categoriasPaginables = categoriaService.categoriasPaginadas(0, cantidadCategorias);
		model.addAttribute("totalPagina", categoriasPaginables.getTotalPages());
		model.addAttribute("categoriasPaginadas", categoriasPaginables);
		return "categoria.jsp";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping("/busqueda")
	public String busquedaCategoria(HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		return "busquedacategoria.jsp";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping("/busqueda/buscar")
	public String buscarCategoria(@RequestParam("nombre") String nombre, Model model) {
		model.addAttribute("listaEncontrados", categoriaService.findByNombre(nombre));
		return "busquedacategoria.jsp";
	}
	@RequestMapping("/insertar")
	public String insertarCategoria(@RequestParam("nombre") String nombre) {
		Categoria categoria = new Categoria(); 
		categoria.setNombre(nombre);
		categoria = categoriaService.save(categoria);
		return "redirect:/categoria";
	}
	@RequestMapping("/editar/{id}") //despliega editar
	public String editar(@PathVariable("id") Long id, Model model) {
		Categoria categoria = categoriaService.findById(id);
		model.addAttribute("categoria", categoria);
		return "editarcategoria.jsp";
	}
	@RequestMapping("/update") //edita
	public String update(@ModelAttribute("categoria") Categoria categoria) {
		categoriaService.save(categoria);
		return "redirect:/categoria";
	}
	@RequestMapping("/eliminar/{id}") //despliega editar
	public String eliminar(@PathVariable("id") Long id) {
		categoriaService.deleteById(id);
		return "redirect:/categoria";
	}

	@RequestMapping("/paginacion/{numeroPagina}")
	public String getCategoriaPagina(@PathVariable("numeroPagina") int numeroPagina, Model model) {
		Page<Categoria> categoriasPaginables = categoriaService.categoriasPaginadas(numeroPagina-1, cantidadCategorias);
		model.addAttribute("totalPagina", categoriasPaginables.getTotalPages());
		model.addAttribute("categoriasPaginadas", categoriasPaginables);
		return "categoria.jsp";
	}
}
