package ar.edu.unju.fi.tpfinal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO3OUT;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO4Out;

public class InformeExcelTres extends DocumentoExcel {
	private static Logger log = Logger.getLogger(DocumentoExcel.class);
	private static String FILE = PATH_DOCUMENTO_EXCEL + "ExcelPunto3.xls";

	@Override
	public Boolean generarDocumentoRegiones(EmpleadoDTO3OUT listaRegiones) {
		log.debug("Generando Documento Excel");
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("Doc. Excel Punto3");
		Integer fila = 5;
		addImagenLogo(workbook, sheet);

		addCabecera(workbook, sheet, "REGISTRO POR REGIONES");
		addSubCabecera(workbook, sheet, "Lista de todos los empleados de la Empresa por regiones (corte de control).");
		fila = addDatos(workbook, sheet, listaRegiones.getEmpleadosAmericas(), fila, "AMERICA");
		fila = addDatos(workbook, sheet, listaRegiones.getEmpleadosEurope(), fila, "EUROPA");
		fila = addDatos(workbook, sheet, listaRegiones.getEmpleadosAsia(), fila, "ASIA");
		fila = addDatos(workbook, sheet, listaRegiones.getEmpleadosMiddleEastAndAfrica(), fila,
				"MEDIO ORIENTE Y AFRICA");

		try (FileOutputStream fos = new FileOutputStream(new File(FILE))) {
			workbook.write(fos);
			log.debug("Generado Documento Excel Correctamente");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void addImagenLogo(HSSFWorkbook workbook, HSSFSheet sheet) {
		FileInputStream stream = null;
		try {
			stream = new FileInputStream("src/main/resources/img/logoExcel.jpg");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final CreationHelper helper = workbook.getCreationHelper();
		final Drawing<?> drawing = sheet.createDrawingPatriarch();

		final ClientAnchor anchor = helper.createClientAnchor();
		anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);

		int pictureIndex = 0;
		try {
			pictureIndex = workbook.addPicture(IOUtils.toByteArray(stream), Workbook.PICTURE_TYPE_PNG);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		anchor.setCol1(11);
		anchor.setRow1(0); // same row is okay
		anchor.setRow2(1);
		anchor.setCol2(14);
		final Picture pict = drawing.createPicture(anchor, pictureIndex);
		pict.resize();
	}

	private Integer addDatos(HSSFWorkbook w, HSSFSheet sheet, List<String> list, Integer fila, String region) {
		HSSFRow row = createCellCabezeraTablaDatos(w, sheet, null, fila, 1, "N°");
		createCellCabezeraTablaDatos(w, sheet, row, fila, 3, region);
		sheet.addMergedRegion(new CellRangeAddress(fila, fila, 1, 2));
		sheet.addMergedRegion(new CellRangeAddress(fila, fila, 3, 9));
		fila = fila + 1;
		Integer posicion = 0;
		for (String e : list) {
			row = createTextCellSubTitulo(w, sheet, null, fila, 1, String.valueOf(posicion += 1));
			createTextCellSubTitulo(w, sheet, row, fila, 3, e);
			sheet.addMergedRegion(new CellRangeAddress(fila, fila, 1, 2));
			sheet.addMergedRegion(new CellRangeAddress(fila, fila, 3, 9));
			fila = fila + 1;
		}
		fila = fila + 2;
		return fila;
	}

	@Override
	public Boolean generarDocumentoJerarquico(List<EmpleadoDTO4Out> lista) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean generarDocumento(List<EmpleadoDTO> empleadosRegiones) {
		// TODO Auto-generated method stub
		return null;
	}

}
