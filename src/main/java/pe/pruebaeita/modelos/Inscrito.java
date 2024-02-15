package pe.pruebaeita.modelos;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Inscripciones")
public class Inscrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inscritoId;
	private String nmbrs;
	private String apllds;
	private String dni;
	private LocalDate fNacimiento;
	private String direccn;
	private String correoE;
	private String telf;
	@Enumerated(EnumType.STRING)
	private Modalidad mPreferida;
	@ManyToOne
	@JoinColumn(name = "terapeuta_id")
	private Especialista tPreferido;
	@ManyToOne
	@JoinColumn(name = "contacto_id")
	private Contacto contacto;
	//private LocalDate fRegistro;
}
