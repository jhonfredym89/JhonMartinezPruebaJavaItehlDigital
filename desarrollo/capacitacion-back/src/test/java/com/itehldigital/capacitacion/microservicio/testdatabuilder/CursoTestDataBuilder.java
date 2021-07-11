package com.itehldigital.capacitacion.microservicio.testdatabuilder;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;

public class CursoTestDataBuilder {
	private String codigo;
	private String nombre;
	private Float costo;
	private Float horas;
	private String modalidad;

	public CursoTestDataBuilder() {
		codigo = "Curso01";
		nombre = "Curso de Prueba";
		costo = 100000.2F;
		horas = 10F;
		modalidad = "Online";
	}

	public CursoTestDataBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public CursoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public CursoTestDataBuilder conCosto(Float costo) {
		this.costo = costo;
		return this;
	}

	public CursoTestDataBuilder conHoras(Float horas) {
		this.horas = horas;
		return this;
	}

	public CursoTestDataBuilder conModalidad(String modalidad) {
		this.modalidad = modalidad;
		return this;
	}

	public Curso construir() {
		return new Curso(codigo, nombre, null, costo, horas, null, modalidad);
	}
}
