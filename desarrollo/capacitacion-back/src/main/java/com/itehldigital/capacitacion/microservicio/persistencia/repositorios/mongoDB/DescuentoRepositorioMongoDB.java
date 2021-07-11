package com.itehldigital.capacitacion.microservicio.persistencia.repositorios.mongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.itehldigital.capacitacion.microservicio.persistencia.colecciones.DescuentoColeccion;

public interface DescuentoRepositorioMongoDB extends MongoRepository<DescuentoColeccion, String> {

}
