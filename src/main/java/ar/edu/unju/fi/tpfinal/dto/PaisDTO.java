/**
 * 
 */
package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;

import ar.edu.unju.fi.tpfinal.entity.Region;

public class PaisDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nombre;
	private Region regionID;

	public PaisDTO() {

	}

	public PaisDTO(String id, String nombre, Region regionID) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.regionID = regionID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Region getRegionID() {
		return regionID;
	}

	public void setRegionID(Region regionID) {
		this.regionID = regionID;
	}

	@Override
	public String toString() {
		return "PaisDTO [id=" + id + ", nombre=" + nombre + ", regionID=" + regionID + "]";
	}

}