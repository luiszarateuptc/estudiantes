package co.edu.uptc.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuditBasicDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private Long time;
	
	private String action;
	
}
