package com.itehldigital.capacitacion.microservicio.persistencia.repositorios;

import java.util.List;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;
import com.itehldigital.capacitacion.microservicio.negocio.dtos.CursoDTO;

public interface CursoRepositorio {

	void registrar(Curso curso);

	List<CursoDTO> consultarPorModalidad(String modalidad);

	void actualizar(String codigo, Curso curso);

	boolean existeCurso(String codigo);

	CursoDTO consultarCursoPorCodigo(String codigo);
}
