/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase Baloto.
 * 
 * Clase donde se agrega el n�mero del baloto que se necesita para poder
 * guardarlo en la variable del baloto que est� contenida en la clase.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class Baloto extends Apuesta implements Sorteo {

	/*
	 * serialVersionUID es estatico y de tipo long = a 1L.
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * numero es de tipo String.
	 */
	private String numero;
	/*
	 * porcentaje4 es de tipo float.
	 */
	private float porcentaje4;
	/*
	 * porcentaje5 es de tipo float.
	 */
	private float porcentaje5;
	/*
	 * porcentaje6 es de tipo String.
	 */
	private String porcentaje6;
	/*
	 * presupuesto es de tipo double.
	 */
	private double presupuesto;

	/**
	 * Constructor vac�o de la clase.
	 */
	public Baloto() {
	}

	/**
	 * Este constructor espec�fico crea el objeto Baloto que extiende de apuesta y
	 * contiene los par�metros que se necesitan para su creaci�n. <b>pre</b> Debe
	 * contener los par�metros para crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los par�metros que se le enviaron.
	 * <br>
	 * 
	 * @param sede         es de tipo String que contiene la apuesta: sede debe ser
	 *                     != de null y != " ".
	 * @param cedula       es de tipo String que contiene el apostador: cedula debe
	 *                     ser != de null y != " ".
	 * @param fecha        es de tipo Date que contiene la apuesta: fecha no puede
	 *                     ser de d�as anteriores al d�a actual y posteriores al d�a
	 *                     actual.
	 * @param valorApuesta es de tipo String que contiene la apuesta: valorApuesta
	 *                     debe ser != de null y != de " ".
	 * @param premio       es de tipo String que contiene la apuesta: premio debe
	 *                     ser != de null y != " ".
	 * @param numero       es de tipo String que contiene el baloto para la apuesta:
	 *                     numero debe ser != de null y != de " ".
	 */
	public Baloto(String sede, String cedula, Date fecha, String valorApuesta, String premio, String numero) {
		super(sede, cedula, fecha, valorApuesta, premio);

		this.numero = numero;
	}

	/**
	 * Se crea el objeto Baloto con los par�metros que necesita para su creaci�n.
	 * <b>pre</b> Debe contener los parametros para crear el objeto. <br>
	 * <b>post</b> Se crea el objeto con los par�metros que se le enviaron.<br>
	 * 
	 * @param numero      es de tipo String que contiene el baloto para la apuesta:
	 *                    numero debe ser != de null y != de " ".
	 * @param porcentaje4 es de tipo float que contiene el baloto: porcentaje4 debe
	 *                    ser != de 0.
	 * @param porcentaje5 es de tipo float que contiene el baloto: porcentaje5 debe
	 *                    ser != de 0.
	 * @param porcentaje6 es de tipo float que contiene el baloto: porcentaje6 debe
	 *                    ser != de 0.
	 * @param presupuesto es de tipo double que contiene el baloto: presupuesto debe
	 *                    ser != de 0.
	 */
	public Baloto(float porcentaje4, float porcentaje5, String porcentaje6, double presupuesto) {
		this.porcentaje4 = porcentaje4;
		this.porcentaje5 = porcentaje5;
		this.porcentaje6 = porcentaje6;
		this.presupuesto = presupuesto;
	}

	/**
	 * Este m�todo recibe un par�metro de tipo String para verificar que tenga
	 * n�meros hasta el 45. <b>pre</b>El par�metro que recibe debe contener solo
	 * n�meros.</br>
	 * <b>post</b> Si el par�metro que se recibe contiene solo n�meros la excepci�n
	 * est� correcta. Si no, el m�todo mostrar� la excepci�n que se presenta en el
	 * m�todo.<br>
	 * 
	 * @param numero es de tipo String: numero debe ser != de null y != de " ".
	 * @return la variable que tiene el m�todo de tipo booleano para verficar si
	 *         contiene solo n�meros.
	 * @throws ExcepcionApuesta que se utiliza en el m�todo.
	 */
	public boolean excepcionNumero(String numero) throws ExcepcionApuesta {
		boolean verificar = true;

		int numero1 = 0;

		if (numero.trim().matches("[0-9]{1,2}")) {

			numero1 = Integer.parseInt(numero);

		} else {
			throw new ExcepcionApuesta("Ingresaste un n�mero de apuesta err�neo.");
		}

		if (numero.trim().matches("[0-9]{1,2}") && numero1 <= 45) {
			verificar = false;

		} else {
			throw new ExcepcionApuesta("Ingresaste un n�mero de apuesta err�neo.");
		}
		return verificar;
	}

	/**
	 * Este m�todo recibe un par�metro de tipo String para verificar que tenga
	 * n�meros. <b>pre</b>El par�metro que recibe debe contener solo n�meros.</br>
	 * <b>post</b> Si el par�metro que se recibe contiene solo n�meros la excepci�n
	 * est� correcta. Si no, el m�todo mostrar� la excepci�n que se presenta en el
	 * m�todo.<br>
	 * 
	 * @param numero es de tipo String: numero debe ser != de null y != de " ".
	 * @return la variable que tiene el m�todo de tipo booleano para verficar si
	 *         contiene solo n�meros.
	 * @throws ExcepcionApuesta que se utiliza en el m�todo.
	 */
	public boolean excepcionApuesta(String numero) throws ExcepcionApuesta {
		boolean verificar = true;

		if (numero.trim().matches("[0-9]*")) {
			verificar = false;

		} else {
			throw new ExcepcionApuesta("Ingresaste una apuesta err�nea.");
		}
		return verificar;
	}

	/**
	 * Este m�todo genera los n�meros aleatorios para el baloto. <b>pre</b> Se debe
	 * realizar un tipo de apuesta para generar los n�meros.<br>
	 * <b>post</b> Se generan los n�meros ganadores del Baloto.<br>
	 * 
	 * @return la variable resultado de tipo String con los n�meros ganadores.
	 */

	@Override
	public String calcularAleatorio() {
		String resultado = "";
		ArrayList<Integer> alNumeros = new ArrayList<Integer>();
		int numero = 0;
		int a = 0;
		for (int i = 0; i < 6; i++) {
			a = 1;
			do {
				numero = (int) Math.floor(Math.random() * (0 - 46 + 1) + 46);
				if (!alNumeros.contains(numero)) {
					alNumeros.add(numero);
					a = 0;
				}

			} while (a == 1);
		}
		for (int j = 0; j < alNumeros.size(); j++) {
			if (!resultado.equals("")) {
				resultado += "-";
			}
			resultado += alNumeros.get(j);
		}
		return resultado;
	}

	/**
	 * Este m�todo es para determinar el ganador de el baloto. <b>pre</b> Debe
	 * contener los parametros de n�mero para buscar el ganador del baloto. <br>
	 * <b>post</b> Si se encuentra el ganador con los n�meros que ingres�, se
	 * mostrar� el si es el ganador. Si no, la variable retornar� un valor
	 * vac�o.<br>
	 * 
	 * @param pNumero  es de tipo String: pNumero debe ser != de null y != de vac�o.
	 * @param alBaloto es de tipo ArrayList: alBaloto debe ser != de null.
	 * @return la variable de tipo String para verificar el ganador de el baloto.
	 */
	public String determinarGanador2(String pNumero, ArrayList<Baloto> alBaloto) {

		String verificar = "";

		for (int i = 0; i < alBaloto.size(); i++) {

			if (pNumero.equals(alBaloto.get(i).getNumero())) {

				verificar = alBaloto.get(i).getCedula();
			}

		}

		return verificar;
	}

	@Override
	public double determinarGanador() {

		return 0;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the porcentaje4
	 */
	public float getPorcentaje4() {
		return porcentaje4;
	}

	/**
	 * @param porcentaje4 the porcentaje4 to set
	 */
	public void setPorcentaje4(float porcentaje4) {
		this.porcentaje4 = porcentaje4;
	}

	/**
	 * @return the porcentaje5
	 */
	public float getPorcentaje5() {
		return porcentaje5;
	}

	/**
	 * @param porcentaje5 the porcentaje5 to set
	 */
	public void setPorcentaje5(float porcentaje5) {
		this.porcentaje5 = porcentaje5;
	}

	/**
	 * @return the porcentaje6
	 */
	public String getPorcentaje6() {
		return porcentaje6;
	}

	/**
	 * @param porcentaje6 the porcentaje6 to set
	 */
	public void setPorcentaje6(String porcentaje6) {
		this.porcentaje6 = porcentaje6;
	}

	/**
	 * @return the presupuesto
	 */
	public double getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @param presupuesto the presupuesto to set
	 */
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
