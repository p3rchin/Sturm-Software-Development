/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase CasaDeApuesta.
 * 
 * Clase donde se agrega el nombre, n�mero de sedes y presupuesto que se a�ade a
 * la casa de apuestas.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class CasaDeApuesta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/*
	 * nombre es de tipo String.
	 */
	private String nombre;
	/*
	 * numeroSedes es de tipo String.
	 */
	private String numeroSedes;
	/*
	 * presupuesto es de tipo String.
	 */
	private String presupuesto;

	/**
	 * Constructor vac�o de la clase.
	 */
	public CasaDeApuesta() {
	}

	/**
	 * Este constructor espec�fico crea el objeto CasaDeApuesta y contiene los
	 * par�metros que se necesitan para su creaci�n. 
	 * <b>pre</b> Debe contener los par�metros para crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los par�metros que se le enviaron. <br>
	 * 
	 * @param nombre      tipo String de la casa de apuesta: nombre debe ser != de
	 *                    null y != " ".
	 * @param numero      tipo String de la casa de apuesta: numero debe ser != de
	 *                    null y != " ".
	 * @param presupuesto tipo String de la casa de apuesta: debe ser != de null y
	 *                    != " ".
	 */
	public CasaDeApuesta(String nombre, String numero, String presupuesto) {
		super();
		this.nombre = nombre;
		this.numeroSedes = numero;
		this.presupuesto = presupuesto;
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
	 * Este m�todo recibe un par�metro tipo String para verificar que solo
	 * contenga n�meros. 
	 * <b>pre</b> El par�metro String que se recibe debe contener solo n�meros.<br>
	 * <b>post</b> Si el par�metro que se recibe contiene solo n�meros la excepci�n
	 * est� correcta. Si no, el m�todo mostrar� la excepci�n que se presenta en el
	 * m�todo.<br>
	 * @param pPresupuesto es de tipo String que contiene el presupuesto de la casa
	 *                     de apuestas: pPresupuesto debe ser != null y != de " ".
	 * @return La variable que se contiene en el m�todo de tipo boolean y que
	 *         verifica si se contiene solo n�meros.
	 * @throws ExcepcionNumero es la excepci�n que se usa en este m�todo.
	 */
	public boolean excepcionPresupuesto(String pPresupuesto) throws ExcepcionNumero {
		boolean verificar;

		if (soloNumeros(pPresupuesto)) {
			verificar = true;
		} else {
			throw new ExcepcionNumero("Se�or usuario ingreso un caracter no valido.\nPor favor ingrese solo numeros");
		}
		return verificar;
	}
	
	/**
	 * Este m�todo recibe un par�metro tipo String para verificar que solo
	 * contenga n�meros. 
	 * <b>pre</b> El par�metro String que se recibe debe contener solo n�meros.<br>
	 * <b>post</b> Si el par�metro que se recibe contiene solo n�meros la excepci�n
	 * est� correcta. Si no, el m�todo mostrar� la excepci�n que se presenta en el
	 * m�todo.<br>
	 * @param pSede es de tipo String que contiene el n�mero de sedes de la casa
	 *                     de apuestas: pSede debe ser != null y != de " ".
	 * @return La variable que se contiene en el m�todo de tipo boolean y que
	 *         verifica si se contiene solo n�meros.
	 * @throws ExcepcionNumero es la excepci�n que se usa en este m�todo.
	 */
	public boolean excepcionSede(String pSede) throws ExcepcionNumero {
		boolean verificar;

		if (soloNumeros(pSede)) {
			verificar = true;
		} else {
			throw new ExcepcionNumero("Se�or usuario ingreso un caracter no valido.\nPor favor ingrese solo numeros");
		}
		return verificar;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the numero
	 */
	public String getNumeroSedes() {
		return numeroSedes;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumeroSedes(String numero) {
		this.numeroSedes = numero;
	}

	/**
	 * @return the presupuesto
	 */
	public String getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @param presupuesto the presupuesto to set
	 */
	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}

}
