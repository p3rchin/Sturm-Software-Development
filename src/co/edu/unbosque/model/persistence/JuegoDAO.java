/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

import co.edu.unbosque.model.Juego;
/**
 * Clase JuegoDAO.
 * 
 * La clase sirve para realizar los diferentes métodos para modificar, eliminar,
 * mostrar y editar lo que se está agrenado en los diferentes archivos.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class JuegoDAO {
	/*
	 * archivo es de tipo Archivo.
	 */
	private Archivo archivo;
	/**
	 * Este es el constructor específico de la clase donde recibe como parámetro un
	 * archivo junto con las invariantes. <b>pre</b> Debe existir el parámetro del
	 * archivo para crear el constructor específico.<br>
	 * <b>post</b> Se inicializa el archivo junto con el método de las
	 * invariantes.<br>
	 * 
	 * @param archivo es de tipo Archivo: archivo debe verificar si existe o no,
	 *                escribir en él.
	 */
	public JuegoDAO(Archivo archivo) {

		this.archivo = archivo;
	}
	/*
	 * Constructor vacío de la clase.
	 */
	JuegoDAO() {

	}
	/**
	 * Este método tipo Juego hace la búsqueda dentro de los parámetros del
	 * arraylist y la búsqueda se realiza con nombre del juego. 
	 * <b>pre</b> Deben estar los parámetros para realizar la busqueda.<br>
	 * <b>post</b> Se encuentra el juego con el nombre indicado dentro del
	 * arraylist<br>
	 * 
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de " ".
	 * @param alJuego es de tipo ArrayList con parámetro Juego: alJuego
	 *                    debe ser != de null.
	 * @return a la varibale encontrado para mandarlo al objeto y buscarlo.
	 */
	public Juego buscarJuego(String pNombre, ArrayList<Juego> alJuego) {

		Juego encontrado = null;

		if (!alJuego.isEmpty()) {

			for (int i = 0; i < alJuego.size(); i++) {

				if (alJuego.get(i).getNombreJuego().equals(pNombre)) {

					encontrado = alJuego.get(i);
				}
			}
		}

		return encontrado;
	}

	/**
	 * Agrega el juego en en el arraylist que se encuentra en el método y lo escribe 
	 * en el archivo que se ha creado.
	 * <b>pre</b> Debe cumplirse el parámetro en el método para escribir en el archivo.<br>
	 * <b>post</b> Se agrega el juego en el archivo.<br>.
	 * @param file es de tipo File: file debe verificar que exista el archivo para escribir en 
	 * este, si no, crea el archivo.
	 */
	public void agregarJuego(File file) {

		ArrayList<Juego> alJuego = new ArrayList<Juego>();

		Juego superAstro = new Juego("Superastro", "chance", 0);
		Juego Baloto = new Juego("Baloto", "loteria", 0);
		Juego futbol = new Juego("Bet-Hat-Trick", "deportivo", 0);

		alJuego.add(superAstro);
		alJuego.add(Baloto);
		alJuego.add(futbol);
		archivo.escribirEnArchivoJuego(alJuego, file);

	}

	/**
	 * Este método es de tipo booleano el cuál busca el tipo de juego que desea editar el 
	 * administrador.
	 * <b>pre</b> Debe cumplirse los parámetros en el método para buscar y editar el juego.<br>
	 * <b>post</b> Se edita el juego que el administrador buscó.<br>.
	 * @param pNombre es de tipo String: pNombre debe ser != de vacío y != de " ".
	 * @param presupuesto es de tipo double: presupuesto debe ser != de 0.
	 * @param alJuego es de tipo ArrayList con parámetro Juego: alJuego debe ser != de null.
	 * @param file es de tipo File: file debe verificar que exista el archivo para escribir en 
	 * este, si no, crea el archivo.
	 * @return la variable booleana para encontrar el juego que se quiere modificar.
	 */
	public boolean editarJuego(String pNombre, double presupuesto, ArrayList<Juego> alJuego, File file) {

		boolean encontrado = false;

		for (int i = 0; i < alJuego.size(); i++) {

			if (alJuego.get(i).getNombreJuego().equals(pNombre)) {

				alJuego.get(i).setPresupuesto(presupuesto);

				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				archivo.escribirEnArchivoJuego(alJuego, file);
				encontrado = true;
				break;
			} else {
				encontrado = false;
			}

		}
		return encontrado;
	}
	/**
	 * Este método permite ver el juego que se quiere buscar por medio del nombre.
	 * <b>pre</b>Deben estar los parámetros indicados para poder buscar y mostrar el juego que desea.<br>
	 * <b>post</b> Se le presenta al administrador el baloto que ha decidido buscar.<br>
	 * @param alJuego es de tipo ArrayList con parámetro Juego: alJuego debe ser != de null.
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de vacío.
	 * @return la variable String para mostrar el juego que se ha buscado.
	 */
	public String verJuego(ArrayList<Juego> alJuego, String pNombre) {

		String texto = "";

		Juego mostrar = buscarJuego(pNombre, alJuego);

		for (int i = 0; i < alJuego.size(); i++) {

			if (alJuego.get(i).equals(mostrar)) {

				texto = (alJuego.get(i).getNombreJuego() + "\n" + alJuego.get(i).getTipo() + "\n"
						+ alJuego.get(i).getPresupuesto() + "\n" + "------------------------------" + "\n");
			}
		}

		return texto;

	}
	/**
	 * Este método permite ver la cantidad total de juegos que hay en el arraylist.
	 * <b>pre</b>Deben estar los parámetros indicados para mostrar el total.<br>
	 * <b>post</b> Se le presenta al usuario la cantidad total de juegos registrados.<br>
	 * @param alJuego es de tipo ArrayList con parámetro Juego: alJuego debe ser != de null. 
	 * @return la variable String para mostrar el total de juegos.
	 */
	public String verJuegoTotal(ArrayList<Juego> alJuego) {

		String texto = "";

		for (int i = 0; i < alJuego.size(); i++) {

			texto += (alJuego.get(i).getNombreJuego() + "\n" + alJuego.get(i).getTipo() + "\n"
					+ alJuego.get(i).getPresupuesto() + "\n" + "------------------------------" + "\n");

		}

		return texto;
	}
}
