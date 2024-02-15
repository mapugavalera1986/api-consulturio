package pe.pruebaeita.servicios;

import java.util.List;
import java.util.Optional;

import pe.pruebaeita.transferencias.EspecialistaDto;


public interface IEspecialistaService {
	List<EspecialistaDto> listarTodos();
	/*Optional<TerapeutaDto> buscar(int id);
	TerapeutaDto agregar(TerapeutaDto c_nuevo);
	TerapeutaDto modificar(int id, TerapeutaDto c_cambiar);
	void eliminar(int id);*/
}
