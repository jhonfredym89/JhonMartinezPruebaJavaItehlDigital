package com.itehldigital.capacitacion.comun.utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.itehldigital.capacitacion.comun.excepciones.ExcepcionValorInvalido;

public class UtilidadFecha {
	private UtilidadFecha() {
	}

	public static LocalDate convertirTextoALocalDate(String fechaEnTexto) {
		try {
			return LocalDate.parse(fechaEnTexto);
		} catch (DateTimeParseException e) {
			throw new ExcepcionValorInvalido("El formato de la Fecha debe ser yyyy-mm-dd");
		}
	}
}
