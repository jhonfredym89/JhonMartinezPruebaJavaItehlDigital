package com.itehldigital.capacitacion.comun.excepciones;

public class ExcepcionRegistroExistente extends RuntimeException {

	private static final long serialVersionUID = 32916312250240914L;
	
	public ExcepcionRegistroExistente(String mensaje) {
		super(mensaje);
	}

}
