package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
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
import ar.edu.unju.fi.tpfinal.service.DocumentoService;
import ar.edu.unju.fi.tpfinal.service.EmpleadoService;
import ar.edu.unju.fi.tpfinal.util.InformeExcelCuatro;
import ar.edu.unju.fi.tpfinal.util.InformeExcelDos;
import ar.edu.unju.fi.tpfinal.util.InformeExcelTres;
import ar.edu.unju.fi.tpfinal.util.InformeExcelUno;
import ar.edu.unju.fi.tpfinal.util.InformePdfCuatro;
import ar.edu.unju.fi.tpfinal.util.InformePdfDos;
import ar.edu.unju.fi.tpfinal.util.InformePdfTres;
import ar.edu.unju.fi.tpfinal.util.InformePdfUno;

@SpringBootTest
@RunWith(JUnitPlatform.class)
class DocumentoTest {
	
	private Logger log = Logger.getLogger(DocumentoTest.class);
	
	@Autowired
	private DocumentoService documentoService;
	
	
	@Autowired
	private EmpleadoService empleadoService;
	private List<EmpleadoDTO> lista = new ArrayList<EmpleadoDTO>();
	
	
	@BeforeEach
	void setUp() throws Exception {
		log.debug("Start setUp: OK ");
		lista = new ArrayList<EmpleadoDTO>();
	}

	@AfterEach
	void tearDown() throws Exception {
		log.debug("Start tearDown: OK");
		lista=null;
	}
	
	@Test
	void testGenerarInformeExcelUno() {
		log.info("Iniciando Generacion Informe Punto 1 en Excel");
		lista = empleadoService.findBySalarioMayorAlPromedio(100l);
		documentoService.setDocumento(new InformeExcelUno());
		Boolean prueba= documentoService.generarDocumento(lista);
		assertTrue(prueba);
		log.info("Se genero un Documento Excel de Empleado");
		
	}
	
	@Test
	void testGenerarInformeExcelDos() {
		log.info("Iniciando Generacion Informe Punto 2 en Excel");
		lista = empleadoService.listEmpleadosConRenovacionDeCargo(2L);
		documentoService.setDocumento(new InformeExcelDos());
		Boolean prueba= documentoService.generarDocumento(lista);
		assertTrue(prueba);
		log.info("Se genero un Documento Excel de Empleado");
		
	}

	
	@Test
	void testGenerarInformeExcelTres() {
		log.info("Iniciando Generacion Informe Punto 3 en Excel");
		EmpleadoDTO3OUT listasEmpleadosRegionesDTO = empleadoService.findByRegions();
		documentoService.setDocumento(new InformeExcelTres());
		Boolean prueba= documentoService.generarDocumento(listasEmpleadosRegionesDTO);
		assertTrue(prueba);
		log.info("Se genero un Documento Excel de Empleado");
		
	}
	
	@Test
	void testGenerarInformeExcelCuatro() {
		log.info("Iniciando Generacion Informe Punto 4 en Excel");
		List<EmpleadoDTO4Out> listaEncontrados = empleadoService.listEmpleadoJerarquica(101l);
		documentoService.setDocumento(new InformeExcelCuatro());
		Boolean prueba= documentoService.generarDocumentoJerarquico(listaEncontrados);
		assertTrue(prueba);
		log.info("Se genero un Documento Excel de Empleado");
		
	}
	
	
	
	
	@Test
	void testGenerarInformePDFUno() {
		List<EmpleadoDTO> listaEncontrados = empleadoService.findBySalarioMayorAlPromedio(100l);
		log.info("Iniciando Generacion Informe PDF Punto 1");
		documentoService.setDocumento(new InformePdfUno());
		Boolean prueba=documentoService.generarDocumento(listaEncontrados);
		assertTrue(prueba);
		log.info("Se genero un Documento PDF de Empleado");
	}
	
	
	@Test
	void testGenerarInformePDFDos() {
		log.info("Iniciando Generacion Informe PDF Punto 2");
		List<EmpleadoDTO> lista = empleadoService.listEmpleadosConRenovacionDeCargo(2l);
		documentoService.setDocumento(new InformePdfDos());
		Boolean prueba=documentoService.generarDocumento(lista);
		assertTrue(prueba);
		log.info("Se genero un Documento PDF de Empleado");
	}
	
	@Test
	void testGenerarInformePDFTres() {

		EmpleadoDTO3OUT listasEmpleadosRegionesDTO = empleadoService.findByRegions();
		log.info("Iniciando Generacion Informe PDF Punto 1");
		
		documentoService.setDocumento(new InformePdfTres() );
		
		
		Boolean prueba = documentoService.generarDocumento(listasEmpleadosRegionesDTO);
		
		assertTrue(prueba);
		log.info("Se genero un Documento PDF de Empleado");
	}


	@Test
	void testGenerarInformePDFCuatro() {

		List<EmpleadoDTO4Out> listaEncontrados = empleadoService.listEmpleadoJerarquica(101l);

		log.info("Iniciando Generacion Informe PDF Punto 1");
		documentoService.setDocumento(new InformePdfCuatro());
		Boolean prueba = documentoService.generarDocumentoJerarquico(listaEncontrados);
		assertTrue(prueba);
		log.info("Se genero un Documento PDF de Empleado");
	}
	
	
}
