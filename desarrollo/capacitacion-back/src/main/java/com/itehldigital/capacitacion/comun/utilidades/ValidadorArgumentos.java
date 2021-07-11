package com.itehldigital.capacitacion.comun.utilidades;

import java.time.LocalDate;

import com.itehldigital.capacitacion.comun.excepciones.ExcepcionCampoObligatorio;
import com.itehldigital.capacitacion.comun.excepciones.ExcepcionValorInvalido;

public class ValidadorArgumentos {

	private ValidadorArgumentos() {
	}

	public static void validarCampoObligatorioYLanzarExcepcion(Object campo, String mensajeExcepcion) {
		if (campo == null) {
			throw new ExcepcionCampoObligatorio(mensajeExcepcion);
		}
	}

	public static void validarValorMayorQueCero(float valor, String mensajeExcepcion) {
		if (valor <= 0) {
			throw new ExcepcionValorInvalido(mensajeExcepcion);
		}
	}

	public static LocalDate validarFechaMayorIgualQueHoy(LocalDate fecha, String mensajeExcepcion) {
		LocalDate hoy = LocalDate.now();

		if (fecha.isBefore(hoy)) {
			throw new ExcepcionValorInvalido(mensajeExcepcion);
		}

		return fecha;
	}
}
