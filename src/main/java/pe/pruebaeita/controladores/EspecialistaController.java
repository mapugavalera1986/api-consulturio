package pe.pruebaeita.controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.pruebaeita.acceso.IDatosController;
import pe.pruebaeita.mapeadores.EspecialistaMapper;
import pe.pruebaeita.repositorios.IEspecialistaRepository;
import pe.pruebaeita.transferencias.EspecialistaDto;

@RestController
@RequestMapping("/api/especialistas")
public class EspecialistaController implements IDatosController<EspecialistaDto> {

	@Autowired
	private IEspecialistaRepository repo_especialistas;

	@Autowired
	private EspecialistaMapper mapear;

	@GetMapping
	public ResponseEntity<List<EspecialistaDto>> listarTodo() {
		List<EspecialistaDto> listar_todo = repo_especialistas.findAll().stream().map(mapear::volverDto)
				.collect(Collectors.toList());
		return new ResponseEntity<List<EspecialistaDto>>(listar_todo, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EspecialistaDto> obtener(@PathVariable int id) {
		Optional<EspecialistaDto> buscado = repo_especialistas.findById(id).map(mapear::volverDto);
		if (buscado.isPresent()) {
			return new ResponseEntity<EspecialistaDto>(buscado.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<EspecialistaDto> agregar(@RequestBody EspecialistaDto nuevo) {
		try {
			EspecialistaDto guardado = mapear.volverDto(repo_especialistas.save(mapear.volverEntidad(nuevo)));
			return new ResponseEntity<EspecialistaDto>(guardado, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<EspecialistaDto> modificar(@PathVariable int id, @RequestBody EspecialistaDto cambiar) {
		try {
			Optional<EspecialistaDto> buscado = repo_especialistas.findById(id).map(mapear::volverDto);
			if (buscado.isPresent()) {
				cambiar.setId(id);
				EspecialistaDto guardado = mapear.volverDto(repo_especialistas.save(mapear.volverEntidad(cambiar)));
				return new ResponseEntity<EspecialistaDto>(guardado, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable int id) {
		Optional<EspecialistaDto> buscado = repo_especialistas.findById(id).map(mapear::volverDto);
		try {
			if (buscado.isPresent()) {
				repo_especialistas.delete(mapear.volverEntidad(buscado.get()));
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
