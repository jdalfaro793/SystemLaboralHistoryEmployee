package ar.edu.unju.fi.tpfinal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "employees")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long id;

	@Column(name = "first_name")
	private String nombre;

	@Column(name = "last_name")
	private String apellido;

	@Column(name = "email")
	private String eMail;

	@Column(name = "phone_number")
	private String telefono;

	@Column(name = "hire_date")
	private Date fechaContrato;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_id")
	private Trabajo trabajo;

	@Column(name = "salary")
	private Double salario;

	@Column(name = "commission_pct")
	private Double comisionPct;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_id")
	private Empleado gerente;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Departamento departamento;

	// constructor por defecto
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	// constructor parametrizado
	public Empleado(String nombre, String apellido, String eMail, String telefono, Date fechaContrato, Trabajo trabajo,
			Double salario, Double comisionPct, Empleado gerente , Departamento departamento ) {
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
