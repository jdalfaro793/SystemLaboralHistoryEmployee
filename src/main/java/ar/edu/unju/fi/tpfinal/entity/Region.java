package ar.edu.unju.fi.tpfinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {

	
	@SequenceGenerator(
		    name="RegionSeq", // Mismo rrrrrnombre que en la linea generator
		    sequenceName = "REGIONS_SEQ", // rrrrrnombre de la sequencia (Cualquier rrrrrnombre)
		    initialValue = 5, // Valor inicial de la secuencia para generar ID
		    allocationSize = 1 // Incremento de la secuencia
		)
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegionSeq")
	@Column(name = "region_id")
	private Long id;

	@Column(name = "region_name", length = 25)
	private String nombre;

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Region(String nombre) {
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
		return "Region [id=" + id + ", nombre=" +nombre + "]";
	}

	/*@Override
	public String toString() {
		return "Region [id=" + id +"]";
	}*/
	

}
