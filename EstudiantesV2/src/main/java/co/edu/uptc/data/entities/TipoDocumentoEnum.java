package co.edu.uptc.data.entities;

public enum TipoDocumentoEnum {

	CC(1l, "Cédula de Ciudadanía"), CE(2l, "Cédula de Extranjería"), NIT(1l, "Nit"), NUIP(1l, "Nuip"),
	TI(1l, "Tarjeta de Identidad");

	private Long id;

	private String descripcion;

	private TipoDocumentoEnum(Long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
