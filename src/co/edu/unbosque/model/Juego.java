/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * Clase Juego.
 * 
 * Clase donde se agrega el nombre del juego, tipo de juego y presupuesto que se añade al juego.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class Juego implements Serializable{
	/*
	 * serialVersionUID es estatico y de tipo long = a 1L.
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * nombreJuego es de tipo String.
	 */
	private String nombreJuego;
	/*
	 * tipo es de tipo String.
	 */
	private String Tipo;
	/*
	 * presupuesto es de tipo double.
	 */
	private double presupuesto;

	/**
	 * Constructor vacío de la clase
	 */
	public Juego() {
		
	}

	/**
	 * Constructor específico que crea el objeto Juego donde se le ingresan los parámetros.
	 *<b>pre</b> Debe contener los parametros para crear el objeto. <br>
	 * <b>post</b> Se crea el objeto con los parámetros que se le enviaron<br>
	 * @param nombreJuego es de tipo String que pertenece al juego: nombreJuego debe ser != de null y !=  de " ".
	 * @param tipo es de tipo String que pertenece al juego: tipo debe ser != de null y != de " ".
	 * @param presupuesto
	 */
	public Juego(String nombreJuego, String tipo, double presupuesto) {
		super();
		this.nombreJuego = nombreJuego;
		Tipo = tipo;
		this.presupuesto = presupuesto;
	}

	/**
	 * @return the nombreJuego
	 */
	public String getNombreJuego() {
		return nombreJuego;
	}

	/**
	 * @param nombreJuego the nombreJuego to set
	 */
	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return Tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		Tipo = tipo;
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

}
