package pe.pruebaeita.modelos;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Terapeutas")
public class Especialista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int terapeutaId;
	private String nmbrs;
	private String apllds;
	private LocalDate fNacimiento;
	private String dni;
	private String ruc;
	private String direccn;
	private String correoE;
	private String telf;
	@Enumerated(EnumType.STRING)
	private Especialidad especialidad;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tPreferido")
	private List<Inscrito> inscritos;
	//private LocalDate fregistro;
}
