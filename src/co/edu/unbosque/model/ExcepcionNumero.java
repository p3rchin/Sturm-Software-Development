/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.model;
/**
 * Clase ExcepcionNumero.
 * 
 * Clase donde se crea una excepción personalizada del número.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class ExcepcionNumero extends Exception {
	/*
	 * serialVersionUID es estatico y de tipo long = a 1L.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor vacio de la clase.
	 */
	ExcepcionNumero() {

	}

	/**
	 * Constructor específico que crea la ExcepcionNumero con un parametro tipo String.
	 * <b>pre</b> Se debe colocar la excepción en el método a utilizar.<br>
	 * <b>post</b> Si es correcta la excepción se le mostrará el mensaje que se ha puesto.<br>
	 * @param mensaje es de tipo String que arroja la excepción: mensaje debe ser != null y != de " ".
	 */
	public ExcepcionNumero(String mensaje) {
		super(mensaje);
	}
}
