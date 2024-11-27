/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service;

import java.util.Optional;

import ar.edu.unju.fi.tpfinal.entity.Region;

public interface RegionService {

	Region insertar(Region region);
	Optional<Region> findByRegion(Region region);
	void delete(Region region);
	Optional<Region> findById(Long id);
}
