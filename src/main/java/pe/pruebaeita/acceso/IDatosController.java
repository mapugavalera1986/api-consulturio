package pe.pruebaeita.acceso;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IDatosController<T> {
	//Falta agregar las baskets, modificar y eliminar
	public ResponseEntity<List<T>> listarTodo();
	public ResponseEntity<T> obtener(int id);
	public ResponseEntity<T> agregar(T nuevo);
	public ResponseEntity<T> modificar(int id, T cambiar);
	public ResponseEntity<?> eliminar(int id);
}