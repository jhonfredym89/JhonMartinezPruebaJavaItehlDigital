package com.itehldigital.capacitacion.microservicio.negocio.dtos;

public class CursoDTO {
	private String codigo;
	private String nombre;
	private String descripcion;
	private Float costo;
	private Float horas;
	private String publicoObjetivo;
	private String modalidad;

	public CursoDTO() {
	}

	public CursoDTO(String codigo, String nombre, String descripcion, Float costo, Float horas, String publicoObjetivo,
			String modalidad) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
		this.horas = horas;
		this.publicoObjetivo = publicoObjetivo;
		this.modalidad = modalidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Float getCosto() {
		return costo;
	}

	public Float getHoras() {
		return horas;
	}

	public String getPublicoObjetivo() {
		return publicoObjetivo;
	}

	public String getModalidad() {
		return modalidad;
	}
}
