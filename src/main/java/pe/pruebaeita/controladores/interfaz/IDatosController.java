package pe.pruebaeita.controladores.interfaz;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IDatosController<T> {
	//Falta agregar las baskets, modificar y eliminar
	public ResponseEntity<List<T>> listarTodo();
	public ResponseEntity<T> obtener(int id);
	public ResponseEntity<List<T>> buscar(String buscar);
	public ResponseEntity<String> agregar(T nuevo);
	public ResponseEntity<String> modificar(int id, T cambiar);
	public ResponseEntity<String> eliminar(int id);
}