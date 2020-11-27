package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

import co.edu.unbosque.model.*;
/**
 * Clase SedeDAO.
 * 
 * La clase sirve para realizar los diferentes m�todos para modificar, eliminar,
 * mostrar y editar lo que se est� agrenado en los diferentes archivos.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class SedeDAO {
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
	public SedeDAO(Archivo archivo) {

		this.archivo = archivo;
	}
	/**
	 * Constructor vac�o de la clase.
	 */
	SedeDAO() {

	}
	/**
	 * Este m�todo tipo Sede hace la b�squeda dentro de los par�metros del
	 * arraylist y la b�squeda se realiza con la ubicaci�n registrada. 
	 * <b>pre</b> Deben estar los par�metros para realizar la b�squeda.<br>
	 * <b>post</b> Se encuentra la sede con la ubicaci�n indicada dentro del
	 * arraylist.<br>
	 * 
	 * @param pUbicacion es de tipo String: pUbicacion debe ser != de null y != de " ".
	 * @param alSede es de tipo ArrayList con par�metro Sede: alSede
	 *                    debe ser != de null.
	 * @return a la varibale encontrado para mandarlo al objeto y buscarlo.
	 */
	public Sede buscarSede(String pUbicacion, ArrayList<Sede> alSede) {

		Sede encontrado = null;

		if (!alSede.isEmpty()) {

			for (int i = 0; i < alSede.size(); i++) {

				if (alSede.get(i).getUbicacion().equals(pUbicacion)) {

					encontrado = alSede.get(i);
				}
			}
		}

		return encontrado;
	}

	/**
	 * M�todo para agregar una sede con su ubicaci�n y empleados de esa sede.
	 * <b>pre</b>Deben estar los par�metros indicados para poder agregar la sede.<br>
	 * <b>post</b> Se agrega la sede al ArrayList y al archivo si el resultado
	 * es verdadero. Si no, es falso y por lo tanto no se agrega.<br>
	 * @param pUbicacion es de tipo String: pUbicacion debe ser != de null y != de " ".
	 * @param pEmpleados es de tipo String: pEmpleados debe ser != de null y != de " ".
	 * @param alSede es de tipo ArrayList con par�metro Sede: alSede debe ser != de null.
	 * @param file file es de tipo File: file debe existir.
	 * @return variable agregar donde retorna el valor falso si agreg� la sede o falso 
	 * si no la agreg�.
	 */
	public boolean agregarSede(String pUbicacion, String pEmpleados, ArrayList<Sede> alSede, File file) {

		Sede agregar = new Sede(pUbicacion, pEmpleados);

		if (buscarSede(pUbicacion, alSede) == null) {

			alSede.add(agregar);
			archivo.escribirEnArchivoSede(alSede, file);

			return true;
		} else {

			return false;
		}

	}

	/**
	 * M�todo que se usa para eliminar la sede de la casa de apuestas buscando la ubicaci�n
	 * de la sede en el ArrayList.
	 * <b>pre</b>Deben estar los par�metros indicados para poder eliminar la sede.<br>
	 * <b>post</b> Se elimina la sede mediante la ubicaci�n ingresada si el valor es verdadero.
	 * Si no, no se elimina ya que no encontr� la ubicaci�n. <br>
	 * @param pUbicacion es de tipo String: pUbicacion debe ser != de null y != de " ".
	 * @param alSede es de tipo ArrayList con par�metro Sede: alSede debe ser != de null.
	 * @param file es de tipo File: file debe existir.
	 * @return la variable donde verifica si existe la ubicaci�n ingresada o no existe.
	 */
	public boolean eliminarSede(String pUbicacion, ArrayList<Sede> alSede, File file) {

		boolean verificar = false;

		try {

			Sede eliminar = buscarSede(pUbicacion, alSede);

			if (buscarSede(pUbicacion, alSede) != null) {

				alSede.remove(eliminar);
				file.delete();
				file.createNewFile();
				archivo.escribirEnArchivoSede(alSede, file);
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
	 * M�todo que, con la ubicaci�n anterior busca la sede para agregarle una nueva ubicaci�n 
	 * con unos empleados diferentes.
	 * <b>pre</b>Deben estar los par�metros indicados para poder editar la sede.<br>
	 * <b>post</b> Se edita la sede mediante la ubicaci�n ingresada si el valor es verdadero.
	 * Si no, no se edita ya que no encontr� la ubicaci�n. <br>
	 * @param pUbicacionvieja es de tipo String: pUbicacionvieja debe ser != de null y != de " ".
	 * @param pUbicacion es de tipo String: pUbicacion debe ser != de null y != de " ". 
	 * @param pEmpleados es de tipo String: pEmpleados debe ser != de null y != de " ".
	 * @param alSede de tipo ArrayList con par�metro Sede: alSede debe ser != de null.
	 * @param file es de tipo File: file debe existir.
	 * @return la variable donde verifica si existe la ubicaci�n ingresada o no existe.
	 */
	public boolean editarSede(String pUbicacionvieja, String pUbicacion, String pEmpleados, ArrayList<Sede> alSede,
			File file) {

		boolean encontrado = false;

		for (int i = 0; i < alSede.size(); i++) {

			if (alSede.get(i).getUbicacion().equals(pUbicacionvieja)) {

				if (!"".equals(pUbicacion) && !"".equals(pEmpleados)) {

					alSede.get(i).setUbicacion(pUbicacion);
					alSede.get(i).setnEmpleados(pEmpleados);

					file.delete();
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					archivo.escribirEnArchivoSede(alSede, file);
					encontrado = true;
					break;

				} else if (!"".equals(pUbicacion) && "".equals(pEmpleados)) {

					alSede.get(i).setUbicacion(pUbicacion);

					file.delete();
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					archivo.escribirEnArchivoSede(alSede, file);
					encontrado = true;
					break;

				} else if ("".equals(pUbicacion) && !"".equals(pEmpleados)) {

					alSede.get(i).setnEmpleados(pEmpleados);

					file.delete();
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					archivo.escribirEnArchivoSede(alSede, file);
					encontrado = true;
					break;
				}

			} else {
				encontrado = false;
			}

		}
		return encontrado;
	}
	/**
	 * Este m�todo permite ver la sede que se quiere buscar por medio de la ubicaci�n.
	 * <b>pre</b>Deben estar los par�metros indicados para poder buscar y mostrar la sede.<br>
	 * <b>post</b> Se le presenta al usuario la sede que ha decidido buscar.<br>
	 * @param alSede es de tipo ArrayList con par�metro Sede: alSede debe ser != de null.
	 * @param pUbicacion es de tipo String: pUbicacion debe ser != de null y != de vac�o.
	 * @return la variable String para mostrar la sede que se ha buscado.
	 */
	public String verSede(ArrayList<Sede> alSede, String pUbicacion) {

		String texto = "";

		Sede mostrar = buscarSede(pUbicacion, alSede);

		for (int i = 0; i < alSede.size(); i++) {

			if (alSede.get(i).equals(mostrar)) {

				texto = (alSede.get(i).getUbicacion() + "\n" + alSede.get(i).getnEmpleados() + "\n"
						+ "------------------------------" + "\n");
			}
		}

		return texto;

	}
	/**
	 * Este m�todo permite ver la cantidad total de sedes que se han registrado hasta el momento.
	 * <b>pre</b>Deben estar los par�metros indicados para mostrar el total.<br>
	 * <b>post</b> Se le presenta al usuario la cantidad total de sedes registradas.<br>
	 * @param alSede es de tipo ArrayList con par�metro Sede: alSede debe ser != de null. 
	 * @return la variable String para mostrar el total de sedes.
	 */
	public String verSedeTotal(ArrayList<Sede> alSede) {

		String texto = "";

		for (int i = 0; i < alSede.size(); i++) {

			texto += (alSede.get(i).getUbicacion() + "\n" + alSede.get(i).getnEmpleados() + "\n"
					+ "------------------------------" + "\n");

		}

		return texto;

	}

}
