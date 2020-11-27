/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;
/**
 * Clase Apuesta
 * 
 * Clase donde se agregan los datos de la apuesta que se necesitan para poder
 * guardarlos en las diferentes variables que est�n contenidas en la clase.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
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
	 * Constructor vac�o de la clase.
	 */
	public Apuesta() {

	}

	/**
	 * Este constructor espec�fico crea el objeto Apuesta y contiene los par�metros que se necesitan para su creaci�n.
	 * <b>pre</b> Debe contener los par�metros para crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los par�metros que se le enviaron. <br>
	 * @param sede es de tipo String que contiene la apuesta: sede debe ser != de null y != " ".
	 * @param cedula es de tipo String que contiene el apostador: cedula debe ser != de null y != " ".
	 * @param fecha es de tipo Date que contiene la apuesta: fecha no puede ser de d�as anteriores al d�a actual y posteriores al d�a actual.
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
