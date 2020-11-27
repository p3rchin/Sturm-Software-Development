/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

import co.edu.unbosque.model.Apostador;

/**
 * Clase ApostadorDAO.
 * 
 * La clase sirve para realizar los diferentes m�todos para modificar, eliminar,
 * mostrar y editar lo que se est� agregando en los diferentes archivos.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class ApostadorDAO {
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
	public ApostadorDAO(Archivo archivo) {

		this.archivo = archivo;
		verificarInvariante();
	}

	/**
	 * Constructor vac�o de la clase.
	 */
	public ApostadorDAO() {

	}

	/**
	 * Este m�todo tipo Apostador hace la busqueda dentro de los par�metros del
	 * arraylist y la b�squeda se realiza con la c�dula. <b>pre</b> Deben estar los
	 * par�metros para realizar la busqueda.<br>
	 * <b>post</b> Se encuentra el usuario con la c�dula indicada dentro del
	 * arraylist<br>
	 * 
	 * @param pCedula     es de tipo String: pCedula debe ser != de null y != de "
	 *                    ". <br>
	 * @param alApostador es de tipo ArrayList con par�metro Apostador: alApostador
	 *                    debe ser != de null.
	 * @return a la varibale encontrado para mandarlo al objeto.
	 */
	public Apostador buscarApostador(String pCedula, ArrayList<Apostador> alApostador) {

		Apostador encontrado = null;

		if (!alApostador.isEmpty()) {

			for (int i = 0; i < alApostador.size(); i++) {

				if (alApostador.get(i).getCedula().equals(pCedula)) {

					encontrado = alApostador.get(i);
				}
			}
		}

		return encontrado;
	}

	/**
	 * Este m�todo agrega al apostador directamente en el archivo y en el arraylist
	 * con los par�metros que se le est�n indicando. <b>pre</b>Deben estar los
	 * par�metros indicados para poder agregar el apostador.<br>
	 * <b>post</b> Se agrega el apostador al ArrayList y al archivo si el resultado
	 * es verdadero. Si no es falso y por lo tanto no se agrega.<br>
	 * 
	 * @param pNombre     es de tipo String: pNombre debe ser != de null y != de "
	 *                    ".
	 * @param pCedula     es de tipo String: pCedula debe ser != de null y != de "
	 *                    ".
	 * @param pSede       es de tipo String: pSede debe ser != de null y != de " ".
	 * @param pDireccion  es de tipo String: pDireccion debe ser != de null y != de
	 *                    " ".
	 * @param pCelular    es de tipo String: pCelular debe ser != de null y != de "
	 *                    ".
	 * @param alApostador es de tipo ArrayList con par�metro Apostador: alApostador
	 *                    debe ser != null.
	 * @param file        es de tipo File: file debe existir.
	 * @return la variable falsa o verdadera para agregar el apostador.
	 */
	public boolean agregarApostador(String pNombre, String pCedula, String pSede, String pDireccion, String pCelular,
			double pGanancias, Date pFecha, ArrayList<Apostador> alApostador, File file) {

		Apostador agregar = new Apostador(pNombre, pCedula, pSede, pDireccion, pCelular, pGanancias, pFecha);

		if (buscarApostador(pCedula, alApostador) == null) {

			alApostador.add(agregar);
			archivo.escribirEnArchivoApostador(alApostador, file);

			return true;

		} else {

			return false;
		}

	}

	/**
	 * M�todo que se usa para eliminar el apostador buscando la c�dula del apostador
	 * en el ArrayList. <b>pre</b>Deben estar los par�metros indicados para poder
	 * eliminar el apostador.<br>
	 * <b>post</b> Se elimina el apostador del ArrayList y lo elimina del archivo es
	 * verdadero. Si no, es falso por lo tanto no se elimina.<br>
	 * 
	 * @param pCedula     es de tipo String: pCedula debe ser != de null y != de "
	 *                    ".
	 * @param alApostador es de tipo ArrayList con par�metro Apostador: alApostador
	 *                    debe ser != null.
	 * @param file        es de tipo File: file debe existir.
	 * @return la variable verificar para saber si est� el apostador o no lo est�
	 */
	public boolean eliminarApostador(String pCedula, ArrayList<Apostador> alApostador, File file) {

		boolean verificar = false;

		try {

			Apostador eliminar = buscarApostador(pCedula, alApostador);

			if (buscarApostador(pCedula, alApostador) != null) {

				alApostador.remove(eliminar);
				file.delete();
				file.createNewFile();
				archivo.escribirEnArchivoApostador(alApostador, file);
				verificar = true;
			} else {

				verificar = false;
			}
			return verificar;

		} catch (Exception e) {

		}
		return verificar;

	}

	/**
	 * M�todo de editar los datos del apostador, se busca por la c�dula que es lo
	 * �nico que no puede modificar, puede editar su nombre, sede, direcci�n y
	 * celular. <b>pre</b>Deben estar los par�metros indicados para poder editar el
	 * apostador.<br>
	 * <b>post</b> Se edita el apostador en el ArrayList y lo edita en el archivo si
	 * es verdadero. Si no, es falso por lo tanto no se edita.<br>
	 * 
	 * @param pNombre     es de tipo String: pNombre debe ser != de null y != de "
	 *                    ".
	 * @param pCedula     es de tipo String: pCedula debe ser != de null y != de "
	 *                    ".
	 * @param pSede       es de tipo String: pSede debe ser != de null y != de " ".
	 * @param pDireccion  es de tipo String: pDireccion debe ser != de null y != de
	 *                    " ".
	 * @param pCelular    es de tipo String: pCelular debe ser != de null y != de "
	 *                    ".
	 * @param alApostador es de tipo ArrayList con par�metro Apostador: alApostador
	 *                    debe ser != null.
	 * @param file        es de tipo File: file debe existir.
	 * @return la variable de encontrado es falsa o verdadera para editar el
	 *         apostador.
	 */
	public boolean editarApostador(String pNombre, String pCedula, String pSede, String pDireccion, String pCelular,
			ArrayList<Apostador> alApostador, File file) {

		boolean encontrado = false;

		for (int i = 0; i < alApostador.size(); i++) {

			if (alApostador.get(i).getCedula().equals(pCedula)) {

				alApostador.get(i).setNombre(pNombre);
				alApostador.get(i).setSede(pSede);
				alApostador.get(i).setDireccion(pDireccion);
				alApostador.get(i).setCelular(pCelular);

				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				archivo.escribirEnArchivoApostador(alApostador, file);
				encontrado = true;
				break;
			} else {
				encontrado = false;
			}

		}
		return encontrado;
	}

	/**
	 * Este m�todo edita la ganancia del apostador, la busca por medio de la c�dula
	 * y pone la ganacia del apostador. <b>pre</b> Deben estar los par�metros para
	 * poder editar la apuesta.<br>
	 * <b>post</b> Si en la b�squeda del apostador por medio de la c�dula lo
	 * encuentra reescribir� la ganancia de sus apuestas. Si no, ser� falso y no
	 * editar� la ganancia.<br>
	 * 
	 * @param pCedula     es de tipo String: pCedula debe ser != de null y != de "
	 *                    ".
	 * @param pGanancia   es de tipo double: pGanancia debe ser != de 0.
	 * @param alApostador es de tipo ArrayList con par�metro de Apostador: debe
	 *                    existir el apostador y ser != de null.
	 * @param file        es de tipo File: file debe ser creado si no existe y si
	 *                    existe, ser eliminado y volverlo a crear.
	 * @return una variable booleana para encontrar el apostador y modificar su
	 *         ganancia.
	 */
	public boolean editarApostadorGanancia(String pCedula, double pGanancia, ArrayList<Apostador> alApostador,
			File file) {

		boolean encontrado = false;

		for (int i = 0; i < alApostador.size(); i++) {

			if (alApostador.get(i).getCedula().equals(pCedula)) {

				alApostador.get(i).setGanancias(alApostador.get(i).getGanancias() + pGanancia);

				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				archivo.escribirEnArchivoApostador(alApostador, file);
				encontrado = true;
				break;
			} else {
				encontrado = false;
			}

		}
		return encontrado;
	}

	/**
	 * M�todo para mostrar el apostador que se ha buscado por medio de la c�dula.
	 * <b>pre</b>Deben estar los par�metros indicados para poder mostrar el
	 * apostador.<br>
	 * <b>post</b> Se busca el apostador con la c�dula indicada que se encuentra en
	 * el ArrayList.<br>
	 * 
	 * @param alApostador es de tipo ArrayList con par�metro Apostador: alApostador
	 *                    debe ser != null.
	 * @param pCedula     es de tipo String: pCedula debe ser != de null y != de "
	 *                    ".
	 * @return la variable de tipo String con los datos del apostador.
	 */
	public String verApostador(ArrayList<Apostador> alApostador, String pCedula) {

		String texto = "";

		Apostador mostrar = buscarApostador(pCedula, alApostador);

		for (int i = 0; i < alApostador.size(); i++) {

			if (alApostador.get(i).equals(mostrar)) {

				texto = (alApostador.get(i).getNombre() + "\n" + alApostador.get(i).getCedula() + "\n"
						+ alApostador.get(i).getSede() + "\n" + alApostador.get(i).getDireccion() + "\n"
						+ alApostador.get(i).getCelular() + "\n" + alApostador.get(i).getGanancias() + "\n"
						+ "------------------------------" + "\n");
			}
		}

		return texto;

	}

	/**
	 * Ver la cantidad de apostadores totales que est�n registrados. <b>pre</b>Deben
	 * estar los par�metros indicados para poder mostrar todos los apostadores.<br>
	 * <b>post</b> Se buscan los apostadores en el ArrayList y se le muestran al
	 * usuario.<br>
	 * 
	 * @param alApostador es de tipo ArrayList con par�metro Apostador: alApostador
	 *                    debe ser != null.
	 * @return la variable tipo String para que se le pueda mostrar al usuario.
	 */
	public String verApostadorTotal(ArrayList<Apostador> alApostador) {

		String texto = "";

		for (int i = 0; i < alApostador.size(); i++) {

			texto = (alApostador.get(i).getNombre() + "\n" + alApostador.get(i).getCedula() + "\n"
					+ alApostador.get(i).getSede() + "\n" + alApostador.get(i).getDireccion() + "\n"
					+ alApostador.get(i).getCelular() + "\n" + alApostador.get(i).getGanancias() + "\n"
					+ "------------------------------" + "\n");

		}

		return texto;

	}

	/**
	 * M�todo que verifica las diferentes invariantes que puedan haber. <b>pre</b>
	 * Debe existir la variable para comprobar en el test.<br>
	 * <b>post</b> En el test se verifica que la invariante se cumpla.<br>
	 */
	private void verificarInvariante() {

		assert archivo != null : "El archivo con el que se va ha trabajar no puede ser null";

	}

}
