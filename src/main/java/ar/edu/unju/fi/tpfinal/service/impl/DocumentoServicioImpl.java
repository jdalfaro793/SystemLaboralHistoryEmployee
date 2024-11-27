package ar.edu.unju.fi.tpfinal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO3OUT;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO4Out;
import ar.edu.unju.fi.tpfinal.service.DocumentoService;
import ar.edu.unju.fi.tpfinal.util.Documento;

@Service
public class DocumentoServicioImpl implements DocumentoService {
	
	private Documento documento;
	
	@Override
	public Boolean generarDocumento(List<EmpleadoDTO> lista) {
		// TODO Auto-generated method stub
		return documento.generarDocumento(lista);
	}


	@Override
	public void setDocumento(Documento documento) {
		this.documento=documento;
		
	}
	@Override
	public Boolean generarDocumentoJerarquico(List<EmpleadoDTO4Out> lista) {
		// TODO Auto-generated method stub
		return documento.generarDocumentoJerarquico(lista);

	}


	@Override
	public Boolean generarDocumento(EmpleadoDTO3OUT EmpleadosRegionesDTO) {
		// TODO Auto-generated method stub
		return documento.generarDocumentoRegiones(EmpleadosRegionesDTO);
	}

}
