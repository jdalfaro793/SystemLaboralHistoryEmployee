package ar.edu.unju.fi.tpfinal.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.dao.RolRepository;
import ar.edu.unju.fi.tpfinal.entity.Rol;
import ar.edu.unju.fi.tpfinal.service.RolService;

@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolRepository rolDao;

	@Override
	public Optional<Rol> buscarRol(Long id) {
	
		return rolDao.findById(id);
	}

}
