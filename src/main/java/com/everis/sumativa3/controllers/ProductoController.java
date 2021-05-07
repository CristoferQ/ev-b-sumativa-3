package com.everis.sumativa3.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	ProductoService productoService;
	@Autowired
	CategoriaService categoriaService;
	
	//PAGINACION
	private static final int cantidadProductos = 3; //cantidad de elementos
	@RequestMapping("")
	public String indexProducto(HttpSession session, Model model) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
			model.addAttribute("listaProductos", productoService.findAll());
			model.addAttribute("listaCategorias", categoriaService.findAll());
			
			Page<Producto> productosPaginables = productoService.productosPaginados(0, cantidadProductos);
			model.addAttribute("totalPagina", productosPaginables.getTotalPages());
			model.addAttribute("productosPaginados", productosPaginables);
			return "producto.jsp";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping("/busqueda")
	public String busquedaProducto(HttpSession session) {
		Integer registrado = (Integer) session.getAttribute("registrado");
		if(registrado==1) {
		return "busquedaproducto.jsp";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping("/busqueda/buscar")
	public String buscarProducto(@RequestParam("nombre") String nombre, Model model) {
		model.addAttribute("listaEncontrados", productoService.findByNombre(nombre));
		return "busquedaproducto.jsp";
	}
	@RequestMapping("/insertar")
	public String insertarProducto(@RequestParam("nombre") String nombre,
			@RequestParam("caracteristica") String caracteristica,
			@RequestParam("precio") String precio
			) {
		Producto producto = new Producto(); 
		producto.setNombre(nombre); 
		producto.setCaracteristica(caracteristica);
		producto.setPrecio(Float.parseFloat(precio)); 
		producto = productoService.save(producto);
		return "redirect:/producto";
	}
	@RequestMapping("/editar/{id}") //despliega editar
	public String editar(@PathVariable("id") Long id, Model model) {
		Producto producto = productoService.findById(id);
		List<Categoria> listaCategorias = categoriaService.findAll();
		model.addAttribute("listaCategorias", listaCategorias);
		model.addAttribute("producto", producto);
		return "editarproducto.jsp";
	}
	@RequestMapping("/update") //edita
	public String update(@ModelAttribute("producto") Producto producto) {
		productoService.save(producto);
		return "redirect:/producto";
	}
	@RequestMapping("/eliminar/{id}") //despliega editar
	public String eliminar(@PathVariable("id") Long id) {
		productoService.deleteById(id);
		return "redirect:/producto";
	}

	@RequestMapping("/paginacion/{numeroPagina}")
	public String getProductoPagina(@PathVariable("numeroPagina") int numeroPagina, Model model) {
		
		model.addAttribute("listaCategorias", categoriaService.findAll());
		Page<Producto> productosPaginables = productoService.productosPaginados(numeroPagina-1, cantidadProductos);
		model.addAttribute("totalPagina", productosPaginables.getTotalPages());
		model.addAttribute("productosPaginados", productosPaginables);
		return "producto.jsp";
	}
}
