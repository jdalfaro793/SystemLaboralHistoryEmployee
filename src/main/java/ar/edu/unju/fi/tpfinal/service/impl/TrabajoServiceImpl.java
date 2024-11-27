/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.dao.TrabajoRepository;
import ar.edu.unju.fi.tpfinal.entity.Trabajo;
import ar.edu.unju.fi.tpfinal.service.TrabajoService;


@Service
public class TrabajoServiceImpl implements TrabajoService{

	@Autowired
	private TrabajoRepository trabajoRepository;
	
	@Override
	public void save(Trabajo trabajo) {
		trabajoRepository.save(trabajo);
		
	}

	@Override
	public void delete(Trabajo trabajo) {
		trabajoRepository.delete(trabajo);
		
	}

	@Override
	public Optional<Trabajo> findByTrabajo(Trabajo trabajo) {
		Optional<Trabajo> t = trabajoRepository.findById(trabajo.getId());
		return t;
	}

	@Override
	public Optional<Trabajo> findById(String id) {
		Optional<Trabajo> t = trabajoRepository.findById(id);
		return t;
	}

	

	

}
