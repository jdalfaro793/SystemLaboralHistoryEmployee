package ar.edu.unju.fi.tpfinal.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.edu.unju.fi.tpfinal.dto.AutenticacionEmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.AutenticacionUsuarioDTO;

public class Utils {

	public static String mostrarJsonAutenticacionUsuario(AutenticacionUsuarioDTO dto) {
		String json;
		try {

			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);

			return json;

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static String mostrarJsonEmpleadoDTO(AutenticacionEmpleadoDTO dto) {
		String json;
		try {

			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);

			return json;

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Metodo que formateara la fecha de tipo Date
	 * 
	 * @param fecha pasado por parametro para su formato requerido
	 * @return un String con la fecha formateada.
	 */
	public static String formatearFecha(Date fecha) {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(fecha);
		return date;
	}

	public static String formatearLevel(String lv) {
		if (Integer.parseInt(lv) == 0) {
			return "=>";
		}

		if (Integer.parseInt(lv) == 1) {
			return "===>";
		}

		if (Integer.parseInt(lv) == 2) {
			return "=====>";
		}
		if (Integer.parseInt(lv) == 3) {
			return "=======>";
		}
		if (Integer.parseInt(lv) == 4) {
			return "=========>";
		}
		if (Integer.parseInt(lv) == 5) {
			return "===========>";
		}
		return lv;
	}

	public static String formatearSalario(double sueldoNeto) {
		DecimalFormat decimalFormat = new DecimalFormat("###.00");// Aplica formato al mostrar la suma de los salarios.

		return "$ " + decimalFormat.format(sueldoNeto);
	}

	public static String encriptarPassword(String password) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5"); // Creamos instancia de tipo de encriptacion md5
			byte[] messageDigest = md5.digest(password.getBytes()); // transformamos en arreglo de bytes la password
			BigInteger number = new BigInteger(1, messageDigest);
			String encriptado = number.toString(16);

			while (encriptado.length() < 32) {
				encriptado = "" + encriptado;
			}
			return encriptado;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
