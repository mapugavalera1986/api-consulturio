package pe.pruebaeita.mapeadores;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.pruebaeita.mapeadores.interfaz.IDatosMapper;
import pe.pruebaeita.modelos.Contacto;
import pe.pruebaeita.repositorios.IInscritoRepository;
import pe.pruebaeita.transferencias.ContactoDto;
import pe.pruebaeita.transferencias.InscritoMinDto;

@Component
public class ContactoMapper implements IDatosMapper<ContactoDto, Contacto> {
	
	@Autowired
	private InscritoMapper inscritos;
	
	@Autowired
	private IInscritoRepository repo_inscritos;
	
	@Override
	public ContactoDto volverDto(Contacto ingresar) {
		ContactoDto egresar = new ContactoDto();
		egresar.setId(ingresar.getId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setEmail(ingresar.getEmail());
		egresar.setTelf(ingresar.getTelf());
		egresar.setInscritos(listarMiniInscritos(ingresar));
		return egresar;
	}
	
	@Override
	public Contacto volverEntidad(ContactoDto ingresar) {
		Contacto egresar = new Contacto();
		egresar.setId(ingresar.getId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setEmail(ingresar.getEmail());
		egresar.setTelf(ingresar.getTelf());
		return egresar;
	}
	
	private List<InscritoMinDto> listarMiniInscritos(Contacto encontrar){
		return repo_inscritos.findByContacto(encontrar).stream().map(inscritos::volverMinDto).collect(Collectors.toList());
	}
}

