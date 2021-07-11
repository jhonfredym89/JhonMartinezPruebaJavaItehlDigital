package com.itehldigital.capacitacion.microservicio.negocio.servicios;

import java.util.List;

import com.itehldigital.capacitacion.microservicio.negocio.dtos.CursoDTO;

public interface CursoServicio {

	void registrar(CursoDTO cursoDTO);

	List<CursoDTO> consultarPorModalidad(String modalidad);

	void actualizar(String codigo, CursoDTO cursoDTO);
}
