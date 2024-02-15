package pe.pruebaeita.mapeadores;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.pruebaeita.modelos.Inscrito;
import pe.pruebaeita.modelos.Modalidad;
import pe.pruebaeita.repositorios.IContactoRepository;
import pe.pruebaeita.repositorios.IEspecialistaRepository;
import pe.pruebaeita.transferencias.InscritoDto;

@Component
public class InscritoMapper {
	
	@Autowired
	private IContactoRepository repo_contactos;
	
	@Autowired
	private IEspecialistaRepository repo_terapeutas;
	
	public InscritoDto volverDto(Inscrito ingresar) {
		InscritoDto egresar = new InscritoDto();
		egresar.setInscritoId(ingresar.getInscritoId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setFNacimiento(ingresar.getFNacimiento().toString());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		egresar.setMPreferida(ingresar.getMPreferida().name());
		egresar.setTPreferidoId(ingresar.getTPreferido().getTerapeutaId());
		egresar.setContactoId(ingresar.getContacto().getContactoId());
		return egresar;
	}
	
	public Inscrito volverEntidad(InscritoDto ingresar) {
		Inscrito egresar = new Inscrito();
		egresar.setInscritoId(ingresar.getInscritoId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setFNacimiento(LocalDate.parse(ingresar.getFNacimiento()));
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		egresar.setMPreferida(Modalidad.valueOf(ingresar.getMPreferida()));
		egresar.setTPreferido(repo_terapeutas.findById(ingresar.getTPreferidoId()).get());
		egresar.setContacto(repo_contactos.findById(ingresar.getContactoId()).get());
		return egresar;
	}
}