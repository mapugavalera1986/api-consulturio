package pe.pruebaeita.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.pruebaeita.modelos.Contacto;

@Repository
public interface IContactoRepository extends JpaRepository<Contacto, Integer> {
}