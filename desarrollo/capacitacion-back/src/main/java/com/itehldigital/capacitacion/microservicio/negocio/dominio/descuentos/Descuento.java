package com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos;

import java.time.LocalDate;

import com.itehldigital.capacitacion.comun.utilidades.UtilidadFecha;
import com.itehldigital.capacitacion.comun.utilidades.ValidadorArgumentos;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;

public abstract class Descuento {
	private String nombre;
	private Curso curso;
	private String pais;
	private Float descuento;
	private LocalDate fechaFinal;

	protected Descuento(String nombre, Curso curso, String pais, String fechaFinal) {
		ValidadorArgumentos.validarCampoObligatorioYLanzarExcepcion(nombre, "El Nombre es obligatorio");
		ValidadorArgumentos.validarCampoObligatorioYLanzarExcepcion(curso, "El Curso es obligatorio");
		ValidadorArgumentos.validarCampoObligatorioYLanzarExcepcion(pais, "El País es obligatorio");
		ValidadorArgumentos.validarCampoObligatorioYLanzarExcepcion(fechaFinal, "La Fecha Final es obligatorio");

		LocalDate fecha = UtilidadFecha.convertirTextoALocalDate(fechaFinal);

		ValidadorArgumentos.validarFechaMayorIgualQueHoy(fecha,
				"La Fecha Final tiene que ser igual o superior a la fecha actual");

		this.nombre = nombre;
		this.curso = curso;
		this.pais = pais;
		this.fechaFinal = fecha;
	}

	protected abstract float calcularDescuento();

	public void aplicarDescuento() {
		this.descuento = calcularDescuento();
	}

	public String getNombre() {
		return nombre;
	}

	public Curso getCurso() {
		return curso;
	}

	public String getPais() {
		return pais;
	}

	public Float getDescuento() {
		return descuento;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
}
