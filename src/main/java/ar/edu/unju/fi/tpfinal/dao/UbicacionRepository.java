
package ar.edu.unju.fi.tpfinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.entity.Ubicacion;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {
	Ubicacion findByCodigoPostal(String codigoPostal);

	Ubicacion findByCiudad(String ciudad);
}