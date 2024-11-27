package ar.edu.unju.fi.tpfinal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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

import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO3OUT;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO4Out;
import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboral;
import ar.edu.unju.fi.tpfinal.entity.Trabajo;
import ar.edu.unju.fi.tpfinal.exceptions.PersonalizedMessageException;
import ar.edu.unju.fi.tpfinal.service.DepartamentoService;
import ar.edu.unju.fi.tpfinal.service.EmpleadoService;
import ar.edu.unju.fi.tpfinal.service.HistoriaLaboralService;
import ar.edu.unju.fi.tpfinal.service.TrabajoService;

@SpringBootTest
@RunWith(JUnitPlatform.class)
class EmpleadoRepositoryTest {

	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private TrabajoService trabajoService;
	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private HistoriaLaboralService historiaLaboralService;

	private Logger log = Logger.getLogger(EmpleadoRepositoryTest.class);

	@BeforeEach
	void setUp() throws Exception {
		log.debug("Start setUp: OK ");

	}

	@AfterEach
	void tearDown() throws Exception {
		log.debug("Start tearDown: OK");

	}

	@Test
	void testGuardarEmpleadoDTO() {
		try {
			Trabajo cargoTrabajo = trabajoService.findById("AC_MGR").get();
			Empleado empleadoManager = empleadoService.findById(101L).get();
			Departamento departamento = departamentoService.findById(120L).get();
			EmpleadoDTO empleadoDTO = new EmpleadoDTO("Jorge", "Alfaro", "jalfaro@gmail.com", "123456789", new Date(), cargoTrabajo, 1000.00, 0.1, empleadoManager, departamento);
			HistoriaLaboral historia = new HistoriaLaboral();

			EmpleadoDTO newEmpleadoDTO = empleadoService.saveDTO(empleadoDTO, historia);
			log.debug(newEmpleadoDTO);
			assertNotNull(newEmpleadoDTO);
			historiaLaboralService.delete(historia);
			empleadoService.deleteDTO(newEmpleadoDTO);
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testBuscarEmpleadoDTO() {
		try {
			log.debug("Ejecutando testBuscarEmpleadoPorID()");
			EmpleadoDTO empleadoDTO = empleadoService.findByID(100L);
			assertNotNull(empleadoDTO);
			log.debug("Fin testBuscarEmpleadoPorID()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testFindByGerente() {

		try {
			log.debug("Ejecutando testFindByGerente()");
			EmpleadoDTO empleadoDTO = empleadoService.findByID(100L);

			List<EmpleadoDTO> encontrados = empleadoService.findByGerenteDTO(empleadoDTO);
			log.info("Los empleados encontrados: " + encontrados);
			assertEquals(encontrados.size(), 14);

			log.debug("Fin testFindByGerente()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testBusquedaPorParametrosOpcionales() {
		try {
			log.debug("Ejecutando testBusquedaPorParametrosOpcionales()");
			
			String nombreOApellido = "King";
			Departamento departamento1 = departamentoService.findById(100L).get();
			Departamento departamento2 = departamentoService.findById(120l).get();
			List<Departamento> listaIDDepartamento = new ArrayList<Departamento>();
			listaIDDepartamento.add(departamento1);
			listaIDDepartamento.add(departamento2);
			Empleado idManager = empleadoService.findById(100L).get();
			log.info("Se realizara la busqueda por parametros: " + nombreOApellido + ", " + listaIDDepartamento + ", " + idManager);
			List<EmpleadoDTO> listaEncontrados = empleadoService.findByParametersDTO(nombreOApellido, listaIDDepartamento, idManager);
			int total = listaEncontrados.size();
			log.info("Total encontrados: " + total);
			log.info("Los Empleados encontrados son: " + listaEncontrados);
			assertNotNull(listaEncontrados);
			log.debug("Fin testBusquedaPorParametrosOpcionales()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testEmpleadosConSalarioMayorAlPromedioDTO() {
		try {
			log.debug("Ejecutando testEmpleadosConSalarioMayorAlPromedioDTO()");
			List<EmpleadoDTO> listaEncontrados = empleadoService.findBySalarioMayorAlPromedio(50l);
			assertTrue(listaEncontrados.size() == 13);
			int total = listaEncontrados.size();
			log.info("Encontrados con salario mayor al promedio: " + total);
			log.debug("Fin testEmpleadosConSalarioMayorAlPromedioDTO()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testEmpleadoConSuRegion() {
		try {
			log.debug("Ejecutando testEmpleadoConSuRegion()");
			EmpleadoDTO3OUT list = empleadoService.findByRegions();
			assertNotNull(list);
			//empleadoService.mostrarEmpleadosConRegion(list);
			log.debug("Fin testEmpleadoConSuRegion()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void ListaEmpleadoConNCargos() {

		try {
			log.debug("Ejecutando ListaEmpleadoConNCargos()");
			List<EmpleadoDTO> lista = empleadoService.listEmpleadosConRenovacionDeCargo(2l);
			assertTrue(lista.size()==3);
			log.debug("Fin ListaEmpleadoConNCargos()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	@Test
	void ListaEmpleadosJerarquica() {
		try {
			log.debug("Inicio ListaEmpleadosJerarquica");
			List<EmpleadoDTO4Out>lista=empleadoService.listEmpleadoJerarquica(101l);
			assertNotNull(lista);
			log.debug("Fin ListaEmpleadosJerarquica");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
