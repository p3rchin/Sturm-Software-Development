/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import co.edu.unbosque.model.SuperAstro;

import java.util.ArrayList;
/**
 * Clase SuperAstroDAO.
 * 
 * La clase sirve para realizar los diferentes m�todos para modificar, eliminar,
 * mostrar y editar lo que se est� agregando en los diferentes archivos.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class SuperAstroDAO {
	/*
	 * archivo es de tipo Archivo.
	 */
	private Archivo archivo;
	/**
	 * Este es el constructor espec�fico de la clase donde recibe como par�metro un
	 * archivo. 
	 * <b>pre</b> Debe existir el par�metro del archivo para crear el constructor espec�fico.<br>
	 * <b>post</b> Se inicializa el archivo.<br>
	 * 
	 * @param archivo es de tipo Archivo: archivo debe verificar si existe o no,
	 *                escribir en �l.
	 */
	public SuperAstroDAO(Archivo archivo) {

		this.archivo = archivo;
	}
	/**
	 * Constructor vac�o de la clase.
	 */
	SuperAstroDAO() {

	}

	/**
	 * Este m�todo tipo SuperAstro hace la b�squeda dentro de los par�metros del
	 * arraylist y la b�squeda se realiza con la c�dula.
	 * <b>pre</b> Deben estar los par�metros para realizar la busqueda.<br>
	 * <b>post</b> Se encuentra el usuario con la c�dula indicada dentro del
	 * arraylist<br>
	 * @param pCedula pCedula es de tipo String: pCedula debe ser != de null y != de " ".
	 * @param alSuperAstro es un ArrayList con par�metro SuperAstro: alSuperAstro debe ser != de null.  
	 * @return a la varibale encontrado para mandarlo al objeto y buscarlo.
	 */
	public SuperAstro buscarSuperAstro(String pCedula, ArrayList<SuperAstro> alSuperAstro) {

		SuperAstro encontrado = null;

		if (!alSuperAstro.isEmpty()) {

			for (int i = 0; i < alSuperAstro.size(); i++) {

				if (alSuperAstro.get(i).getCedula().equals(pCedula)) {

					encontrado = alSuperAstro.get(i);
				}
			}
		}

		return encontrado;
	}

	/**
	 * Este m�todo agrega una apuesta de Super astro en el archivo y en el arrylist 
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
	 * @param pZodiaco es de tipo String: pZodiaco debe ser != de null y != de vac�o.
	 * @param alSuperAstro alSuperAstro es un ArrayList con par�metro SuperAstro: alSuperAstro debe ser != de null.
	 * @param file es de tipo File: file debe verificar si existe, si no, debe crear el file.
	 */
	public void agregarSuperAstro(String pNombre, String pCedula, Date pFecha, String pValorApuesta, String pPremio,
			String numero, String pZodiaco, ArrayList<SuperAstro> alSuperAstro, File file) {

		SuperAstro agregar = new SuperAstro(pNombre, pCedula, pFecha, pValorApuesta, pPremio, numero, pZodiaco);

		alSuperAstro.add(agregar);
		archivo.escribirEnArchivoSuperAstro(alSuperAstro, file);

	}

	/**
	 * M�todo que se usa para eliminar la apuesta del Supe astro buscando la c�dula del apostador
	 * en el ArrayList.
	 * <b>pre</b>Deben estar los par�metros indicados para poder eliminar la apuesta.<br>
	 * <b>post</b> Se elimina la apuesta del Super Astro mediante la c�dula ingresada si el valor es verdadero.
	 * Si no, no se elimina ya que no encontr� la c�dula. <br>
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de vac�o.
	 * @param alSuperAstro es un ArrayList con par�metro SuperAstro: alSuperAstro debe ser != de null.
	 * @param file es de tipo File: file debe verificar si existe, si no, debe crear el file.
	 * @return la variable donde verifica si existe la c�dula ingresada o no existe.
	 */
	public boolean eliminarSuperAstro(String pCedula, ArrayList<SuperAstro> alSuperAstro, File file) {

		boolean verificar = false;

		try {

			SuperAstro eliminar = buscarSuperAstro(pCedula, alSuperAstro);

			if (buscarSuperAstro(pCedula, alSuperAstro) != null) {

				alSuperAstro.remove(eliminar);
				file.delete();
				file.createNewFile();
				archivo.escribirEnArchivoSuperAstro(alSuperAstro, file);
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
	 * Este m�todo edita una apuesta de Super astro en el archivo y en el arraylist 
	 * con los diferentes par�metros que se le est�n indicando.
	 * <b>pre</b>Deben estar los par�metros indicados para poder editar la apuesta.<br>
	 * <b>post</b> Se edita la apuesta Super Astro al ArrayList y al archivo si el resultado
	 * es verdadero. Si no, es falso y por lo tanto no se agrega.<br>
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de vac�o.
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de vac�o.
	 * @param pFecha es de tipo Date: pFecha debe tener la fecha del d�a tipo dd/MM/yyyy.
	 * @param pValorApuesta es de tipo String: pValorApuesta debe ser != de null y != de vac�o.
	 * @param pPremio es de tipo String: pPremio debe ser != de null y != de vac�o.
	 * @param numero es de tipo String: numero debe ser != de null y != de vac�o.
	 * @param pZodiaco es de tipo String: pZodiaco debe ser != de null y != de vac�o.
	 * @param alSuperAstro alSuperAstro es un ArrayList con par�metro SuperAstro: alSuperAstro debe ser != de null.
	 * @param file es de tipo File: file debe verificar si existe, si no, debe crear el file.
	 * @return la variable para verificar si encontr� la c�dula.
	 */
	public boolean editarSuperAstro(String pNombre, String pCedula, Date pFecha, String pValorApuesta, String pPremio,
			String pNumero, String pZodiaco, ArrayList<SuperAstro> alSuperAstro, File file) {

		boolean encontrado = false;

		for (int i = 0; i < alSuperAstro.size(); i++) {

			if (alSuperAstro.get(i).getCedula().equals(pCedula)) {

				alSuperAstro.get(i).setSede(pNombre);
				alSuperAstro.get(i).setFecha(pFecha);
				alSuperAstro.get(i).setValorApuesta(pValorApuesta);
				alSuperAstro.get(i).setPremio(pPremio);
				alSuperAstro.get(i).setNumero(pNumero);
				alSuperAstro.get(i).setZodiaco(pZodiaco);

				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				archivo.escribirEnArchivoSuperAstro(alSuperAstro, file);
				encontrado = true;
				break;
			} else {
				encontrado = false;
			}

		}
		return encontrado;
	}
	/**
	 * Este m�todo permite ver el Super astro que se quiere buscar por medio de la c�dula.
	 * <b>pre</b>Deben estar los par�metros indicados para poder buscar y mostrar el super astro.<br>
	 * <b>post</b> Se le presenta al usuario el super astro que ha decidido buscar.<br>
	 * @param alSuperAstro es de tipo ArrayList con par�metro SuperAstro: alSuperAstro debe ser != de null.
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de vac�o.
	 * @return la variable String para mostrar el super astro que se ha buscado.
	 */
	public String verSuperAstro(ArrayList<SuperAstro> alSuperAstro, String pCedula) {

		String texto = "";

		SuperAstro mostrar = buscarSuperAstro(pCedula, alSuperAstro);

		for (int i = 0; i < alSuperAstro.size(); i++) {

			if (alSuperAstro.get(i).equals(mostrar)) {

				texto = ("Sede: " + alSuperAstro.get(i).getSede() + "\n" + "Cedula: " + alSuperAstro.get(i).getCedula()
						+ "\n" + "Fecha: " + alSuperAstro.get(i).getFecha() + "\n" + "Valor de la apuesta: "
						+ alSuperAstro.get(i).getValorApuesta() + "\n" + alSuperAstro.get(i).getPremio() + "\n"
						+ "Numero: " + alSuperAstro.get(i).getNumero() + "\n" + "Zodiaco:"
						+ alSuperAstro.get(i).getZodiaco() + "\n" + "------------------------------" + "\n");
			}
		}

		return texto;

	}
	/**
	 * Este m�todo mostrar� el �ltimo super astro agregado para realizar la apuesta.
	 * <b>pre</b>Deben estar los par�metros indicados para poder buscar y mostrar el super astro.<br>
	 * <b>post</b> Se le presenta al usuario el �ltimo super astro que se ha registrado.<br>
	 * @param alSuperAstro es de tipo ArrayList con par�metro SuperAstro: alSuperAstro debe ser != de null.
	 * @param pPosicion es de tipo int: pPosicion debe ser != de 0.
	 * @return la variable String para mostrar el �ltimo super astro que se ha registrado.
	 */
	public String verSuperAstroUltimo(ArrayList<SuperAstro> alSuperAstro, int pPosicion) {

		String texto = "";
		int numeroFactura = pPosicion;
		int posicion = pPosicion - 1;

		texto = ("-----------------Factura de venta---------------------\n\n" + "N� de Factura " + numeroFactura
				+ "\n\n" + "Sede: " + alSuperAstro.get(posicion).getSede() + "\n" + "Cedula: "
				+ alSuperAstro.get(posicion).getCedula() + "\n" + "Fecha: " + alSuperAstro.get(posicion).getFecha()
				+ "\n" + "Valor de la apuesta: " + alSuperAstro.get(posicion).getValorApuesta() + "\n" + "PREMIO:\n"
				+ alSuperAstro.get(posicion).getPremio() + "\n" + "Numero: " + alSuperAstro.get(posicion).getNumero()
				+ "\n" + "Zodiaco: " + alSuperAstro.get(posicion).getZodiaco() + "\n\n"
				+ "-----------------------------------------------------" + "\n");

		return texto;

	}
	/**
	 * Este m�todo permite ver la cantidad total de super astro que se han registrado hasta el momento.
	 * <b>pre</b>Deben estar los par�metros indicados para mostrar el total.<br>
	 * <b>post</b> Se le presenta al usuario la cantidad total de super astro registrados.<br>
	 * @param alSuperAstro es de tipo ArrayList con par�metro SuperAstro: alSuperAstro debe ser != de null. 
	 * @return la variable String para mostrar el total de super astro.
	 * 
	 */
	public String verSuperAstroTotal(ArrayList<SuperAstro> alSuperAstro) {

		String texto = "";

		for (int i = 0; i < alSuperAstro.size(); i++) {

			texto += ("Sede: " + alSuperAstro.get(i).getSede() + "\n" + "Cedula: " + alSuperAstro.get(i).getCedula()
					+ "\n" + "Fecha: " + alSuperAstro.get(i).getFecha() + "\n" + "Valor de la apuesta: "
					+ alSuperAstro.get(i).getValorApuesta() + "\n" + alSuperAstro.get(i).getPremio() + "\n" + "Numero: "
					+ alSuperAstro.get(i).getNumero() + "\n" + "Zodiaco:" + alSuperAstro.get(i).getZodiaco() + "\n"
					+ "------------------------------" + "\n");

		}

		return texto;

	}

}
