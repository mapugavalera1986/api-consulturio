package pe.pruebaeita.servicios.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.pruebaeita.mapeadores.InscritoMapper;
import pe.pruebaeita.modelos.Inscrito;
import pe.pruebaeita.repositorios.IInscritoRepository;
import pe.pruebaeita.servicios.IInscritoService;
import pe.pruebaeita.transferencias.InscritoDto;

@Service
@AllArgsConstructor
public class InscritoService implements IInscritoService {
	
	@Autowired
	private IInscritoRepository repo_inscritos;
	
	@Autowired
	private InscritoMapper mapear_inscritos;

	@Override
	public List<InscritoDto> listarTodos() {
		List<Inscrito> listar_todo = repo_inscritos.findAll();
		return listar_todo.stream().map(mapear_inscritos::volverDto).collect(Collectors.toList());
	}

	@Override
	public Optional<InscritoDto> buscar(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<InscritoDto> buscarContacto(int cuidadorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InscritoDto agregar(InscritoDto inscrito_nuevo) {
		Inscrito agregar = mapear_inscritos.volverEntidad(inscrito_nuevo);
		agregar = repo_inscritos.save(agregar);
		return mapear_inscritos.volverDto(agregar);
	}

	@Override
	public InscritoDto modificar(int id, InscritoDto inscrito_modificar) {
		Optional<Inscrito> encontrar = repo_inscritos.findById(id);
		if(encontrar.isPresent()) {
			Inscrito procesar = mapear_inscritos.volverEntidad(inscrito_modificar);
			procesar.setInscritoId(id);
			procesar = repo_inscritos.save(procesar);
			return mapear_inscritos.volverDto(procesar);
		} else {
			return new InscritoDto();
		}
	}

	@Override
	public void eliminar(int id) {
		Optional<Inscrito> encontrar = repo_inscritos.findById(id);
		if(encontrar.isPresent()) {
			repo_inscritos.deleteById(id);
		}
	}

}
