package com.itehldigital.capacitacion.microservicio.negocio.dominio.descuentos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.itehldigital.capacitacion.comun.excepciones.ExcepcionCampoObligatorio;
import com.itehldigital.capacitacion.microservicio.testdatabuilder.DescuentoOnlineTestDataBuilder;

public class DescuentoOnlineTest {

	@Test
	public void nombreEsObligatorio() {
		String mensajeCampoRequerido = "El Nombre es obligatorio";

		Exception excepcion = Assertions.assertThrows(ExcepcionCampoObligatorio.class,
				() -> new DescuentoOnlineTestDataBuilder().conNombre(null).construir());

		assertEquals(mensajeCampoRequerido, excepcion.getMessage());
	}

	@Test
	public void cursoEsObligatorio() {
		String mensajeCampoRequerido = "El Curso es obligatorio";

		Exception excepcion = Assertions.assertThrows(ExcepcionCampoObligatorio.class,
				() -> new DescuentoOnlineTestDataBuilder().conCurso(null).construir());

		assertEquals(mensajeCampoRequerido, excepcion.getMessage());
	}

	@Test
	public void paisEsObligatorio() {
		String mensajeCampoRequerido = "El País es obligatorio";

		Exception excepcion = Assertions.assertThrows(ExcepcionCampoObligatorio.class,
				() -> new DescuentoOnlineTestDataBuilder().conPais(null).construir());

		assertEquals(mensajeCampoRequerido, excepcion.getMessage());
	}

	@Test
	public void fechaFinalEsObligatorio() {
		String mensajeCampoRequerido = "La Fecha Final es obligatorio";

		Exception excepcion = Assertions.assertThrows(ExcepcionCampoObligatorio.class,
				() -> new DescuentoOnlineTestDataBuilder().conFechaFinal(null).construir());

		assertEquals(mensajeCampoRequerido, excepcion.getMessage());
	}

	@Test
	public void descuentoPuedeSerCreado() {
		Descuento descuento = new DescuentoOnlineTestDataBuilder().construir();

		assertEquals("Descuento por lanzamiento", descuento.getNombre());
	}

	@Test
	public void descuentoDebeSerDelVeintePorCiento() {
		Descuento descuento = new DescuentoOnlineTestDataBuilder().construir();

		descuento.aplicarDescuento();

		assertEquals(20000.04F, descuento.getDescuento(), 1);
	}
}
