package com.ecoclick.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecoclick.models.Usuario;

public interface IUsuario {

	List<Usuario> getAllUsuarios();
	
	Optional<Usuario> getUsuarioById(int idUsuario);
	
	boolean createUsuario(Usuario usuario);
	
	boolean deleteUsuario(int idUsuario);
	
	boolean editUsuario(Usuario usuario);
}
