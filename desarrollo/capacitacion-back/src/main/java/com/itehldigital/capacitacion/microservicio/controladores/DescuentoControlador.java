package com.itehldigital.capacitacion.microservicio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itehldigital.capacitacion.microservicio.negocio.dtos.DescuentoDTO;
import com.itehldigital.capacitacion.microservicio.negocio.servicios.DescuentoServicio;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/capacitacion/v1/descuentos")
@Api(tags = "Descuentos")
public class DescuentoControlador {

	@Autowired
	private DescuentoServicio descuentoServicio;

	@PostMapping()
	@ApiOperation(value = "Crea un Descuento para un Curso")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Descuento creado"),
			@ApiResponse(code = 400, message = "El Descuento ya existe"),
			@ApiResponse(code = 404, message = "No existe el Curso al que se le quiere crear un Descuento"),
			@ApiResponse(code = 405, message = "Excepción al validar campos obligatorios") })
	public ResponseEntity<String> crearDescuento(@RequestBody DescuentoDTO descuento) {
		descuentoServicio.aplicarDescuento(descuento);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
