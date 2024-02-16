package pe.pruebaeita.acceso;

public interface IDatosMapper<T, Y> {
	public T volverDto(Y ingresar);
	public Y volverEntidad(T ingresar);
}
