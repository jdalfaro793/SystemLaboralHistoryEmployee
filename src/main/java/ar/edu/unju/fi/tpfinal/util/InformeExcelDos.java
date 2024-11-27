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

public class InformeExcelDos extends DocumentoExcel{
	private static Logger log = Logger.getLogger(DocumentoExcel.class); 
	private static String FILE = PATH_DOCUMENTO_EXCEL + "ExcelPunto2.xls";
	
	@SuppressWarnings("resource")
	@Override
	public Boolean generarDocumento(List<EmpleadoDTO> lista) {
		log.debug("Generando Documento Excel");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Doc. Excel Punto2");
		addImagenLogo(workbook,sheet);

		addCabecera(workbook, sheet, "EMPLEADOS CON RENOVACION DE CARGOS");
		addSubCabecera(workbook, sheet, "Lista de todos los empleados que cambiaron su cargo 2 veces o más en la Empresa");
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
	
	private void addDatos(HSSFWorkbook w, HSSFSheet sheet, List<EmpleadoDTO> lista) {
        HSSFRow row = createCellCabezeraTablaDatos(w, sheet, null, 5, 1, "N°");
        createCellCabezeraTablaDatos(w, sheet, row, 5, 3, "APELLIDO Y NOMBRE");
        createCellCabezeraTablaDatos(w, sheet, row, 5, 7, "CARGO(actual)");
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 1, 2));
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 3, 6));
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 7, 11));
        int rowNum = 6; 
       
        Integer posicion = 0;
        for (EmpleadoDTO e : lista) {
        	
        	row = createTextCellSubTitulo(w, sheet, null, rowNum, 1, String.valueOf(posicion += 1) ) ;
        	createTextCellSubTitulo(w, sheet, row, rowNum, 3, e.getApellido()+ ", " +e.getNombre());
        	createTextCellSubTitulo(w, sheet, row, rowNum, 7, e.getTrabajo().getProfesion());
        	sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 1, 2));
            sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 3, 6));
            sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum, 7, 11));
        	rowNum++;
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

		anchor.setCol1(12);
		anchor.setRow1(0); // same row is okay
		anchor.setRow2(1);
		anchor.setCol2(12);
		final Picture pict = drawing.createPicture(anchor, pictureIndex);
		pict.resize();
	}
	
	
	@Override
	public Boolean generarDocumentoJerarquico(List<EmpleadoDTO4Out> lista) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean generarDocumentoRegiones(EmpleadoDTO3OUT empleadosRegiones) {
		// TODO Auto-generated method stub
		return null;
	}

}
