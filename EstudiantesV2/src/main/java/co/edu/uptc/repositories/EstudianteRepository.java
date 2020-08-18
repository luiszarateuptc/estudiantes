package co.edu.uptc.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.uptc.data.entities.Estudiante;
import co.edu.uptc.data.entities.TipoDocumentoEnum;
import co.edu.uptc.dto.EstudianteBasicDto;

@Repository(value = "estudianteRepository")
@Transactional
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

	@Query("SELECT e FROM Estudiante e WHERE e.numeroDocumento = :numeroDoc AND e.tipoDocumento = :tipoDoc")
	public List<Estudiante> getEstudianteByNumDocTipDoc(@Param("numeroDoc") String numeroDoc,
			@Param("tipoDoc") TipoDocumentoEnum tipoDoc);
	
	@Query("SELECT new co.edu.uptc.dto.EstudianteBasicDto(e.primerNombre, e.segundoNombre, e.primerApellido, e.segundoApellido) FROM Estudiante e")
	public List<EstudianteBasicDto> obtenerTodos();
	
	public List<Estudiante> findByPrimerNombre(String primerNombre);

}
