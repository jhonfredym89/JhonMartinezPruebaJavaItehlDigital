package com.itehldigital.capacitacion.comun.excepciones;

public class ExcepcionRegistroNoExistente extends RuntimeException {

	private static final long serialVersionUID = -3561461841682062529L;

	public ExcepcionRegistroNoExistente(String mensaje) {
		super(mensaje);
	}

}
