package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;
import java.util.Date;

import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.Trabajo;

public class EmpleadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	private String apellido;

	private String eMail;

	private String telefono;

	private Date fechaContrato;

	private Trabajo trabajo;

	private Double salario;

	private Double comisionPct;

	private Empleado gerente;

	private Departamento departamento;

	// constructor por defecto
	public EmpleadoDTO() {
		// TODO Auto-generated constructor stub
	}

	// constructor parametrizado
	public EmpleadoDTO(String nombre, String apellido, String eMail, String telefono, Date fechaContrato,
			Trabajo trabajo, Double salario, Double comisionPct, Empleado gerente, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.eMail = eMail;
		this.telefono = telefono;
		this.fechaContrato = fechaContrato;
		this.trabajo = trabajo;
		this.salario = salario;
		this.comisionPct = comisionPct;
		this.gerente = gerente;
		this.departamento = departamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getComisionPct() {
		return comisionPct;
	}

	public void setComisionPct(Double comisionPct) {
		this.comisionPct = comisionPct;
	}

	public Empleado getGerente() {
		return gerente;
	}

	public void setGerente(Empleado gerente) {
		this.gerente = gerente;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + "]";
	}

}