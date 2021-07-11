package com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos;

import com.itehldigital.capacitacion.comun.excepciones.ExcepcionValorInvalido;
import com.itehldigital.capacitacion.comun.utilidades.ValidadorArgumentos;

public class Curso {
	private String codigo;
	private String nombre;
	private String descripcion;
	private Float costo;
	private Float horas;
	private String publicoObjetivo;
	private String modalidad;

	public Curso(String codigo, String nombre, String descripcion, Float costo, Float horas, String publicoObjetivo,
			String modalidad) {

		ValidadorArgumentos.validarCampoObligatorioYLanzarExcepcion(codigo, "El Código es obligatorio");
		ValidadorArgumentos.validarCampoObligatorioYLanzarExcepcion(nombre, "El Nombre es obligatorio");
		ValidadorArgumentos.validarCampoObligatorioYLanzarExcepcion(costo, "El Costo es obligatorio");
		ValidadorArgumentos.validarCampoObligatorioYLanzarExcepcion(horas, "Las Horas son obligatorias");
		ValidadorArgumentos.validarValorMayorQueCero(horas, "Las Horas deben ser mayor a cero");
		ValidadorArgumentos.validarCampoObligatorioYLanzarExcepcion(modalidad, "La Modalidad es obligatorio");
		validarModalidad(modalidad);

		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
		this.horas = horas;
		this.publicoObjetivo = publicoObjetivo;
		this.modalidad = modalidad;
	}

	private void validarModalidad(String modalidad) {
		boolean noExiteModalidad = true;

		for (Modalidad modalidadEnum : Modalidad.values()) {
			if (modalidadEnum.getNombre().equals(modalidad)) {
				noExiteModalidad = false;
				return;
			}
		}

		if (noExiteModalidad) {
			throw new ExcepcionValorInvalido(modalidad + " NO es un valor valido para la Modalidad");
		}
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
