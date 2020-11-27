/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase Partido.
 * 
 * Clase donde se agrega el resultado, el nombre del equipo local y del equipo
 * visitante, el porcentaje de de cuando gana el equipo al cual se apostó,
 * cuando los esquipos empatan y cuando el equipo apostado pierde. Esta clase
 * extiende de la clase Apuesta.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class Partido extends Apuesta {

	/*
	 * serialVersionUID es estatico y de tipo long = a 1L.
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * resultado es de tipo String.
	 */
	private String resultado;
	/*
	 * equipoLocal es de tipo String.
	 */
	private String equipoLocal;
	/*
	 * equipoVisitante es de tipo String.
	 */
	private String equipoVisitante;
	/*
	 * porcentajeGanador es de tipo float.
	 */
	private float porcentajeGanador;
	/*
	 * porcentajeEmpate es de tipo float.
	 */
	private float porcentajeEmpate;
	/*
	 * porcentajePerdedor es de tipo float.
	 */
	private float porcentajePerdedor;
	/*
	 * presupuesto es de tipo float.
	 */
	private float presupuesto;

	/**
	 * Constructor vacío de la clase.
	 */
	public Partido() {
	}

	/**
	 * Este constructor específico crea el objeto Partido y contiene los parámetros
	 * que se necesitan para su creación. <b>pre</b> Debe contener los parámetros
	 * para crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los parámetros que se le enviaron.
	 * <br>
	 * 
	 * @param sede            es de tipo String que contiene el partido: sede debe
	 *                        ser != de null y != " ".
	 * @param cedula          es de tipo String que contiene el partido: cedula debe
	 *                        ser != de null y != " ".
	 * @param fecha           es de tipo Date que contiene el partido: fecha no
	 *                        puede ser de días anteriores al día actual y
	 *                        posteriores al día actual.
	 * @param valorApuesta    es de tipo String que contiene el partido:
	 *                        valorApuesta debe ser != de null y != de " ".
	 * @param premio          es de tipo String que contiene el partido: premio debe
	 *                        ser != de null y != de " ".
	 * @param resultado       es de tipo String que contiene el partido: resultado
	 *                        debe ser != de null y != de " ".
	 * @param equipoLocal     es de tipo String que contiene el partido: equipoLocal
	 *                        debe ser != de null y != de " ".
	 * @param equipoVisitante es de tipo String que contiene el partido:
	 *                        equipoVisitante debe ser != de null y != de " ".
	 */
	public Partido(String sede, String cedula, Date fecha, String valorApuesta, String premio, String resultado,
			String equipoLocal, String equipoVisitante) {
		super(sede, cedula, fecha, valorApuesta, premio);

		this.resultado = resultado;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;

	}

	/**
	 * Este constructor específico crea el objeto partido con los parámetros que
	 * contiene la clase. <b>pre</b> Debe contener los parámetros para crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los parámetros que se le enviaron.
	 * <br>
	 * 
	 * @param equipoLocal        es de tipo String que contiene el partido:
	 *                           equipoLocal debe ser != de null y != de " ".
	 * @param equipoVisitante    es de tipo String que contiene el partido:
	 *                           equipoVisitante debe ser != de null y != de " ".
	 * @param porcentajeGanador  es de tipo float que contiene el partido:
	 *                           porcentajeGanador debe ser != 0.
	 * @param porcentajeEmpate   es de tipo float que contiene el partido:
	 *                           porcentajeEmpate debe ser != 0.
	 * @param porcentajePerdedor es de tipo float que contiene el partido:
	 *                           porcentajePerdedor debe ser != 0.
	 */
	public Partido(String equipoLocal, String equipoVisitante, float porcentajeGanador, float porcentajeEmpate,
			float porcentajePerdedor, float presupuesto) {

		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.porcentajeGanador = porcentajeGanador;
		this.porcentajeEmpate = porcentajeEmpate;
		this.porcentajePerdedor = porcentajePerdedor;
		this.presupuesto = presupuesto;
	}

	/**
	 * Este método recibe un parámetro de tipo String para verificar que tenga
	 * números. <b>pre</b>El parámetro que recibe debe contener solo números.</br>
	 * <b>post</b> Si el parámetro que se recibe contiene solo números la excepción
	 * está correcta. Si no, el método mostrará la excepción que se presenta en el
	 * método.<br>
	 * 
	 * @param numero es de tipo String: numero debe ser != de null y != de " ".
	 * @return la variable que tiene el método de tipo booleano para verficar si
	 *         contiene solo números.
	 * @throws ExcepcionApuesta que se utiliza en el método.
	 */
	public boolean excepcionApuesta(String numero) throws ExcepcionApuesta {
		boolean verificar = true;

		if (numero.trim().matches("[0-9]*")) {
			verificar = false;

		} else {
			throw new ExcepcionApuesta("Ingresaste una apuesta errónea.");
		}
		return verificar;
	}
	
	/**
	 * Este método es para determinar el ganador del partido al cual se ha apostado.
	 * <b>pre</b> Debe contener los parametros de número para buscar el ganador del partido. <br>
	 * <b>post</b> Si se encuentra el ganador al partido que apostó, se 
	 * mostrará si es el ganador. Si no, la variable retornará un valor vacío.<br>
	 * @param pLocal es de tipo String: pLocal debe ser != null y != de " ".
	 * @param pVisitante es de tipo String: pVisitante debe ser != null y != de " ".
	 * @param resultado es de tipo String: resultado debe ser != null y != de " ".
	 * @param alPartido es de tipo ArrayList: alPartido debe ser != null.
	 * @return la variable de verificar retorna si encuentra el ganador.
	 */
	public String determinarGanador2(String pLocal, String pVisitante, String resultado, ArrayList<Partido> alPartido) {

		String verificar = "";

		for (int i = 0; i < alPartido.size(); i++) {

			if (pLocal.equals(alPartido.get(i).getEquipoLocal())
					&& pVisitante.equals(alPartido.get(i).getEquipoVisitante())
					&& resultado.equals(alPartido.get(i).getResultado())) {

				verificar = alPartido.get(i).getCedula();
			}

		}

		return verificar;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the equipoLocal
	 */
	public String getEquipoLocal() {
		return equipoLocal;
	}

	/**
	 * @param equipoLocal the equipoLocal to set
	 */
	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	/**
	 * @return the equipoVisitante
	 */
	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	/**
	 * @param equipoVisitante the equipoVisitante to set
	 */
	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	/**
	 * @return the porcentajeGanador
	 */
	public float getPorcentajeGanador() {
		return porcentajeGanador;
	}

	/**
	 * @param porcentajeGanador the porcentajeGanador to set
	 */
	public void setPorcentajeGanador(float porcentajeGanador) {
		this.porcentajeGanador = porcentajeGanador;
	}

	/**
	 * @return the porcentajeEmpate
	 */
	public float getPorcentajeEmpate() {
		return porcentajeEmpate;
	}

	/**
	 * @param porcentajeEmpate the porcentajeEmpate to set
	 */
	public void setPorcentajeEmpate(float porcentajeEmpate) {
		this.porcentajeEmpate = porcentajeEmpate;
	}

	/**
	 * @return the porcentajePerdedor
	 */
	public float getPorcentajePerdedor() {
		return porcentajePerdedor;
	}

	/**
	 * @param porcentajePerdedor the porcentajePerdedor to set
	 */
	public void setPorcentajePerdedor(float porcentajePerdedor) {
		this.porcentajePerdedor = porcentajePerdedor;
	}

	/**
	 * @return the presupuesto
	 */
	public float getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @param presupuesto the presupuesto to set
	 */
	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}

}
