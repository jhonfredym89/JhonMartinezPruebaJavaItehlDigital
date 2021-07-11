package com.itehldigital.capacitacion.microservicio.persistencia.repositorios.mongoDB;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.itehldigital.capacitacion.microservicio.persistencia.colecciones.CursoColeccion;

public interface CursoRepositorioMongoDB extends MongoRepository<CursoColeccion, String> {

	List<CursoColeccion> findByModalidad(String modalidad);

	boolean existsByCodigo(String codigo);

	CursoColeccion findByCodigo(String codigo);
}
