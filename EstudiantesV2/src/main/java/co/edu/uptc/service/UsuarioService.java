package co.edu.uptc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.uptc.data.entities.Usuario;
import co.edu.uptc.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNombreUsuario(username);
		List<GrantedAuthority> permisos = new ArrayList<GrantedAuthority>();
		permisos.add(new SimpleGrantedAuthority("ADMINISTRADOR"));
		UserDetails userDetails = new User(username, usuario.getPassword(), permisos);
		return userDetails;
	}

	public Long createUser(Usuario usuario) {
		usuario.setPassword(bCrypt.encode(usuario.getPassword()));
		usuario = usuarioRepository.save(usuario);
		return usuario.getId();
	}

}
