package com.ecoclick.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoclick.models.Usuario;
import com.ecoclick.repository.UsuarioRep;
import com.ecoclick.services.interfaces.IUsuario;

@Service
public class UsuarioImpl implements IUsuario{
	
	@Autowired
	UsuarioRep usuarioRep;

	@Override
	public List<Usuario> getAllUsuarios() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = usuarioRep.findAll();
			return usuarios;
		} catch (Exception e) {
			return new ArrayList<Usuario>();
		}
	}

	@Override
	public Optional<Usuario> getUsuarioById(int idUsuario) {
		try {
			return usuarioRep.findById(idUsuario);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean createUsuario(Usuario usuario) {
		try {
			usuarioRep.saveAndFlush(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteUsuario(int idUsuario) {
		try {
			if(usuarioRep.existsById(idUsuario)) {
				usuarioRep.deleteById(idUsuario);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean editUsuario(Usuario usuario) {
		try {
			if(usuarioRep.existsById(usuario.getId_usuario())) {
				usuarioRep.saveAndFlush(usuario);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
