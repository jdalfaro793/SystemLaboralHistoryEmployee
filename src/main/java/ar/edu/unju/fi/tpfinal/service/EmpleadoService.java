package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO3OUT;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO4Out;
import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboral;

public interface EmpleadoService {

	void save(Empleado empleado, HistoriaLaboral historiaLaboral);

	void delete(Empleado empleado);

	Optional<Empleado> buscarEmpleado(Long id);

	Optional<Empleado> findById(Long id);

	List<Empleado> findByGerente(Empleado empleado);

	List<Empleado> findByParameters(String nombre, List<Departamento> departamento, Empleado gerente);

	// ===========DTOS SERVICES

	EmpleadoDTO saveDTO(EmpleadoDTO empleadoDTO, HistoriaLaboral historiaLaboral);

	void deleteDTO(EmpleadoDTO empleadoDTO);

	EmpleadoDTO findByID(Long id);

	List<EmpleadoDTO> findByGerenteDTO(EmpleadoDTO empleadoDTO);

	List<EmpleadoDTO> findByParametersDTO(String nombre, List<Departamento> departamento, Empleado gerente);

	// ========TEST

	List<EmpleadoDTO> findBySalarioMayorAlPromedio(Long id);

	EmpleadoDTO3OUT findByRegions();

	void mostrarEmpleadosConRegion(EmpleadoDTO3OUT DTO);

	List<EmpleadoDTO> listEmpleadosConRenovacionDeCargo(long N);

	void mostrarEmpleadosConRenovacionCargo(List<EmpleadoDTO> list);

	List<EmpleadoDTO4Out> listEmpleadoJerarquica(Long id);

//	List<EmpleadoConRegion> findByRegions();
}
