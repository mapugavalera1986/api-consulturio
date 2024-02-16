package pe.pruebaeita.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.pruebaeita.modelos.Contacto;
import pe.pruebaeita.modelos.Especialista;
import pe.pruebaeita.modelos.Inscrito;

//Falta implementar cómo se elaborarán las búsquedas por nombres, dirección, edad y fecha de nacimiento
@Repository
public interface IInscritoRepository extends JpaRepository<Inscrito, Integer> {
	List<Inscrito>findByEspecialista(Especialista encontrar);
	List<Inscrito>findByContacto(Contacto encontrar);
}
