package com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.generadores;

import org.springframework.stereotype.Component;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Modalidad;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.Descuento;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.DescuentoOnDemand;

@Component
public class GenerarDescuentoOnDemand implements GenerarDescuento {

	@Override
	public boolean aplicaModalidadParaDescuento(String modalidad) {
		return modalidad.equals(Modalidad.ONDEMAND.getNombre());
	}

	@Override
	public Descuento generar(String nombre, Curso curso, String pais, String fechaFinal) {
		Descuento descuento = new DescuentoOnDemand(nombre, curso, pais, fechaFinal);
		return descuento;
	}

}
