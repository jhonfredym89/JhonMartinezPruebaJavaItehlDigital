package com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;

public class DescuentoOnDemand extends Descuento {

	private static final float DESCUENTO_MODALIDAD_ONDEMAND = 0.3F;

	public DescuentoOnDemand(String nombre, Curso curso, String pais, String fechaFinal) {
		super(nombre, curso, pais, fechaFinal);
	}

	@Override
	protected float calcularDescuento() {
		return super.getCurso().getCosto() * DESCUENTO_MODALIDAD_ONDEMAND;
	}

}
