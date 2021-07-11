package com.itehldigital.capacitacion.microservicio.persistencia.colecciones;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "descuentos")
public class DescuentoColeccion {

	@Id
	private String id;
	private String nombre;
	private String curso;
	private String modalidad;
	private String pais;
	private float descuento;
	private LocalDate fechaFinal;

	public DescuentoColeccion(String nombre, String curso, String modalidad, String pais, float descuento,
			LocalDate fechaFinal) {
		this.nombre = nombre;
		this.curso = curso;
		this.modalidad = modalidad;
		this.pais = pais;
		this.descuento = descuento;
		this.fechaFinal = fechaFinal;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCurso() {
		return curso;
	}

	public String getModalidad() {
		return modalidad;
	}

	public String getPais() {
		return pais;
	}

	public float getDescuento() {
		return descuento;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
}
