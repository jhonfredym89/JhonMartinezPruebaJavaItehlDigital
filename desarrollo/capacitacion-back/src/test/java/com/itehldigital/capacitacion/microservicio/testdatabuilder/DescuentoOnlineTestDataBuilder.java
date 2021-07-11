package com.itehldigital.capacitacion.microservicio.testdatabuilder;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.DescuentoOnline;

public class DescuentoOnlineTestDataBuilder {
	private String nombre;
	private Curso curso;
	private String pais;
	private String fechaFinal;

	public DescuentoOnlineTestDataBuilder() {
		nombre = "Descuento por lanzamiento";
		curso = new CursoTestDataBuilder().construir();
		pais = "Colombia";
		fechaFinal = "2021-12-31";
	}

	public DescuentoOnlineTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public DescuentoOnlineTestDataBuilder conCurso(Curso curso) {
		this.curso = curso;
		return this;
	}

	public DescuentoOnlineTestDataBuilder conPais(String pais) {
		this.pais = pais;
		return this;
	}

	public DescuentoOnlineTestDataBuilder conFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
		return this;
	}

	public DescuentoOnline construir() {
		return new DescuentoOnline(nombre, curso, pais, fechaFinal);
	}
}
