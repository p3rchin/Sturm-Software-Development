/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model;
/**
 * Clase ExcepcionNombre.
 * 
 * Clase donde se crea una excepci�n personalizada del nombre.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class ExcepcionNombre extends Exception {

	/*
	 * serialVersionUID es estatico y de tipo long = a 1L.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor vacio de la clase.
	 */
	ExcepcionNombre() {

	}

	/**
	 * Constructor espec�fico que crea la ExcepcionNombre con un parametro tipo String.
	 * <b>pre</b> Se debe colocar la excepci�n en el m�todo a utilizar.<br>
	 * <b>post</b> Si es correcta la excepci�n se le mostrar� el mensaje que se ha puesto.<br>
	 * @param mensaje es de tipo String que arroja la excepci�n: mensaje debe ser != null y != de " ".
	 */
	public ExcepcionNombre(String mensaje) {
		super(mensaje);
	}
}
