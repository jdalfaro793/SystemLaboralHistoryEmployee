/**
 * 
 */
package ar.edu.unju.fi.tpfinal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "job_history")

public class HistoriaLaboral implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HistoriaLaboralPK idCompuesta;

	@Column(name = "end_date", nullable = true)
	private Date fechaFin;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_id")
	private Trabajo trabajo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Departamento departamento;

	public HistoriaLaboral() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoriaLaboral(Empleado empleado ,Date fechaInicio, Date fechaFin, Trabajo trabajo, Departamento departamento) {
	
		idCompuesta = new HistoriaLaboralPK(empleado, fechaInicio);
		this.fechaFin = fechaFin;
		this.trabajo = trabajo;
		this.departamento = departamento;
	}

	public HistoriaLaboralPK getIdCompuesta() {
		return idCompuesta;
	}

	public void setIdCompuesta(HistoriaLaboralPK idCompuesta) {
		this.idCompuesta = idCompuesta;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "HistoriaLaboral [idCompuesta=" + idCompuesta + ", fechaFin=" + fechaFin + ", trabajo=" + trabajo
				+ ", departamento=" + departamento + "]";
	}

	
	
	
	
}