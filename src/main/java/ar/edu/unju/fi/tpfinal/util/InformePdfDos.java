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

public class InformePdfDos extends DocumentoPdf{

	private static Logger log = Logger.getLogger(DocumentoPdf.class);

	private static String FILE = PATH_DOCUMENTO_PDF + "PdfPunto2.pdf";

	private static Font fechaYEmpresaAzul8 = new Font(Font.FontFamily.COURIER, 9, 0, BaseColor.BLUE);
	private static Font tituloAzul15 = new Font(Font.FontFamily.COURIER, 15, 0, BaseColor.BLUE);
	private static Font description10 = new Font(Font.FontFamily.HELVETICA, 10, 0, BaseColor.BLACK);
	private static Font confCell = new Font(Font.FontFamily.HELVETICA, 9, 0, BaseColor.BLUE);

	@Override
	public Boolean generarDocumento(List<EmpleadoDTO> lista) {
		try {
			log.debug("generando documento pdf");

			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();

			Image imagen = Image.getInstance("src/main/resources/img/logo.jpg");
			imagen.scaleAbsolute(70F, 70F);
			document.add(imagen);
			addCabecera(document);
			addRegistros(document, lista);
		//	addPieDePagina(document, lista);
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
		preface2.add(new Chunk("EMPLEADOS CON RENOVACION DE CARGO", tituloAzul15));
		preface2.add(new Paragraph("Description:", description10));
		preface2.add(new Paragraph(
				"Registros de todos los empleados que renovaron su cargo una determinada cantidad de veces. ",
				description10));

	document.add(preface2);
	document.add(Chunk.NEWLINE);

	}


	private static void addRegistros(Document document, List<EmpleadoDTO> lista) throws DocumentException {

		createTable(document, lista);

	}

	private static void createTable(Document document, List<EmpleadoDTO> lista) throws DocumentException {

		PdfPTable table = new PdfPTable(4);

		float[] columnWidths = new float[]{5f,30f, 40f, 30f};
		table.setWidths(columnWidths);
		
		
		PdfPCell cell = new PdfPCell(new Phrase("Nº",confCell));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("NOMBRE Y APELLIDO",confCell));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		
		cell = new PdfPCell(new Phrase("ULTIMO CARGO",confCell));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("DEPARTAMENTO",confCell));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		table.setHeaderRows(1);

		Integer posicion = 0;

		for (EmpleadoDTO empleado : lista) {
			table.addCell(String.valueOf(posicion+=1));
			
			table.addCell(empleado.getNombre() + ", " + empleado.getApellido());
			
			table.addCell(empleado.getTrabajo().getProfesion());

			table.addCell(empleado.getDepartamento().getNombre());

			
		}

		document.add(table);

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
