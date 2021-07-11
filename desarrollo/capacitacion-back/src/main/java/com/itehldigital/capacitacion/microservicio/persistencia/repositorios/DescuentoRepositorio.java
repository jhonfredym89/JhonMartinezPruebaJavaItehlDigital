package com.itehldigital.capacitacion.microservicio.persistencia.repositorios;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.Descuento;

public interface DescuentoRepositorio {
	void aplicarDescuento(Descuento descuento);
}
