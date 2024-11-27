package ar.edu.unju.fi.tpfinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	Empleado findByNombre(String nombre);

	Empleado findByApellido(String apellido);

	List<Empleado> findByGerente(Empleado empleado);

	List<Empleado> findByDepartamento(Departamento departamento);

	@Query("SELECT e FROM Empleado e WHERE CONCAT (e.nombre,' ',e.apellido) like  %?1% or e.departamento in (?2) or e.gerente=?3")
	List<Empleado> findByParameters(String nombre, List<Departamento> departamento, Empleado gerente);

	// PUNTO 2 SPRINT 4
	@Query("SELECT e.id , e.nombre , e.apellido, count(e.trabajo) from Empleado e ,	HistoriaLaboral h "
			+ " where e.id	 = 	h.idCompuesta.empleadoID "
			+ " group by e.id, e.nombre,	 e.apellido HAVING count(e.trabajo) >= ?1 ")
	List<String> listEmpleadosConRenovacionDeCargo(long N);

	// PUNTO 3 SPRINT 4

	@Query("SELECT e.nombre , e.apellido , r.id " + " FROM Empleado e " + " JOIN e.departamento d "
			+ " JOIN d.location l " + " JOIN l.pais p " + " JOIN p.regionID r "
			+ " WHERE p.regionID = r.id   ORDER BY r.id")
	List<String> findByRegions();

	// PUNTO 4 SPRINT 4

	@Query(value = " "
			+ " WITH RECURSIVE empleadoCTE AS ( SELECT   0 AS level , employee_id, concat(last_name, ', ', first_name, ' - ' ,job_id ) as nombre  "
			+ " FROM employees  WHERE employee_id = ?1 " + " UNION ALL "
			+ " SELECT employees2.level + 1, employees.employee_id , concat(last_name, ', ' ,first_name, ' - ' ,employees.job_id ) "
			+ " FROM employees " + " JOIN empleadoCTE employees2 ON employees.manager_id = employees2.employee_id ) "
			+ " SELECT * FROM empleadoCTE ", nativeQuery = true)
	List<String> listEmpleadoJerarquica(Long id);

}
