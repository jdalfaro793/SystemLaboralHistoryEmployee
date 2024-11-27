/**
 * 
 */
package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;

import ar.edu.unju.fi.tpfinal.entity.Pais;

public class UbicacionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String direccion;

	private String codigoPostal;

	private String ciudad;

	private String provinciaEstado;

	private Pais pais;

	public UbicacionDTO() {
		// TODO Auto-generated constructor stub
	}

	public UbicacionDTO(String direccion, String codigoPostal, String ciudad, String provinciaEstado, Pais pais) {
		super();
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.provinciaEstado = provinciaEstado;
		this.pais = pais;
	}

	// getter y setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvinciaEstado() {
		return provinciaEstado;
	}

	public void setProvinciaEstado(String provinciaEstado) {
		this.provinciaEstado = provinciaEstado;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Ubicacion [id=" + id + ", pais=" + pais + "]";
	}

}