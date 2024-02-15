package pe.pruebaeita.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.pruebaeita.servicios.IInscritoService;
import pe.pruebaeita.transferencias.InscritoDto;

@RestController
@RequestMapping("/api/inscritos")
public class InscritoController {
	
	//Solo se ha implementado la búsqueda de todos los elementos
	
	@Autowired
	private IInscritoService srvc_inscritos;
	
	@GetMapping
	public ResponseEntity<List<InscritoDto>> listarTodos(){
		List<InscritoDto> listar_todos = srvc_inscritos.listarTodos();
		return new ResponseEntity<>(listar_todos, HttpStatus.OK);
	}
}
