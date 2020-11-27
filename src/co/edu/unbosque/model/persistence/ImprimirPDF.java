package co.edu.unbosque.model.persistence;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.unbosque.model.Apostador;
import co.edu.unbosque.model.Baloto;
import co.edu.unbosque.model.Partido;
import co.edu.unbosque.model.Sede;
import co.edu.unbosque.model.SuperAstro;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

public class ImprimirPDF {

	private File fileOrdenamiento;
	private Propiedades propiedades;
	private Properties pDatos;
	private Apostador apostador;
	private File fileSede;
	private File fileApostador;
	private File fileBaloto;
	private File fileSuperAstro;
	private File filePartido;
	private Archivo archivo;
	private ArrayList<Sede> alSede;
	private ArrayList<Apostador> alApostador1;
	private ArrayList<Baloto> alBaloto;
	private ArrayList<SuperAstro> alSuperAstro;
	private ArrayList<Partido> alPartido;

	public ImprimirPDF() throws Exception {
		apostador = new Apostador();
		alSede = new ArrayList<Sede>();
		alApostador1 = new ArrayList<Apostador>();
		alBaloto = new ArrayList<Baloto>();
		alSuperAstro = new ArrayList<SuperAstro>();
		alPartido = new ArrayList<Partido>();
		fileOrdenamiento = new File("datos\\apostadores.dat");
		fileSede = new File("datos\\sedes.dat");
		fileApostador = new File("datos\\apostadores.dat");
		fileBaloto = new File("datos\\apuestas-baloto.dat");
		fileSuperAstro = new File("datos\\apuestas-superastro.dat");
		filePartido = new File("datos\\apuestas-marcadores.dat");
		archivo = new Archivo(fileSede);
		archivo = new Archivo(fileApostador);
		archivo = new Archivo(fileBaloto);
		archivo = new Archivo(fileSuperAstro);
		archivo = new Archivo(filePartido);
		alSede = archivo.leerArchivoSede(fileSede);
		alApostador1 = archivo.leerArchivoApostador(fileApostador);
		alBaloto = archivo.leerArchivoBaloto(fileBaloto);
		alSuperAstro = archivo.leerArchivoSuperAstro(fileSuperAstro);
		alPartido = archivo.leerArchivoPartido(filePartido);

		propiedades = new Propiedades();
		pDatos = new Properties();
		pDatos = propiedades.leerDatos(new File("datos\\ordenamiento.properties"));

	}

	public void imprimirPDF() {
		Document document = new Document();
		ArrayList<Apostador> alApostador = new ArrayList<Apostador>();
		ArrayList<String> alString = new ArrayList<String>();

		Archivo oparchivoE = new Archivo(fileOrdenamiento);

		try {
			PdfWriter.getInstance(document, new FileOutputStream("SturmSoftwareDevelopment.pdf"));
			document.open();

			Paragraph parrafoTitulo = new Paragraph();
			Paragraph parrafoApostador = new Paragraph();
			Paragraph parrafoSede = new Paragraph();
			Paragraph parrafoFutbol = new Paragraph();
			Paragraph parrafoBaloto = new Paragraph();
			Paragraph parrafoSuperastro = new Paragraph();

			parrafoTitulo.add("CASA DE APUESTAS STORM SOFTWARE DEVELOPMENT");
			parrafoTitulo.setAlignment(Element.TITLE);
			document.add(parrafoTitulo);
			document.add(Chunk.NEWLINE);

			///////////// -APOSTADOR-///////////////////
			parrafoApostador.add("APOSTADORES");
			parrafoApostador.setAlignment(Element.ALIGN_LEFT);
			document.add(parrafoApostador);

			document.add(Chunk.NEWLINE);

			PdfPTable tablaApostador = new PdfPTable(6);

			tablaApostador.addCell("Nombre");
			tablaApostador.addCell("Cedula");
			tablaApostador.addCell("Sede");
			tablaApostador.addCell("Dirección");
			tablaApostador.addCell("Celular");
			tablaApostador.addCell("Fecha");

			Apostador[] numeros = new Apostador[alApostador.size()];

			numeros = apostador.ordenamientoPorFechaApostador(alApostador1, alSede);

			alApostador = propiedades.CargarDatos2(pDatos, numeros);

			for (int i = 0; i < alApostador.size(); i++) {
				tablaApostador.addCell(alApostador.get(i).getNombre());
				tablaApostador.addCell(alApostador.get(i).getCedula());
				tablaApostador.addCell(alApostador.get(i).getSede());
				tablaApostador.addCell(alApostador.get(i).getDireccion());
				tablaApostador.addCell(alApostador.get(i).getCelular());

				SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
				formateador.setLenient(false);
				String pFecha = formateador.format(alApostador.get(i).getFecha());

				tablaApostador.addCell(pFecha);

			}

			document.add(tablaApostador);

			////////////////// - APUESTA - //////////////////////////////////////////
			document.add(Chunk.NEWLINE);
			parrafoSede.add("VALOR TOTAL DE APUESTAS");
			document.add(parrafoSede);
			document.add(Chunk.NEWLINE);

			PdfPTable tablaSede = new PdfPTable(3);
			tablaSede.addCell("Nombre");
			tablaSede.addCell("Cedula");
			tablaSede.addCell("Total");

			ArrayList<String> listaApostadores = new ArrayList<String>();

			listaApostadores = apostador.ordenamientoPorApuesta(alApostador, alBaloto, alSuperAstro, alPartido);

			alString = propiedades.CargarDatos3(pDatos, listaApostadores);

			for (int i = 0; i < alString.size(); i++) {

				String numeross = alString.get(i);
				String nombre, cedula;
				nombre = numeross.substring(0, numeross.indexOf(","));
				numeross = numeross.substring(numeross.indexOf(",") + 1, numeross.length());
				cedula = numeross.substring(0, numeross.indexOf(","));
				numeross = numeross.substring(numeross.indexOf(",") + 1, numeross.length());

				tablaSede.addCell(nombre);
				tablaSede.addCell(cedula);
				tablaSede.addCell(numeross);

			}

			document.add(tablaSede);

			///////////////// - BALOTO -////////////////////////

			document.add(Chunk.NEWLINE);
			parrafoBaloto.add("APUESTAS BALOTO");
			document.add(parrafoBaloto);
			document.add(Chunk.NEWLINE);

			PdfPTable tablaBaloto = new PdfPTable(5);
			tablaBaloto.addCell("Sede");
			tablaBaloto.addCell("Cedula");
			tablaBaloto.addCell("Fecha");
			tablaBaloto.addCell("Valor Apuesta");
			tablaBaloto.addCell("Numero");

			for (int i = 0; i < alBaloto.size(); i++) {
				tablaBaloto.addCell(alBaloto.get(i).getSede());
				tablaBaloto.addCell(alBaloto.get(i).getCedula());

				SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
				formateador.setLenient(false);
				String pFecha = formateador.format(alBaloto.get(i).getFecha());

				tablaBaloto.addCell(pFecha);
				tablaBaloto.addCell(alBaloto.get(i).getValorApuesta());
				tablaBaloto.addCell(alBaloto.get(i).getNumero());

			}

			document.add(tablaBaloto);

			///////////////// -SuperAstro- //////////////////////////

			document.add(Chunk.NEWLINE);
			parrafoSuperastro.add("APUESTAS BALOTO");
			document.add(parrafoSuperastro);
			document.add(Chunk.NEWLINE);

			PdfPTable tablaSuperastro = new PdfPTable(6);
			tablaSuperastro.addCell("Sede");
			tablaSuperastro.addCell("Cedula");
			tablaSuperastro.addCell("Fecha");
			tablaSuperastro.addCell("Valor Apuesta");
			tablaSuperastro.addCell("Numero");
			tablaSuperastro.addCell("Zodiaco");

			for (int i = 0; i < alSuperAstro.size(); i++) {
				tablaSuperastro.addCell(alSuperAstro.get(i).getSede());
				tablaSuperastro.addCell(alSuperAstro.get(i).getCedula());

				SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
				formateador.setLenient(false);
				String pFecha = formateador.format(alSuperAstro.get(i).getFecha());

				tablaSuperastro.addCell(pFecha);
				tablaSuperastro.addCell(alSuperAstro.get(i).getValorApuesta());
				tablaSuperastro.addCell(alSuperAstro.get(i).getNumero());
				tablaSuperastro.addCell(alSuperAstro.get(i).getZodiaco());

			}

			document.add(tablaSuperastro);

			///////////////// - MARCADOR FUTBOL-///////////

			document.add(Chunk.NEWLINE);
			parrafoFutbol.add("APUESTAS PARTIDOS");
			document.add(parrafoFutbol);
			document.add(Chunk.NEWLINE);

			PdfPTable tablaFutbol = new PdfPTable(7);
			tablaFutbol.addCell("Sede");
			tablaFutbol.addCell("Cedula");
			tablaFutbol.addCell("Fecha");
			tablaFutbol.addCell("Valor Apuesta");
			tablaFutbol.addCell("Resultado");
			tablaFutbol.addCell("Equipo Local");
			tablaFutbol.addCell("Equipo Visitante");

			for (int i = 0; i < alPartido.size(); i++) {
				tablaFutbol.addCell(alPartido.get(i).getSede());
				tablaFutbol.addCell(alPartido.get(i).getCedula());

				SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
				formateador.setLenient(false);
				String pFecha = formateador.format(alPartido.get(i).getFecha());

				tablaFutbol.addCell(pFecha);
				tablaFutbol.addCell(alPartido.get(i).getValorApuesta());
				tablaFutbol.addCell(alPartido.get(i).getResultado());
				tablaFutbol.addCell(alPartido.get(i).getEquipoLocal());
				tablaFutbol.addCell(alPartido.get(i).getEquipoVisitante());

			}

			document.add(tablaFutbol);

			document.close();

		} catch (Exception e) {

			System.out.println(e);

		}
	}
}