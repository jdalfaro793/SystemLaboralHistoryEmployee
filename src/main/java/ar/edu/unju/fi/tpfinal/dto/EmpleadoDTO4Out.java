package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;

public class EmpleadoDTO4Out implements Serializable {

	private static final long serialVersionUID = 1L;

	String level;
	String id;
	String nombre;

	public EmpleadoDTO4Out() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpleadoDTO4Out(String level, String id, String nombre) {
		super();
		this.level = level;
		this.id = id;
		this.nombre = nombre;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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

	@Override
	public String toString() {
		return "EmpleadoOUT2 [level=" + level + ", id=" + id + ", nombre=" + nombre + "]";
	}

}