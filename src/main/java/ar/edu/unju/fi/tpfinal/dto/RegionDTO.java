/**
 * 
 */
package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;

public class RegionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;

	public RegionDTO() {

	}

	public RegionDTO(String nombre) {
		super();
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "RegionDTO [id=" + id + ", nombre=" + nombre + "]";
	}

}