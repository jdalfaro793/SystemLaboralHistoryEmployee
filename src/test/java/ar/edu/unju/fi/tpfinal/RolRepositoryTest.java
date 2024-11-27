package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
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

import ar.edu.unju.fi.tpfinal.dao.RolRepository;
import ar.edu.unju.fi.tpfinal.entity.Rol;
import ar.edu.unju.fi.tpfinal.exceptions.PersonalizedMessageException;

@SpringBootTest
@RunWith(JUnitPlatform.class)
class RolRepositoryTest {
	@Autowired
	private RolRepository rolRepository;
	private Rol rol1;
	private Rol rol2;
	private Logger log = Logger.getLogger(RolRepositoryTest.class);
	
	@BeforeEach
	void setUp() throws Exception {
		log.debug("Start setUp: OK ");
		rol1 = new Rol("Admin");
		rol2 = new Rol("User");

	}
	
	@AfterEach
	void tearDown() throws Exception {
		log.debug("Start tearDown: OK");
		rol1 = null;
		rol2 = null;
	}
	
	@Test
	void testAgregarRol() {
		try {
			log.debug("Ejecutando testAgregarRol()");
			log.info("Se guardara el rol: " + rol1);
			log.info("Se guardara el rol: " + rol2);

			// Guardamos el primer rol
			rolRepository.save(rol1);
			Optional<Rol> encontrado1 = rolRepository.findById(rol1.getId());
			
			// Guardamos el segundo rol
			rolRepository.save(rol2);
			Optional<Rol> encontrado2 = rolRepository.findById(rol2.getId());

			assertNotNull(encontrado1);
			assertNotNull(encontrado2);
			log.info("Se guardo exitosamente: " + encontrado1);
			log.info("Se guardo exitosamente: " + encontrado2);

			// Borramos lo guardado para no alterar la BD
			rolRepository.delete(rol1);
			rolRepository.delete(rol2);

			// Corroboramos
			assertEquals(rolRepository.findById(rol1.getId()), Optional.empty());
			assertEquals(rolRepository.findById(rol2.getId()), Optional.empty());
			
			
			log.debug("Fin testAgregarRol()");
		} catch (PersonalizedMessageException e) {
			log.error("Error:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error inesperado: " + e.getMessage());
			e.printStackTrace();

		}
	}
}
