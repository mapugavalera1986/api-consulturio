package pe.pruebaeita.transferencias;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InscritoMinDto {
	private String nmbrs;
	private String apllds;
	private int edad;
	private String modalidad;
}
