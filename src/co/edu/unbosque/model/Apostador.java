/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Clase Apostador
 * 
 * Clase donde se agregan los datos del apostador que se necesitan para poder
 * guardarlos en las diferentes variables que están contenidas en la clase.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class Apostador implements Serializable {
	/*
	 * serialVersionUID es estatico y de tipo long = a 1L.
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * nombre es de tipo String.
	 */
	private String nombre;
	/*
	 * cedula es de tipo String.
	 */
	private String cedula;
	/*
	 * sede es de tipo String.
	 */
	private String sede;
	/*
	 * direccion es de tipo String.
	 */
	private String direccion;
	/*
	 * celular es de tipo String.
	 */
	private String celular;
	/*
	 * ganancias es de tipo double.
	 */
	private double ganancias;

	private Date fecha;

	/**
	 * Constructor de la clase apostador.
	 */
	public Apostador() {

	}

	/**
	 * Este constructor específico crea el objeto Apostador con los parámetros que
	 * se necesitan para su creación. <b>pre</b> Debe contener los parámetros para
	 * crearse. <br>
	 * <b>post</b> Se crea el objeto junto con los parámetros que se le enviaron.
	 * <br>
	 * 
	 * @param nombre    es un String del apostador: nombre dede ser != null y != "
	 *                  ".
	 * @param cedula    es un String del apostador: cedula dede ser != null y != "
	 *                  ".
	 * @param sede      es un String del apostador: sede dede ser != null y != " ".
	 * @param direccion es un String del apostador: direccion dede ser != null y !=
	 *                  " ".
	 * @param celular   es un String del apostador: celular dede ser != null y != "
	 *                  ".
	 */

	/**
	 * @param nombre
	 * @param cedula
	 * @param sede
	 * @param direccion
	 * @param celular
	 * @param ganancias
	 * @param fecha
	 */
	public Apostador(String nombre, String cedula, String sede, String direccion, String celular, double ganancias,
			Date fecha) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.sede = sede;
		this.direccion = direccion;
		this.celular = celular;
		this.ganancias = ganancias;
		this.fecha = fecha;
	}

	/**
	 * Este método recibe un String verificando que solo contenga letras. <b>pre</b>
	 * El parámetro que se recibe de tipo String debe ser una palabra.<br>
	 * <b>post</b> Si el método es correcto es porque el String contiene una
	 * palabra. Si no la contiene, el método retorna falso.<br>
	 * 
	 * @param palabra es un String de letras: palabra tiene que ser != de null y !=
	 *                de " ".
	 * @return es el valor booleano que retorna el método.
	 */
	public boolean soloLetras(String palabra) {
		for (int i = 0; i < palabra.length(); i++) {
			char auxiliar = palabra.charAt(i);
			if (auxiliar == '0' || auxiliar == '1' || auxiliar == '2' || auxiliar == '3' || auxiliar == '4'
					|| auxiliar == '5' || auxiliar == '6' || auxiliar == '7' || auxiliar == '8' || auxiliar == '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Este método recibe un String verificando que solo contenga números.
	 * <b>pre</b> El parámetro String debe ser un número.<br>
	 * <b>post</b> Si el metodo se cumple correctamente es porque el String es un
	 * número. Si no, el método retornará un valor falso.<br>
	 * 
	 * @param pNumero es un String numero: pNumero debe ser != de null y != de " ".
	 * @return es el valor booleano que retorna el método.
	 */

	public boolean soloNumeros(String pNumero) {

		for (int i = 0; i < pNumero.length(); i++) {
			char aux = pNumero.charAt(i);
			int digito = aux - '0';
			if (digito > 9 || digito < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Este método recibe un parámetro tipo String para verificar que solo contenga
	 * letras. <b>pre</b> El parámetro String que se recibe debe contener solo
	 * letras.<br>
	 * <b>post</b> Si el parámetro que se recibe contiene solo letras la excepción
	 * está correcta. Si no, el método mostrará la excepción que se presenta en el
	 * método.<br>
	 * 
	 * @param nombre es un String que contiene el nombre del apostador: nombre debe
	 *               ser != de null y != de " ".
	 * @return La variable que se contiene en el método de tipo boolean y que
	 *         verifica si se contiene solo letras.
	 * @throws ExcepcionNombre es la excepción que se utiliza en este método.
	 */
	public boolean excepcionNombre(String nombre) throws ExcepcionNombre {
		boolean verificar = true;
		if (!soloLetras(nombre)) {
			throw new ExcepcionNombre("Ingresaste erroneamente en el nombre, no es válido");

		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Este método recibe un parámetro tipo String para verificar que solo contenga
	 * números y que no sea mayor a 9. <b>pre</b> El parámetro String que se recibe
	 * debe contener solo números.<br>
	 * <b>post</b> Si el parámetro que se recibe contiene solo números la excepción
	 * está correcta. Si no, el método mostrará la excepción que se presenta en el
	 * método.<br>
	 * 
	 * @param cedula es de tipo String que contiene la cedula del apostador: cedula
	 *               debe ser != null y != de " ".
	 * @return La variable que se contiene en el método de tipo boolean y que
	 *         verifica si se contiene solo números.
	 * @throws ExcepcionNumero es la excepción que se usa en este método.
	 */
	public boolean excepcionCedula(String cedula) throws ExcepcionNumero {
		boolean verificar;

		if (soloNumeros(cedula) && cedula.length() <= 10) {
			verificar = true;
		} else {
			throw new ExcepcionNumero("Ingresaste una cédula errónea");
		}
		return verificar;
	}

	/**
	 * Este método recibe un parámetro tipo String para verificar que solo contenga
	 * números y es de 10 dígitos. <b>pre</b> El parámetro String que se recibe debe
	 * contener solo números.<br>
	 * <b>post</b> Si el parámetro que se recibe contiene solo números la excepción
	 * está correcta. Si no, el método mostrará la excepción que se presenta en el
	 * método.<br>
	 * 
	 * @param celular es de tipo String que contiene el celular del apostador:
	 *                celular debe ser != null y != de " ".
	 * @return La variable que se contiene en el método de tipo boolean y que
	 *         verifica si se contiene solo números y es igual a los 10 dígitos.
	 * @throws ExcepcionNumero es la excepción que se usa en este método.
	 */
	public boolean excepcionCelular(String celular) throws ExcepcionNumero {
		boolean verificar = true;

		if (soloNumeros(celular) && celular.length() == 10) {
			verificar = false;

		} else {
			throw new ExcepcionNumero("Ingresaste un celular erróneo");
		}
		return verificar;
	}

	public Apostador[] ordenamientoPorFechaApostador(ArrayList<Apostador> alApostador, ArrayList<Sede> alSede) {

		Sede[] arreglo = new Sede[alSede.size()];
		Apostador[] arregloApostador = new Apostador[alApostador.size()];

		for (int i = 0; i < alSede.size(); i++) {
			arreglo[i] = alSede.get(i);
		}

		Sede aux = null;
		int delantero = 0;
		int tracero = 0;

		for (int i = 0; i < arreglo.length; i++) {

			aux = arreglo[i];

			if (i > 0) {

				delantero = arreglo[i].getUbicacion().charAt(0);
				tracero = arreglo[i - 1].getUbicacion().charAt(0);

				if (delantero == tracero) {

					delantero = arreglo[i].getUbicacion().charAt(1);
					tracero = arreglo[i - 1].getUbicacion().charAt(2);
				}
			}

			while ((i > 0) && (tracero > delantero)) {

				arreglo[i] = arreglo[i - 1];
				i--;
			}

			arreglo[i] = aux;
		}

//-------------------------------------------------------------------------------------------

		int contador = 0;

		for (int i = 0; i < alApostador.size(); i++) {

			arregloApostador[i] = alApostador.get(i);
		}

		arregloApostador = this.quicksort2(arregloApostador, 0, arregloApostador.length - 1);

		for (int i = 0; i < arreglo.length; i++) {

			for (int j = arregloApostador.length - 1; j >= 0; j--) {

				if (arreglo[i].getUbicacion().equals(alApostador.get(j).getSede())) {

					arregloApostador[contador] = alApostador.get(j);
					contador++;

				}
			}
		}

		return arregloApostador;

	}

	public ArrayList<String> ordenamientoPorApuesta(ArrayList<Apostador> alApostador, ArrayList<Baloto> alBaloto,
			ArrayList<SuperAstro> alSuperAstro, ArrayList<Partido> alPartido) {

		Apostador[] arregloApostador = new Apostador[alApostador.size()];

		for (int i = 0; i < alApostador.size(); i++) {

			arregloApostador[i] = alApostador.get(i);
		}

		Apostador aux2 = null;
		int delantero = 0;
		int tracero = 0;

//--------------------------------------------------------------------------------------------

		for (int i = 0; i < arregloApostador.length; i++) {

			aux2 = arregloApostador[i];

			if (i > 0) {

				delantero = arregloApostador[i].getNombre().charAt(0);
				tracero = arregloApostador[i - 1].getNombre().charAt(0);

				if (delantero == tracero) {

					delantero = arregloApostador[i].getNombre().charAt(1);
					tracero = arregloApostador[i - 1].getNombre().charAt(2);
				}
			}

			while ((i > 0) && (tracero > delantero)) {

				arregloApostador[i] = arregloApostador[i - 1];
				i--;
			}

			arregloApostador[i] = aux2;
		}

//-------------------------------------------------------------------------------------------

		int sumaBaloto = 0;

		String parametro = "";

		int numero = 0;

		ArrayList<String> listaApostadores = new ArrayList<String>();

		for (int i = 0; i < arregloApostador.length; i++) {

			numero = 0;

			for (int j = 0; j < alBaloto.size(); j++) {

				if (arregloApostador[i].getCedula().equals(alBaloto.get(j).getCedula())) {

					numero += Integer.parseInt(alBaloto.get(j).getValorApuesta());

				}
			}

			for (int j = 0; j < alSuperAstro.size(); j++) {

				if (arregloApostador[i].getCedula().equals(alSuperAstro.get(j).getCedula())) {

					numero += Integer.parseInt(alSuperAstro.get(j).getValorApuesta());

				}
			}

			for (int j = 0; j < alPartido.size(); j++) {

				if (arregloApostador[i].getCedula().equals(alPartido.get(j).getCedula())) {

					numero += Integer.parseInt(alPartido.get(j).getValorApuesta());

				}
			}

			String apostador = arregloApostador[i].getNombre() + "," + arregloApostador[i].getCedula() + "," + numero;
			listaApostadores.add(apostador);

		}

		return listaApostadores;

	}

	public Apostador[] quicksort2(Apostador[] numeros, int izq, int der) {
		if (izq >= der) {
			return numeros;
		}
		int i = izq, d = der;
		if (izq != der) {
			int pivote;
			Apostador aux = null;
			pivote = izq;
			while (izq != der) {

				while ((numeros[der].getFecha().before(numeros[pivote].getFecha())
						|| numeros[der].getFecha() == numeros[pivote].getFecha()) && izq < der) {
					der--;

				}
				while (numeros[izq].getFecha().after(numeros[pivote].getFecha()) && izq < der) {
					izq++;
				}
				if (der != izq) {
					aux = numeros[der];

					numeros[der] = numeros[izq];
					numeros[izq] = aux;
				}
			}
			if (izq == der) {
				quicksort2(numeros, i, izq - 1);
				quicksort2(numeros, izq + 1, d);
			}
		} else {
			return numeros;
		}
		return numeros;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the sede
	 */
	public String getSede() {
		return sede;
	}

	/**
	 * @param sede the sede to set
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the ganancias
	 */
	public double getGanancias() {
		return ganancias;
	}

	/**
	 * @param ganancias the ganancias to set
	 */
	public void setGanancias(double ganancias) {
		this.ganancias = ganancias;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
