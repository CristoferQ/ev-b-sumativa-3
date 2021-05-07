package com.everis.sumativa3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.sumativa3.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
}
