package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;
import java.util.List;

public class EmpleadoDTO3OUT implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<String> empleadosAmericas;
	private List<String> empleadosEurope;
	private List<String> empleadosAsia;
	private List<String> empleadosMiddleEastAndAfrica;

	public List<String> getEmpleadosAmericas() {
		return empleadosAmericas;
	}

	public void setEmpleadosAmericas(List<String> empleadosAmericas) {
		this.empleadosAmericas = empleadosAmericas;
	}

	public List<String> getEmpleadosEurope() {
		return empleadosEurope;
	}

	public void setEmpleadosEurope(List<String> empleadosEurope) {
		this.empleadosEurope = empleadosEurope;
	}

	public List<String> getEmpleadosAsia() {
		return empleadosAsia;
	}

	public void setEmpleadosAsia(List<String> empleadosAsia) {
		this.empleadosAsia = empleadosAsia;
	}

	public List<String> getEmpleadosMiddleEastAndAfrica() {
		return empleadosMiddleEastAndAfrica;
	}

	public void setEmpleadosMiddleEastAndAfrica(List<String> empleadosMiddleEastAndAfrica) {
		this.empleadosMiddleEastAndAfrica = empleadosMiddleEastAndAfrica;
	}

	public EmpleadoDTO3OUT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpleadoDTO3OUT(List<String> empleadosAmericas, List<String> empleadosEurope, List<String> empleadosAsia,
			List<String> empleadosMiddleEastAndAfrica) {
		super();
		this.empleadosAmericas = empleadosAmericas;
		this.empleadosEurope = empleadosEurope;
		this.empleadosAsia = empleadosAsia;
		this.empleadosMiddleEastAndAfrica = empleadosMiddleEastAndAfrica;
	}

	@Override
	public String toString() {
		return "EmpleadoDTO3OUT [empleadosAmericas=" + empleadosAmericas + ", empleadosEurope=" + empleadosEurope
				+ ", empleadosAsia=" + empleadosAsia + ", empleadosMiddleEastAndAfrica=" + empleadosMiddleEastAndAfrica
				+ "]";
	}

}