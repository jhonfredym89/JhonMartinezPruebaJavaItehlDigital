package com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.generadores;

import org.springframework.stereotype.Component;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Modalidad;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.Descuento;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.DescuentoPrivado;

@Component
public class GenerarDescuentoPrivado implements GenerarDescuento {

	@Override
	public boolean aplicaModalidadParaDescuento(String modalidad) {
		return modalidad.equals(Modalidad.PRIVADO.getNombre());
	}

	@Override
	public Descuento generar(String nombre, Curso curso, String pais, String fechaFinal) {
		Descuento descuento = new DescuentoPrivado(nombre, curso, pais, fechaFinal);
		return descuento;
	}

}
