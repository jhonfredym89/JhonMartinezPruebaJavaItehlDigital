package com.itehldigital.capacitacion.microservicio.negocio.dominio.cursos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.itehldigital.capacitacion.comun.excepciones.ExcepcionCampoObligatorio;
import com.itehldigital.capacitacion.comun.excepciones.ExcepcionValorInvalido;
import com.itehldigital.capacitacion.microservicio.testdatabuilder.CursoTestDataBuilder;

public class CursoTest {

	@Test
	public void codigoEsObligatorio() {
		String mensajeCampoRequerido = "El Código es obligatorio";

		Exception excepcion = Assertions.assertThrows(ExcepcionCampoObligatorio.class,
				() -> new CursoTestDataBuilder().conCodigo(null).construir());

		assertEquals(mensajeCampoRequerido, excepcion.getMessage());
	}

	@Test
	public void nombreEsObligatorio() {
		String mensajeCampoRequerido = "El Nombre es obligatorio";

		Exception excepcion = Assertions.assertThrows(ExcepcionCampoObligatorio.class,
				() -> new CursoTestDataBuilder().conNombre(null).construir());

		assertEquals(mensajeCampoRequerido, excepcion.getMessage());
	}

	@Test
	public void costoEsObligatorio() {
		String mensajeCampoRequerido = "El Costo es obligatorio";

		Exception excepcion = Assertions.assertThrows(ExcepcionCampoObligatorio.class,
				() -> new CursoTestDataBuilder().conCosto(null).construir());

		assertEquals(mensajeCampoRequerido, excepcion.getMessage());
	}

	@Test
	public void horasEsObligatorio() {
		String mensajeCampoRequerido = "Las Horas son obligatorias";

		Exception excepcion = Assertions.assertThrows(ExcepcionCampoObligatorio.class,
				() -> new CursoTestDataBuilder().conHoras(null).construir());

		assertEquals(mensajeCampoRequerido, excepcion.getMessage());
	}

	@Test
	public void modalidadEsObligatorio() {
		String mensajeCampoRequerido = "La Modalidad es obligatorio";

		Exception excepcion = Assertions.assertThrows(ExcepcionCampoObligatorio.class,
				() -> new CursoTestDataBuilder().conModalidad(null).construir());

		assertEquals(mensajeCampoRequerido, excepcion.getMessage());
	}

	@Test
	public void horaDebeSerMayorQueCero() {
		String mensaje = "Las Horas deben ser mayor a cero";

		Exception excepcion = Assertions.assertThrows(ExcepcionValorInvalido.class,
				() -> new CursoTestDataBuilder().conHoras(0F).construir());

		assertEquals(mensaje, excepcion.getMessage());
	}

	@Test
	public void modalidadNoValida() {
		String mensaje = "Presencial NO es un valor valido para la Modalidad";

		Exception excepcion = Assertions.assertThrows(ExcepcionValorInvalido.class,
				() -> new CursoTestDataBuilder().conModalidad("Presencial").construir());

		assertEquals(mensaje, excepcion.getMessage());
	}
	
	@Test
	public void cursoPuedeSerCreado() {
		Curso curso = new CursoTestDataBuilder().construir();
		assertEquals("Curso01", curso.getCodigo());
		assertEquals("Curso de Prueba", curso.getNombre());
		assertEquals(100000.2F, curso.getCosto());
		assertEquals(10, curso.getHoras());
		assertEquals("Online", curso.getModalidad());
	}
}
