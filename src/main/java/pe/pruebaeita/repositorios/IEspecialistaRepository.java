package pe.pruebaeita.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.pruebaeita.modelos.Especialista;

//Falta implementar cómo se elaborarán las búsquedas
@Repository
public interface IEspecialistaRepository extends JpaRepository<Especialista, Integer> {
}