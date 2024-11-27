/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service;

import java.util.Optional;

import ar.edu.unju.fi.tpfinal.entity.Pais;


public interface PaisService {
	void save(Pais pais);
	void delete(Pais pais);
	Optional<Pais> findByPais(Pais pais);
	Optional<Pais> findById(String id);
}
