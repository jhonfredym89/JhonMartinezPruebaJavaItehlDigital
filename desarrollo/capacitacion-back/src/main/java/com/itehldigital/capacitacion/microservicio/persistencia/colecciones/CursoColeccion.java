package com.itehldigital.capacitacion.microservicio.persistencia.colecciones;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cursos")
public class CursoColeccion {

	@Id
	private String id;
	private String codigo;
	private String nombre;
	private float costo;
	private String descripcion;
	private float horas;
	private String publicoObjetivo;
	private String modalidad;

	public CursoColeccion(String id, String codigo, String nombre, float costo, String descripcion, float horas,
			String publicoObjetivo, String modalidad) {

		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.costo = costo;
		this.descripcion = descripcion;
		this.horas = horas;
		this.publicoObjetivo = publicoObjetivo;
		this.modalidad = modalidad;
	}

	public String getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public float getCosto() {
		return costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getHoras() {
		return horas;
	}

	public String getPublicoObjetivo() {
		return publicoObjetivo;
	}

	public String getModalidad() {
		return modalidad;
	}
}
