package co.edu.uptc.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EstudianteBasicDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String primerNombre;
	
	private String segundoNombre;
	
	private String primerApellido;
	
	private String segundoApellido;

	public EstudianteBasicDto(String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido) {
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
	}
	
}
