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

import ar.edu.unju.fi.tpfinal.dao.HistoriaLaboralRepository;
//import ar.edu.unju.fi.tpfinal.dto.DepartamentoDTO;
import ar.edu.unju.fi.tpfinal.dto.HistoriaLaboralDTO;
import ar.edu.unju.fi.tpfinal.entity.Empleado;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboral;
import ar.edu.unju.fi.tpfinal.entity.HistoriaLaboralPK;
import ar.edu.unju.fi.tpfinal.entity.Trabajo;
import ar.edu.unju.fi.tpfinal.service.HistoriaLaboralService;

@Service
public class HistoriaLaboralServiceImpl implements HistoriaLaboralService {
	@Autowired
	private HistoriaLaboralRepository historiaRepository;
	private ModelMapper mapper = new ModelMapper();

	@Override
	public void save(HistoriaLaboral historia) {
		historiaRepository.save(historia);

	}

	@Override
	public void delete(HistoriaLaboral historia) {
		historiaRepository.delete(historia);

	}

	@Override
	public List<HistoriaLaboral> findByTrabajo(HistoriaLaboral historia) {
		List<HistoriaLaboral> h = historiaRepository.findByTrabajo(historia.getTrabajo());
		return h;
	}

	@Override
	public List<HistoriaLaboral> findByDepartamento(HistoriaLaboral historia) {
		List<HistoriaLaboral> h = historiaRepository.findByDepartamento(historia.getDepartamento());
		return h;
	}

	@Override
	public Optional<HistoriaLaboral> findById(HistoriaLaboralPK historia) {
		// TODO Auto-generated method stub
		return historiaRepository.findById(historia);
	}

	@Override
	public HistoriaLaboral modificarEmpleado(Empleado empleado, Date fechaInicio, Trabajo nuevoTrabajo) {
		Optional<HistoriaLaboral> histo = historiaRepository.findById(new HistoriaLaboralPK(empleado, fechaInicio));

		if (histo.equals(Optional.empty())) {
			return null;
		} else if (histo.get().getFechaFin() == null) {

			histo.get().setFechaFin(new Date());

			historiaRepository.save(histo.get());

			HistoriaLaboral historiaNueva = new HistoriaLaboral(histo.get().getIdCompuesta().getEmpleadoID(),
					new Date(), null, nuevoTrabajo, histo.get().getDepartamento());

			historiaRepository.save(historiaNueva);
			return historiaNueva;
		}
		return null;

	}

	@Override
	public List<HistoriaLaboral> findByEmpleado(Empleado historia) {
		List<HistoriaLaboral> l = historiaRepository.findByEmpleado(historia);
		return l;
	}

	// ---====== DTO'S IMPLEMENTS======---

	@Override
	public HistoriaLaboralDTO saveDTO(HistoriaLaboralDTO historiaLaboralDTO) {
		HistoriaLaboral historiaLaboral = new HistoriaLaboral();
		mapper.map(historiaLaboralDTO, historiaLaboral);
		return mapper.map(historiaRepository.save(historiaLaboral), HistoriaLaboralDTO.class);
	}

	@Override
	public void deleteDTO(HistoriaLaboralDTO historiaLaboralDTO) {
		HistoriaLaboral historiaLaboral = new HistoriaLaboral();
		historiaLaboral.setIdCompuesta(historiaLaboralDTO.getIdCompuesta());
		historiaLaboral.setTrabajo(historiaLaboralDTO.getTrabajo());

		historiaRepository.delete(historiaLaboral);
	}

	@Override
	public HistoriaLaboralDTO modificarEmpleadoDTO(Empleado empleado, Date fechaInicio, Trabajo nuevoTrabajo) {
		HistoriaLaboral historiaLaboral = historiaRepository.findById(new HistoriaLaboralPK(empleado, fechaInicio))
				.get();

		if (historiaLaboral == null) {
			return null;
		} else if (historiaLaboral.getFechaFin() == null) {
			historiaLaboral.setFechaFin(new Date());
			historiaRepository.save(historiaLaboral);

			HistoriaLaboral historiaNueva = new HistoriaLaboral(historiaLaboral.getIdCompuesta().getEmpleadoID(),
					new Date(), null, nuevoTrabajo, historiaLaboral.getDepartamento());
			historiaRepository.save(historiaNueva);

			HistoriaLaboralDTO historiaLaboralDTO = new HistoriaLaboralDTO();
			mapper.map(historiaNueva, historiaLaboralDTO);
			return historiaLaboralDTO;
		}
		return null;

	}

	@Override
	public List<HistoriaLaboralDTO> findByEmpleadoDTO(Empleado historia) {
		List<HistoriaLaboral> lista = historiaRepository.findByEmpleado(historia);
		Type listType = new TypeToken<List<HistoriaLaboralDTO>>() {
		}.getType();
		List<HistoriaLaboralDTO> historiaLaboralDTO = mapper.map(lista, listType);
		return historiaLaboralDTO;
	}

	@Override
	public List<Empleado> findByChangeJob(Integer cambio) {
		List<Empleado> lista = new ArrayList<Empleado>();
		List<HistoriaLaboral> l = historiaRepository.findAll();
		Empleado emp;
		for (int i = 0; i < l.size(); i++) {
			emp = l.get(i).getIdCompuesta().getEmpleadoID();
			if (buscar(lista, l.get(i).getIdCompuesta().getEmpleadoID()) != true) {
				if (historiaRepository.findByEmpleado(emp).size() >= cambio)
					lista.add(emp);
			}
		}
		return lista;
	}

	/**
	 * Busca un Empledo en una lista, son enviados por parametros
	 * 
	 * @param lista
	 * @param empleado
	 * @return
	 */
	public boolean buscar(List<Empleado> lista, Empleado empleado) {
		for (Empleado e : lista) {
			if (e.getId() == empleado.getId())
				return true;
		}
		return false;
	}

	@Override
	public List<Object[]> listEmpleadosConRenovacionDeCargo(long N) {

		return historiaRepository.listEmpleadosConRenovacionDeCargo(N);
	}
}
