package pe.pruebaeita.controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.pruebaeita.mapeadores.EspecialistaMapper;
import pe.pruebaeita.repositorios.IEspecialistaRepository;
import pe.pruebaeita.transferencias.EspecialistaDto;

@RestController
@RequestMapping("/api/especialistas")
public class EspecialistaController {
	
	@Autowired
	private IEspecialistaRepository repo_especialistas;
	
	@Autowired
	private EspecialistaMapper mapeado;

	//Así no existan elementos, se listará todo. Esto nos permitirá trabajar con la aplicación Web sin problemas
	@GetMapping
	public ResponseEntity<List<EspecialistaDto>> listarTodo(){
		List<EspecialistaDto> listar_todo = repo_especialistas.findAll().stream().map(mapeado::volverDto).collect(Collectors.toList());
		return ResponseEntity.ok(listar_todo);
	}
	
	//La idea es que regrese una entidad vacía si no se llega a encontrar alguna
	@GetMapping("/id")
	public ResponseEntity<EspecialistaDto> obtener(@PathVariable int id){
		Optional<EspecialistaDto> buscado = repo_especialistas.findById(id).map(mapeado::volverDto);
		if(buscado.isPresent()) {
			return ResponseEntity.ok(buscado.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EspecialistaDto());
		}
	}
}
