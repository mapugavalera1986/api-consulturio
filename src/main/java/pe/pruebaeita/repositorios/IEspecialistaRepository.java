package pe.pruebaeita.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.pruebaeita.modelos.Especialista;

@Repository
public interface IEspecialistaRepository extends JpaRepository<Especialista, Integer> {
}