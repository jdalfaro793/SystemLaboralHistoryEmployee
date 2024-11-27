package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.dto.AutenticacionEmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.AutenticacionUsuarioDTO;
import ar.edu.unju.fi.tpfinal.entity.AutenticacionUsuario;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.Rol;
import ar.edu.unju.fi.tpfinal.exceptions.PersonalizedMessageException;
import ar.edu.unju.fi.tpfinal.service.AutenticacionUsuarioService;
import ar.edu.unju.fi.tpfinal.service.EmpleadoService;
import ar.edu.unju.fi.tpfinal.service.RolService;
import ar.edu.unju.fi.tpfinal.util.Utils;

@SpringBootTest
@RunWith(JUnitPlatform.class)
class AutenticacionUsuarioTest {
	@Autowired
	private AutenticacionUsuarioService autService;

	private AutenticacionUsuario autUsuario;
	private AutenticacionUsuario autUsuarioClave;

	@Autowired
	private EmpleadoService empleadoService;
	private Empleado empleado;

	private AutenticacionUsuarioDTO autDTO;
	private AutenticacionEmpleadoDTO empleadoDTO;

	@Autowired
	private RolService rolService;
	private Rol rol;

	private Logger log = Logger.getLogger(EmpleadoRepositoryTest.class);

	@BeforeEach
	void setUp() throws Exception {

		empleado = empleadoService.buscarEmpleado(185L).get();

		rol = rolService.buscarRol(1L).get();

		autUsuario = new AutenticacionUsuario("LOPEZ98", null, true, rol, empleado);
		autUsuarioClave = new AutenticacionUsuario("TITO2", Utils.encriptarPassword("tito0301"), true, rol, empleado);

	}

	@AfterEach
	void tearDown() throws Exception {

		empleado = null;
		rol = null;
		autUsuario = null;

	}

	/**
	 * El siguiente test verifica si el empleado tiene una clave asignada de lo
	 * contrario le asigna una clave pasada por parametro y devuelve un
	 * usuarioAutenticacionDTO si el usuario tiene clave, devuelve un log de info
	 * con un mensaje de clave ya asignada
	 */
	@Test
	void testGenerarClave() {
		try {
			autService.guardarUsuario(autUsuario);
			autDTO = autService.GenerarClave(empleado, "unaClaveCualquiera");
			if (autDTO == null) {
				log.info("EL USUARIO YA TIENE CLAVE ASIGNADA");
			} else {
				log.info("json de DTO: \n" + Utils.mostrarJsonAutenticacionUsuario(autDTO));
			}
			autService.borrarUsuario(autUsuario);
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();

		}
	}

	/**
	 * El siguiente test verifica valida si el usuario y la clave coinciden con
	 * algun tipo de empleado de la tabla user, de ser correcta el usuario y la
	 * contraseña devuelve su empleadoDTO sino un log de error
	 */
	@Test
	void testAutenticacionLogin() {
		try {
			autService.guardarUsuario(autUsuarioClave);
			assertNotNull(autService.buscarUsuario(autUsuarioClave));
			empleadoDTO = autService.validarLogin("TITO2", "tito0301");
			if (empleadoDTO == null) {
				log.error("LOGIN INVALIDO");
			} else {
				log.info("json de DTO: \n" + Utils.mostrarJsonEmpleadoDTO(empleadoDTO));
			}
			autService.borrarUsuario(autUsuarioClave);
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();

		}
	}
}
