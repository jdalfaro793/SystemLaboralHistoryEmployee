package ar.edu.unju.fi.tpfinal.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.dao.DepartamentoRepository;
import ar.edu.unju.fi.tpfinal.dao.EmpleadoRepository;
import ar.edu.unju.fi.tpfinal.dao.HistoriaLaboralRepository;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO3OUT;
import ar.edu.unju.fi.tpfinal.dto.EmpleadoDTO4Out;
import ar.edu.unju.fi.tpfinal.entity.Departamento;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboral;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboralPK;
import ar.edu.unju.fi.tpfinal.exceptions.PersonalizedMessageException;
import ar.edu.unju.fi.tpfinal.service.EmpleadoService;
import ar.edu.unju.fi.tpfinal.util.Utils;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {


	private ModelMapper mapper = new ModelMapper();

	@Autowired
	private EmpleadoRepository empleadoDao;

	@Autowired
	private HistoriaLaboralRepository historiaLaboralRepository;

	@Autowired
	private DepartamentoRepository departamentoDao;

	@Override
	public Optional<Empleado> buscarEmpleado(Long id) {
		// TODO Auto-generated method stub
		return empleadoDao.findById(id);
	}

	@Override
	public void save(Empleado empleado, HistoriaLaboral historiaLaboral) {
		empleadoDao.save(empleado);

		historiaLaboral.setIdCompuesta(new HistoriaLaboralPK(empleado, new Date()));
		historiaLaboral.setFechaFin(null);
		historiaLaboral.setTrabajo(empleado.getTrabajo());
		historiaLaboral.setDepartamento(empleado.getDepartamento());

		historiaLaboralRepository.save(historiaLaboral);
	}

	@Override
	public void delete(Empleado empleado) {
		empleadoDao.delete(empleado);

	}

	@Override
	public Optional<Empleado> findById(Long id) {
		// TODO Auto-generated method stub
		return empleadoDao.findById(id);
	}

	@Override
	public List<Empleado> findByGerente(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoDao.findByGerente(empleado);
	}

	@Override
	public List<Empleado> findByParameters(String nombre, List<Departamento> departamento, Empleado gerente) {
		List<Empleado> empleadosEncontrados = empleadoDao.findByParameters(nombre, departamento, gerente);

		return empleadosEncontrados;
	}

	// ---====== DTO'S IMPLEMENTS======---

	@Override
	public EmpleadoDTO findByID(Long id) {
		Empleado empleadoEncontrado = empleadoDao.findById(id).get();

		if (empleadoEncontrado.getId() == null)
			throw new PersonalizedMessageException("No se encontro el empleado");
		else {
			EmpleadoDTO dto = mapper.map(empleadoEncontrado, EmpleadoDTO.class);
			return dto;
		}
	}

	@Override
	public EmpleadoDTO saveDTO(EmpleadoDTO empleadoDTO, HistoriaLaboral historiaLaboral) {
		Empleado empleado = new Empleado();
		mapper.map(empleadoDTO, empleado);
		empleadoDao.save(empleado);

		historiaLaboral.setIdCompuesta(new HistoriaLaboralPK(empleado, new Date()));
		historiaLaboral.setFechaFin(null);
		historiaLaboral.setTrabajo(empleado.getTrabajo());
		historiaLaboral.setDepartamento(empleado.getDepartamento());

		historiaLaboralRepository.save(historiaLaboral);

		Empleado empleadoEncontrado = empleadoDao.findById(empleado.getId()).get();
		return mapper.map(empleadoEncontrado, EmpleadoDTO.class);
	}

	@Override
	public List<EmpleadoDTO> findByGerenteDTO(EmpleadoDTO empleadoDTO) {
		Empleado empleado = new Empleado();
		mapper.map(empleadoDTO, empleado);
		List<Empleado> empleadoList = empleadoDao.findByGerente(empleado);
		Type listType = new TypeToken<List<EmpleadoDTO>>() {
		}.getType();
		List<EmpleadoDTO> empleadoDTOList = mapper.map(empleadoList, listType);

		return empleadoDTOList;
	}

	@Override
	public List<EmpleadoDTO> findByParametersDTO(String nombre, List<Departamento> departamento, Empleado gerente) {
		List<Empleado> empleadosEncontrados = empleadoDao.findByParameters(nombre, departamento, gerente);

		Type listType = new TypeToken<List<EmpleadoDTO>>() {
		}.getType();
		List<EmpleadoDTO> empleadoDTOList = mapper.map(empleadosEncontrados, listType);

		return empleadoDTOList;
	}

	@Override
	public void deleteDTO(EmpleadoDTO empleadoDTO) {

		Empleado empleado = new Empleado();

		empleado.setId(empleadoDTO.getId());
		empleado.setApellido(empleadoDTO.getApellido());
		empleado.seteMail(empleadoDTO.geteMail());
		empleado.setTrabajo(empleadoDTO.getTrabajo());

		empleadoDao.delete(empleado);

	}

	// PUNTO 1 SPRINT 4

	@Override
	public List<EmpleadoDTO> findBySalarioMayorAlPromedio(Long id) {
		Departamento departamentoEncontrado = departamentoDao.findById(id).get();
		List<Empleado> empleadosFiltrados = new ArrayList<Empleado>();
		if (departamentoEncontrado == null) {
			return null;
		}
		List<Empleado> listaEmpleadosTotal = empleadoDao.findByDepartamento(departamentoEncontrado);
		Double totalSalario = 0.0;
		Integer contador = 1;
		for (Empleado empleado : listaEmpleadosTotal) {
			totalSalario = empleado.getSalario() + totalSalario;
			contador++;
		}
		for (Empleado empleado : listaEmpleadosTotal) {
			if (empleado.getSalario() > (totalSalario / contador)) {
				empleadosFiltrados.add(empleado);
			}
		}
		Type listType = new TypeToken<List<EmpleadoDTO>>() {
		}.getType();
		List<EmpleadoDTO> empleadoDTOList = mapper.map(empleadosFiltrados, listType);
		return empleadoDTOList;
	}

	@Override
	public EmpleadoDTO3OUT findByRegions() {
		EmpleadoDTO3OUT empleadoDTO3 = new EmpleadoDTO3OUT();
		List<String> listaEmpleadosTotal = empleadoDao.findByRegions();
		List<String> resultadoAmericas = new ArrayList<>();
		List<String> resultadoEurope = new ArrayList<>();
		List<String> resultadoAsia = new ArrayList<>();
		List<String> resultadoMiddleEastAndAfrica = new ArrayList<>();

		for (String string : listaEmpleadosTotal) {
			String[] listaPartes = string.split(",");
			String nombreEmpleado = listaPartes[0] + ", " + listaPartes[1];

			if (string.contains("1")) resultadoEurope.add(nombreEmpleado);
				if (string.contains("2")) resultadoAmericas.add(nombreEmpleado);
					if (string.contains("3")) resultadoAsia.add(nombreEmpleado);
						if (string.contains("4")) resultadoMiddleEastAndAfrica.add(nombreEmpleado);
				
			empleadoDTO3.setEmpleadosAmericas(resultadoAmericas);
			empleadoDTO3.setEmpleadosEurope(resultadoEurope);
			empleadoDTO3.setEmpleadosAsia(resultadoAsia);
			empleadoDTO3.setEmpleadosMiddleEastAndAfrica(resultadoMiddleEastAndAfrica);
		}
		return empleadoDTO3;
	}

	@Override
	public void mostrarEmpleadosConRegion(EmpleadoDTO3OUT ResultadoDTO) {
		System.out.println("\n-== AMERICA ==-");
		for (String empleado : ResultadoDTO.getEmpleadosAmericas()) {
			System.out.println(empleado);
		}

		System.out.println("\n-== EUROPA ==-");

		for (String empleado : ResultadoDTO.getEmpleadosEurope()) {
			System.out.println(empleado);
		}

		System.out.println("\n-== ASIA ==-");
		for (String empleado : ResultadoDTO.getEmpleadosAsia()) {
			System.out.println(empleado);
		}

		System.out.println("\n-== MEDIO ORIENTE Y AFRICA ==-");
		for (String empleado : ResultadoDTO.getEmpleadosMiddleEastAndAfrica()) {
			System.out.println(empleado);
		}

	}

	@Override
	public List<EmpleadoDTO> listEmpleadosConRenovacionDeCargo(long N) {

		List<String> listaStringEmpleados = empleadoDao.listEmpleadosConRenovacionDeCargo(N); // viene de la BD

		List<Empleado> empleadoList = new ArrayList<Empleado>(); // Parseo en class

		for (String string : listaStringEmpleados) {

			String[] nombrePartes = string.split(",");
			String id = nombrePartes[0];

			empleadoList.add(empleadoDao.findById((Long.parseLong(id))).get());

		}

		Type listType = new TypeToken<List<EmpleadoDTO>>() {
		}.getType();
		List<EmpleadoDTO> empleadoDTOList = mapper.map(empleadoList, listType);
		return empleadoDTOList;
	}

	@Override
	public void mostrarEmpleadosConRenovacionCargo(List<EmpleadoDTO> list) {

		for (EmpleadoDTO empleado : list) {
			System.out.println(empleado);
		}
	}

	@Override
	public List<EmpleadoDTO4Out> listEmpleadoJerarquica(Long idmanager) {

		List<String> listaTotal = empleadoDao.listEmpleadoJerarquica(idmanager);

		List<EmpleadoDTO4Out> empleadoList = new ArrayList<EmpleadoDTO4Out>();

		for (String string : listaTotal) {
			String[] nombrePartes = string.split(",");

			String lv = nombrePartes[0];

			String id = nombrePartes[1];

			String apellido = nombrePartes[2];

			String nombreycargo = nombrePartes[3];

			EmpleadoDTO4Out emp = new EmpleadoDTO4Out(Utils.formatearLevel(lv), id, apellido + nombreycargo);

			empleadoList.add(emp);

		}

		return empleadoList;
	}


}
