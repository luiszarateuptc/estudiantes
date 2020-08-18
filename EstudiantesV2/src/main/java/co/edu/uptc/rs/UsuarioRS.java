package co.edu.uptc.rs;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.data.entities.Usuario;
import co.edu.uptc.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRS {

	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin
	@PermitAll
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public Long crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.createUser(usuario);
	}
}
