/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;
/**
 * Clase Apuesta
 * 
 * Clase donde se agregan los datos de la apuesta que se necesitan para poder
 * guardarlos en las diferentes variables que están contenidas en la clase.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class Apuesta implements Serializable {
	/*
	 * serialVersionUID es estatico y de tipo long = a 1L.
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * sede es de tipo String.
	 */
	protected String sede;
	/*
	 * cedula es de tipo String.
	 */
	protected String cedula;
	/*
	 * fecha es de tipo Date.
	 */
	protected Date fecha;
	/*
	 * valorApuesta es de tipo String.
	 */
	protected String valorApuesta;
	/*
	 * premio es de tipo String.
	 */
	protected String premio;
	/*
	 * Constructor vacío de la clase.
	 */
	public Apuesta() {

	}

	/**
	 * Este constructor específico crea el objeto Apuesta y contiene los parámetros que se necesitan para su creación.
	 * <b>pre</b> Debe contener los parámetros para crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los parámetros que se le enviaron. <br>
	 * @param sede es de tipo String que contiene la apuesta: sede debe ser != de null y != " ".
	 * @param cedula es de tipo String que contiene el apostador: cedula debe ser != de null y != " ".
	 * @param fecha es de tipo Date que contiene la apuesta: fecha no puede ser de días anteriores al día actual y posteriores al día actual.
	 * @param valorApuesta es de tipo String que contiene la apuesta: valorApuesta debe ser != de null y != de " ".
	 * @param premio es de tipo String que contiene la apuesta: premio debe ser != de null y != " ".
	 */
	public Apuesta(String sede, String cedula, Date fecha, String valorApuesta, String premio) {
		super();
		this.sede = sede;
		this.cedula = cedula;
		this.fecha = fecha;
		this.valorApuesta = valorApuesta;
		this.premio = premio;
	}

	/**
	 * @return the sede
	 */
	public String getSede() {
		return sede;
	}

	/**
	 * @param sede the sede to set
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the valorApuesta
	 */
	public String getValorApuesta() {
		return valorApuesta;
	}

	/**
	 * @param valorApuesta the valorApuesta to set
	 */
	public void setValorApuesta(String valorApuesta) {
		this.valorApuesta = valorApuesta;
	}

	/**
	 * @return the premio
	 */
	public String getPremio() {
		return premio;
	}

	/**
	 * @param premio the premio to set
	 */
	public void setPremio(String premio) {
		this.premio = premio;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
