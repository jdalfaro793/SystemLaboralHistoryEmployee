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

import ar.edu.unju.fi.tpfinal.entity.Region;
import ar.edu.unju.fi.tpfinal.exceptions.PersonalizedMessageException;
import ar.edu.unju.fi.tpfinal.service.RegionService;


@SpringBootTest
@RunWith(JUnitPlatform.class)
class RegionRepositoryTest {

	private Region region;

	private Logger log = Logger.getLogger(RegionRepositoryTest.class);

	@Autowired
	private RegionService regionService;
	
	@BeforeEach
	void setUp() throws Exception {
		log.debug("Start setUp: OK ");
		region = new Region("regionNombre");
	}

	@AfterEach
	void tearDown() throws Exception {
		log.debug("Start tearDown: OK");
		region = null;

	}

	@Test
	void testInsertar() {
		try {
			
			log.debug("Ejecutando testAgregarRegion()");
			log.info("Se guardara la region: " + region);
			// Guardamos una region
			regionService.insertar(region);
			Region encontrada = regionService.findByRegion(region).get();
			assertNotNull(encontrada);
			
			log.info("Se guardo exitosamente: " + encontrada);
			
			// Borramos lo guardado para no alterar la BD
			regionService.delete(encontrada);
			// Corroboramos
			assertEquals(regionService.findByRegion(region), Optional.empty());
			log.debug("Fin testAgregarRegion()");
		
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();

		}
	}

}
