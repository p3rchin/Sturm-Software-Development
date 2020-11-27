/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * Clase Sede.
 * 
 * Clase donde se agrega la sede donde se esta haciendo la apuesta.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class Sede implements Serializable {
	/*
	 * serialVersionUID es estatico y de tipo long = a 1L.
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ubicacion es de tipo String.
	 */
	private String ubicacion;
	/*
	 * nEmpleados es de tipo String.
	 */
	private String nEmpleados;

	/**
	 * Constructor vacío de la clase.
	 */
	public Sede() {
	}

	/**
	 * Es el constructor específico donde crea el objeto Sede y contiene los parámetros para su creación.
	 * <b>pre</b> Debe contener los parámetros para crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los parámetros que se le enviaron. <br>
	 * @param ubicacion es de tipo String que contiene la sede: ubicacion debe ser != de null y != de " ".
	 * @param nEmpleados es de tipo String que contiene la sede: nEmpleados debe ser != de null y != de " ".
	 */
	public Sede(String ubicacion, String nEmpleados) {
		super();
		this.ubicacion = ubicacion;
		this.nEmpleados = nEmpleados;
	}

	/**
	 * Este método recibe un String verificando que solo contenga números.
	 * <b>pre</b> El parámetro String debe ser un número.<br>
	 * <b>post</b> Si el metodo se cumple correctamente es porque el String es un
	 * número. Si no, el método retornará un valor falso.<br>
	 * 
	 * @param pNumero es un String numero: pNumero debe ser != de null y != de " ".
	 * @return es el valor booleano que retorna el método.
	 */
	public boolean soloNumeros(String pNumero) {

		boolean verificar = true;

		if (!pNumero.trim().matches("[0-9]*")) {

			verificar = false;
		}

		return verificar;
	}

	/**
	 * Este método recibe un String verificando que solo contenga letras. 
	 * <b>pre</b> El parámetro que se recibe de tipo String debe ser una palabra.<br>
	 * <b>post</b> Si el método es correcto es porque el String contiene una
	 * palabra. Si no la contiene, el método retorna falso.<br>
	 * @param pLetra es un String de letras: palabra tiene que ser != de null y !=
	 *                de " ".
	 * @return es el valor booleano que retorna el método.
	 */
	public boolean soloLetras(String pLetra) {

		boolean verificar = true;

		if (!pLetra.trim().matches("[a-zA-Z]*")) {

			verificar = false;
		}

		return verificar;
	}
	
	/**
	 * Este método recibe un parámetro tipo String para verificar que solo contenga
	 * letras. 
	 * <b>pre</b> El parámetro String que se recibe debe contener solo
	 * letras.<br>
	 * <b>post</b> Si el parámetro que se recibe contiene solo letras la excepción
	 * está correcta. Si no, el método mostrará la excepción que se presenta en el
	 * método.<br>
	 * 
	 * @param pUbicacion es es de tipo String: pUbicacion debe ser != de null y != de " ".
	 * @return La variable que se contiene en el método de tipo boolean y que
	 *         verifica si se contiene solo letras.
	 * @throws ExcepcionNombre es la excepción que se utiliza en este método.
	 */
	public boolean excepcionUbicacion(String pUbicacion) throws ExcepcionNombre {
		boolean verificar;

		if (soloLetras(pUbicacion)) {
			verificar = true;
		} else {
			throw new ExcepcionNombre("Señor usuario ingreso un caracter no valido.\nPor favor ingrese solo letras");
		}
		return verificar;
	}

	/**
	 *  * Este método recibe un parámetro de tipo String para verificar que tenga números.
	 * <b>pre</b>El parámetro que recibe debe contener solo números.</br>
	 * <b>post</b> Si el parámetro que se recibe contiene solo números la excepción
	 * está correcta. Si no, el método mostrará la excepción que se presenta en el
	 * método.<br>
	 * @param pEmpleado es de tipo String: numero debe ser != de null y != de " ".
	 * @return la variable que tiene el método de tipo booleano para verficar si contiene solo números.
	 * @throws ExcepcionNumero es la excepción que se usa en este método.
	 */
	public boolean excepcionEmpleado(String pEmpleado) throws ExcepcionNumero {
		boolean verificar;

		if (soloNumeros(pEmpleado)) {
			verificar = true;
		} else {
			throw new ExcepcionNumero("Señor usuario ingreso un caracter no valido.\nPor favor ingrese solo numeros");
		}
		return verificar;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the nEmpleados
	 */
	public String getnEmpleados() {
		return nEmpleados;
	}

	/**
	 * @param nEmpleados the nEmpleados to set
	 */
	public void setnEmpleados(String nEmpleados) {
		this.nEmpleados = nEmpleados;
	}

}
