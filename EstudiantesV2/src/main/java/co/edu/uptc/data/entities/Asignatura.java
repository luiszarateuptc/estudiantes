package co.edu.uptc.data.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cn_asignatura")
@Data
public class Asignatura implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false, length = 150)
	private String nombre;
	
	@Column(name = "creditos", nullable = false)
	private Byte creditos;
	
	@Column(name = "semestre", nullable = false)
	private Byte semestre;
	
	@Column(name = "descripcion", nullable = true, length = 500)
	private String descripcion;

}
