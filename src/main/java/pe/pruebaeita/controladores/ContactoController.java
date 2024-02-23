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
import pe.pruebaeita.mapeadores.ContactoMapper;
import pe.pruebaeita.repositorios.IContactoRepository;
import pe.pruebaeita.transferencias.ContactoDto;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController implements IDatosController<ContactoDto> {

	@Autowired
	private IContactoRepository repo_contactos;

	@Autowired
	private ContactoMapper mapear;

	@GetMapping
	public ResponseEntity<List<ContactoDto>> listarTodo() {
		List<ContactoDto> listar_todo = repo_contactos.findAll().stream().map(mapear::volverDto)
				.collect(Collectors.toList());
		return new ResponseEntity<List<ContactoDto>>(listar_todo, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContactoDto> obtener(@PathVariable int id) {
		Optional<ContactoDto> buscado = repo_contactos.findById(id).map(mapear::volverDto);
		if (buscado.isPresent()) {
			return new ResponseEntity<ContactoDto>(buscado.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<ContactoDto>> buscar(@RequestParam String buscar) {
		List<ContactoDto> lista_buscar = repo_contactos.findByText(buscar).stream().map(mapear::volverDto)
				.collect(Collectors.toList());
		return new ResponseEntity<List<ContactoDto>>(lista_buscar, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> agregar(@RequestBody ContactoDto nuevo) {
		try {
			repo_contactos.save(mapear.volverEntidad(nuevo));
			return new ResponseEntity<String>("Contacto ingresado con éxito", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Error al intentar agregar contacto", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> modificar(@PathVariable int id, @RequestBody ContactoDto cambiar) {
		try {
			Optional<ContactoDto> buscado = repo_contactos.findById(id).map(mapear::volverDto);
			if (buscado.isPresent()) {
				cambiar.setId(id);
				repo_contactos.save(mapear.volverEntidad(cambiar));
				return new ResponseEntity<String>("Se cambiaron los datos con éxito", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No se encontró a contacto", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Búsqueda incorrecta", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id) {
		Optional<ContactoDto> buscado = repo_contactos.findById(id).map(mapear::volverDto);
		try {
			if (buscado.isPresent()) {
				repo_contactos.delete(mapear.volverEntidad(buscado.get()));
				return new ResponseEntity<String>("Contacto eliminado con éxito", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No se encontró a contacto", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Imposible eliminar. Verifica que no haya dependencias",
					HttpStatus.BAD_REQUEST);
		}
	}
}
