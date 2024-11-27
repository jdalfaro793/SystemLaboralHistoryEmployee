package ar.edu.unju.fi.tpfinal.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.dao.DepartamentoRepository;
import ar.edu.unju.fi.tpfinal.dto.DepartamentoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.UbicacionDTO;
import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.Ubicacion;
import ar.edu.unju.fi.tpfinal.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoDao;



	private ModelMapper mapper = new ModelMapper();

	@Override
	public void save(Departamento departamento) {
		departamentoDao.save(departamento);

	}

	@Override
	public void delete(Departamento departamento) {
		departamentoDao.delete(departamento);

	}

	@Override
	public Departamento findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return departamentoDao.findByNombre(nombre);
	}

	@Override
	public List<Departamento> findByManager(Empleado idManager) {
		// TODO Auto-generated method stub
		return departamentoDao.findByManager(idManager);
	}

	@Override
	public Optional<Departamento> findById(Long id) {
		// TODO Auto-generated method stub
		return departamentoDao.findById(id);
	}

	@Override
	public List<Departamento> findByNombreAndUbicacion(String nombre, Ubicacion location) {
		List<Departamento> lista = departamentoDao.findByNombreAndUbicacion(nombre, location);
		return lista;
	}

	@Override
	public DepartamentoDTO saveDTO(DepartamentoDTO departamentoDTO) {
		Departamento departamento = new Departamento();
		mapper.map(departamentoDTO, departamento);
		return mapper.map(departamentoDao.save(departamento), DepartamentoDTO.class);
	}

	@Override
	public DepartamentoDTO findByID(Long id) {
		return mapper.map(departamentoDao.findById(id).get(), DepartamentoDTO.class);
	}

	@Override
	public List<DepartamentoDTO> findByManagerDTO(EmpleadoDTO empleadoDTO) {
		Empleado empleado = new Empleado();
		mapper.map(empleadoDTO, empleado);
		List<Departamento> departamentoList = departamentoDao.findByManager(empleado);
		Type listType = new TypeToken<List<DepartamentoDTO>>() {}.getType();
		List<DepartamentoDTO> departamentoDTOList = mapper.map(departamentoList, listType);
		return departamentoDTOList;
	}

	@Override
	public List<DepartamentoDTO> findByNombreAndUbicacionDTO(String nombre, UbicacionDTO location) {
		Ubicacion ubicacion = new Ubicacion();
		mapper.map(location, ubicacion);
		List<Departamento> departamentoList = departamentoDao.findByNombreAndUbicacion(nombre, ubicacion);
		Type listType = new TypeToken<List<DepartamentoDTO>>() {}.getType();
		List<DepartamentoDTO> departamentoDTOList = mapper.map(departamentoList, listType);
		return departamentoDTOList;
	}

	@Override
	public void deleteDTO(DepartamentoDTO departamentoDTO) {
		Departamento departamento = new Departamento();

		departamento.setId(departamentoDTO.getId());
		departamento.setNombre(departamentoDTO.getNombre());
		departamento.setManager(departamentoDTO.getManager());
		departamento.setLocation(departamentoDTO.getLocation());
		departamentoDao.delete(departamento);
	}

}
