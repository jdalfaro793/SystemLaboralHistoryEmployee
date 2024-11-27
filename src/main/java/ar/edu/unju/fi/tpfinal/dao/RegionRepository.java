package ar.edu.unju.fi.tpfinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

	Region findByNombre(String nombre);

}