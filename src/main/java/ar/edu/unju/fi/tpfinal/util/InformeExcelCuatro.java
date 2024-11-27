package ar.edu.unju.fi.tpfinal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
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

public class InformeExcelCuatro extends DocumentoExcel{
	private static Logger log = Logger.getLogger(DocumentoExcel.class); 
	private static String FILE = PATH_DOCUMENTO_EXCEL + "ExcelPunto4.xls";
	
	
	@Override
	public Boolean generarDocumentoJerarquico(List<EmpleadoDTO4Out> lista) {
		log.debug("Generando Documento Excel");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Doc. Excel Punto4");
		addImagenLogo(workbook,sheet);

		addCabecera(workbook, sheet, "REGISTROS EN ORDEN JERARQUICO");
		addSubCabecera(workbook, sheet, "Lista jerárquica de todos los empleados que dependen de un empleado dado");
		addDatos(workbook, sheet, lista);
		try(FileOutputStream fos = new FileOutputStream(new File(FILE))){
			workbook.write(fos);
			log.debug("Generado Documento Excel Correctamente");
			return true;
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	
	private void addDatos(HSSFWorkbook w, HSSFSheet sheet, List<EmpleadoDTO4Out> lista) {
        HSSFRow row = createCellCabezeraTablaDatos(w, sheet, null, 5, 1, "N°");
        createCellCabezeraTablaDatos(w, sheet, row, 5, 3, "FULLNAME - CARGO");
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 1, 2));
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 3, 9));
        int rowNum = 6; 
        Integer posicion = 0;
        for (EmpleadoDTO4Out e : lista) {
        	row = createTextCellSubTitulo(w, sheet, null, rowNum, 1, String.valueOf(posicion += 1) ) ;
        	createTextCellDatos(w, sheet, row, rowNum, 3, e.getLevel()+e.getNombre());
        	sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 1, 2));
        	sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 3, 9));
        	rowNum++;
		}
	}
	
	private HSSFRow createTextCellDatos(HSSFWorkbook w ,HSSFSheet sheet, HSSFRow row, int rowNum, int cellNum, String text) {
		if(row==null)
			row = sheet.createRow(rowNum);
		HSSFFont font = createFont1(w, (short)11, false);
		HSSFCell cell = row.createCell(cellNum);
		HSSFCellStyle style = w.createCellStyle();
		style.setFont(font);
		cell.setCellValue(new HSSFRichTextString(text));
		cell.setCellStyle(style);
		return row;
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

	@Override
	public Boolean generarDocumento(List<EmpleadoDTO> lista) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean generarDocumentoRegiones(EmpleadoDTO3OUT empleadosRegiones) {
		// TODO Auto-generated method stub
		return null;
	}

}
