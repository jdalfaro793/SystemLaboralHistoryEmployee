/**
 * 
 */
package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.entity.Pais;
import ar.edu.unju.fi.tpfinal.entity.Region;
import ar.edu.unju.fi.tpfinal.exceptions.PersonalizedMessageException;
import ar.edu.unju.fi.tpfinal.service.PaisService;
import ar.edu.unju.fi.tpfinal.service.RegionService;


@SpringBootTest
@RunWith(JUnitPlatform.class)
class PaisRepositoryTest {

	@Autowired
	private PaisService paisService;

	@Autowired
	private RegionService regionService;

	private Region region;
	private Pais pais1;
	private Pais pais2;

	private Logger log = Logger.getLogger(PaisRepositoryTest.class);

	@BeforeEach
	void setUp() throws Exception {
		log.debug("Start setUp: OK ");

		region = regionService.findById(4L).get();
		pais1 = new Pais("P1", "Pais 1", region);
		pais2 = new Pais("P2", "Pais 2", region);

	}

	@AfterEach
	void tearDown() throws Exception {
		log.debug("Start tearDown: OK");

		region = null;
		pais1 = null;
		pais2 = null;

	}

	@Test
	void testAgregarPais() {
		try {
			log.debug("Ejecutando testAgregarPais()");

			log.info("Se guardaran los paises: " + pais1 + " , " + pais2);

			paisService.save(pais1);
			paisService.save(pais2);
			
			Pais pais1Encontrado = paisService.findByPais(pais1).get();
			Pais pais2Encontrado = paisService.findByPais(pais2).get();

			assertNotNull(pais1Encontrado);
			assertNotNull(pais2Encontrado);

			log.info("Se guardaron exitosamente: " + pais1Encontrado + " , " + pais2Encontrado);

			// Borramos lo guardado para no alterar la BD
			paisService.delete(pais1);
			paisService.delete(pais2);

			assertEquals(paisService.findByPais(pais1), Optional.empty());
			assertEquals(paisService.findByPais(pais2), Optional.empty());

			log.debug("Fin testAgregarPais()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();

		}
	}

}
