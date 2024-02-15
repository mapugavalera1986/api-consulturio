package pe.pruebaeita.transferencias;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EspecialistaDto {
	private int terapeutaId;
	private String nmbrs;
	private String apllds;
	private String fNacimiento;
	private String dni;
	private String ruc;
	private String direccn;
	private String correoE;
	private String telf;
	private String especialidad;
}
