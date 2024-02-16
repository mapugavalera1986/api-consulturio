package pe.pruebaeita.mapeadores;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import pe.pruebaeita.acceso.IDatosMapper;
import pe.pruebaeita.modelos.Especialista;
import pe.pruebaeita.transferencias.EspecialistaDto;
import pe.pruebaeita.xtras.Calcular;

@Component
public class EspecialistaMapper implements IDatosMapper<EspecialistaDto, Especialista> {
	
	@Override
	public EspecialistaDto volverDto(Especialista ingresar) {
		EspecialistaDto egresar = new EspecialistaDto();
		egresar.setId(ingresar.getId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setNacimiento(ingresar.getNacimiento().toString());
		egresar.setEdad(Calcular.calcEdadYears(ingresar.getNacimiento()));
		egresar.setDireccn(ingresar.getDireccn());
		egresar.setDni(ingresar.getDni());
		egresar.setRuc(ingresar.getRuc());
		egresar.setEmail(ingresar.getEmail());
		egresar.setTelf(ingresar.getTelf());
		return egresar;
	}
	
	@Override
	public Especialista volverEntidad(EspecialistaDto ingresar) {
		Especialista egresar = new Especialista();
		egresar.setId(ingresar.getId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setNacimiento(LocalDate.parse(ingresar.getNacimiento()));
		egresar.setDireccn(ingresar.getDireccn());
		egresar.setDni(ingresar.getDni());
		egresar.setRuc(ingresar.getRuc());
		egresar.setEmail(ingresar.getEmail());
		egresar.setTelf(ingresar.getTelf());
		return egresar;
	}
}