package pe.pruebaeita.servicios;

import java.util.List;
//import java.util.Optional;

import pe.pruebaeita.transferencias.ContactoDto;

public interface IContactoService {
	List<ContactoDto> listarTodos();
	/*Optional<ContactoDto> buscar(int id);
	ContactoDto agregar(ContactoDto c_nuevo);
	ContactoDto modificar(int id, ContactoDto c_cambiar);
	void eliminar(int id);*/
}
