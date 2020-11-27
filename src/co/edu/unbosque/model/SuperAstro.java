package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase SuperAstro.
 * 
 * Clase SuperAstro donde se encuentra la apuesta del Super Astro, se guarda su
 * n�mero de apuesta, el signo zodiacal para apostar, el porcentaje que se gana
 * de la apuesta y su presupuesto. Esta clase extiende de la clase Apuesta.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 *
 */

public class SuperAstro extends Apuesta implements Sorteo {

	/*
	 * serialVersionUID es estatico y de tipo long = a 1L.
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * numero es de tipo String.
	 */
	private String numero;
	/*
	 * zodiaco es de tipo String.
	 */
	private String zodiaco;
	/*
	 * porcentajenumeros es de tipo float.
	 */
	private float porcentajenumeros;
	/*
	 * porcentajetodo es de tipo String.
	 */
	private String porcentajetodo;
	/*
	 * presupuesto es de tipo double.
	 */
	private double presupuesto;

	/**
	 * Constructor vac�a de la clase.
	 */
	public SuperAstro() {
	}

	/**
	 * Este constructor espec�fico crea el objeto SuperAstro y contiene los
	 * par�metros que se necesitan para su creaci�n. <b>pre</b> Debe contener los
	 * par�metros para crearse. <br>
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
	 * @param numero       es de tipo String que contiene el super astro: numero
	 *                     debe ser debe ser != de null y != " ".
	 * @param zodiaco      es de tipo String que contiene el super astro: zodiaco
	 *                     debe ser debe ser != de null y != " ".
	 */
	public SuperAstro(String sede, String cedula, Date fecha, String valorApuesta, String premio, String numero,
			String zodiaco) {
		super(sede, cedula, fecha, valorApuesta, premio);

		this.numero = numero;
		this.zodiaco = zodiaco;
	}

	/**
	 * Este constructor espec�fico crea el objeto SuperAstro y contiene los
	 * par�metros que se necesitan para su creaci�n. <b>pre</b> Debe contener los
	 * par�metros para crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los par�metros que se le enviaron.
	 * <br>
	 * 
	 * @param numero            es de tipo String que contiene el super astro:
	 *                          numero debe ser debe ser != de null y != " ".
	 * @param zodiaco           es de tipo String que contiene el super astro:
	 *                          zodiaco debe ser debe ser != de null y != " ".
	 * @param porcentajenumeros de tipo float que contiene el super astro:
	 *                          porcentajenumeros debe ser != 0.
	 * @param porcentajetodo    es de tipo String que contiene el super astro:
	 *                          porcentajetodo debe ser debe ser != de null y != "
	 *                          ".
	 * @param presupuesto       es de tipo double que contiene el super astro:
	 *                          presupuesto debe ser != 0.
	 */
	public SuperAstro(float porcentajenumeros, String porcentajetodo, double presupuesto) {

		this.porcentajenumeros = porcentajenumeros;
		this.porcentajetodo = porcentajetodo;
		this.presupuesto = presupuesto;
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

	public boolean excepcionNumero(String numero) throws ExcepcionApuesta {
		boolean verificar = true;

		if (numero.trim().matches("[0-9]")) {
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
	 * Este m�todo genera los n�meros aleatorios y n�meros aleatorios para la
	 * apuesta del super astro. <b>pre</b> Se debe realizar un tipo de apuesta para
	 * generar los n�meros aleatorios y el signo zodialcal aleatorio.<br>
	 * <b>post</b> Se generan los n�meros ganadores del Super Astro.<br>
	 * 
	 * @return la variable resultado de tipo String con los n�meros ganadores y el
	 *         signo ganador.
	 */

	@Override
	public String calcularAleatorio() {
		String resultado = "";
		ArrayList<Integer> alNumeros = new ArrayList<Integer>();
		ArrayList<String> alSignos = new ArrayList<String>();
		alSignos.add("Aries");
		alSignos.add("Tauro");
		alSignos.add("Geminis");
		alSignos.add("Cancer");
		alSignos.add("Leo");
		alSignos.add("Virgo");
		alSignos.add("Libra");
		alSignos.add("Escorpio");
		alSignos.add("Sagitario");
		alSignos.add("Capricornio");
		alSignos.add("Acuario");
		alSignos.add("Piscis");
		int numero = 0;
		for (int i = 0; i < 4; i++) {
			numero = (int) Math.floor(Math.random() * (-1 - 10 + 1) + 10);
			alNumeros.add(numero);
		}
		for (int j = 0; j < alNumeros.size(); j++) {
			if (!resultado.equals("")) {
				resultado += "-";
			}
			resultado += alNumeros.get(j);
		}
		resultado += "-" + alSignos.get((int) Math.floor(Math.random() * (-1 - 12 + 1) + 12));
		return resultado;
	}

	/**
	 * Este m�todo es para determinar el ganador del Super Astro. <b>pre</b> Debe
	 * contener los parametros de n�mero para buscar el ganador del Super Astro.
	 * <br>
	 * <b>post</b> Si se encuentra el ganador con los n�meros que ingres� y el signo
	 * zodiacal, se mostrar� si es el ganador. Si no, la variable retornar� un valor
	 * vac�o.<br>
	 * 
	 * @param pNumero      es de tipo String: pNumero debe ser != de null y != de
	 *                     vac�o.
	 * @param alSuperAstro es de tipo ArrayList: alSuperAstro debe ser != de null.
	 * @return la variable de tipo String para verificar el ganador del Super Astro.
	 */
	public String determinarGanador2(String pZodiaco, String pNumero, ArrayList<SuperAstro> alSuperAstro) {

		String verificar = "";

		for (int i = 0; i < alSuperAstro.size(); i++) {

			if (pNumero.equals(alSuperAstro.get(i).getNumero()) && pZodiaco.equals(alSuperAstro.get(i).getZodiaco())) {

				verificar = alSuperAstro.get(i).getCedula();
			}

		}

		return verificar;
	}

	@Override
	public double determinarGanador() {
		// TODO Auto-generated method stub
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
	 * @return the zodiaco
	 */
	public String getZodiaco() {
		return zodiaco;
	}

	/**
	 * @param zodiaco the zodiaco to set
	 */
	public void setZodiaco(String zodiaco) {
		this.zodiaco = zodiaco;
	}

	/**
	 * @return the porcentajenumeros
	 */
	public float getPorcentajenumeros() {
		return porcentajenumeros;
	}

	/**
	 * @param porcentajenumeros the porcentajenumeros to set
	 */
	public void setPorcentajenumeros(float porcentajenumeros) {
		this.porcentajenumeros = porcentajenumeros;
	}

	/**
	 * @return the porcentajetodo
	 */
	public String getPorcentajetodo() {
		return porcentajetodo;
	}

	/**
	 * @param porcentajetodo the porcentajetodo to set
	 */
	public void setPorcentajetodo(String porcentajetodo) {
		this.porcentajetodo = porcentajetodo;
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
