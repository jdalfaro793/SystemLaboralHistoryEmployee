/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.dao.RegionRepository;
import ar.edu.unju.fi.tpfinal.entity.Region;
import ar.edu.unju.fi.tpfinal.service.RegionService;



@Service
public class RegionServiceImpl implements RegionService {
	
	@Autowired 
	private RegionRepository regionRepository;
	
	@Override
	public Region insertar(Region region) {
		regionRepository.save(region);
		return region;
	}

	@Override
	public Optional<Region> findByRegion(Region region) {
		Optional<Region> r = regionRepository.findById(region.getId());	
		return r;
	}

	@Override
	public void delete(Region region) {
		regionRepository.delete(region);
	}

	@Override
	public Optional<Region> findById(Long id) {
		Optional<Region> r = regionRepository.findById(id);
		return r;
	}
}
