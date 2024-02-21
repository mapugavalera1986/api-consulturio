package pe.pruebaeita.mapeadores.interfaz;

public interface IDatosMapper<T, Y> {
	public T volverDto(Y ingresar);
	public Y volverEntidad(T ingresar);
}
