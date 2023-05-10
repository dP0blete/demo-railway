package com.ecoclick.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecoclick.repository.UsuarioRep;
import com.ecoclick.models.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRep usuarioRep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRep
				.findByNombre(username)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario con nombre "+ username+ " no existe."));
		return new UserDetailsImpl(usuario);
	}
	
}
