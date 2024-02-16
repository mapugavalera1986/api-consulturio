package pe.pruebaeita.mapeadores;

import org.springframework.stereotype.Component;

import pe.pruebaeita.acceso.IDatosMapper;
import pe.pruebaeita.modelos.Contacto;
import pe.pruebaeita.transferencias.ContactoDto;

@Component
public class ContactoMapper implements IDatosMapper<ContactoDto, Contacto> {
	
	@Override
	public ContactoDto volverDto(Contacto ingresar) {
		ContactoDto egresar = new ContactoDto();
		egresar.setId(ingresar.getId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setDni(ingresar.getDni());
		egresar.setEmail(ingresar.getEmail());
		egresar.setTelf(ingresar.getTelf());
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
}

