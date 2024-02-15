package pe.pruebaeita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppIniciar {

	public static void main(String[] args) {
		SpringApplication.run(AppIniciar.class, args);
		System.out.println("La API para el consultorio ya está funcionando");
	}
}