/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service;

import java.util.Optional;

import ar.edu.unju.fi.tpfinal.dto.UbicacionDTO;
import ar.edu.unju.fi.tpfinal.entity.Ubicacion;

public interface UbicacionService {
	void save(Ubicacion ubicacion);
	void delete(Ubicacion ubicacion);
	Optional<Ubicacion> findByUbicacion(Ubicacion ubicacion);
	Optional<Ubicacion> findById(Long id);
	
	
	//DTOS
	
	UbicacionDTO findByID (Long id);
}
