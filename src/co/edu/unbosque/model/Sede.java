/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * Clase Sede.
 * 
 * Clase donde se agrega la sede donde se esta haciendo la apuesta.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
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
	 * Constructor vac�o de la clase.
	 */
	public Sede() {
	}

	/**
	 * Es el constructor espec�fico donde crea el objeto Sede y contiene los par�metros para su creaci�n.
	 * <b>pre</b> Debe contener los par�metros para crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los par�metros que se le enviaron. <br>
	 * @param ubicacion es de tipo String que contiene la sede: ubicacion debe ser != de null y != de " ".
	 * @param nEmpleados es de tipo String que contiene la sede: nEmpleados debe ser != de null y != de " ".
	 */
	public Sede(String ubicacion, String nEmpleados) {
		super();
		this.ubicacion = ubicacion;
		this.nEmpleados = nEmpleados;
	}

	/**
	 * Este m�todo recibe un String verificando que solo contenga n�meros.
	 * <b>pre</b> El par�metro String debe ser un n�mero.<br>
	 * <b>post</b> Si el metodo se cumple correctamente es porque el String es un
	 * n�mero. Si no, el m�todo retornar� un valor falso.<br>
	 * 
	 * @param pNumero es un String numero: pNumero debe ser != de null y != de " ".
	 * @return es el valor booleano que retorna el m�todo.
	 */
	public boolean soloNumeros(String pNumero) {

		boolean verificar = true;

		if (!pNumero.trim().matches("[0-9]*")) {

			verificar = false;
		}

		return verificar;
	}

	/**
	 * Este m�todo recibe un String verificando que solo contenga letras. 
	 * <b>pre</b> El par�metro que se recibe de tipo String debe ser una palabra.<br>
	 * <b>post</b> Si el m�todo es correcto es porque el String contiene una
	 * palabra. Si no la contiene, el m�todo retorna falso.<br>
	 * @param pLetra es un String de letras: palabra tiene que ser != de null y !=
	 *                de " ".
	 * @return es el valor booleano que retorna el m�todo.
	 */
	public boolean soloLetras(String pLetra) {

		boolean verificar = true;

		if (!pLetra.trim().matches("[a-zA-Z]*")) {

			verificar = false;
		}

		return verificar;
	}
	
	/**
	 * Este m�todo recibe un par�metro tipo String para verificar que solo contenga
	 * letras. 
	 * <b>pre</b> El par�metro String que se recibe debe contener solo
	 * letras.<br>
	 * <b>post</b> Si el par�metro que se recibe contiene solo letras la excepci�n
	 * est� correcta. Si no, el m�todo mostrar� la excepci�n que se presenta en el
	 * m�todo.<br>
	 * 
	 * @param pUbicacion es es de tipo String: pUbicacion debe ser != de null y != de " ".
	 * @return La variable que se contiene en el m�todo de tipo boolean y que
	 *         verifica si se contiene solo letras.
	 * @throws ExcepcionNombre es la excepci�n que se utiliza en este m�todo.
	 */
	public boolean excepcionUbicacion(String pUbicacion) throws ExcepcionNombre {
		boolean verificar;

		if (soloLetras(pUbicacion)) {
			verificar = true;
		} else {
			throw new ExcepcionNombre("Se�or usuario ingreso un caracter no valido.\nPor favor ingrese solo letras");
		}
		return verificar;
	}

	/**
	 *  * Este m�todo recibe un par�metro de tipo String para verificar que tenga n�meros.
	 * <b>pre</b>El par�metro que recibe debe contener solo n�meros.</br>
	 * <b>post</b> Si el par�metro que se recibe contiene solo n�meros la excepci�n
	 * est� correcta. Si no, el m�todo mostrar� la excepci�n que se presenta en el
	 * m�todo.<br>
	 * @param pEmpleado es de tipo String: numero debe ser != de null y != de " ".
	 * @return la variable que tiene el m�todo de tipo booleano para verficar si contiene solo n�meros.
	 * @throws ExcepcionNumero es la excepci�n que se usa en este m�todo.
	 */
	public boolean excepcionEmpleado(String pEmpleado) throws ExcepcionNumero {
		boolean verificar;

		if (soloNumeros(pEmpleado)) {
			verificar = true;
		} else {
			throw new ExcepcionNumero("Se�or usuario ingreso un caracter no valido.\nPor favor ingrese solo numeros");
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
