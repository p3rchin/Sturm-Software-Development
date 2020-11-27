/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Clase AplMain.
 *  
 * Esta clase es para poder empezar el programa que se ha creado
 * de la casa de apuestas.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class AplMain {

	/**
	 * Este método es de tipo estático y hace que el programa funcione con la
	 * variable del controlador. <b>pre</b> Se le agrega la variable del controlador
	 * para llamar los demás parámetros allí contenidos. <br>
	 * <b>post</b> Mostrará el programa completo con lo que contenga el
	 * controlador.<br>
	 * 
	 * @param args es un arreglo de tipo String.
	 * @throws Exception es la excepción utilizada en le programa.
	 */
	public static void main(String[] args) throws Exception {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		Controller control = new Controller();
	}
}