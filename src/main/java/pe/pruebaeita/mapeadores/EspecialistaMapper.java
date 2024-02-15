package pe.pruebaeita.mapeadores;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import pe.pruebaeita.modelos.Especialidad;
import pe.pruebaeita.modelos.Especialista;
import pe.pruebaeita.transferencias.EspecialistaDto;

@Component
public class EspecialistaMapper {

	public EspecialistaDto volverDto (Especialista ingresar) {
		EspecialistaDto egresar = new EspecialistaDto();
		egresar.setTerapeutaId(ingresar.getTerapeutaId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setFNacimiento(ingresar.getFNacimiento().toString());
		egresar.setDni(ingresar.getDni());
		egresar.setRuc(ingresar.getRuc());
		egresar.setDireccn(ingresar.getDireccn());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		egresar.setEspecialidad(ingresar.getEspecialidad().name());
		return egresar;
	}
	
	public Especialista volverEntidad(EspecialistaDto ingresar) {
		Especialista egresar = new Especialista();
		egresar.setTerapeutaId(ingresar.getTerapeutaId());
		egresar.setNmbrs(ingresar.getNmbrs());
		egresar.setApllds(ingresar.getApllds());
		egresar.setFNacimiento(LocalDate.parse(ingresar.getFNacimiento()));
		egresar.setDni(ingresar.getDni());
		egresar.setRuc(ingresar.getRuc());
		egresar.setDireccn(ingresar.getDireccn());
		egresar.setCorreoE(ingresar.getCorreoE());
		egresar.setTelf(ingresar.getTelf());
		egresar.setEspecialidad(Especialidad.valueOf(ingresar.getEspecialidad()));
		return egresar;
	}
}
