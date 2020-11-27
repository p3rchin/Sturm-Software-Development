/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model;

/**
 * Clase Sorteo.
 * 
 * Clase tipo interface Sorteo donde contienen los m�todos para calcular el
 * n�mero aleatorio.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 *
 */
public interface Sorteo {
	/*
	 * M�todo de tipo String que calcular� el n�mero aleatorio.
	 */
	String calcularAleatorio();

	/*
	 * M�todo de tipo double que determina el ganador de la apuesta realizada.
	 */
	double determinarGanador();

}
