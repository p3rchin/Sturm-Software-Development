/*
 * Paquete donde est� contenida la clase.
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
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class AplMain {

	/**
	 * Este m�todo es de tipo est�tico y hace que el programa funcione con la
	 * variable del controlador. <b>pre</b> Se le agrega la variable del controlador
	 * para llamar los dem�s par�metros all� contenidos. <br>
	 * <b>post</b> Mostrar� el programa completo con lo que contenga el
	 * controlador.<br>
	 * 
	 * @param args es un arreglo de tipo String.
	 * @throws Exception es la excepci�n utilizada en le programa.
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