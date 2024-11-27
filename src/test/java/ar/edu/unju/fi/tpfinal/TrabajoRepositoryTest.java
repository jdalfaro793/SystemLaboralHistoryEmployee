/**
 * 
 */
package ar.edu.unju.fi.tpfinal;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.entity.Trabajo;
import ar.edu.unju.fi.tpfinal.exceptions.PersonalizedMessageException;
import ar.edu.unju.fi.tpfinal.service.TrabajoService;

@SpringBootTest
@RunWith(JUnitPlatform.class)
class TrabajoRepositoryTest {

	@Autowired
	private TrabajoService trabajoService;
	
	private Trabajo trabajo;

	private Logger log = Logger.getLogger(TrabajoRepositoryTest.class);

	@BeforeEach
	void setUp() throws Exception {
		log.debug("Start setUp: OK ");

		trabajo = new Trabajo("IT_WPROG", "Web Programmer", 9000, 17000);
	}

	@AfterEach
	void tearDown() throws Exception {
		log.debug("Start tearDown: OK");

		trabajo = null;
	}

	@Test
	void testAgregarTrabajo() {
		try {
			log.debug("Ejecutando testAgregarTrabajo()");
			log.info("Se guardara el trabajo: " + trabajo);
			
			trabajoService.save(trabajo);
			Trabajo trabajoEncontado = trabajoService.findByTrabajo(trabajo).get();
			
			// Verificamos que se guardo
			assertNotNull(trabajoEncontado);
			log.info("Se guardo exitosamente: " + trabajoEncontado);

			trabajoService.delete(trabajo);
			assertEquals(trabajoService.findByTrabajo(trabajo), Optional.empty());
			log.debug("Fin testAgregarTrabajo()");
			
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();

		}
	}

	@Test
	void testBuscarTrabajo() {
		try {
			log.debug("Ejecutando testBuscarTrabajo()");
			// Se buscara un trabajo por la siguiente id
			String id = "AD_VP";
			
			log.info("Se buscara el trabajo con id: " + id);
			Trabajo trabajoEncontado = trabajoService.findById(id).get();
			log.info("Se encontro el trabajo:" + trabajoEncontado);
			
			// verificamos que se encuentro
			assertNotNull(trabajoEncontado);
			log.debug("Fin testBuscarTrabajo()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();

		}
	}
}
