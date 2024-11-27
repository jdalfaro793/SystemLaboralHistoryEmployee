/**
 * 
 */
package ar.edu.unju.fi.tpfinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.entity.Trabajo;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, String>{
	Trabajo findByProfesion(String profesion);
}
