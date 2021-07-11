package com.itehldigital.capacitacion.microservicio.negocio.servicios.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itehldigital.capacitacion.comun.excepciones.ExcepcionRegistroExistente;
import com.itehldigital.capacitacion.comun.excepciones.ExcepcionRegistroNoExistente;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;
import com.itehldigital.capacitacion.microservicio.negocio.dtos.CursoDTO;
import com.itehldigital.capacitacion.microservicio.negocio.servicios.CursoServicio;
import com.itehldigital.capacitacion.microservicio.persistencia.repositorios.CursoRepositorio;

@Service
public class CursoServicioImpl implements CursoServicio {

	@Autowired
	private CursoRepositorio cursoRepositorio;

	@Override
	public void registrar(CursoDTO cursoDTO) {
		Curso curso = new Curso(cursoDTO.getCodigo(), cursoDTO.getNombre(), cursoDTO.getDescripcion(),
				cursoDTO.getCosto(), cursoDTO.getHoras(), cursoDTO.getPublicoObjetivo(), cursoDTO.getModalidad());

		if (existeCurso(cursoDTO.getCodigo())) {
			throw new ExcepcionRegistroExistente("Ya existe un Curso con el código " + cursoDTO.getCodigo());
		}

		cursoRepositorio.registrar(curso);
	}

	@Override
	public List<CursoDTO> consultarPorModalidad(String modalidad) {
		return cursoRepositorio.consultarPorModalidad(modalidad);
	}

	@Override
	public void actualizar(String codigo, CursoDTO cursoDTO) {

		if (!existeCurso(codigo)) {
			throw new ExcepcionRegistroNoExistente(codigo);
		}

		Curso curso = new Curso(cursoDTO.getCodigo(), cursoDTO.getNombre(), cursoDTO.getDescripcion(),
				cursoDTO.getCosto(), cursoDTO.getHoras(), cursoDTO.getPublicoObjetivo(), cursoDTO.getModalidad());

		cursoRepositorio.actualizar(codigo, curso);
	}

	private boolean existeCurso(String codigo) {
		return cursoRepositorio.existeCurso(codigo);
	}

}
