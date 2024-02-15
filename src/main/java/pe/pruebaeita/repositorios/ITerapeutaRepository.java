package pe.pruebaeita.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.pruebaeita.modelos.Terapeuta;

@Repository
public interface ITerapeutaRepository extends JpaRepository<Terapeuta, Integer> {
}