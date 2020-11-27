package co.edu.unbosque.model.persistence;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import co.edu.unbosque.model.*;

public class Propiedades {

	private ArrayList<CasaDeApuesta> alCasa = new ArrayList<CasaDeApuesta>();
	private ArrayList<Apostador> alApostador = new ArrayList<Apostador>();
	private ArrayList<String> alString = new ArrayList<String>();

	private Properties prop = new Properties();
	private String archivoprop = "datos\\config.properties";
	private String archivoprop2 = "datos\\ordenamiento.properties";

	public boolean escribirPropiedades(String pNombre, String pPresupuesto, String pSede, Properties pDatos)
			throws FileNotFoundException, IOException {

		String nombreCasa = pDatos.getProperty("NombreCasa");
		String sedes = pDatos.getProperty("Sedes");
		String presupuesto = pDatos.getProperty("Presupuesto");

		boolean condicion = false;

		if (!"".equals(pNombre) && !"".equals(pPresupuesto) && !"".equals(pSede)) {

			prop.setProperty("NombreCasa", pNombre);
			prop.setProperty("Sedes", pSede);
			prop.setProperty("Presupuesto", pPresupuesto);

			prop.store(new FileOutputStream(archivoprop), null);

			condicion = true;

		} else if (!"".equals(pNombre) && !"".equals(pPresupuesto) && "".equals(pSede)) {

			prop.setProperty("NombreCasa", pNombre);
			prop.setProperty("Sedes", sedes);
			prop.setProperty("Presupuesto", pPresupuesto);
			prop.store(new FileOutputStream(archivoprop), null);

			condicion = true;

		} else if (!"".equals(pNombre) && "".equals(pPresupuesto) && !"".equals(pSede)) {

			prop.setProperty("NombreCasa", pNombre);
			prop.setProperty("Sedes", pSede);
			prop.setProperty("Presupuesto", presupuesto);
			prop.store(new FileOutputStream(archivoprop), null);

			condicion = true;

		} else if (!"".equals(pNombre) && "".equals(pPresupuesto) && "".equals(pSede)) {

			prop.setProperty("NombreCasa", pNombre);
			prop.setProperty("Sedes", sedes);
			prop.setProperty("Presupuesto", presupuesto);
			prop.store(new FileOutputStream(archivoprop), null);

			condicion = true;

		} else if ("".equals(pNombre) && !"".equals(pPresupuesto) && !"".equals(pSede)) {

			prop.setProperty("NombreCasa", nombreCasa);
			prop.setProperty("Presupuesto", pPresupuesto);
			prop.setProperty("Sedes", pSede);
			prop.store(new FileOutputStream(archivoprop), null);

			condicion = true;

		} else if ("".equals(pNombre) && !"".equals(pPresupuesto) && "".equals(pSede)) {

			prop.setProperty("NombreCasa", nombreCasa);
			prop.setProperty("Sedes", sedes);
			prop.setProperty("Presupuesto", pPresupuesto);
			prop.store(new FileOutputStream(archivoprop), null);

			condicion = true;

		} else if ("".equals(pNombre) && "".equals(pPresupuesto) && !"".equals(pSede)) {

			prop.setProperty("NombreCasa", nombreCasa);
			prop.setProperty("Sede", pSede);
			prop.setProperty("Presupuesto", presupuesto);
			prop.store(new FileOutputStream(archivoprop), null);

			condicion = true;

		}

		return condicion;

	}

	public void escribirPropiedades2(Apostador[] numeros, ArrayList<String> numeros2, Properties pDatos)
			throws FileNotFoundException, IOException {

		for (int i = 0; i < numeros.length; i++) {

			prop.setProperty("Nombre" + i, numeros[i].getNombre());
			prop.setProperty("Cedula" + i, numeros[i].getCedula());
			prop.setProperty("Sede" + i, numeros[i].getSede());
			prop.setProperty("Direccion" + i, numeros[i].getDireccion());
			prop.setProperty("Celular" + i, numeros[i].getCelular());
			prop.setProperty("Ganancia" + i, "" + numeros[i].getGanancias());

			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			formateador.setLenient(false);
			String fechaFor = formateador.format(numeros[i].getFecha());

			prop.setProperty("Fecha" + i, "" + fechaFor);

			prop.store(new FileOutputStream(archivoprop2), null);

		}

		for (int i = 0; i < numeros2.size(); i++) {

			String numeross = numeros2.get(i);
			String nombre, cedula;
			nombre = numeross.substring(0, numeross.indexOf(","));
			numeross = numeross.substring(numeross.indexOf(",") + 1, numeross.length());
			cedula = numeross.substring(0, numeross.indexOf(","));
			numeross = numeross.substring(numeross.indexOf(",") + 1, numeross.length());

			prop.setProperty("Nombres" + i, nombre);
			prop.setProperty("Cedulas" + i, cedula);
			prop.setProperty("Total" + i, numeross);

			prop.store(new FileOutputStream(archivoprop2), null);

		}

	}

	public Properties leerDatos(File archivo) throws Exception {

		Properties datos = new Properties();
		FileInputStream in = new FileInputStream(archivo);

		try {

			datos.load(in);
			in.close();
		} catch (Exception e) {

			throw new Exception("Error en cargariInfo");
		}

		return datos;
	}

	public ArrayList<CasaDeApuesta> CargarDatos(Properties pDatos) {

		String nombreCasa = "";
		String sedes = "";
		String presupuesto = "";

		nombreCasa = pDatos.getProperty("NombreCasa");
		sedes = pDatos.getProperty("Sedes");
		presupuesto = pDatos.getProperty("Presupuesto");

		CasaDeApuesta casa = new CasaDeApuesta(nombreCasa, sedes, presupuesto);

		alCasa.add(casa);

		return alCasa;
	}

	public ArrayList<Apostador> CargarDatos2(Properties pDatos, Apostador[] numeros) {

		String nombre = "";
		String cedula = "";
		String sede = "";
		String direccion = "";
		String celular = "";
		String Ganancia = "";
		String fecha = "";

		for (int i = 0; i < numeros.length; i++) {

			try {

				nombre = pDatos.getProperty("Nombre" + i);
				cedula = pDatos.getProperty("Cedula" + i);
				sede = pDatos.getProperty("Sede" + i);
				direccion = pDatos.getProperty("Direccion" + i);
				celular = pDatos.getProperty("Celular" + i);
				Ganancia = pDatos.getProperty("Ganancia" + i);
				fecha = pDatos.getProperty("Fecha" + i);

				double pGanancia = 0;

				SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
				formateador.setLenient(false);
				Date pFecha = formateador.parse(fecha);

				Apostador casa = new Apostador(nombre, cedula, sede, direccion, celular, pGanancia, pFecha);

				alApostador.add(casa);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return alApostador;
	}

	public ArrayList<String> CargarDatos3(Properties pDatos, ArrayList<String> numeros2) {

		String nombre = "";
		String cedula = "";
		String total = "";

		for (int i = 0; i < numeros2.size(); i++) {

			nombre = pDatos.getProperty("Nombres" + i);
			cedula = pDatos.getProperty("Cedulas" + i);
			total = pDatos.getProperty("Total" + i);

			String apostador = nombre + "," + cedula + "," + total;

			alString.add(apostador);

		}

		return alString;
	}

}
