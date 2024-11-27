/**
 * 
 */
package ar.edu.unju.fi.tpfinal.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.dao.UbicacionRepository;
import ar.edu.unju.fi.tpfinal.dto.UbicacionDTO;
import ar.edu.unju.fi.tpfinal.entity.Ubicacion;
import ar.edu.unju.fi.tpfinal.service.UbicacionService;



@Service
public class UbicacionServiceImpl implements UbicacionService {
	private ModelMapper mapper = new ModelMapper();
	@Autowired
	private UbicacionRepository ubicacionRepository;

	@Override
	public void save(Ubicacion ubicacion) {
		ubicacionRepository.save(ubicacion);

	}

	@Override
	public void delete(Ubicacion ubicacion) {
		ubicacionRepository.delete(ubicacion);

	}

	@Override
	public Optional<Ubicacion> findByUbicacion(Ubicacion ubicacion) {
		Optional<Ubicacion> u = ubicacionRepository.findById(ubicacion.getId());
		return u;
	}

	@Override
	public Optional<Ubicacion> findById(Long id) {
		Optional<Ubicacion> u = ubicacionRepository.findById(id);
		return u;
	}

	@Override
	public UbicacionDTO findByID(Long id) {
		Ubicacion encontrado = ubicacionRepository.findById(id).get();
		if (encontrado == null) {
			return null;
		}
		UbicacionDTO dto = mapper.map(encontrado, UbicacionDTO.class);
		return dto;
	}

}
