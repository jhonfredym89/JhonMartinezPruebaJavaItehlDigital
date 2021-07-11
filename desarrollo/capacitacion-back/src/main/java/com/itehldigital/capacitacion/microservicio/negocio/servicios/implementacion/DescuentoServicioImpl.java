package com.itehldigital.capacitacion.microservicio.negocio.servicios.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itehldigital.capacitacion.comun.excepciones.ExcepcionRegistroNoExistente;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos.Curso;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.Descuento;
import com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos.generadores.GenerarDescuento;
import com.itehldigital.capacitacion.microservicio.negocio.dtos.CursoDTO;
import com.itehldigital.capacitacion.microservicio.negocio.dtos.DescuentoDTO;
import com.itehldigital.capacitacion.microservicio.negocio.servicios.DescuentoServicio;
import com.itehldigital.capacitacion.microservicio.persistencia.repositorios.CursoRepositorio;
import com.itehldigital.capacitacion.microservicio.persistencia.repositorios.DescuentoRepositorio;

@Service
public class DescuentoServicioImpl implements DescuentoServicio {

	@Autowired
	private List<GenerarDescuento> estrategiasGenerarDescuento;

	@Autowired
	private CursoRepositorio cursoRepositorio;

	@Autowired
	private DescuentoRepositorio descuentoRepositorio;

	@Override
	public void aplicarDescuento(DescuentoDTO descuentoDTO) {
		CursoDTO cursoDTO = cursoRepositorio.consultarCursoPorCodigo(descuentoDTO.getCodigoCurso());

		if (cursoDTO == null) {
			throw new ExcepcionRegistroNoExistente(
					"El Curso con código " + descuentoDTO.getCodigoCurso() + " no existe");
		}

		Curso curso = new Curso(cursoDTO.getCodigo(), cursoDTO.getNombre(), cursoDTO.getDescripcion(),
				cursoDTO.getCosto(), cursoDTO.getHoras(), cursoDTO.getPublicoObjetivo(), cursoDTO.getModalidad());

		GenerarDescuento generarDescuento = estrategiasGenerarDescuento.stream()
				.filter(estrategia -> estrategia.aplicaModalidadParaDescuento(curso.getModalidad())).findFirst()
				.orElseThrow(RuntimeException::new);

		Descuento descuento = generarDescuento.generar(descuentoDTO.getNombre(), curso, descuentoDTO.getPais(),
				descuentoDTO.getFechaFinal());

		descuento.aplicarDescuento();

		descuentoRepositorio.aplicarDescuento(descuento);
	}

}
