package pe.pruebaeita.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.pruebaeita.modelos.Contacto;
import pe.pruebaeita.modelos.Inscrito;

@Repository
public interface IInscritoRepository extends JpaRepository<Inscrito, Integer> {
	Optional<List<Inscrito>>findByContacto(Contacto encontrar);
	void deleteByContacto(Contacto encontrar);
}
