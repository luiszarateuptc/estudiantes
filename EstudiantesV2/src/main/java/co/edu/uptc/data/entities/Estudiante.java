package co.edu.uptc.data.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cn_estudiante")
@Data
public class Estudiante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "primer_nombre", nullable = false, length = 120)
	private String primerNombre;

	@Column(name = "segundo_nombre", nullable = true, length = 120)
	private String segundoNombre;

	@Column(name = "primer_apellido", nullable = false, length = 120)
	private String primerApellido;

	@Column(name = "segundo_apellido", nullable = true, length = 120)
	private String segundoApellido;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_documento", nullable = false)
	private TipoDocumentoEnum tipoDocumento;

	@Column(name = "numero_documento", nullable = false)
	private String numeroDocumento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
	private List<Calificacion> calificaciones;

}
