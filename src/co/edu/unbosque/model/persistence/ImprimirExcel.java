package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import co.edu.unbosque.model.Apostador;
import co.edu.unbosque.model.Baloto;
import co.edu.unbosque.model.Partido;
import co.edu.unbosque.model.Sede;
import co.edu.unbosque.model.SuperAstro;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ImprimirExcel {
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

	public ImprimirExcel() {
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
		try {
			pDatos = propiedades.leerDatos(new File("datos\\ordenamiento.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void imprimirExcel() {

		ArrayList<Apostador> alApostador = new ArrayList<Apostador>();
		ArrayList<String> alString = new ArrayList<String>();

		Archivo oparchivoE = new Archivo(fileOrdenamiento);

		HSSFWorkbook objWB = new HSSFWorkbook();
		String[] celdas = { "Nombre", "Cedula", "Sede", "Direccion", "Celular", "Fecha" };

		HSSFSheet hoja1 = objWB.createSheet("hoja 1");

		HSSFRow fila = hoja1.createRow((short) 0);

		HSSFFont fuente = objWB.createFont();
		fuente.setFontHeightInPoints((short) 11);
		fuente.setFontName(fuente.FONT_ARIAL);
		fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle estiloCelda = objWB.createCellStyle();
		estiloCelda.setWrapText(true);
		estiloCelda.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);
		estiloCelda.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		estiloCelda.setFont(fuente);

		estiloCelda.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda.setBottomBorderColor((short) 8);
		estiloCelda.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda.setLeftBorderColor((short) 8);
		estiloCelda.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda.setRightBorderColor((short) 8);
		estiloCelda.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda.setTopBorderColor((short) 8);

		estiloCelda.setFillForegroundColor((short) 22);
		estiloCelda.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCell celda = fila.createCell((short) 0);
		celda.setCellStyle(estiloCelda);
		celda.setCellType(HSSFCell.CELL_TYPE_STRING);

		for (int i = 0; i < celdas.length; i++) {

			String enunciado = celdas[i];
			HSSFCell cell = fila.createCell(i);
			cell.setCellValue(enunciado);

		}

		Apostador[] numeros = new Apostador[alApostador.size()];

		numeros = apostador.ordenamientoPorFechaApostador(alApostador1, alSede);

		alApostador = propiedades.CargarDatos2(pDatos, numeros);

		for (int i = 0; i < alApostador.size(); i++) {

			HSSFRow on = hoja1.createRow(i + 1);

			on.createCell(0).setCellValue(alApostador.get(i).getNombre());
			on.createCell(1).setCellValue(alApostador.get(i).getCedula());
			on.createCell(2).setCellValue(alApostador.get(i).getSede());
			on.createCell(4).setCellValue(alApostador.get(i).getCelular());
			on.createCell(3).setCellValue(alApostador.get(i).getDireccion());

			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			formateador.setLenient(false);
			String pFecha = formateador.format(alApostador.get(i).getFecha());
			on.createCell(5).setCellValue(pFecha);

		}

/////////////////////////////////-HOJA2-/////////////////////////////////////////////////////////
		String[] celdas1 = { "Nombre", "Cedula", "Total" };

		HSSFSheet hoja2 = objWB.createSheet("hoja 2");

		HSSFRow fila1 = hoja2.createRow((short) 0);

		HSSFFont fuente1 = objWB.createFont();
		fuente1.setFontHeightInPoints((short) 11);
		fuente1.setFontName(fuente1.FONT_ARIAL);
		fuente1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle estiloCelda1 = objWB.createCellStyle();
		estiloCelda1.setWrapText(true);
		estiloCelda1.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);
		estiloCelda1.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		estiloCelda1.setFont(fuente);

		estiloCelda1.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda1.setBottomBorderColor((short) 8);
		estiloCelda1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda1.setLeftBorderColor((short) 8);
		estiloCelda1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda1.setRightBorderColor((short) 8);
		estiloCelda1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda1.setTopBorderColor((short) 8);

		estiloCelda1.setFillForegroundColor((short) 22);
		estiloCelda1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCell celda1 = fila1.createCell((short) 0);
		celda1.setCellStyle(estiloCelda1);
		celda1.setCellType(HSSFCell.CELL_TYPE_STRING);

		for (int i = 0; i < celdas1.length; i++) {

			String enunciado1 = celdas1[i];
			HSSFCell cell = fila1.createCell(i);
			cell.setCellValue(enunciado1);

		}

		ArrayList<String> listaApostadores = new ArrayList<String>();

		listaApostadores = apostador.ordenamientoPorApuesta(alApostador, alBaloto, alSuperAstro, alPartido);

		alString = propiedades.CargarDatos3(pDatos, listaApostadores);

		for (int i = 0; i < alString.size(); i++) {

			HSSFRow on = hoja2.createRow(i + 1);

			String numeross = alString.get(i);
			String nombre, cedula;
			nombre = numeross.substring(0, numeross.indexOf(","));
			numeross = numeross.substring(numeross.indexOf(",") + 1, numeross.length());
			cedula = numeross.substring(0, numeross.indexOf(","));
			numeross = numeross.substring(numeross.indexOf(",") + 1, numeross.length());

			on.createCell(0).setCellValue(nombre);
			on.createCell(1).setCellValue(cedula);
			on.createCell(2).setCellValue(numeross);

		}

///////////////////////////////-Hoja3-/////////////////////////////////////
		String[] celdas2 = { "Sede", "Cedula", "Fecha", "ValorApuesta", "Resultado", "Equipo Local",
				"Equipo Visitante" };

		HSSFSheet hoja3 = objWB.createSheet("hoja 3");

		HSSFRow fila2 = hoja3.createRow((short) 0);

		HSSFFont fuente2 = objWB.createFont();
		fuente2.setFontHeightInPoints((short) 11);
		fuente2.setFontName(fuente2.FONT_ARIAL);
		fuente2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle estiloCelda2 = objWB.createCellStyle();
		estiloCelda2.setWrapText(true);
		estiloCelda2.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);
		estiloCelda2.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		estiloCelda2.setFont(fuente);

		estiloCelda2.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda2.setBottomBorderColor((short) 8);
		estiloCelda2.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda2.setLeftBorderColor((short) 8);
		estiloCelda2.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda2.setRightBorderColor((short) 8);
		estiloCelda2.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda2.setTopBorderColor((short) 8);

		estiloCelda2.setFillForegroundColor((short) 22);
		estiloCelda2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCell celda2 = fila2.createCell((short) 0);
		celda2.setCellStyle(estiloCelda2);
		celda2.setCellType(HSSFCell.CELL_TYPE_STRING);

		for (int i = 0; i < celdas2.length; i++) {

			String enunciado1 = celdas2[i];
			HSSFCell cell = fila2.createCell(i);
			cell.setCellValue(enunciado1);

		}

		for (int i = 0; i < alPartido.size(); i++) {

			HSSFRow on = hoja3.createRow(i + 1);
			on.createCell(0).setCellValue(alPartido.get(i).getSede());
			on.createCell(1).setCellValue(alPartido.get(i).getCedula());
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			formateador.setLenient(false);
			String pFecha = formateador.format(alPartido.get(i).getFecha());
			on.createCell(2).setCellValue(pFecha);
			on.createCell(3).setCellValue(alPartido.get(i).getValorApuesta());
			on.createCell(4).setCellValue(alPartido.get(i).getResultado());
			on.createCell(5).setCellValue(alPartido.get(i).getEquipoLocal());
			on.createCell(6).setCellValue(alPartido.get(i).getEquipoVisitante());

		}

//////////////////////////////-Hoja4-/////////////////////////////////////////

		String[] celdas3 = { "Sede", "Cedula", "Fecha", "ValorApuesta", "Numero" };

		HSSFSheet hoja4 = objWB.createSheet("hoja 4");

		HSSFRow fila3 = hoja4.createRow((short) 0);

		HSSFFont fuente3 = objWB.createFont();
		fuente3.setFontHeightInPoints((short) 11);
		fuente3.setFontName(fuente3.FONT_ARIAL);
		fuente3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle estiloCelda3 = objWB.createCellStyle();
		estiloCelda3.setWrapText(true);
		estiloCelda3.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);
		estiloCelda3.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		estiloCelda3.setFont(fuente3);

		estiloCelda3.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda3.setBottomBorderColor((short) 8);
		estiloCelda3.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda3.setLeftBorderColor((short) 8);
		estiloCelda3.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda3.setRightBorderColor((short) 8);
		estiloCelda3.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda3.setTopBorderColor((short) 8);

		estiloCelda3.setFillForegroundColor((short) 22);
		estiloCelda3.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCell celda3 = fila3.createCell((short) 0);
		celda3.setCellStyle(estiloCelda3);
		celda3.setCellType(HSSFCell.CELL_TYPE_STRING);

		for (int i = 0; i < celdas3.length; i++) {

			String enunciado1 = celdas3[i];
			HSSFCell cell = fila3.createCell(i);
			cell.setCellValue(enunciado1);

		}

		for (int i = 0; i < alBaloto.size(); i++) {

			HSSFRow on = hoja4.createRow(i + 1);
			on.createCell(0).setCellValue(alBaloto.get(i).getSede());
			on.createCell(1).setCellValue(alBaloto.get(i).getCedula());
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			formateador.setLenient(false);
			String pFecha = formateador.format(alBaloto.get(i).getFecha());
			on.createCell(2).setCellValue(pFecha);
			on.createCell(3).setCellValue(alBaloto.get(i).getValorApuesta());
			on.createCell(4).setCellValue(alBaloto.get(i).getNumero());

		}

/////////////////////////////-Hoja5-////////////////////////////////////////

		String[] celdas4 = { "Sede", "Cedula", "Fecha", "ValorApuesta", "Numero", "Zodiaco" };

		HSSFSheet hoja5 = objWB.createSheet("hoja 5");

		HSSFRow fila4 = hoja5.createRow((short) 0);

		HSSFFont fuente4 = objWB.createFont();
		fuente4.setFontHeightInPoints((short) 11);
		fuente4.setFontName(fuente4.FONT_ARIAL);
		fuente4.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle estiloCelda4 = objWB.createCellStyle();
		estiloCelda4.setWrapText(true);
		estiloCelda4.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);
		estiloCelda4.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		estiloCelda4.setFont(fuente4);

		estiloCelda4.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda4.setBottomBorderColor((short) 8);
		estiloCelda4.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda4.setLeftBorderColor((short) 8);
		estiloCelda4.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda4.setRightBorderColor((short) 8);
		estiloCelda4.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		estiloCelda4.setTopBorderColor((short) 8);

		estiloCelda4.setFillForegroundColor((short) 22);
		estiloCelda4.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFCell celda4 = fila4.createCell((short) 0);
		celda4.setCellStyle(estiloCelda4);
		celda4.setCellType(HSSFCell.CELL_TYPE_STRING);

		for (int i = 0; i < celdas4.length; i++) {

			String enunciado1 = celdas4[i];
			HSSFCell cell = fila4.createCell(i);
			cell.setCellValue(enunciado1);

		}

		for (int i = 0; i < alSuperAstro.size(); i++) {

			HSSFRow on = hoja5.createRow(i + 1);
			on.createCell(0).setCellValue(alSuperAstro.get(i).getSede());
			on.createCell(1).setCellValue(alSuperAstro.get(i).getCedula());
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			formateador.setLenient(false);
			String pFecha = formateador.format(alSuperAstro.get(i).getFecha());
			on.createCell(2).setCellValue(pFecha);
			on.createCell(3).setCellValue(alSuperAstro.get(i).getValorApuesta());
			on.createCell(4).setCellValue(alSuperAstro.get(i).getNumero());
			on.createCell(5).setCellValue(alSuperAstro.get(i).getZodiaco());

		}

		try {
			FileOutputStream elFichero = new FileOutputStream("SturmSoftwareDevelopment.xls");
			objWB.write(elFichero);
			elFichero.close();
		} catch (Exception e) {
			System.out.println("Error en el archivo Excel");
		}
	}
}