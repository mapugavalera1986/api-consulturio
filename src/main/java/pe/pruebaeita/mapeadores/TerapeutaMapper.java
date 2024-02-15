package pe.pruebaeita.mapeadores;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import pe.pruebaeita.modelos.Especialidad;
import pe.pruebaeita.modelos.Terapeuta;
import pe.pruebaeita.transferencias.TerapeutaDto;

@Component
public class TerapeutaMapper {

	public TerapeutaDto volverDto (Terapeuta ingresar) {
		TerapeutaDto egresar = new TerapeutaDto();
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
	
	public Terapeuta volverEntidad(TerapeutaDto ingresar) {
		Terapeuta egresar = new Terapeuta();
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
