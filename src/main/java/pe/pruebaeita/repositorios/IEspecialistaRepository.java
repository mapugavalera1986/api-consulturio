package pe.pruebaeita.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.pruebaeita.modelos.Especialista;

//Falta implementar cómo se elaborarán las búsquedas por nombres, dirección, edad y fecha de nacimiento
@Repository
public interface IEspecialistaRepository extends JpaRepository<Especialista, Integer> {
	@Query("SELECT e FROM Especialista e WHERE CONCAT(e.nmbrs, ' ', e.apllds) LIKE CONCAT('%',:buscar,'%')")
	List<Especialista> findByText(@Param("buscar") String buscar);
}