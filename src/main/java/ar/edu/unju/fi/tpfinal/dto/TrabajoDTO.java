/**
 * 
 */
package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;

public class TrabajoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String profesion;
	private Integer salarioMinimo;
	private Integer salarioMaximo;

	public TrabajoDTO() {

	}

	public TrabajoDTO(String id, String profesion, Integer salarioMinimo, Integer salarioMaximo) {
		super();
		this.id = id;
		this.profesion = profesion;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
	}

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
		return "TrabajoDTO [id=" + id + ", profesion=" + profesion + ", salarioMinimo=" + salarioMinimo
				+ ", salarioMaximo=" + salarioMaximo + "]";
	}

}