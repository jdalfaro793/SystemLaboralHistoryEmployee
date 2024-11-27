package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component
public class AutenticacionUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	private String username;

	private String role_name;

	private String fullName;

	
	
	
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getrole_name() {
		return role_name;
	}

	public void setrole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
