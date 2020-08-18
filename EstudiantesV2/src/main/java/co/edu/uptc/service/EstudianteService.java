package co.edu.uptc.service;

import java.util.List;
import static java.util.Objects.nonNull;
import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uptc.aspect.UptcTime;
import co.edu.uptc.data.entities.Estudiante;
import co.edu.uptc.data.entities.TipoDocumentoEnum;
import co.edu.uptc.dto.EstudianteBasicDto;
import co.edu.uptc.repositories.EstudianteRepository;

@Service("estudianteService")
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	public Long crearEstudiante(Estudiante estudiante) {
		Long idEstudiante = existeEstudiante(estudiante.getNumeroDocumento(), estudiante.getTipoDocumento());
		if (isNull(idEstudiante)) {
			estudiante = estudianteRepository.save(estudiante);
			return estudiante.getId();
		}
		return idEstudiante;
	}

	public Long existeEstudiante(String numeroDocumento, TipoDocumentoEnum tipoDocumento) {
		List<Estudiante> listEstudiante = estudianteRepository.getEstudianteByNumDocTipDoc(numeroDocumento,
				tipoDocumento);
		return nonNull(listEstudiante) && !listEstudiante.isEmpty() ? listEstudiante.iterator().next().getId() : null;
	}
	
	@UptcTime(value = "consultarTodos")
	public List<Estudiante> consultarTodos(){
		return estudianteRepository.findAll();
	}
	
	@UptcTime
	public List<EstudianteBasicDto> consultarTodosBasico(){
		return estudianteRepository.obtenerTodos();
	}
	
	public List<Estudiante> obtenerEstudiantePrimerNombre(String primerNombre){
		return estudianteRepository.findByPrimerNombre(primerNombre);
	}

}
