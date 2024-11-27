package ar.edu.unju.fi.tpfinal;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.dto.HistoriaLaboralDTO;
import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboralPK;
import ar.edu.unju.fi.tpfinal.entity.Trabajo;
import ar.edu.unju.fi.tpfinal.exceptions.PersonalizedMessageException;
import ar.edu.unju.fi.tpfinal.service.DepartamentoService;
import ar.edu.unju.fi.tpfinal.service.EmpleadoService;
import ar.edu.unju.fi.tpfinal.service.HistoriaLaboralService;
import ar.edu.unju.fi.tpfinal.service.TrabajoService;

@SuppressWarnings("deprecation")
@SpringBootTest
@RunWith(JUnitPlatform.class)
class HistoriaLaboralTest {

	@Autowired
	private HistoriaLaboralService historiaLaboralService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private TrabajoService trabajoService;
	@Autowired
	private DepartamentoService departamentoService;

	private Logger log = Logger.getLogger(HistoriaLaboralTest.class);

	@BeforeEach
	void setUp() throws Exception {
		log.debug("Start setUp: OK ");

	}

	@AfterEach
	void tearDown() throws Exception {
		log.debug("Start tearDown: OK");

	}

//	@Test
	void testAgregarHistoriaLaboralDTO() {
		try {
			log.debug("Ejecutando testAgregarHistoriaLaboralDTO()");

			Empleado empleado = empleadoService.findById(198L).get();
			Trabajo trabajo = trabajoService.findById("AD_VP").get();
			Departamento departamento = departamentoService.findById(90L).get();

			HistoriaLaboralDTO historiaLaboralDTO = new HistoriaLaboralDTO(
					new HistoriaLaboralPK(empleado, new Date(114, 04, 04)), null, trabajo, departamento);
			HistoriaLaboralDTO newHistoriaDTO = historiaLaboralService.saveDTO(historiaLaboralDTO);
			assertNotNull(newHistoriaDTO);
			historiaLaboralService.deleteDTO(newHistoriaDTO);
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

//	@Test
	void testModificacionDeEmpleadoDTO() {
		try {
			log.debug("Ejecutando testModificacionDeEmpleado()");

			Empleado empleado = empleadoService.findById(198L).get();
			Trabajo trabajo = trabajoService.findById("AD_VP").get();
			Departamento departamento = departamentoService.findById(90L).get();
			HistoriaLaboralDTO historiaLaboralDTO = new HistoriaLaboralDTO(
					new HistoriaLaboralPK(empleado, new Date(114, 04, 04)), null, trabajo, departamento);
			HistoriaLaboralDTO newHistoriaDTO = historiaLaboralService.saveDTO(historiaLaboralDTO);
			assertNotNull(newHistoriaDTO);

			Trabajo nuevoTrabajo = new Trabajo("POO_GRP06", "Programador Orientado a Objetos", 12300, 17500);
			trabajoService.save(nuevoTrabajo);
			Empleado empleadoEncontrado = empleadoService.findById(198l).get();
			Date fechaInicio = new Date(114, 04, 04);
			HistoriaLaboralDTO actualizacionEmpleado = historiaLaboralService.modificarEmpleadoDTO(empleadoEncontrado,
					fechaInicio, nuevoTrabajo);
			assertNotNull(actualizacionEmpleado);

			historiaLaboralService.deleteDTO(newHistoriaDTO);
			historiaLaboralService.deleteDTO(actualizacionEmpleado);

			log.debug("Fin testModificacionDeEmpleado()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

//	@Test
	void testBuscarHistoriasLaboralesDTO() {
		try {
			Empleado empleado = empleadoService.findById(200l).get();
			List<HistoriaLaboralDTO> listaHistoriaLaboral = historiaLaboralService.findByEmpleadoDTO(empleado);
			int num = listaHistoriaLaboral.size();
			log.info("Historias laborales del empleado: " + empleado + " = " + num);
			assertTrue(listaHistoriaLaboral.size() == 2);
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();

		}
	}

	/**
	 * Lista de todos los empleados que cambiaron su cargo N veces o más (en el test
	 * el valor N que se le pasa es el 2 ya que hay 3(tres) empleados que cumplen la
	 * busqueda en la base de datos)
	 */
	@Test
	void testFindByChangeJob() {
		try {
			log.debug("Ejecutando testFindByChangeJob");

			Integer cambio = 2;
			List<Empleado> l = historiaLaboralService.findByChangeJob(cambio);
			log.debug("Lista de todos los empleados que cambiaron su cargo 2 veces o más --> " + l.size());
			assertTrue(l.size() == 3);

			for (Empleado empleado : l) {
				System.out.println(empleado);
			}

			log.debug("Fin testFindByChangeJob");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// @Test
	void test() {
		log.debug("lllllllllllllllllllllll INICIO llllllllllllllllllllllllllllllllllllllllllllllllllllll");
		List<Object[]> resultado = historiaLaboralService.listEmpleadosConRenovacionDeCargo(2);
	
		for (Object[] objects : resultado) {
			System.out.println(objects);
		}

		log.debug("lllllllllllllllllllllll FIN llllllllllllllllllllllllllllllllllllllllllllllllllllll");

	}

}