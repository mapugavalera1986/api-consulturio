package pe.pruebaeita.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.pruebaeita.modelos.Contacto;

@Repository
public interface IContactoRepository extends JpaRepository<Contacto, Integer> {
	@Query("SELECT c FROM Contacto c WHERE CONCAT(c.nmbrs, ' ', c.apllds) LIKE CONCAT('%',:buscar,'%')")
	List<Contacto> findByText(@Param("buscar") String buscar);
}