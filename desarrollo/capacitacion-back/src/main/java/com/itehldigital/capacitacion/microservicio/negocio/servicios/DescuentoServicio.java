package com.itehldigital.capacitacion.microservicio.negocio.servicios;

import com.itehldigital.capacitacion.microservicio.negocio.dtos.DescuentoDTO;

public interface DescuentoServicio {

	void aplicarDescuento(DescuentoDTO descuentoDTO);
}
