package com.itehldigital.capacitacion.microservicio.persistencia.repositorios.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.Descuento;
import com.itehldigital.capacitacion.microservicio.persistencia.colecciones.DescuentoColeccion;
import com.itehldigital.capacitacion.microservicio.persistencia.repositorios.DescuentoRepositorio;
import com.itehldigital.capacitacion.microservicio.persistencia.repositorios.mongoDB.DescuentoRepositorioMongoDB;

@Repository
public class DescuentoRepositorioImpl implements DescuentoRepositorio {

	@Autowired
	private DescuentoRepositorioMongoDB repositorioMongoDB;

	@Override
	public void aplicarDescuento(Descuento descuento) {
		DescuentoColeccion descuentoColeccion = new DescuentoColeccion(descuento.getNombre(),
				descuento.getCurso().getNombre(), descuento.getCurso().getModalidad(), descuento.getPais(),
				descuento.getDescuento(), descuento.getFechaFinal());

		repositorioMongoDB.insert(descuentoColeccion);
	}

}
