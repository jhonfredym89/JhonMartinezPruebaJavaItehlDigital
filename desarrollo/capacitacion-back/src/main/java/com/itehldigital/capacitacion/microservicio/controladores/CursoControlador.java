package com.itehldigital.capacitacion.microservicio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itehldigital.capacitacion.microservicio.negocio.dtos.CursoDTO;
import com.itehldigital.capacitacion.microservicio.negocio.servicios.CursoServicio;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/capacitacion/v1/cursos")
@Api(tags = "Cursos")
public class CursoControlador {

	@Autowired
	private CursoServicio cursoServicio;

	@PostMapping()
	@ApiOperation(value = "Registra un nuevo Curso")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Curso registrado"),
			@ApiResponse(code = 400, message = "El Curso ya existe"),
			@ApiResponse(code = 405, message = "Excepción al validar campos obligatorios") })
	public ResponseEntity<String> registrarCurso(@RequestBody CursoDTO curso) {
		cursoServicio.registrar(curso);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/modalidad/{modalidad}")
	@ApiOperation(value = "Consulta Cursos por la Modalidad", notes = "Retorna todos los Cursos que tengan la Modalidad suministrada")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Consulta exitosa"),
			@ApiResponse(code = 204, message = "No existen Cursos con la Modalidad suministrada") })
	public ResponseEntity<List<CursoDTO>> consultarCursosPorModalidad(@PathVariable String modalidad) {
		List<CursoDTO> cursos = cursoServicio.consultarPorModalidad(modalidad);
		return new ResponseEntity<>(cursos, cursos.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

	@PutMapping("/{codigo}")
	@ApiOperation(value = "Actualiza la información de un Curso")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Curso actualizado"),
			@ApiResponse(code = 404, message = "Curso no encontrado"),
			@ApiResponse(code = 405, message = "Excepción al validar campos obligatorios") })
	public ResponseEntity<String> actualizarCurso(@PathVariable String codigo, @RequestBody CursoDTO curso) {
		cursoServicio.actualizar(codigo, curso);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
