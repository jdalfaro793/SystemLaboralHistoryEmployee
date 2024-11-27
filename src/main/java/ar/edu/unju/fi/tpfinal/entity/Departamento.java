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

/**
 * 
 * @author Dario
 *
 */

// LEER: Falta crear atributo location_id al ultimo y mapear 
// falta crear el dao de esta entity y clase test

@Entity
@Table(name = "departments")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private Long id;

	@Column(name = "department_name")
	private String nombre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_id")
	private Empleado manager;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "location_id")
	private Ubicacion location;

	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departamento(String nombre, Empleado manager, Ubicacion location) {
		super();

		this.nombre = nombre;
		this.manager = manager;
		this.location = location;
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

	public Empleado getManager() {
		return manager;
	}

	public void setManager(Empleado manager) {
		this.manager = manager;
	}

	public Ubicacion getLocation() {
		return location;
	}

	public void setLocation(Ubicacion location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + "]";

	}
}
