package pe.pruebaeita.mapeadores;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.pruebaeita.mapeadores.interfaz.IDatosMapper;
import pe.pruebaeita.modelos.Inscrito;
import pe.pruebaeita.modelos.Modalidad;
import pe.pruebaeita.repositorios.IContactoRepository;
import pe.pruebaeita.repositorios.IEspecialistaRepository;
import pe.pruebaeita.transferencias.InscritoDto;
import pe.pruebaeita.transferencias.InscritoMinDto;

@Component
public class InscritoMapper implements IDatosMapper<InscritoDto, Inscrito> {

	@Autowired
	private IContactoRepository repo_contactos;
	
	@Autowired
	private IEspecialistaRepository repo_especialistas;
	
	//Este DTO miniatura solo es para mostrar algunas cositas en la API. No se debe utilizar para otras operaciones.
	public InscritoMinDto volverMinDto(Inscrito ingresar) {
		InscritoMinDto egresar = new InscritoMinDto();
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setEdad(ingresar.getEdad());
		egresar.setModalidad(ingresar.getModalidad().name());
		return egresar;
	}
	
	@Override
	public InscritoDto volverDto(Inscrito ingresar) {
		InscritoDto egresar = new InscritoDto();
		egresar.setId(ingresar.getId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setNacimiento(ingresar.getNacimiento().toString());
		egresar.setEdad(ingresar.getEdad());
		egresar.setDireccn(ingresar.getDireccn());
		egresar.setDni(ingresar.getDni());
		egresar.setEmail(ingresar.getEmail());
		egresar.setTelf(ingresar.getTelf());
		egresar.setModalidad(ingresar.getModalidad().name());
		egresar.setEspecialista_id(ingresar.getEspecialista().getId());
		egresar.setContacto_id(ingresar.getContacto().getId());
		return egresar;
	}

	@Override
	public Inscrito volverEntidad(InscritoDto ingresar) {
		Inscrito egresar = new Inscrito();
		egresar.setId(ingresar.getId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setNacimiento(LocalDate.parse(ingresar.getNacimiento()));
		egresar.setEdad(ingresar.getEdad());
		egresar.setDireccn(ingresar.getDireccn());
		egresar.setDni(ingresar.getDni());
		egresar.setEmail(ingresar.getEmail());
		egresar.setTelf(ingresar.getTelf());
		egresar.setModalidad(Modalidad.valueOf(ingresar.getModalidad()));
		egresar.setEspecialista(repo_especialistas.findById(ingresar.getEspecialista_id()).get());
		egresar.setContacto(repo_contactos.findById(ingresar.getContacto_id()).get());
		return egresar;
	}
}
