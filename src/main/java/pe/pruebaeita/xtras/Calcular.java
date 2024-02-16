package pe.pruebaeita.xtras;

import java.time.LocalDate;
import java.time.Period;

public class Calcular {

	public static int calcEdadYears(LocalDate fecha_nacimiento) {
		LocalDate fecha_actual = LocalDate.now();
		Period tiempo = Period.between(fecha_nacimiento, fecha_actual);
		return tiempo.getYears();
	}
}
