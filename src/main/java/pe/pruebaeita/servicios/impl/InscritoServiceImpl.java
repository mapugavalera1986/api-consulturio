package pe.pruebaeita.servicios.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.pruebaeita.mapeadores.InscritoMapper;
import pe.pruebaeita.modelos.Contacto;
import pe.pruebaeita.modelos.Inscrito;
import pe.pruebaeita.repositorios.IContactoRepository;
import pe.pruebaeita.repositorios.IInscritoRepository;
import pe.pruebaeita.servicios.IInscritoService;
import pe.pruebaeita.transferencias.InscritoDto;

@Service
@AllArgsConstructor
public class InscritoServiceImpl implements IInscritoService {
	
	@Autowired
	private IInscritoRepository repo_inscritos;
	
	@Autowired
	private IContactoRepository repo_contactos;
	
	@Autowired
	private InscritoMapper mapear_inscritos;

	@Override
	public List<InscritoDto> listarTodos() {
		List<Inscrito> listar_todo = repo_inscritos.findAll();
		return listar_todo.stream().map(mapear_inscritos::volverDto).collect(Collectors.toList());
	}
	@Override
	public Optional<InscritoDto> buscar(int id) {//Se necesita arreglar esto
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<InscritoDto> buscarContacto(int contactoId) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}
}
