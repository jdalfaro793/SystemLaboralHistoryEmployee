package ar.edu.unju.fi.tpfinal.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.dto.HistoriaLaboralDTO;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboral;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboralPK;
import ar.edu.unju.fi.tpfinal.entity.Trabajo;

public interface HistoriaLaboralService {
	void save(HistoriaLaboral historia);

	void delete(HistoriaLaboral historia);

	List<HistoriaLaboral> findByTrabajo(HistoriaLaboral historia);

	List<HistoriaLaboral> findByDepartamento(HistoriaLaboral historia);

	Optional<HistoriaLaboral> findById(HistoriaLaboralPK historia);

	List<HistoriaLaboral> findByEmpleado(Empleado historia);

	HistoriaLaboral modificarEmpleado(Empleado empleado, Date fechaInicio, Trabajo nuevoTrabajo);

	// ===========DTOS SERVICES

	HistoriaLaboralDTO saveDTO(HistoriaLaboralDTO historiaLaboralDTO);

	void deleteDTO(HistoriaLaboralDTO historiaLaboralDTO);

	HistoriaLaboralDTO modificarEmpleadoDTO(Empleado empleado, Date fechaInicio, Trabajo nuevoTrabajo);

	List<HistoriaLaboralDTO> findByEmpleadoDTO(Empleado historia);
	
	/**
	 * Lista de todos los empleados que cambiaron su cargo N veces o más
	 * @param cambio
	 * @return
	 */
	List<Empleado> findByChangeJob(Integer cambio);
	
	//TEST
	List<Object[]> listEmpleadosConRenovacionDeCargo(long n);

}
