/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.model;

/**
 * Clase Sorteo.
 * 
 * Clase tipo interface Sorteo donde contienen los métodos para calcular el
 * número aleatorio.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 *
 */
public interface Sorteo {
	/*
	 * Método de tipo String que calculará el número aleatorio.
	 */
	String calcularAleatorio();

	/*
	 * Método de tipo double que determina el ganador de la apuesta realizada.
	 */
	double determinarGanador();

}
