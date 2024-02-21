package pe.pruebaeita.mapeadores;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.pruebaeita.mapeadores.interfaz.IDatosMapper;
import pe.pruebaeita.modelos.Especialista;
import pe.pruebaeita.repositorios.IInscritoRepository;
import pe.pruebaeita.transferencias.EspecialistaDto;
import pe.pruebaeita.transferencias.InscritoMinDto;

@Component
public class EspecialistaMapper implements IDatosMapper<EspecialistaDto, Especialista> {
	
	@Autowired
	private InscritoMapper inscritos;
	
	@Autowired
	private IInscritoRepository repo_inscritos;
	
	@Override
	public EspecialistaDto volverDto(Especialista ingresar) {
		EspecialistaDto egresar = new EspecialistaDto();
		egresar.setId(ingresar.getId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setNacimiento(ingresar.getNacimiento().toString());
		egresar.setEdad(ingresar.getEdad());
		egresar.setDireccn(ingresar.getDireccn());
		egresar.setDni(ingresar.getDni());
		egresar.setRuc(ingresar.getRuc());
		egresar.setEmail(ingresar.getEmail());
		egresar.setTelf(ingresar.getTelf());
		egresar.setInscritos(listarMiniInscritos(ingresar));
		return egresar;
	}
	
	@Override
	public Especialista volverEntidad(EspecialistaDto ingresar) {
		Especialista egresar = new Especialista();
		egresar.setId(ingresar.getId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setNacimiento(LocalDate.parse(ingresar.getNacimiento()));
		egresar.setEdad(ingresar.getEdad());
		egresar.setDireccn(ingresar.getDireccn());
		egresar.setDni(ingresar.getDni());
		egresar.setRuc(ingresar.getRuc());
		egresar.setEmail(ingresar.getEmail());
		egresar.setTelf(ingresar.getTelf());
		return egresar;
	}
	
	private List<InscritoMinDto> listarMiniInscritos(Especialista encontrar){
		return repo_inscritos.findByEspecialista(encontrar).stream().map(inscritos::volverMinDto).collect(Collectors.toList());
	}
}