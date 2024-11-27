package ar.edu.unju.fi.tpfinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Rol {
	
	@SequenceGenerator(
		    name="RolSeq", // Mismo nombre que en la linea generator
		    sequenceName = "ROL_SEQ", // nombre de la sequencia (Cualquier nombre)
		    initialValue = 30, // Valor inicial de la secuencia para generar ID
		    allocationSize = 1 // Incremento de la secuencia
		)
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RolSeq")
	@Column(name = "role_id")
	private Long id;

	@Column(name = "name")
	private String nombre;

	public Rol() {
		super();
	}

	public Rol(String nombre) {
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
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
