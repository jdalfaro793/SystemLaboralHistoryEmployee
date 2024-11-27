/**
 * 
 */
package ar.edu.unju.fi.tpfinal.entity;

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
@Table(name = "locations")
public class Ubicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private Long id;
	
	@Column(name = "street_address")
	private String direccion;
	
	@Column(name = "postal_code")
	private String codigoPostal;
	
	@Column(name = "city")
	private String ciudad;
	
	@Column(name = "state_province")
	private String provinciaEstado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id")
	private Pais pais;
	
	//constructor por defecto
	public Ubicacion() {
		// TODO Auto-generated constructor stub
	}
	
	// constructor por defecto
	public Ubicacion(String direccion, String codigoPostal, String ciudad, String provinciaEstado, Pais pais) {
		super();
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.provinciaEstado = provinciaEstado;
		this.pais = pais;
	}
	
	
	//getter y setter
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
