package com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos;

public enum Modalidad {
	PRIVADO("Privado"), ONLINE("Online"), ONDEMAND("OnDemand");
	
	private final String nombre;

	private Modalidad(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
