package pe.pruebaeita.servicios;

import java.util.List;
import java.util.Optional;

import pe.pruebaeita.transferencias.InscritoDto;

public interface IInscritoService {
	List<InscritoDto> listarTodos();
	Optional<InscritoDto> buscar(int id);
	List<InscritoDto> buscarContacto(int cuidadorId);
	InscritoDto agregar(InscritoDto inscrito_nuevo);
	InscritoDto modificar(int id, InscritoDto inscrito_modificar);
	void eliminar(int id);
}
