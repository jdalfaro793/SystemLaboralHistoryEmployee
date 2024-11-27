
package ar.edu.unju.fi.tpfinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.Ubicacion;
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	Departamento findByNombre(String nombre);
	List<Departamento> findByManager(Empleado idManager);
	
	/**
	 * Busca departamentos por un nombre y una Localidad determinada
	 * @param nombre
	 * @param localidad
	 * @return lista de parametros
	 */
	@Query ("SELECT d FROM Departamento d WHERE d.nombre like ?1% and d.location = ?2")
	List<Departamento> findByNombreAndUbicacion(String nombre, Ubicacion location);
}
