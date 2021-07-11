package com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;

public class DescuentoOnline extends Descuento {

	private static final float DESCUENTO_MODALIDAD_ONLINE = 0.2F;

	public DescuentoOnline(String nombre, Curso curso, String pais, String fechaFinal) {
		super(nombre, curso, pais, fechaFinal);
	}

	@Override
	protected float calcularDescuento() {
		return super.getCurso().getCosto() * DESCUENTO_MODALIDAD_ONLINE;
	}

}
