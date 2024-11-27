/**
 * 
 */
package ar.edu.unju.fi.tpfinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboral;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboralPK;
import ar.edu.unju.fi.tpfinal.entity.Trabajo;

/**
 * @author User
 *
 */
@Repository
public interface HistoriaLaboralRepository extends JpaRepository<HistoriaLaboral, HistoriaLaboralPK> {
	List<HistoriaLaboral> findByTrabajo(Trabajo idTrabajo);

	List<HistoriaLaboral> findByDepartamento(Departamento departamento);

	@Query("SELECT h FROM HistoriaLaboral h WHERE employee_id = ?1")
	List<HistoriaLaboral> findByEmpleado(Empleado id);

	@Query("SELECT e.nombre , e.apellido, count(e.trabajo) from Empleado e ,	HistoriaLaboral h "
			+ " where e.id	 = 	h.idCompuesta.empleadoID "
			+ " group by e.nombre,	 e.apellido HAVING count(e.trabajo) >= ?1 ")
	List<Object[]> listEmpleadosConRenovacionDeCargo(long N);

}
