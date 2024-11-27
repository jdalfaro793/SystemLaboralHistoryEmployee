package ar.edu.unju.fi.tpfinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, String> {

	Pais findByNombre(String nombre);

}
