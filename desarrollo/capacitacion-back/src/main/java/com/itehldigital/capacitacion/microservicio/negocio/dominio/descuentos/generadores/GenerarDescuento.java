package com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.generadores;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.Descuento;

public interface GenerarDescuento {
	boolean aplicaModalidadParaDescuento(String modalidad);

	Descuento generar(String nombre, Curso curso, String pais, String fechaFinal);
}
