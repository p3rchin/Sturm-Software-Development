/*
 * Paquete donde está contenida la clase.
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
 * La clase sirve para realizar los diferentes métodos para modificar, eliminar,
 * mostrar y editar lo que se está agregando en los diferentes archivos.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class BalotoDAO {
	/*
	 * archivo es de tipo Archivo.
	 */
	private Archivo archivo;

	/**
	 * Este es el constructor específico de la clase donde recibe como parámetro un
	 * archivo.
	 * <b>pre</b> Debe existir el parámetro del archivo para crear el constructor específico.<br>
	 * <b>post</b> Se inicializa el archivo junto con el método de las
	 * invariantes.<br>
	 * 
	 * @param archivo es de tipo Archivo: archivo debe verificar si existe o no,
	 *                escribir en él.
	 */
	public BalotoDAO(Archivo archivo) {

		this.archivo = archivo;
	}
	/**
	 * Constructor vacío de la clase.
	 */
	BalotoDAO() {

	}
	/**
	 * Este método tipo Baloto hace la búsqueda dentro de los parámetros del
	 * arraylist y la búsqueda se realiza con la cédula. <b>pre</b> Deben estar los
	 * parámetros para realizar la busqueda.<br>
	 * <b>post</b> Se encuentra el usuario con la cédula indicada dentro del
	 * arraylist<br>
	 * 
	 * @param pCedula     es de tipo String: pCedula debe ser != de null y != de " ".
	 * @param alBaloto es de tipo ArrayList con parámetro Baloto: alBaloto
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
	 * Este método agrega una apuesta de baloto en el archivo y en el arraylist 
	 * con los diferentes parámetros que se le están indicando.
	 * <b>pre</b>Deben estar los parámetros indicados para poder agregar el apostador.<br>
	 * <b>post</b> Se agrega el apostador al ArrayList y al archivo si el resultado
	 * es verdadero. Si no, es falso y por lo tanto no se agrega.<br>
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de vacío.
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de vacío.
	 * @param pFecha es de tipo Date: pFecha debe tener la fecha del día tipo dd/MM/yyyy.
	 * @param pValorApuesta es de tipo String: pValorApuesta debe ser != de null y != de vacío.
	 * @param pPremio es de tipo String: pPremio debe ser != de null y != de vacío.
	 * @param numero es de tipo String: numero debe ser != de null y != de vacío.
	 * @param alBaloto es de tipo ArrayList con parámetro Baloto: alBaloto debe ser != de null.
	 * @param file es de tipo File: file debe verificar si existe, si no, debe crear el file.
	 */
	public void agregarBaloto(String pNombre, String pCedula, Date pFecha, String pValorApuesta, String pPremio,
			String numero, ArrayList<Baloto> alBaloto, File file) {

		Baloto agregar = new Baloto(pNombre, pCedula, pFecha, pValorApuesta, pPremio, numero);

		alBaloto.add(agregar);
		archivo.escribirEnArchivoBaloto(alBaloto, file);

	}
	
	/**
	 * Método que se usa para eliminar la apuesta del baloto buscando la cédula del apostador
	 * en el ArrayList.
	 * <b>pre</b>Deben estar los parámetros indicados para poder eliminar la apuesta.<br>
	 * <b>post</b> Se elimina la apuesta del baloto mediante la cédula ingresada si el valor es verdadero.
	 * Si no, no se elimina ya que no encontró la cédula. <br>
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de " ".
	 * @param alBaloto es de tipo ArrayList con parámetro Baloto: alBaloto debe ser != de null.
	 * @param file es de tipo File: file debe veriicar si existe, si no, debe crear el file.
	 * @return la variable donde verifica si existe la cédula ingresada o no existe.
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
	 * Este método edita el baloto con los parámetros necesarios para realizar el procedimiento
	 * <b>pre</b>Deben estar los parámetros indicados para poder editar el baloto.<br>
	 * <b>post</b> Se edita el baloto en el ArrayList y lo edita en el archivo si
	 * es verdadero. Si no, es falso por lo tanto no se edita.<br>
	 * @param pNombre es de tipo String: pNombre debe ser != de null y != de vacío.
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de vacío.
	 * @param pFecha es de tipo Date: pFecha debe tener la fecha del día tipo dd/MM/yyyy.
	 * @param pValorApuesta es de tipo String: pValorApuesta debe ser != de null y != de vacío.
	 * @param pPremio es de tipo String: pPremio debe ser != de null y != de vacío.
	 * @param pNumero es de tipo String: pNumero debe ser != de null y != de vacío.
	 * @param alBaloto es de tipo ArrayList con parámetro Baloto: alBaloto debe ser != de null.
	 * @param file es de tipo File: file debe veriicar si existe, si no, debe crear el file.
	 * @return la variable para verificar si encontró la cédula.
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
	 * Este método permite ver el baloto que se quiere buscar por medio de la cédula.
	 * <b>pre</b>Deben estar los parámetros indicados para poder buscar y mostrar el baloto.<br>
	 * <b>post</b> Se le presenta al usuario el baloto que ha decidido buscar.<br>
	 * @param alBaloto es de tipo ArrayList con parámetro Baloto: alBaloto debe ser != de null.
	 * @param pCedula es de tipo String: pCedula debe ser != de null y != de vacío.
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
	 * Este método mostrará el último baloto agregado para realizar la apuesta.
	 * <b>pre</b>Deben estar los parámetros indicados para poder buscar y mostrar el baloto.<br>
	 * <b>post</b> Se le presenta al usuario el último baloto que se ha registrado.<br>
	 * @param alBaloto es de tipo ArrayList con parámetro Baloto: alBaloto debe ser != de null.
	 * @param pPosicion es de tipo int: pPosicion debe ser != de 0.
	 * @return la variable String para mostrar el último baloto que se ha registrado.
	 */
	public String verBalotoUltimo(ArrayList<Baloto> alBaloto, int pPosicion) {

		String texto = "";
		int numeroFactura = pPosicion;
		int posicion = pPosicion - 1;

		texto = ("-----------------Factura de venta---------------------\n\n" + "N° de Factura" + numeroFactura + "\n\n"
				+ "Sede: " + alBaloto.get(posicion).getSede() + "\n" + "Cedula: " + alBaloto.get(posicion).getCedula()
				+ "\n" + "Fecha: " + alBaloto.get(posicion).getFecha() + "\n" + "Valor de la apuesta: " + "PREMIO:\n"
				+ alBaloto.get(posicion).getValorApuesta() + "\n" + alBaloto.get(posicion).getPremio() + "\n"
				+ "Numero: " + alBaloto.get(posicion).getNumero() + "\n\n"
				+ "-----------------------------------------------------" + "\n");

		return texto;

	}

	/**
	 * Este método permite ver la cantidad total de balotos que se han registrado hasta el momento.
	 * <b>pre</b>Deben estar los parámetros indicados para mostrar el total.<br>
	 * <b>post</b> Se le presenta al usuario la cantidad total de balotos registrados.<br>
	 * @param alBaloto es de tipo ArrayList con parámetro Baloto: alBaloto debe ser != de null. 
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
