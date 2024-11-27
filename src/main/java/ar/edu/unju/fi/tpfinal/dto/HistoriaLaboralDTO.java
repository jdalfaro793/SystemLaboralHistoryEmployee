package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;
import java.util.Date;

import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboralPK;
import ar.edu.unju.fi.tpfinal.entity.Trabajo;

public class HistoriaLaboralDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private HistoriaLaboralPK idCompuesta;
	private Date fechaFin;
	private Trabajo trabajo;
	private Departamento departamento;

	public HistoriaLaboralDTO() {

	}

	public HistoriaLaboralDTO(HistoriaLaboralPK idCompuesta, Date fechaFin, Trabajo trabajo,
			Departamento departamento) {
		super();
		this.idCompuesta = idCompuesta;
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
		return "HistoriaLaboralDTO [idCompuesta=" + idCompuesta + ", fechaFin=" + fechaFin + ", trabajo=" + trabajo
				+ ", departamento=" + departamento + "]";
	}

}
