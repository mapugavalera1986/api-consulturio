package pe.pruebaeita.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.pruebaeita.modelos.Especialista;

//Falta implementar cómo se elaborarán las búsquedas por nombres, dirección, edad y fecha de nacimiento
@Repository
public interface IEspecialistaRepository extends JpaRepository<Especialista, Integer> {
	List<Especialista> findByNmbrsContainingOrAplldsContainingIgnoreCase(String nmbrs, String apllds);
	List<Especialista> findByNmbrsOrApllds(String nmbrs, String apllds);
}