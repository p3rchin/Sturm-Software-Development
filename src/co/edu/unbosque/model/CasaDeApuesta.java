/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase CasaDeApuesta.
 * 
 * Clase donde se agrega el nombre, número de sedes y presupuesto que se añade a
 * la casa de apuestas.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
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
	 * Constructor vacío de la clase.
	 */
	public CasaDeApuesta() {
	}

	/**
	 * Este constructor específico crea el objeto CasaDeApuesta y contiene los
	 * parámetros que se necesitan para su creación. 
	 * <b>pre</b> Debe contener los parámetros para crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los parámetros que se le enviaron. <br>
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
	 * Este método recibe un parámetro tipo String para verificar que solo
	 * contenga números. 
	 * <b>pre</b> El parámetro String que se recibe debe contener solo números.<br>
	 * <b>post</b> Si el parámetro que se recibe contiene solo números la excepción
	 * está correcta. Si no, el método mostrará la excepción que se presenta en el
	 * método.<br>
	 * @param pPresupuesto es de tipo String que contiene el presupuesto de la casa
	 *                     de apuestas: pPresupuesto debe ser != null y != de " ".
	 * @return La variable que se contiene en el método de tipo boolean y que
	 *         verifica si se contiene solo números.
	 * @throws ExcepcionNumero es la excepción que se usa en este método.
	 */
	public boolean excepcionPresupuesto(String pPresupuesto) throws ExcepcionNumero {
		boolean verificar;

		if (soloNumeros(pPresupuesto)) {
			verificar = true;
		} else {
			throw new ExcepcionNumero("Señor usuario ingreso un caracter no valido.\nPor favor ingrese solo numeros");
		}
		return verificar;
	}
	
	/**
	 * Este método recibe un parámetro tipo String para verificar que solo
	 * contenga números. 
	 * <b>pre</b> El parámetro String que se recibe debe contener solo números.<br>
	 * <b>post</b> Si el parámetro que se recibe contiene solo números la excepción
	 * está correcta. Si no, el método mostrará la excepción que se presenta en el
	 * método.<br>
	 * @param pSede es de tipo String que contiene el número de sedes de la casa
	 *                     de apuestas: pSede debe ser != null y != de " ".
	 * @return La variable que se contiene en el método de tipo boolean y que
	 *         verifica si se contiene solo números.
	 * @throws ExcepcionNumero es la excepción que se usa en este método.
	 */
	public boolean excepcionSede(String pSede) throws ExcepcionNumero {
		boolean verificar;

		if (soloNumeros(pSede)) {
			verificar = true;
		} else {
			throw new ExcepcionNumero("Señor usuario ingreso un caracter no valido.\nPor favor ingrese solo numeros");
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
