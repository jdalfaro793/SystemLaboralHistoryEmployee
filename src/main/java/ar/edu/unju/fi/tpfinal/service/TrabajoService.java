/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service;

import java.util.Optional;

import ar.edu.unju.fi.tpfinal.entity.Trabajo;


public interface TrabajoService {
	
	void save(Trabajo trabajo);
	Optional<Trabajo> findByTrabajo(Trabajo trabajo);
	Optional<Trabajo> findById(String id);
	void delete(Trabajo nuevoTrabajo);
}
