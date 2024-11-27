package ar.edu.unju.fi.tpfinal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class HistoriaLaboralPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")
	private Empleado empleadoID;
	

	@Column(name = "start_date")
	private Date fechaInicio;

	public HistoriaLaboralPK(Empleado empleado, Date fechaInicio) {
		this.empleadoID=empleado;
		this.fechaInicio = fechaInicio;
	}
	
	public HistoriaLaboralPK(Empleado empleado) {
		this.empleadoID = empleado;
	}

	public HistoriaLaboralPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado getEmpleadoID() {
		return empleadoID;
	}

	public void setEmpleadoID(Empleado empleadoID) {
		this.empleadoID = empleadoID;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Override
	public String toString() {
		return "HistoriaLaboralPK [empleadoID=" + empleadoID + ", fechaInicio=" + fechaInicio + "]";
	}

	

}
