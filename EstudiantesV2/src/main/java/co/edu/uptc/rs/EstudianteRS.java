package co.edu.uptc.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.data.entities.Estudiante;
import co.edu.uptc.dto.EstudianteBasicDto;
import co.edu.uptc.service.EstudianteService;

@RestController
@RequestMapping("/student")
public class EstudianteRS {

	@Autowired
	private EstudianteService estudianteService;

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMINISTRADOR')")
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public Long crearEstudiante(@RequestBody Estudiante estudiante) {
		return estudianteService.crearEstudiante(estudiante);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMINISTRADOR')")
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Estudiante> obtenerTodos() {
		return estudianteService.consultarTodos();
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMINISTRADOR')")
	@GetMapping(value = "/all/basic", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EstudianteBasicDto> obtenerTodosBasic() {
		return estudianteService.consultarTodosBasico();
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMINISTRADOR')")
	@GetMapping(value = "/all/firstName", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Estudiante> obtenerPrimerNombre(@RequestParam(value = "primernombre") String primernombre) {
		return estudianteService.obtenerEstudiantePrimerNombre(primernombre);
	}

}
