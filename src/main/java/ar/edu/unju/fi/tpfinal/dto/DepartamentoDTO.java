package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;

import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.Ubicacion;

public class DepartamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	private Empleado manager;
	private Ubicacion location;

	public DepartamentoDTO() {

	}

	public DepartamentoDTO(String nombre, Empleado manager, Ubicacion location) {
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
		return "DepartamentoDTO [id=" + id + ", nombre=" + nombre + ", manager=" + manager + ", location=" + location
				+ "]";
	}

}