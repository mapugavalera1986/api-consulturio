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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.pruebaeita.controladores.interfaz.IDatosController;
import pe.pruebaeita.mapeadores.InscritoMapper;
import pe.pruebaeita.repositorios.IInscritoRepository;
import pe.pruebaeita.transferencias.InscritoDto;

@RestController
@RequestMapping("/api/inscripciones")
public class InscritoController implements IDatosController<InscritoDto> {

	@Autowired
	private IInscritoRepository repo_inscritos;

	@Autowired
	private InscritoMapper mapear;

	@GetMapping
	public ResponseEntity<List<InscritoDto>> listarTodo() {
		List<InscritoDto> listar_todo = repo_inscritos.findAll().stream().map(mapear::volverDto)
				.collect(Collectors.toList());
		return new ResponseEntity<List<InscritoDto>>(listar_todo, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<InscritoDto> obtener(@PathVariable int id) {
		Optional<InscritoDto> buscado = repo_inscritos.findById(id).map(mapear::volverDto);
		if (buscado.isPresent()) {
			return new ResponseEntity<InscritoDto>(buscado.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<InscritoDto>> buscar(@RequestParam String buscar) {
		List<InscritoDto> lista_buscar = repo_inscritos.findByText(buscar).stream().map(mapear::volverDto)
				.collect(Collectors.toList());
		return new ResponseEntity<List<InscritoDto>>(lista_buscar, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> agregar(@RequestBody InscritoDto nuevo) {
		try {
			repo_inscritos.save(mapear.volverEntidad(nuevo));
			return new ResponseEntity<String>("Inscrito ingresado con éxito", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Error al intentar agregar participante", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> modificar(@PathVariable int id, @RequestBody InscritoDto cambiar) {
		try {
			Optional<InscritoDto> buscado = repo_inscritos.findById(id).map(mapear::volverDto);
			if (buscado.isPresent()) {
				cambiar.setId(id);
				repo_inscritos.save(mapear.volverEntidad(cambiar));
				return new ResponseEntity<String>("Se cambiaron los datos con éxito", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No se encontró a participante", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Búsqueda incorrecta", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id) {
		Optional<InscritoDto> buscado = repo_inscritos.findById(id).map(mapear::volverDto);
		try {
			if (buscado.isPresent()) {
				repo_inscritos.delete(mapear.volverEntidad(buscado.get()));
				return new ResponseEntity<String>("Inscrito eliminado con éxito", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No se encontró a participante", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Imposible eliminar. Verifica que no haya dependencias",
					HttpStatus.BAD_REQUEST);
		}
	}
}
