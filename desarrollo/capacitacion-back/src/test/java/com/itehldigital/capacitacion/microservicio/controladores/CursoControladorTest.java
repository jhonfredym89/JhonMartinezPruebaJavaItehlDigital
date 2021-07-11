package com.itehldigital.capacitacion.microservicio.controladores;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itehldigital.capacitacion.comun.excepciones.ExcepcionManejador;
import com.itehldigital.capacitacion.microservicio.negocio.dtos.CursoDTO;
import com.itehldigital.capacitacion.microservicio.testdatabuilder.CursoDTOTestDataBuilder;

@SpringBootTest
public class CursoControladorTest {

	@Autowired
	private CursoControlador cursoControlador;

	@Autowired
	private ExcepcionManejador excepcionManejador;

	@Test
	public void registrarCurso() throws JsonProcessingException, Exception {
		CursoDTO curso = new CursoDTOTestDataBuilder().construir();

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(cursoControlador).build();

		mockMvc.perform(post("/capacitacion/v1/cursos").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(curso))).andExpect(status().isCreated());
	}

	@Test
	public void actualizarCursoNoExistente() throws JsonProcessingException, Exception {
		CursoDTO curso = new CursoDTOTestDataBuilder().construir();

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(cursoControlador, excepcionManejador).build();

		mockMvc.perform(put("/capacitacion/v1/cursos/codigoNoExistente").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(curso))).andExpect(status().isNotFound());
	}
}
