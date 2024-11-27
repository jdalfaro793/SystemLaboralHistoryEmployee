/**
 * 
 */
package ar.edu.unju.fi.tpfinal.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Trabajo {
	@Id
	@Column(name = "job_id", nullable = false, length = 10)
	private String id;
	
	@Column(name = "job_title")
	private String profesion;
	
	@Column(name = "min_salary")
	private Integer salarioMinimo;
	
	@Column(name = "max_salary")
	private Integer salarioMaximo;

	//Constructor por defecto
	public Trabajo() {
		// TODO Auto-generated constructor stub
	}
	
	//Constructor Parametrizado
	public Trabajo(String id, String profesion, Integer salarioMinimo, Integer salarioMaximo) {
		super();
		this.id = id;
		this.profesion = profesion;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
	}

	//getter y setters
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getProfesion() {
		return profesion;
	}


	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}


	public Integer getSalarioMinimo() {
		return salarioMinimo;
	}


	public void setSalarioMinimo(Integer salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}


	public Integer getSalarioMaximo() {
		return salarioMaximo;
	}


	public void setSalarioMaximo(Integer salarioMaximo) {
		this.salarioMaximo = salarioMaximo;
	}

	@Override
	public String toString() {
		return "Trabajo [id=" + id + ", profesion=" + profesion  + "]";
	}
	
}
