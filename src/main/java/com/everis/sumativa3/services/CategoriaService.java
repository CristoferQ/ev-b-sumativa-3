package com.everis.sumativa3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.everis.sumativa3.models.Categoria;
import com.everis.sumativa3.models.Producto;
import com.everis.sumativa3.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;

	public Page<Categoria> categoriasPaginadas(int numeroPagina, int cantidadProductos){
		PageRequest pageRequest = PageRequest.of(numeroPagina, cantidadProductos);
		return categoriaRepository.findAll(pageRequest);
	}
		
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	public Categoria findById(Long id) {
		return categoriaRepository.findById(id).get();
	}
	public void deleteById(Long id) {
		categoriaRepository.deleteById(id);
	}
	
	public List<Categoria> findByNombre(String nombre) {
		return categoriaRepository.findByNombre(nombre);
	}
}	
