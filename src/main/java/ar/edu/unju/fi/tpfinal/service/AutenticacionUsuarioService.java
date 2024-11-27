package ar.edu.unju.fi.tpfinal.service;

import java.util.Optional;

import ar.edu.unju.fi.tpfinal.dto.AutenticacionEmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.AutenticacionUsuarioDTO;
import ar.edu.unju.fi.tpfinal.entity.AutenticacionUsuario;
import ar.edu.unju.fi.tpfinal.entity.Empleado;

public interface AutenticacionUsuarioService {

	AutenticacionUsuarioDTO GenerarClave (Empleado empleado, String clave);
	
	void guardarUsuario(AutenticacionUsuario usuario);
	
	void borrarUsuario(AutenticacionUsuario usuario);
	
	Optional<AutenticacionUsuario> buscarUsuario(AutenticacionUsuario usuario);
	
	AutenticacionEmpleadoDTO validarLogin(String usuario, String clave);
	
}
