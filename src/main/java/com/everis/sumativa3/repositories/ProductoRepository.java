package com.everis.sumativa3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.sumativa3.models.Categoria;
import com.everis.sumativa3.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	List<Producto> findByNombre(String nombre);
}
