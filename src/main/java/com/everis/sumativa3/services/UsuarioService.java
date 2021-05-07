package com.everis.sumativa3.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.everis.sumativa3.models.Usuario;
import com.everis.sumativa3.repositories.UsuarioRepository;


@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	public Usuario registrar(Usuario usuario) {
		String hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
	    usuario.setPassword(hashed);
		return usuarioRepository.save(usuario);
	}
	public boolean autenticacion(String email, String password) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) { 
			return false;
		}else {
			if(BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
}
