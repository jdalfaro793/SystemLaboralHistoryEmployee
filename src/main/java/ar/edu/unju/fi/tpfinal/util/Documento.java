package ar.edu.unju.fi.tpfinal.util;

import java.util.List;

import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO3OUT;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO4Out;

public abstract class Documento {
	public static final String PATH_DOCUMENTO = "C:\\tmp\\";
	public abstract Boolean generarDocumento(List<EmpleadoDTO> lista); 
	public abstract Boolean generarDocumentoJerarquico(List<EmpleadoDTO4Out> lista);
	public abstract Boolean generarDocumentoRegiones(EmpleadoDTO3OUT empleadosRegiones);
}
