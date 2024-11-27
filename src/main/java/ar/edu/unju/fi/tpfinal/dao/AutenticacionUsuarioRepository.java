package ar.edu.unju.fi.tpfinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.entity.AutenticacionUsuario;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
@Repository
public interface AutenticacionUsuarioRepository extends JpaRepository<AutenticacionUsuario, Long>{
	
	
	AutenticacionUsuario findByUsername(String username);
	
	AutenticacionUsuario findByEmpleado(Empleado empleado);
	
}
