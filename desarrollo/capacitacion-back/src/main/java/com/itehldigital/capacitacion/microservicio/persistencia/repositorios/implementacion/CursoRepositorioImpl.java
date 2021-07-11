package com.itehldigital.capacitacion.microservicio.persistencia.repositorios.implementacion;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;
import com.itehldigital.capacitacion.microservicio.negocio.dtos.CursoDTO;
import com.itehldigital.capacitacion.microservicio.persistencia.colecciones.CursoColeccion;
import com.itehldigital.capacitacion.microservicio.persistencia.repositorios.CursoRepositorio;
import com.itehldigital.capacitacion.microservicio.persistencia.repositorios.mongoDB.CursoRepositorioMongoDB;

@Repository
public class CursoRepositorioImpl implements CursoRepositorio {

	@Autowired
	private CursoRepositorioMongoDB repositorioMongoDB;

	@Override
	public void registrar(Curso curso) {
		CursoColeccion cursoColeccion = new CursoColeccion(null, curso.getCodigo(), curso.getNombre(), curso.getCosto(),
				curso.getDescripcion(), curso.getHoras(), curso.getPublicoObjetivo(), curso.getModalidad());

		repositorioMongoDB.insert(cursoColeccion);
	}

	@Override
	public List<CursoDTO> consultarPorModalidad(String modalidad) {
		List<CursoColeccion> cursos = repositorioMongoDB.findByModalidad(modalidad);

		if (cursos.isEmpty()) {
			return Collections.emptyList();
		}

		return cursos.stream()
				.map(curso -> new CursoDTO(curso.getCodigo(), curso.getNombre(), curso.getDescripcion(),
						curso.getCosto(), curso.getHoras(), curso.getPublicoObjetivo(), curso.getModalidad()))
				.collect(Collectors.toList());
	}

	@Override
	public void actualizar(String codigo, Curso curso) {
		CursoColeccion cursoExistente = consultarPorCodigo(codigo);

		CursoColeccion cursoColeccion = new CursoColeccion(cursoExistente.getId(), curso.getCodigo(), curso.getNombre(),
				curso.getCosto(), curso.getDescripcion(), curso.getHoras(), curso.getPublicoObjetivo(),
				curso.getModalidad());

		repositorioMongoDB.save(cursoColeccion);

	}

	@Override
	public boolean existeCurso(String codigo) {
		return repositorioMongoDB.existsByCodigo(codigo);
	}

	@Override
	public CursoDTO consultarCursoPorCodigo(String codigo) {
		CursoColeccion curso = consultarPorCodigo(codigo);

		if (curso == null) {
			return null;
		}

		return new CursoDTO(curso.getCodigo(), curso.getNombre(), curso.getDescripcion(), curso.getCosto(),
				curso.getHoras(), curso.getPublicoObjetivo(), curso.getModalidad());
	}

	private CursoColeccion consultarPorCodigo(String codigo) {
		return repositorioMongoDB.findByCodigo(codigo);
	}
}
