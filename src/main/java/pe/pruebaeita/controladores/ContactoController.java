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

	@PostMapping
	public ResponseEntity<ContactoDto> agregar(@RequestBody ContactoDto nuevo) {
		try {
			ContactoDto guardado = mapear.volverDto(repo_contactos.save(mapear.volverEntidad(nuevo)));
			return new ResponseEntity<ContactoDto>(guardado, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContactoDto> modificar(@PathVariable int id, @RequestBody ContactoDto cambiar) {
		try {
			Optional<ContactoDto> buscado = repo_contactos.findById(id).map(mapear::volverDto);
			if (buscado.isPresent()) {
				cambiar.setId(id);
				ContactoDto guardado = mapear.volverDto(repo_contactos.save(mapear.volverEntidad(cambiar)));
				return new ResponseEntity<ContactoDto>(guardado, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable int id) {
		Optional<ContactoDto> buscado = repo_contactos.findById(id).map(mapear::volverDto);
		try {
			if (buscado.isPresent()) {
				repo_contactos.delete(mapear.volverEntidad(buscado.get()));
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
