package ar.edu.unju.fi.tpfinal.util;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO3OUT;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO4Out;

public class InformePdfTres extends DocumentoPdf {

	private static Logger log = Logger.getLogger(DocumentoPdf.class);

	private static String FILE = PATH_DOCUMENTO_PDF + "PdfPunto3.pdf";

	private static Font fechaYEmpresaAzul8 = new Font(Font.FontFamily.COURIER, 9, 0, BaseColor.BLUE);
	private static Font tituloAzul15 = new Font(Font.FontFamily.COURIER, 15, 0, BaseColor.BLUE);
	private static Font description10 = new Font(Font.FontFamily.HELVETICA, 10, 0, BaseColor.BLACK);
	private static Font confCell = new Font(Font.FontFamily.HELVETICA, 9, 0, BaseColor.BLUE);

	private static float[] anchos = new float[] {3, 20};
	
	

	@Override
	public Boolean generarDocumentoRegiones(EmpleadoDTO3OUT empleadosRegiones) {
		try {
			log.debug("generando documento pdf");

			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();

			Image imagen = Image.getInstance("src/main/resources/img/logo.jpg");
			imagen.scaleAbsolute(70F, 70F);
			document.add(imagen);
			addCabecera(document);

			addRegistros(document, empleadosRegiones);
			document.setMargins(75, 36, 75, 36);

			document.close();

			log.debug("Documento Generado Correctamente");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static void addCabecera(Document document) throws DocumentException {
		Paragraph preface2 = new Paragraph();

		preface2.add(new Paragraph(Utils.formatearFecha(new Date()), fechaYEmpresaAzul8));

		preface2.setTabSettings(new TabSettings(130f));
		preface2.add(Chunk.TABBING);
		preface2.add(new Chunk("EMPLEADOS SEGUN SU REGION", tituloAzul15));
		preface2.add(new Paragraph("Description:", description10));
		preface2.add(new Paragraph(
				"Registros de todos los empleados segun su region de procedencia. ",
				description10));

		document.add(preface2);
		document.add(Chunk.NEWLINE);

	}

	private static void addRegistros(Document document, EmpleadoDTO3OUT lista) throws DocumentException {

		createTableAmericas(document, lista);
		document.newPage();
		createTableEurope(document, lista);
		document.newPage();

		createTableAsia(document, lista);
		document.newPage();

		createTableMedioOrienteYAfrica(document, lista);

	}

	private static void createTableAmericas(Document document, EmpleadoDTO3OUT lista) throws DocumentException {

		PdfPTable table = new PdfPTable(anchos);


		PdfPCell cell = new PdfPCell(new Phrase("Nº", confCell));
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("AMERICAS", confCell));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		table.setHeaderRows(1);

		Integer posicion = 0;

		for (String empleado : lista.getEmpleadosAmericas()) {
			table.addCell(String.valueOf(posicion += 1));
			table.addCell(empleado);
		}

		document.add(table);

	}

	private static void createTableEurope(Document document, EmpleadoDTO3OUT lista) throws DocumentException {
		PdfPTable table2 = new PdfPTable(anchos);


		PdfPCell cell2 = new PdfPCell(new Phrase("Nº", confCell));
		cell2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table2.addCell(cell2);

		cell2 = new PdfPCell(new Phrase("EUROPE", confCell));
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		table2.setHeaderRows(1);
		Integer posicion2 = 0;

		for (String empleado : lista.getEmpleadosEurope()) {
			table2.addCell(String.valueOf(posicion2 += 1));
			table2.addCell(empleado);
		}
		document.add(table2);

	}

	private static void createTableAsia(Document document, EmpleadoDTO3OUT lista) throws DocumentException {
		PdfPTable table3 = new PdfPTable(anchos);

		PdfPCell cell3 = new PdfPCell(new Phrase("Nº", confCell));
		cell3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table3.addCell(cell3);

		cell3 = new PdfPCell(new Phrase("ASIA", confCell));
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		table3.setHeaderRows(1);
		Integer posicion2 = 0;

		for (String empleado : lista.getEmpleadosAsia()) {
			table3.addCell(String.valueOf(posicion2 += 1));
			table3.addCell(empleado);
		}
		document.add(table3);// TODO Auto-generated method stub

	}

	private static void createTableMedioOrienteYAfrica(Document document, EmpleadoDTO3OUT lista)
			throws DocumentException {
		PdfPTable table4 = new PdfPTable(anchos);

		PdfPCell cell4 = new PdfPCell(new Phrase("Nº", confCell));
		cell4.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table4.addCell(cell4);

		cell4 = new PdfPCell(new Phrase("MIDDLE EAST AND AFRICA", confCell));
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4.addCell(cell4);

		table4.setHeaderRows(1);
		Integer posicion2 = 0;

		for (String empleado : lista.getEmpleadosMiddleEastAndAfrica()) {
			table4.addCell(String.valueOf(posicion2 += 1));
			table4.addCell(empleado);
		}
		document.add(table4);

	}

	@Override
	public Boolean generarDocumento(List<EmpleadoDTO> lista) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean generarDocumentoJerarquico(List<EmpleadoDTO4Out> lista) {
		// TODO Auto-generated method stub
		return null;
	}

}
