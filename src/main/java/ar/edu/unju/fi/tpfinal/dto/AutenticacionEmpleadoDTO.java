package ar.edu.unju.fi.tpfinal.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component

public class AutenticacionEmpleadoDTO  implements Serializable{


	private static final long serialVersionUID = 1L;
	

	private String EmployeeId;
	private String name;
	private String eMail;
	private String jobName;
	private String departmentName;
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	
}
