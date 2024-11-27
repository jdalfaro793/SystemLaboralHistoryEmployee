package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.dto.DepartamentoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.UbicacionDTO;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.Ubicacion;
import ar.edu.unju.fi.tpfinal.exceptions.PersonalizedMessageException;
import ar.edu.unju.fi.tpfinal.service.DepartamentoService;
import ar.edu.unju.fi.tpfinal.service.EmpleadoService;
import ar.edu.unju.fi.tpfinal.service.UbicacionService;

@SpringBootTest
@RunWith(JUnitPlatform.class)
class DepartamentoRepositoryTest {

	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private UbicacionService ubicacionService;

	private Logger log = Logger.getLogger(DepartamentoRepositoryTest.class);

	@BeforeEach
	void setUp() throws Exception {
		log.debug("Start setUp: OK ");

	}

	@AfterEach
	void tearDown() throws Exception {
		log.debug("Start tearDown: OK");

	}
	
	@Test
	void tesGuardarDepartamentoDTO() {
		try {
			log.debug("Ejecutando tesGuardarDepartamentotDTO()");
			Empleado manager = empleadoService.findById(100L).get();
			Ubicacion ubicacion = ubicacionService.findById(1000L).get();
			DepartamentoDTO departamentoDTO = new DepartamentoDTO("POO2020G6", manager, ubicacion);

			DepartamentoDTO newDepartamentoDTO = departamentoService.saveDTO(departamentoDTO);
			assertNotNull(newDepartamentoDTO);
			
			departamentoService.deleteDTO(newDepartamentoDTO);
			log.debug("Fin tesGuardarDepartamentotDTO()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	
	@Test
	void testModificarDepartamentoDTO() {
		try {

			log.debug("Ejecutando testModificarDepartamento()");

			DepartamentoDTO departamento = departamentoService.findByID(200L);
			departamento.setNombre("TEST MODIFICACION");
			DepartamentoDTO newModificacion = departamentoService.saveDTO(departamento);
			assertNotNull(newModificacion);

			log.debug("Fin testModificarDepartamento()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testBuscarDepartamentoPorManagerDTO() {
		try {

			log.debug("Ejecutando testBuscarDepartamentoPorManager()");
			EmpleadoDTO managerBuscado = empleadoService.findByID(200L);
			List<DepartamentoDTO> listaDepartamento = departamentoService.findByManagerDTO(managerBuscado);
			log.info("Departamentos encontrados: " + listaDepartamento);
			int cantidadDepartamento = listaDepartamento.size();
			assertTrue(cantidadDepartamento == 1);
			log.debug("Fin testBuscarDepartamentoPorManager()");

		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}

	
	@Test
	void testBuscarPorNombreYUbicacionDTO() {

		try {
			log.debug("Ejecutando testFindByNombreAndUbicacion");
			UbicacionDTO ubicacion = ubicacionService.findByID(1700l);

			log.info(ubicacion);
			String nombre = "IT";
			List<DepartamentoDTO> lista = departamentoService.findByNombreAndUbicacionDTO(nombre, ubicacion);
			log.info("La cantidad de Departamentos encontrados en la busqueda es: " + lista.size());
			assertEquals(lista.size(), 2);
			log.debug("Fin testFindByNombreAndUbicacion");

		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
