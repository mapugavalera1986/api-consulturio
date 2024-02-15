package pe.pruebaeita.mapeadores;

import org.springframework.stereotype.Component;

import pe.pruebaeita.modelos.Contacto;
import pe.pruebaeita.transferencias.ContactoDto;

@Component
public class ContactoMapper {
	
	public ContactoDto volverDto(Contacto ingresar) {
		ContactoDto egresar = new ContactoDto();
		egresar.setContactoId(ingresar.getContactoId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		return egresar;
	}
	
	public Contacto volverEntidad(ContactoDto ingresar) {
		Contacto egresar = new Contacto();
		egresar.setContactoId(ingresar.getContactoId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		return egresar;
	}
}

