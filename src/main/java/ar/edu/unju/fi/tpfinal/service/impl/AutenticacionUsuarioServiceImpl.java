package ar.edu.unju.fi.tpfinal.service.impl;

//import java.awt.PageAttributes.MediaType;
import java.util.Optional;

//import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.dao.AutenticacionUsuarioRepository;
import ar.edu.unju.fi.tpfinal.dto.AutenticacionEmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.AutenticacionUsuarioDTO;
import ar.edu.unju.fi.tpfinal.entity.AutenticacionUsuario;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.service.AutenticacionUsuarioService;
import ar.edu.unju.fi.tpfinal.util.Utils;

@Service
public class AutenticacionUsuarioServiceImpl implements AutenticacionUsuarioService {

	@Autowired
	private AutenticacionUsuarioRepository autenticacionDao;

	@Autowired
	private AutenticacionUsuarioDTO usuarioDTO;

	@Autowired
	private AutenticacionEmpleadoDTO empleadoDTO;

	/**
	 * Proceso que recibe un objeto de tipo Empleado, y una clave de tipo String y
	 * hace una verificacion de que el empleado no se encuentre con una contraseña
	 * de lo contrario devolvera null.
	 */
	@Override
	public AutenticacionUsuarioDTO GenerarClave(Empleado empleado, String clave) {
		AutenticacionUsuario unUsuario = autenticacionDao.findByEmpleado(empleado);
		if (unUsuario == null) {
			return null;
		} else if (unUsuario.getPassword() == null) {
			unUsuario.setPassword(Utils.encriptarPassword(clave));
			usuarioDTO.setUsername(unUsuario.getUsername());
			usuarioDTO.setFullName(unUsuario.getEmpleado().getNombre() + " " + unUsuario.getEmpleado().getApellido());
			usuarioDTO.setrole_name(unUsuario.getRol().getNombre());
			autenticacionDao.save(unUsuario);
			return usuarioDTO;
		}
		return null;
	}

	@Override
	public void guardarUsuario(AutenticacionUsuario usuario) {
		autenticacionDao.save(usuario);
	}

	@Override
	public void borrarUsuario(AutenticacionUsuario usuario) {
		autenticacionDao.delete(usuario);

	}

	@Override
	public Optional<AutenticacionUsuario> buscarUsuario(AutenticacionUsuario usuario) {
		Optional<AutenticacionUsuario> au = autenticacionDao.findById(usuario.getId());
		return au;

	}

	@Override
	public AutenticacionEmpleadoDTO validarLogin(String usuario, String clave) {
		AutenticacionUsuario unUsuario = autenticacionDao.findByUsername(usuario);
		if (unUsuario == null) {
			return null;
		} else if (unUsuario.getPassword().equals(Utils.encriptarPassword(clave))) {

			empleadoDTO.setEmployeeId(unUsuario.getEmpleado().getId().toString());
			empleadoDTO.setName(unUsuario.getEmpleado().getNombre() + " " + unUsuario.getEmpleado().getApellido());
			empleadoDTO.seteMail(unUsuario.getEmpleado().geteMail());
			empleadoDTO.setJobName(unUsuario.getEmpleado().getTrabajo().getProfesion());
			empleadoDTO.setDepartmentName(unUsuario.getEmpleado().getDepartamento().getNombre());
			return empleadoDTO;
		}
		return null;
	}

}
