/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

import co.edu.unbosque.model.Juego;
/**
 * Clase JuegoDAO.
 * 
 * La clase sirve para realizar los diferentes m�todos para modificar, eliminar,
 * mostrar y editar lo que se est� agrenado en los diferentes archivos.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class JuegoDAO {
	/*
	 * archivo es de tipo Archivo.
	 */
	private Archivo archivo;
	/**
	 * Este es el constructor espec�fico de la clase donde recibe como par�metro un
	 * archivo junto con las invariantes. <b>pre</b> Debe existir el par�metro del
	 * archivo para crear el constructor espec�fico.<br>
	 * <b>post</b> Se inicializa el archivo junto con el m�todo de las
	 * invariantes.<br>
	 * 
	 * @param archivo es de tipo Archivo: archivo debe verificar si existe o no,
	 *                escribir en �l.
	 */
	public JuegoDAO(Archivo archivo) {

		this.archivo = archivo;
	}
	/*
	 * Constructor vac�o de la clase.
	 */
	JuegoDAO() {

	}
	/**
	 * Este m�todo tipo Juego hace la b�squeda dentro de los par�metros del
	 * arraylist y la b�squeda se realiza con nombre del juego. 
	 * <b>pre</b> Deben estar los par�metros para realizar la busqueda.<br>
	 * <b>post</b> Se encuentra el juego con el nombre indicado dentro del
	 * arraylist<br>
	 * 
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de " ".
	 * @param alJuego es de tipo ArrayList con par�metro Juego: alJuego
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
	 * Agrega el juego en en el arraylist que se encuentra en el m�todo y lo escribe 
	 * en el archivo que se ha creado.
	 * <b>pre</b> Debe cumplirse el par�metro en el m�todo para escribir en el archivo.<br>
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
	 * Este m�todo es de tipo booleano el cu�l busca el tipo de juego que desea editar el 
	 * administrador.
	 * <b>pre</b> Debe cumplirse los par�metros en el m�todo para buscar y editar el juego.<br>
	 * <b>post</b> Se edita el juego que el administrador busc�.<br>.
	 * @param pNombre es de tipo String: pNombre debe ser != de vac�o y != de " ".
	 * @param presupuesto es de tipo double: presupuesto debe ser != de 0.
	 * @param alJuego es de tipo ArrayList con par�metro Juego: alJuego debe ser != de null.
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
	 * Este m�todo permite ver el juego que se quiere buscar por medio del nombre.
	 * <b>pre</b>Deben estar los par�metros indicados para poder buscar y mostrar el juego que desea.<br>
	 * <b>post</b> Se le presenta al administrador el baloto que ha decidido buscar.<br>
	 * @param alJuego es de tipo ArrayList con par�metro Juego: alJuego debe ser != de null.
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de vac�o.
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
	 * Este m�todo permite ver la cantidad total de juegos que hay en el arraylist.
	 * <b>pre</b>Deben estar los par�metros indicados para mostrar el total.<br>
	 * <b>post</b> Se le presenta al usuario la cantidad total de juegos registrados.<br>
	 * @param alJuego es de tipo ArrayList con par�metro Juego: alJuego debe ser != de null. 
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
