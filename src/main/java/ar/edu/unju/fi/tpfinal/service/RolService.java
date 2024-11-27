package ar.edu.unju.fi.tpfinal.service;

import java.util.Optional;

import ar.edu.unju.fi.tpfinal.entity.Rol;

public interface RolService {
	Optional<Rol> buscarRol(Long id);
}
