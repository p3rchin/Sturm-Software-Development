/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model.persistence;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import co.edu.unbosque.model.Baloto;
import co.edu.unbosque.model.SuperAstro;

/**
 * Clase BalotoDAO.
 * 
 * La clase sirve para realizar los diferentes m�todos para modificar, eliminar,
 * mostrar y editar lo que se est� agregando en los diferentes archivos.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class BalotoDAO {
	/*
	 * archivo es de tipo Archivo.
	 */
	private Archivo archivo;

	/**
	 * Este es el constructor espec�fico de la clase donde recibe como par�metro un
	 * archivo.
	 * <b>pre</b> Debe existir el par�metro del archivo para crear el constructor espec�fico.<br>
	 * <b>post</b> Se inicializa el archivo junto con el m�todo de las
	 * invariantes.<br>
	 * 
	 * @param archivo es de tipo Archivo: archivo debe verificar si existe o no,
	 *                escribir en �l.
	 */
	public BalotoDAO(Archivo archivo) {

		this.archivo = archivo;
	}
	/**
	 * Constructor vac�o de la clase.
	 */
	BalotoDAO() {

	}
	/**
	 * Este m�todo tipo Baloto hace la b�squeda dentro de los par�metros del
	 * arraylist y la b�squeda se realiza con la c�dula. <b>pre</b> Deben estar los
	 * par�metros para realizar la busqueda.<br>
	 * <b>post</b> Se encuentra el usuario con la c�dula indicada dentro del
	 * arraylist<br>
	 * 
	 * @param pCedula     es de tipo String: pCedula debe ser != de null y != de " ".
	 * @param alBaloto es de tipo ArrayList con par�metro Baloto: alBaloto
	 *                    debe ser != de null.
	 * @return a la varibale encontrado para mandarlo al objeto y buscarlo.
	 */
	public Baloto buscarBaloto(String pCedula, ArrayList<Baloto> alBaloto) {

		Baloto encontrado = null;

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
	 * Este m�todo agrega una apuesta de baloto en el archivo y en el arraylist 
	 * con los diferentes par�metros que se le est�n indicando.
	 * <b>pre</b>Deben estar los par�metros indicados para poder agregar el apostador.<br>
	 * <b>post</b> Se agrega el apostador al ArrayList y al archivo si el resultado
	 * es verdadero. Si no, es falso y por lo tanto no se agrega.<br>
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de vac�o.
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de vac�o.
	 * @param pFecha es de tipo Date: pFecha debe tener la fecha del d�a tipo dd/MM/yyyy.
	 * @param pValorApuesta es de tipo String: pValorApuesta debe ser != de null y != de vac�o.
	 * @param pPremio es de tipo String: pPremio debe ser != de null y != de vac�o.
	 * @param numero es de tipo String: numero debe ser != de null y != de vac�o.
	 * @param alBaloto es de tipo ArrayList con par�metro Baloto: alBaloto debe ser != de null.
	 * @param file es de tipo File: file debe verificar si existe, si no, debe crear el file.
	 */
	public void agregarBaloto(String pNombre, String pCedula, Date pFecha, String pValorApuesta, String pPremio,
			String numero, ArrayList<Baloto> alBaloto, File file) {

		Baloto agregar = new Baloto(pNombre, pCedula, pFecha, pValorApuesta, pPremio, numero);

		alBaloto.add(agregar);
		archivo.escribirEnArchivoBaloto(alBaloto, file);

	}
	
	/**
	 * M�todo que se usa para eliminar la apuesta del baloto buscando la c�dula del apostador
	 * en el ArrayList.
	 * <b>pre</b>Deben estar los par�metros indicados para poder eliminar la apuesta.<br>
	 * <b>post</b> Se elimina la apuesta del baloto mediante la c�dula ingresada si el valor es verdadero.
	 * Si no, no se elimina ya que no encontr� la c�dula. <br>
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de " ".
	 * @param alBaloto es de tipo ArrayList con par�metro Baloto: alBaloto debe ser != de null.
	 * @param file es de tipo File: file debe veriicar si existe, si no, debe crear el file.
	 * @return la variable donde verifica si existe la c�dula ingresada o no existe.
	 */
	public boolean eliminarBaloto(String pCedula, ArrayList<Baloto> alBaloto, File file) {

		boolean verificar = false;

		try {

			Baloto eliminar = buscarBaloto(pCedula, alBaloto);

			if (buscarBaloto(pCedula, alBaloto) != null) {

				alBaloto.remove(eliminar);
				file.delete();
				file.createNewFile();
				archivo.escribirEnArchivoBaloto(alBaloto, file);
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
	 * Este m�todo edita el baloto con los par�metros necesarios para realizar el procedimiento
	 * <b>pre</b>Deben estar los par�metros indicados para poder editar el baloto.<br>
	 * <b>post</b> Se edita el baloto en el ArrayList y lo edita en el archivo si
	 * es verdadero. Si no, es falso por lo tanto no se edita.<br>
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de vac�o.
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de vac�o.
	 * @param pFecha es de tipo Date: pFecha debe tener la fecha del d�a tipo dd/MM/yyyy.
	 * @param pValorApuesta es de tipo String: pValorApuesta debe ser != de null y != de vac�o.
	 * @param pPremio es de tipo String: pPremio debe ser != de null y != de vac�o.
	 * @param pNumero es de tipo String: pNumero debe ser != de null y != de vac�o.
	 * @param alBaloto es de tipo ArrayList con par�metro Baloto: alBaloto debe ser != de null.
	 * @param file es de tipo File: file debe veriicar si existe, si no, debe crear el file.
	 * @return la variable para verificar si encontr� la c�dula.
	 */
	public boolean editarBaloto(String pNombre, String pCedula, Date pFecha, String pValorApuesta, String pPremio,
			String pNumero, ArrayList<Baloto> alBaloto, File file) {

		boolean encontrado = false;

		for (int i = 0; i < alBaloto.size(); i++) {

			if (alBaloto.get(i).getCedula().equals(pCedula)) {

				alBaloto.get(i).setSede(pNombre);
				alBaloto.get(i).setFecha(pFecha);
				alBaloto.get(i).setValorApuesta(pValorApuesta);
				alBaloto.get(i).setPremio(pPremio);
				alBaloto.get(i).setNumero(pNumero);

				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				archivo.escribirEnArchivoBaloto(alBaloto, file);
				encontrado = true;
				break;
			} else {
				encontrado = false;
			}

		}
		return encontrado;
	}

	/**
	 * Este m�todo permite ver el baloto que se quiere buscar por medio de la c�dula.
	 * <b>pre</b>Deben estar los par�metros indicados para poder buscar y mostrar el baloto.<br>
	 * <b>post</b> Se le presenta al usuario el baloto que ha decidido buscar.<br>
	 * @param alBaloto es de tipo ArrayList con par�metro Baloto: alBaloto debe ser != de null.
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de vac�o.
	 * @return la variable String para mostrar el baloto que se ha buscado.
	 */
	public String verBaloto(ArrayList<Baloto> alBaloto, String pCedula) {

		String texto = "";

		Baloto mostrar = buscarBaloto(pCedula, alBaloto);

		for (int i = 0; i < alBaloto.size(); i++) {

			if (alBaloto.get(i).equals(mostrar)) {

				texto = ("Sede: " + alBaloto.get(i).getSede() + "\n" + "Cedula: " + alBaloto.get(i).getCedula() + "\n"
						+ "Fecha: " + alBaloto.get(i).getFecha() + "\n" + "Valor de la apuesta: "
						+ alBaloto.get(i).getValorApuesta() + "\n" + alBaloto.get(i).getPremio() + "\n" + "Numero: "
						+ alBaloto.get(i).getNumero() + "\n\n");
			}
		}

		return texto;

	}

	/**
	 * Este m�todo mostrar� el �ltimo baloto agregado para realizar la apuesta.
	 * <b>pre</b>Deben estar los par�metros indicados para poder buscar y mostrar el baloto.<br>
	 * <b>post</b> Se le presenta al usuario el �ltimo baloto que se ha registrado.<br>
	 * @param alBaloto es de tipo ArrayList con par�metro Baloto: alBaloto debe ser != de null.
	 * @param pPosicion es de tipo int: pPosicion debe ser != de 0.
	 * @return la variable String para mostrar el �ltimo baloto que se ha registrado.
	 */
	public String verBalotoUltimo(ArrayList<Baloto> alBaloto, int pPosicion) {

		String texto = "";
		int numeroFactura = pPosicion;
		int posicion = pPosicion - 1;

		texto = ("-----------------Factura de venta---------------------\n\n" + "N� de Factura" + numeroFactura + "\n\n"
				+ "Sede: " + alBaloto.get(posicion).getSede() + "\n" + "Cedula: " + alBaloto.get(posicion).getCedula()
				+ "\n" + "Fecha: " + alBaloto.get(posicion).getFecha() + "\n" + "Valor de la apuesta: " + "PREMIO:\n"
				+ alBaloto.get(posicion).getValorApuesta() + "\n" + alBaloto.get(posicion).getPremio() + "\n"
				+ "Numero: " + alBaloto.get(posicion).getNumero() + "\n\n"
				+ "-----------------------------------------------------" + "\n");

		return texto;

	}

	/**
	 * Este m�todo permite ver la cantidad total de balotos que se han registrado hasta el momento.
	 * <b>pre</b>Deben estar los par�metros indicados para mostrar el total.<br>
	 * <b>post</b> Se le presenta al usuario la cantidad total de balotos registrados.<br>
	 * @param alBaloto es de tipo ArrayList con par�metro Baloto: alBaloto debe ser != de null. 
	 * @return la variable String para mostrar el total de balotos.
	 */
	public String verBalotoTotal(ArrayList<Baloto> alBaloto) {

		String texto = "";

		for (int i = 0; i < alBaloto.size(); i++) {

			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			formateador.setLenient(false);
			String pFecha = formateador.format(alBaloto.get(i).getFecha());

			texto += ("Sede: " + alBaloto.get(i).getSede() + "\n" + "Cedula: " + alBaloto.get(i).getCedula() + "\n"
					+ "Fecha: " + alBaloto.get(i).getFecha() + "\n" + "Valor de la apuesta: "
					+ alBaloto.get(i).getValorApuesta() + "\n" + alBaloto.get(i).getPremio() + "\n" + "Numero: "
					+ alBaloto.get(i).getNumero() + "\n\n");

		}

		return texto;

	}

}
