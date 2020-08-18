package co.edu.uptc.data.entities;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cn_calificacion")
@Data
public class Calificacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "asignatura_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_calificacion_asignatura_id"))
	@ManyToOne(optional = false)
	private Asignatura asignatura;
	
	@JoinColumn(name = "estudiante_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_calificacion_estudiante_id"))
	@ManyToOne(optional = false)
	private Estudiante estudiante;
	
	@Column(name = "definitiva", nullable = true)
	private Double definitiva;
	
	private ZonedDateTime fecha;
}
