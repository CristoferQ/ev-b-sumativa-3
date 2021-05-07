package com.everis.sumativa3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.everis.sumativa3.models.Categoria;
import com.everis.sumativa3.models.Producto;
import com.everis.sumativa3.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;

	public Page<Producto> productosPaginados(int numeroPagina, int cantidadProductos){
		PageRequest pageRequest = PageRequest.of(numeroPagina, cantidadProductos);
		return productoRepository.findAll(pageRequest);
	}
		
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}
	public Producto findById(Long id) {
		return productoRepository.findById(id).get();
	}
	public void deleteById(Long id) {
		productoRepository.deleteById(id);
	}
	public List<Producto> findByNombre(String nombre) {
		return productoRepository.findByNombre(nombre);
	}
}	
