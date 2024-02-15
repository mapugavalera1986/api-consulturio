package pe.pruebaeita.servicios.impl;

import java.util.List;
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

}
