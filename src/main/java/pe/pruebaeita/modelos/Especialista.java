package pe.pruebaeita.modelos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

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
@Table(name = "especialistas")
public class Especialista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nmbrs;
	private String apllds;
	private LocalDate nacimiento;
	private String dni;
	private String ruc;
	private String direccn;
	private String email;
	private String telf;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "especialista")
	private List<Inscrito> inscritos;
	//private LocalDate fregistro;
}
