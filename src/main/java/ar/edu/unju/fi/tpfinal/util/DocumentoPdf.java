package ar.edu.unju.fi.tpfinal.util;

import java.util.List;

import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;

public abstract class DocumentoPdf extends Documento {
	
	public static final String PATH_DOCUMENTO_PDF = PATH_DOCUMENTO + "InformesPDF\\";
	
	public abstract Boolean generarDocumento(List<EmpleadoDTO> lista);
}
