/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

import co.edu.unbosque.model.Partido;
import co.edu.unbosque.model.SuperAstro;
/**
 * Clase PartidoDAO.
 * 
 * La clase sirve para realizar los diferentes m�todos para modificar, eliminar,
 * mostrar y editar lo que se est� agregando en los diferentes archivos.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class PartidoDAO {
	/*
	 * archivo es de tipo Archivo.
	 */
	private Archivo archivo;
	/**
	 * Este es el constructor espec�fico de la clase donde recibe como par�metro un
	 * archivo. <b>pre</b> Debe existir el par�metro del
	 * archivo para crear el constructor espec�fico.<br>
	 * <b>post</b> Se inicializa el archivo.<br>
	 * 
	 * @param archivo es de tipo Archivo: archivo debe verificar si existe o no,
	 *                escribir en �l.
	 */
	public PartidoDAO(Archivo archivo) {

		this.archivo = archivo;
	}

	/**
	 * Constructor vac�o de la clase
	 */
	PartidoDAO() {

	}
	/**
	 * Este m�todo tipo Partido hace la b�squeda dentro de los par�metros del
	 * arraylist y la b�squeda se realiza con la c�dula registrada. 
	 * <b>pre</b> Deben estar los par�metros para realizar la busqueda.<br>
	 * <b>post</b> Se encuentra el juego con la c�dula indicado dentro del
	 * arraylist.<br>
	 * 
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de " ".
	 * @param alBaloto es de tipo ArrayList con par�metro Partido: alBaloto
	 *                    debe ser != de null.
	 * @return a la varibale encontrado para mandarlo al objeto y buscarlo.
	 */
	public Partido buscarPartido(String pCedula, ArrayList<Partido> alBaloto) {

		Partido encontrado = null;

		if (!alBaloto.isEmpty()) {

			for (int i = 0; i < alBaloto.size(); i++) {

				if (alBaloto.get(i).getCedula().equals(pCedula)) {

					encontrado = alBaloto.get(i);
				}
			}
		}

		return encontrado;
	}

	/**
	 * M�todo que agrega el partido que el usuario ha registrado para realizar su apuesta.
	 * <b>pre</b>Deben estar los par�metros indicados para poder agregar el partido.<br>
	 * <b>post</b> Se agrega el partido al ArrayList y al archivo si el resultado
	 * es verdadero. Si no, es falso y por lo tanto no se agrega.<br>
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de " ".
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de " ".
	 * @param pFecha es de tipo Date: fecha es la fecha del d�a.
	 * @param pValorApuesta es de tipo String: pValorApuesta debe ser != de null y != de " ".
	 * @param pPremio es de tipo String: pPremio debe ser != de null y != de " ".
	 * @param pResultado es de tipo String: pResultado debe ser != de null y != de " ".
	 * @param pLocal es de tipo String: pLocal debe ser != de null y != de " ".
	 * @param pVisitante es de tipo String: pVisitante debe ser != de null y != de " ".
	 * @param alPartido es de tipo ArrayList con par�metro Partido: alPartido debe ser != de null.
	 * @param file es de tipo File: file debe existir.
	 */
	public void agregarPartido(String pNombre, String pCedula, Date pFecha, String pValorApuesta, String pPremio,
			String pResultado, String pLocal, String pVisitante, ArrayList<Partido> alPartido, File file) {

		Partido agregar = new Partido(pNombre, pCedula, pFecha, pValorApuesta, pPremio, pResultado, pLocal, pVisitante);

		alPartido.add(agregar);
		archivo.escribirEnArchivoPartido(alPartido, file);

	}
	/**
	 * M�todo que se usa para eliminar la apuesta del partido buscando la c�dula del apostador
	 * en el ArrayList.
	 * <b>pre</b>Deben estar los par�metros indicados para poder eliminar la apuesta.<br>
	 * <b>post</b> Se elimina la apuesta del partido mediante la c�dula ingresada si el valor es verdadero.
	 * Si no, no se elimina ya que no encontr� la c�dula. <br>
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de " ".
	 * @param alPartido es de tipo ArrayList con par�metro Partido: alPartido debe ser != de null.
	 * @param file es de tipo File: file debe veriicar si existe, si no, debe crear el file.
	 * @return la variable donde verifica si existe la c�dula ingresada o no existe.
	 */
	public boolean eliminarPartido(String pCedula, ArrayList<Partido> alPartido, File file) {

		boolean verificar = false;

		try {

			Partido eliminar = buscarPartido(pCedula, alPartido);

			if (buscarPartido(pCedula, alPartido) != null) {

				alPartido.remove(eliminar);
				file.delete();
				file.createNewFile();
				archivo.escribirEnArchivoPartido(alPartido, file);
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
	 *  * Este m�todo edita la apuesta del partido con los par�metros necesarios para realizar el procedimiento
	 * <b>pre</b>Deben estar los par�metros indicados para poder editar el partido para la apuesta.<br>
	 * <b>post</b> Se edita el partido en el ArrayList y lo edita en el archivo si
	 * es verdadero. Si no, es falso por lo tanto no se edita.<br>
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de " ".
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de " ".
	 * @param pFecha es de tipo Date: fecha es la fecha del d�a.
	 * @param pValorApuesta es de tipo String: pValorApuesta debe ser != de null y != de " ".
	 * @param pPremio es de tipo String: pPremio debe ser != de null y != de " ".
	 * @param pResultado es de tipo String: pResultado debe ser != de null y != de " ".
	 * @param pLocal es de tipo String: pLocal debe ser != de null y != de " ".
	 * @param pVisitante es de tipo String: pVisitante debe ser != de null y != de " ".
	 * @param alPartido es de tipo ArrayList con par�metro Partido: alPartido debe ser != de null.
	 * @param file es de tipo File: file debe existir.
	 * @return la variable para verificar si encontr� la c�dula.
	 */
	public boolean editarPartido(String pNombre, String pCedula, Date pFecha, String pValorApuesta, String pPremio,
			String pResultado, String pLocal, String pVisitante, ArrayList<Partido> alPartido, File file) {

		boolean encontrado = false;

		for (int i = 0; i < alPartido.size(); i++) {

			if (alPartido.get(i).getCedula().equals(pCedula)) {

				alPartido.get(i).setSede(pNombre);
				alPartido.get(i).setFecha(pFecha);
				alPartido.get(i).setValorApuesta(pValorApuesta);
				alPartido.get(i).setPremio(pPremio);
				alPartido.get(i).setResultado(pResultado);
				alPartido.get(i).setEquipoLocal(pLocal);
				alPartido.get(i).setEquipoVisitante(pVisitante);

				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				archivo.escribirEnArchivoPartido(alPartido, file);
				encontrado = true;
				break;
			} else {
				encontrado = false;
			}

		}
		return encontrado;
	}
	/**
	 * Este m�todo permite ver el partido que se quiere buscar por medio de la c�dula.
	 * <b>pre</b>Deben estar los par�metros indicados para poder buscar y mostrar el partido.<br>
	 * <b>post</b> Se le presenta al usuario el partido que ha decidido buscar.<br>
	 * @param alPartido es de tipo ArrayList con par�metro Partido: alPartido debe ser != de null.
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de vac�o.
	 * @return la variable String para mostrar el baloto que se ha buscado.
	 */
	public String verPartido(ArrayList<Partido> alPartido, String pCedula) {

		String texto = "";

		Partido mostrar = buscarPartido(pCedula, alPartido);

		for (int i = 0; i < alPartido.size(); i++) {

			if (alPartido.get(i).equals(mostrar)) {

				texto = (alPartido.get(i).getSede() + "\n" + alPartido.get(i).getCedula() + "\n"
						+ alPartido.get(i).getFecha() + "\n" + alPartido.get(i).getValorApuesta() + "\n"
						+ alPartido.get(i).getPremio() + "\n" + alPartido.get(i).getResultado() + "\n"
						+ alPartido.get(i).getEquipoLocal() + "\n" + alPartido.get(i).getEquipoVisitante() + "\n"
						+ "------------------------------" + "\n");
			}
		}

		return texto;

	}
	/**
	 * Este m�todo mostrar� el �ltimo partido agregado para realizar la apuesta.
	 * <b>pre</b>Deben estar los par�metros indicados para poder buscar y mostrar el partido.<br>
	 * <b>post</b> Se le presenta al usuario el �ltimo partido que se ha registrado.<br>
	 * @param alPartido es de tipo ArrayList con par�metro Partido: alPartido debe ser != de null.
	 * @param pPosicion es de tipo int: pPosicion debe ser != de 0.
	 * @return la variable String para mostrar el �ltimo baloto que se ha registrado.
	 */
	public String verPartidoUltimo(ArrayList<Partido> alPartido, int pPosicion) {

		String texto = "";
		int numeroFactura = pPosicion;
		int posicion = pPosicion - 1;

		texto = ("-----------------Factura de venta---------------------\n\n" + "N� de Factura " + numeroFactura
				+ "\n\n" + "Sede: " + alPartido.get(posicion).getSede() + "\n" + "Cedula: "
				+ alPartido.get(posicion).getCedula() + "\n" + "Fecha: " + alPartido.get(posicion).getFecha() + "\n"
				+ "Valor de la apuesta: " + alPartido.get(posicion).getValorApuesta() + "\n" + "PREMIO:\n"
				+ alPartido.get(posicion).getPremio() + "\n" + "Resultado: " + alPartido.get(posicion).getResultado()
				+ "\n" + "Equipo Local: " + alPartido.get(posicion).getEquipoLocal() + "\nVS\n" + "Equipo Visitante: "
				+ alPartido.get(posicion).getEquipoVisitante() + "\n\n"
				+ "-----------------------------------------------------" + "\n");

		return texto;

	}
	/**
	 * Este m�todo permite ver la cantidad total de partidos que se han registrado hasta el momento.
	 * <b>pre</b>Deben estar los par�metros indicados para mostrar el total.<br>
	 * <b>post</b> Se le presenta al usuario la cantidad total de partidos registrados.<br>
	 * @param alPartido es de tipo ArrayList con par�metro Partido: alPartido debe ser != de null. 
	 * @return la variable String para mostrar el total de partidos.
	 */
	public String verPartidoTotal(ArrayList<Partido> alPartido) {

		String texto = "";

		for (int i = 0; i < alPartido.size(); i++) {

			texto = (alPartido.get(i).getSede() + "\n" + alPartido.get(i).getCedula() + "\n"
					+ alPartido.get(i).getFecha() + "\n" + alPartido.get(i).getValorApuesta() + "\n"
					+ alPartido.get(i).getPremio() + "\n" + alPartido.get(i).getResultado() + "\n"
					+ alPartido.get(i).getEquipoLocal() + "\n" + alPartido.get(i).getEquipoVisitante() + "\n"
					+ "------------------------------" + "\n");

		}

		return texto;

	}

}
