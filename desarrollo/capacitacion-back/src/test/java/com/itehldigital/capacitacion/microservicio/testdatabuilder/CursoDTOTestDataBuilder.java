package com.itehldigital.capacitacion.microservicio.testdatabuilder;

import com.itehldigital.capacitacion.microservicio.negocio.dtos.CursoDTO;

public class CursoDTOTestDataBuilder {
	private String codigo;
	private String nombre;
	private String descripcion;
	private Float costo;
	private Float horas;
	private String publicoObjetivo;
	private String modalidad;

	public CursoDTOTestDataBuilder() {
		codigo = "Curso01";
		nombre = "Curso de Prueba";
		descripcion = "Un Curso para Prueba de Integración";
		costo = 200000F;
		horas = 23.5F;
		publicoObjetivo = "Todos";
		modalidad = "Privado";
	}

	public CursoDTOTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public CursoDTO construir() {
		return new CursoDTO(codigo, nombre, descripcion, costo, horas, publicoObjetivo, modalidad);
	}

}
