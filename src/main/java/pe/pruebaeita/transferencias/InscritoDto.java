package pe.pruebaeita.transferencias;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InscritoDto {
	private int inscritoId;
	private String nmbrs;
	private String apllds;
	private String dni;
	private String fNacimiento;
	private String direccn;
	private String correoE;
	private String telf;
	private String mPreferida;
	private int tPreferidoId;
	private int contactoId;
}