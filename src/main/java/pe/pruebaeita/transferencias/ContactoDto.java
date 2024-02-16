package pe.pruebaeita.transferencias;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContactoDto {
	private int id;
	private String nmbrs;
	private String apllds;
	private String dni;
	private String email;
	private String telf;
}
