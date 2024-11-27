/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.dao.PaisRepository;
import ar.edu.unju.fi.tpfinal.entity.Pais;
import ar.edu.unju.fi.tpfinal.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public void save(Pais pais) {
		paisRepository.save(pais);
		
	}

	@Override
	public void delete(Pais pais) {
		paisRepository.delete(pais);
		
	}

	@Override
	public Optional<Pais> findByPais(Pais pais) {
		Optional<Pais> p =paisRepository.findById(pais.getId());
		return p;
	
	}

	@Override
	public Optional<Pais> findById(String id) {
		Optional<Pais> p = paisRepository.findById(id);
		return p;
	}

}
