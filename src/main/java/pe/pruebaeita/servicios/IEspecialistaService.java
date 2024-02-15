package pe.pruebaeita.servicios;

import java.util.List;
import java.util.Optional;

import pe.pruebaeita.transferencias.EspecialistaDto;

public interface IEspecialistaService {
	List<EspecialistaDto> listarTodos();
	Optional<EspecialistaDto> buscar(int id);
	EspecialistaDto agregar(EspecialistaDto espc_nuevo);
	EspecialistaDto modificar(int id, EspecialistaDto espc_modificar);
	void eliminar(int id);
}