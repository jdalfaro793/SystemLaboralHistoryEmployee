package ar.edu.unju.fi.tpfinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.entity.Rol;
@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
	Rol findByNombre(String nombre);
}
