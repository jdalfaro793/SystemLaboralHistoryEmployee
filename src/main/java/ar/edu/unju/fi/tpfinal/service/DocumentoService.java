package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO3OUT;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO4Out;
import ar.edu.unju.fi.tpfinal.util.Documento;

public interface DocumentoService {
	Boolean generarDocumento(List<EmpleadoDTO> lista);
	void setDocumento(Documento documento);
	
	Boolean generarDocumentoJerarquico(List<EmpleadoDTO4Out> lista);
	Boolean generarDocumento(EmpleadoDTO3OUT listasEmpleadosRegionesDTO);

	
	
	//Boolean generarDocumentoL(List<EmpleadoDTO> lista);
	
	
}
