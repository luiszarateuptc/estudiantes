package co.edu.uptc.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uptc.data.entities.Usuario;

@Repository(value = "usuarioRepository")
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByNombreUsuario(String username);

}
