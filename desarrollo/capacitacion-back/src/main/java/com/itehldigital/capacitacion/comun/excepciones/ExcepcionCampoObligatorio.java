package com.itehldigital.capacitacion.comun.excepciones;

public class ExcepcionCampoObligatorio extends RuntimeException {

	private static final long serialVersionUID = 4928178897624770427L;
	
	public ExcepcionCampoObligatorio(String mensaje) {
		super(mensaje);
	}

}
