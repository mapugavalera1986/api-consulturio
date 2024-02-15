package pe.pruebaeita.servicios.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import pe.pruebaeita.mapeadores.EspecialistaMapper;
import pe.pruebaeita.modelos.Especialista;
import pe.pruebaeita.repositorios.IEspecialistaRepository;
import pe.pruebaeita.servicios.IEspecialistaService;
import pe.pruebaeita.transferencias.EspecialistaDto;

public class EspecialistaServiceImpl implements IEspecialistaService {
	
	@Autowired
	private IEspecialistaRepository repo_especialistas;
	
	@Autowired
	private EspecialistaMapper mapear_especialistas;

	@Override
	public List<EspecialistaDto> listarTodos() {
		List<Especialista> listar_todo = repo_especialistas.findAll();
		return listar_todo.stream().map(mapear_especialistas::volverDto).collect(Collectors.toList());
	}

	@Override
	public Optional<EspecialistaDto> buscar(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public EspecialistaDto agregar(EspecialistaDto espc_nuevo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EspecialistaDto modificar(int id, EspecialistaDto espc_modificar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

}
