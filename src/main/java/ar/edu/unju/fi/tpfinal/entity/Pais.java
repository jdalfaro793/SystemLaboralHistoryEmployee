package ar.edu.unju.fi.tpfinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Pais {

	@Id
	@Column(name = "country_id", nullable = false, length = 2)
	private String id;

	@Column(name = "country_name", length = 40)
	private String nombre;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "region_id")
	private Region regionID;

	public Pais() {
	}

	public Pais(String id, String nombre, Region regionID) {
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

	public Region getRegion_id() {
		return regionID;
	}

	public void setRegion_id(Region region_id) {
		this.regionID = region_id;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", regionID=" + regionID + "]";
	}

}
