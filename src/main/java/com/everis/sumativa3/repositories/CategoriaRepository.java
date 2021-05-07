package com.everis.sumativa3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.sumativa3.models.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	List<Categoria> findByNombre(String nombre);
}
