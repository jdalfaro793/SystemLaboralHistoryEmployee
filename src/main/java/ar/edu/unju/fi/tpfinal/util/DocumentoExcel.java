package ar.edu.unju.fi.tpfinal.util;

import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;

public abstract class DocumentoExcel extends Documento {

	public static final String PATH_DOCUMENTO_EXCEL = PATH_DOCUMENTO + "InformesExcel\\";

	public abstract Boolean generarDocumento(List<EmpleadoDTO> lista);

	protected void addCabecera(HSSFWorkbook w, HSSFSheet sheet, String titulo) {
		String fecha = Utils.formatearFecha(new Date());
		createTextCell(w, sheet, null, 0, 0, fecha);
		createTextCell(w, sheet, null, 1, 1, titulo);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 10));
	}



	private HSSFRow createTextCell(HSSFWorkbook w, HSSFSheet sheet, HSSFRow row, int rowNum, int cellNum, String text) {
		if (row == null)
			row = sheet.createRow(rowNum);
		HSSFFont font = createFont(w, IndexedColors.LIGHT_BLUE.getIndex(), (short) 13, true);
		HSSFCell cell = row.createCell(cellNum);
		HSSFCellStyle style = w.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		cell.setCellValue(new HSSFRichTextString(text));
		cell.setCellStyle(style);
		return row;
	}

	protected void addSubCabecera(HSSFWorkbook w, HSSFSheet sheet, String subTitulo) {

		createTextCellSubTitulo(w, sheet, null, 2, 0, "Descripcion:");

		createTextCellSubTitulo(w, sheet, null, 3, 0, subTitulo);
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 12));
	}

	protected HSSFRow createTextCellSubTitulo(HSSFWorkbook w, HSSFSheet sheet, HSSFRow row, int rowNum, int cellNum,
			String text) {
		if (row == null)
			row = sheet.createRow(rowNum);
		HSSFFont font = createFont1(w, (short) 11, true);
		HSSFCell cell = row.createCell(cellNum);
		HSSFCellStyle style = w.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		cell.setCellValue(new HSSFRichTextString(text));
		cell.setCellStyle(style);
		return row;
	}

	protected HSSFFont createFont1(HSSFWorkbook w, short fontHeight, boolean fontBold) {
		HSSFFont font = w.createFont();
		font.setBold(fontBold);
		font.setFontName("Arial");
		font.setFontHeightInPoints(fontHeight);
		return font;
	}

	protected HSSFFont createFont(HSSFWorkbook w, short fontColor, short fontHeight, boolean fontBold) {
		HSSFFont font = w.createFont();
		font.setBold(fontBold);
		font.setColor(fontColor);
		font.setFontName("Courier");
		font.setFontHeightInPoints(fontHeight);
		return font;
	}

	protected HSSFRow createCellCabezeraTablaDatos(HSSFWorkbook w, HSSFSheet sheet, HSSFRow row, int rowNum,
			int cellNum, String text) {
		if (row == null)
			row = sheet.createRow(rowNum);
		HSSFFont font = createFont(w, IndexedColors.ROYAL_BLUE.getIndex(), (short) 13, true);
		HSSFCell cell = row.createCell(cellNum);
		HSSFCellStyle style = w.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellValue(new HSSFRichTextString(text));
		cell.setCellStyle(style);
		return row;
	}
}
