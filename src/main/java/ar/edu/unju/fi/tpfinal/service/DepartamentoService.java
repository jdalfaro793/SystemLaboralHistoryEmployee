package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.dto.DepartamentoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.UbicacionDTO;
import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.Ubicacion;

public interface DepartamentoService {
	void save(Departamento departamento);

	void delete(Departamento departamento);

	Departamento findByNombre(String nombre);

	Optional<Departamento> findById(Long id);

	List<Departamento> findByManager(Empleado idManager);

	List<Departamento> findByNombreAndUbicacion(String nombre, Ubicacion location);

	// ===========DTOS SERVICES

	DepartamentoDTO saveDTO(DepartamentoDTO departamento);

	void deleteDTO(DepartamentoDTO departamento);

	List<DepartamentoDTO> findByManagerDTO(EmpleadoDTO manager);

	DepartamentoDTO findByID(Long id);

	List<DepartamentoDTO> findByNombreAndUbicacionDTO(String nombre, UbicacionDTO location);

}
