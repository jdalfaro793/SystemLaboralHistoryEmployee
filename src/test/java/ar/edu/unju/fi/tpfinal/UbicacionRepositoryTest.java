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

import ar.edu.unju.fi.tpfinal.entity.Pais;
import ar.edu.unju.fi.tpfinal.entity.Ubicacion;
import ar.edu.unju.fi.tpfinal.exceptions.PersonalizedMessageException;
import ar.edu.unju.fi.tpfinal.service.PaisService;
import ar.edu.unju.fi.tpfinal.service.UbicacionService;


@SpringBootTest
@RunWith(JUnitPlatform.class)
class UbicacionRepositoryTest {

	@Autowired
	private UbicacionService ubicacionService;
	@Autowired
	private PaisService paisService;
	
	private Ubicacion ubicacion;
	private Pais pais;
	
	private Logger log = Logger.getLogger(UbicacionRepositoryTest.class);

	@BeforeEach
	void setUp() throws Exception {
		log.debug("Start setUp: OK ");

		pais = paisService.findById("AR").get();
		ubicacion = new Ubicacion("Gral. Guemes Nº 430", "Y4610", "San Salvador", "Jujuy", pais);
	}

	@AfterEach
	void tearDown() throws Exception {
		log.debug("Start tearDown: OK");

		pais = null;
		ubicacion = null;
	}

	@Test
	void testGuardarUbicacion() {
		try {
			log.debug("Ejecutando testGuardarUbicacion()");
			log.info("Se guardara la ubicacion: " + ubicacion);

			// Guardar ubicacion
			ubicacionService.save(ubicacion);
			Ubicacion encontrado = ubicacionService.findByUbicacion(ubicacion).get();
			log.info("Se guardo exitosamente: " + encontrado);

			// Verificamos que se guardo
			assertNotNull(encontrado);
			// Borramos lo guardado
			ubicacionService.delete(ubicacion);
			assertEquals(ubicacionService.findByUbicacion(ubicacion), Optional.empty());
			log.debug("Fin testGuardarUbicacion()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();

		}
	}

	@Test
	void testBuscarUbicacion() {
		try {
			log.debug("Ejecutando testBuscarUbicacion()");
			Long id = 2900L;
			log.info("Se buscara la ubicacion con id: " + id);
			// Buscamos una ubicacion por id
			Ubicacion encontrado = ubicacionService.findById(id).get();
			log.info("Se encontro la ubicacion:  " + encontrado);

			// Verificamos que la encontro
			assertNotNull(encontrado);
			log.debug("Fin testBuscarUbicacion()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();

		}
	}
}
