/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.controller;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.view.*;

/**
 * Clase Controller Esta clase controla y se maneja las diferentes clases, se
 * unen para que se pueda ver correctamente el programa.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class Controller implements ActionListener {
	/*
	 * ventanaPrincipal es de tipo VentanaPrincipal.
	 */
	private VentanaPrincipal ventanaPrincipal;
	/*
	 * sesionAdministrador es de tipo SesionAdministrador.
	 */
	private SesionAdministrador sesionAdministrador;
	/*
	 * ventanaApostador es de tipo VentanaApostador.
	 */
	private VentanaApostador ventanaApostador;
	/*
	 * ventanaAdministrador es de tipo VentanaAdministrador.
	 */
	private VentanaAdministrador ventanaAdministrador;

	/*
	 * alCasa es un ArrayList de tipo CasaDeApuesta.
	 */
	private ArrayList<CasaDeApuesta> alCasa;
	/*
	 * alJuego es un ArrayList de tipo Juego.
	 */
	private ArrayList<Juego> alJuego;
	/*
	 * alSede es un ArrayList de tipo Sede.
	 */
	private ArrayList<Sede> alSede;
	/*
	 * alApostador es un ArrayList de tipo Apostador.
	 */
	private ArrayList<Apostador> alApostador;
	/*
	 * alBaloto es un ArrayList de tipo Baloto.
	 */
	private ArrayList<Baloto> alBaloto;
	/*
	 * alSuperAstro es un ArrayList de tipo SuperAstro
	 */
	private ArrayList<SuperAstro> alSuperAstro;
	/*
	 * alPartido es un ArrayList de tipo Partido.
	 */
	private ArrayList<Partido> alPartido;
	/*
	 * alPremioBaloto es un ArrayList de tipo Baloto.
	 */
	private ArrayList<Baloto> alPremioBaloto;
	/*
	 * alPremioSuperAstro es un ArrayList de tipo SuperAstro.
	 */
	private ArrayList<SuperAstro> alPremioSuperAstro;
	/*
	 * alPremioPartido es un ArrayList de tipo Partido.
	 */
	private ArrayList<Partido> alPremioPartido;

	/*
	 * sede es de tipo Sede.
	 */
	private Sede sede;
	/*
	 * apostador es de tipo Apostador.
	 */
	private Apostador apostador;
	/*
	 * casa es de tipo CasaDeApuesta.
	 */
	private CasaDeApuesta casa;
	/*
	 * apuesta es de tipo Apuesta.
	 */
	private Apuesta apuesta;
	/*
	 * baloto es de tipo Baloto.
	 */
	private Baloto baloto;
	/*
	 * superAstro es de tipo SuperAstro.
	 */
	private SuperAstro superAstro;
	/*
	 * partido es de tipo Partido.
	 */
	private Partido partido;

	/*
	 * propiedades es de tipo Propiedades.
	 */
	private Propiedades propiedades;
	/*
	 * pDatos es de tipo Properties
	 */
	private Properties pDatos;

	/*
	 * fileJuego es de tipo File.
	 */
	private File fileJuego;
	/*
	 * fileSede es de tipo File.
	 */
	private File fileSede;
	/*
	 * fileApostador es de tipo File.
	 */
	private File fileApostador;
	/*
	 * fileBaloto es de tipo File.
	 */
	private File fileBaloto;
	/*
	 * fileSuperAstro es de tipo File.
	 */
	private File fileSuperAstro;
	/*
	 * filePartido es de tipo File.
	 */
	private File filePartido;
	/*
	 * filePremioBaloto es de tipo File.
	 */
	private File filePremioBaloto;
	/*
	 * filePremioSuperAstro es de tipo File.
	 */
	private File filePremioSuperAstro;
	/*
	 * filePremioPartido es de tipo File.
	 */
	private File filePremioPartido;

	/*
	 * archivo es de tipo Archivo.
	 */
	private Archivo archivo;

	/*
	 * juegoDAO es de tipo JuegoDAO.
	 */
	private JuegoDAO juegoDAO;
	/*
	 * sedeDAO es de tipo SedeDAO.
	 */
	private SedeDAO sedeDAO;
	/*
	 * balotoDAO es de tipo BalotoDAO.
	 */
	private BalotoDAO balotoDAO;
	/*
	 * superAstroDAO es de tipo SuperAstroDAO.
	 */
	private SuperAstroDAO superAstroDAO;
	/*
	 * partidoDAO es de tipo PartidoDAO.
	 */
	private PartidoDAO partidoDAO;
	/*
	 * apostadorDAO es de tipo ApostadorDAO.
	 */
	private ApostadorDAO apostadorDAO;
	/*
	 * premiosDAO es de tipo premiosDAO.
	 */
	private PremiosDAO premiosDAO;

	/*
	 * ganadorBaloto es de tipo String
	 */
	private String ganadorBaloto;
	/*
	 * ganadorSuperAstro es de tipo String.
	 */
	private String ganadorSuperAstro;
	/*
	 * ganadorPartido es de tipo String
	 */
	private String ganadorPartido;

	private ImprimirPDF pdf;

	private ImprimirExcel exel;

	/**
	 * Constructor de la clase Controller donde contiene una excepción. En este se
	 * inicializan todos los métodos y variables. <b>pre</b> Se deben inicializar
	 * todas las variables y agregarlas para que el programa funcione y se unan la
	 * vista y el modelo.<br>
	 * <b>post</b> Se iniciliazan las variables para guardar en las variables y usar
	 * los métodos de las diferentes clases.<br>
	 * 
	 * @throws Exception es la excepción que usa el constructor.
	 */
	public Controller() throws Exception {

		sesionAdministrador = new SesionAdministrador();
		ventanaPrincipal = new VentanaPrincipal();
		ventanaApostador = new VentanaApostador();
		ventanaAdministrador = new VentanaAdministrador();

		alCasa = new ArrayList<CasaDeApuesta>();
		alJuego = new ArrayList<Juego>();
		alSede = new ArrayList<Sede>();
		alApostador = new ArrayList<Apostador>();
		alBaloto = new ArrayList<Baloto>();
		alSuperAstro = new ArrayList<SuperAstro>();
		alPartido = new ArrayList<Partido>();
		alPremioBaloto = new ArrayList<Baloto>();
		alPremioSuperAstro = new ArrayList<SuperAstro>();
		alPremioPartido = new ArrayList<Partido>();

		pdf = new ImprimirPDF();
		exel = new ImprimirExcel();
		sede = new Sede();
		apostador = new Apostador();
		casa = new CasaDeApuesta();
		apuesta = new Apuesta();
		baloto = new Baloto();
		superAstro = new SuperAstro();
		partido = new Partido();
		propiedades = new Propiedades();
		pDatos = new Properties();
		pDatos = propiedades.leerDatos(new File("datos\\config.properties"));
		alCasa = propiedades.CargarDatos(pDatos);

		fileJuego = new File("datos\\juegos.dat");
		fileSede = new File("datos\\sedes.dat");
		fileApostador = new File("datos\\apostadores.dat");
		fileBaloto = new File("datos\\apuestas-baloto.dat");
		fileSuperAstro = new File("datos\\apuestas-superastro.dat");
		filePartido = new File("datos\\apuestas-marcadores.dat");
		filePremioBaloto = new File("datos\\premio-baloto.dat");
		filePremioSuperAstro = new File("datos\\premio-superastro.dat");
		filePremioPartido = new File("datos\\premio-partido.dat");

		archivo = new Archivo(fileJuego);
		archivo = new Archivo(fileSede);
		archivo = new Archivo(fileApostador);
		archivo = new Archivo(fileBaloto);
		archivo = new Archivo(fileSuperAstro);
		archivo = new Archivo(filePartido);
		archivo = new Archivo(filePremioBaloto);
		archivo = new Archivo(filePremioSuperAstro);
		archivo = new Archivo(filePremioPartido);

		juegoDAO = new JuegoDAO(archivo);
		sedeDAO = new SedeDAO(archivo);
		apostadorDAO = new ApostadorDAO(archivo);
		balotoDAO = new BalotoDAO(archivo);
		superAstroDAO = new SuperAstroDAO(archivo);
		partidoDAO = new PartidoDAO(archivo);
		premiosDAO = new PremiosDAO(archivo);

		alJuego = archivo.leerArchivoJuego(fileJuego);
		alSede = archivo.leerArchivoSede(fileSede);
		alApostador = archivo.leerArchivoApostador(fileApostador);
		alBaloto = archivo.leerArchivoBaloto(fileBaloto);
		alSuperAstro = archivo.leerArchivoSuperAstro(fileSuperAstro);
		alPartido = archivo.leerArchivoPartido(filePartido);

		alPremioBaloto = archivo.leerArchivoBaloto(filePremioBaloto);
		alPremioSuperAstro = archivo.leerArchivoSuperAstro(filePremioSuperAstro);
		alPremioPartido = archivo.leerArchivoPartido(filePremioPartido);

		asignarOyentes();

		Apostador[] numeros = new Apostador[alApostador.size()];

		numeros = apostador.ordenamientoPorFechaApostador(alApostador, alSede);

		ArrayList<String> numeros2 = new ArrayList<String>();

		numeros2 = apostador.ordenamientoPorApuesta(alApostador, alBaloto, alSuperAstro, alPartido);

		propiedades.escribirPropiedades2(numeros, numeros2, pDatos);

		juegoDAO.agregarJuego(fileJuego);

	}

	/**
	 * Método al cuál se le asignan los oyentes a cada botón que esta en los paneles
	 * y ventanas. <b>pre</b> Deben tener un Action Command para poderles agregar el
	 * escuchador y agregarlo al método. <br>
	 * <b>post</b> Se le agrega el escuchador a cada botón para que funcione.<br>
	 */
	public void asignarOyentes() {

		ventanaPrincipal.getMinimizar().addActionListener(this);
		ventanaPrincipal.getCerrar().addActionListener(this);
		ventanaPrincipal.getBoton1().addActionListener(this);
		ventanaPrincipal.getBoton2().addActionListener(this);

		ventanaApostador.getVolver().addActionListener(this);
		ventanaApostador.getMinimizar().addActionListener(this);
		ventanaApostador.getCerrar().addActionListener(this);
		ventanaApostador.getIngresar().addActionListener(this);
		ventanaApostador.getRegistrar().addActionListener(this);

		ventanaApostador.getPanelRegistrarApostador().getVolver().addActionListener(this);
		ventanaApostador.getPanelRegistrarApostador().getMinimizar().addActionListener(this);
		ventanaApostador.getPanelRegistrarApostador().getCerrar().addActionListener(this);
		ventanaApostador.getPanelRegistrarApostador().getRegistrar().addActionListener(this);

		ventanaApostador.getPanelEditarApostador().getVolver().addActionListener(this);
		ventanaApostador.getPanelEditarApostador().getMinimizar().addActionListener(this);
		ventanaApostador.getPanelEditarApostador().getCerrar().addActionListener(this);
		ventanaApostador.getPanelEditarApostador().getEditar().addActionListener(this);

		ventanaApostador.getPanelApostador().getVolver().addActionListener(this);
		ventanaApostador.getPanelApostador().getMinimizar().addActionListener(this);
		ventanaApostador.getPanelApostador().getCerrar().addActionListener(this);
		ventanaApostador.getPanelApostador().getSeleccionar().addActionListener(this);
		ventanaApostador.getPanelApostador().getConfigurarPerfil().addActionListener(this);

		ventanaApostador.getPanelJuegoBaloto().getVolver().addActionListener(this);
		ventanaApostador.getPanelJuegoBaloto().getMinimizar().addActionListener(this);
		ventanaApostador.getPanelJuegoBaloto().getCerrar().addActionListener(this);
		ventanaApostador.getPanelJuegoBaloto().getInformacion().addActionListener(this);
		ventanaApostador.getPanelJuegoBaloto().getApostar().addActionListener(this);
		ventanaApostador.getPanelJuegoBaloto().getAleatorio().addActionListener(this);

		ventanaApostador.getPanelJuegoSuperAstro().getVolver().addActionListener(this);
		ventanaApostador.getPanelJuegoSuperAstro().getMinimizar().addActionListener(this);
		ventanaApostador.getPanelJuegoSuperAstro().getCerrar().addActionListener(this);
		ventanaApostador.getPanelJuegoSuperAstro().getInformacion().addActionListener(this);
		ventanaApostador.getPanelJuegoSuperAstro().getApostar().addActionListener(this);
		ventanaApostador.getPanelJuegoSuperAstro().getAleatorio().addActionListener(this);

		ventanaApostador.getPanelJuegoFutbol().getVolver().addActionListener(this);
		ventanaApostador.getPanelJuegoFutbol().getMinimizar().addActionListener(this);
		ventanaApostador.getPanelJuegoFutbol().getCerrar().addActionListener(this);
		ventanaApostador.getPanelJuegoFutbol().getInformacion().addActionListener(this);
		ventanaApostador.getPanelJuegoFutbol().getApostar().addActionListener(this);

		sesionAdministrador.getIngresar().addActionListener(this);
		sesionAdministrador.getSalir().addActionListener(this);

		ventanaAdministrador.getVolver().addActionListener(this);
		ventanaAdministrador.getMinimizar().addActionListener(this);
		ventanaAdministrador.getCerrar().addActionListener(this);
		ventanaAdministrador.getBoton1().addActionListener(this);
		ventanaAdministrador.getBoton2().addActionListener(this);
		ventanaAdministrador.getBoton3().addActionListener(this);
		ventanaAdministrador.getBoton4().addActionListener(this);
		ventanaAdministrador.getBoton5().addActionListener(this);
		ventanaAdministrador.getBoton6().addActionListener(this);
		ventanaAdministrador.getBoton7().addActionListener(this);
		ventanaAdministrador.getBoton8().addActionListener(this);

		ventanaAdministrador.getPanelAdministrarCasa().getVolver().addActionListener(this);
		ventanaAdministrador.getPanelAdministrarCasa().getMinimizar().addActionListener(this);
		ventanaAdministrador.getPanelAdministrarCasa().getCerrar().addActionListener(this);
		ventanaAdministrador.getPanelAdministrarCasa().getRegistrar().addActionListener(this);

		ventanaAdministrador.getPanelAdministrarSede().getVolver().addActionListener(this);
		ventanaAdministrador.getPanelAdministrarSede().getMinimizar().addActionListener(this);
		ventanaAdministrador.getPanelAdministrarSede().getCerrar().addActionListener(this);
		ventanaAdministrador.getPanelAdministrarSede().getAñadir().addActionListener(this);
		ventanaAdministrador.getPanelAdministrarSede().getEditar().addActionListener(this);

		ventanaAdministrador.getPanelRegistroResultados().getVolver().addActionListener(this);
		ventanaAdministrador.getPanelRegistroResultados().getMinimizar().addActionListener(this);
		ventanaAdministrador.getPanelRegistroResultados().getCerrar().addActionListener(this);

		ventanaAdministrador.getPanelRegistroResultados().getRegistrarBaloto().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarBaloto().getVolver().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarBaloto().getMinimizar().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarBaloto().getCerrar().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarBaloto().getRegistrarResultados().addActionListener(this);

		ventanaAdministrador.getPanelRegistroResultados().getRegistrarSuperAstro().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarSuperAstro().getVolver().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarSuperAstro().getMinimizar().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarSuperAstro().getCerrar().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarSuperAstro().getRegistrarSuperAstro().addActionListener(this);

		ventanaAdministrador.getPanelRegistroResultados().getRegistrarFutbol().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarPartido().getVolver().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarPartido().getMinimizar().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarPartido().getCerrar().addActionListener(this);
		ventanaAdministrador.getPanelRegistrarPartido().getRegistrar().addActionListener(this);

	}

	/**
	 * Método al cuál se escucha lo que tiene en los botones y este les agregará el
	 * evento al botón. Se agrega los diferentes parámetros a realizar entre vista y
	 * modelo. <b>pre</b> Se debe tener el escuchador y agregar como se llama ese
	 * escuchador al método.<br>
	 * <b>post</b> Se le da un evento para la funcionalidad del botón y funcionen
	 * los parámetros.<br>
	 * 
	 * @param e que es de tipo ActionEvent: e debe ser != de null.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

//-----------------------------------MINIMIZA Y CIERRA VENTANA---------------------------------------------

		if (comando.equals("MINIMIZARVENTANA")) {
			ventanaPrincipal.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARVENTANA")) {
			System.exit(0);
		}
//-----------------------------------------------------SECCION DE APOSTADOR---------------------------

		if (comando.equals("INGRESOAPOSTADOR")) {

			ventanaPrincipal.setVisible(false);
			ventanaApostador.setVisible(true);

		} else if (comando.equals("INGRESOAPUESTAS")) {

			if (!"".equals(ventanaApostador.getCedula().getText())) {

				String pCedula = ventanaApostador.getCedula().getText();

				if (apostadorDAO.buscarApostador(pCedula, alApostador) != null) {

					JOptionPane.showMessageDialog(null, "Se encontró la cédula con éxito", "Información",
							JOptionPane.INFORMATION_MESSAGE);

					ventanaApostador.getCedula().setVisible(false);
					ventanaApostador.getIngresar().setVisible(false);
					ventanaApostador.getRegistrar().setVisible(false);

					ventanaApostador.getPanelApostador().getSede().removeAllItems();
					ventanaApostador.getPanelApostador().getSede().addItem(new String("Seleccione una sede..."));

					for (int i = 0; i < alSede.size(); i++) {

						ventanaApostador.getPanelApostador().getSede()
								.addItem(new String(alSede.get(i).getUbicacion()));
					}
					ventanaApostador.getPanelApostador().setVisible(true);
					ventanaApostador.getPanelApostador().getCedula().setText(String.valueOf("Cédula: " + pCedula));
					for (int i = 0; i < alApostador.size(); i++) {

						if (alApostador.get(i).getCedula().equals(pCedula)) {
							String pNombre = alApostador.get(i).getNombre();
							ventanaApostador.getPanelApostador().getUsuario()
									.setText(String.valueOf("Nombre: " + pNombre));
						}
					}

				} else {

					JOptionPane.showMessageDialog(null, "No se encontró esa cédula", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Le faltó llenar el campo", "Error", JOptionPane.WARNING_MESSAGE);
			}

		} else if (comando.equals("CONFIGURARPERFILAPOSTADOR")) {

			try {

				String[] prueba = { "Seleccione...", "Ver tu información", "Editar tu información", "Eliminar Perfil" };

				String pUbicacion = (JOptionPane.showInputDialog(null, "Selecciona que deseas hacer.", "Perfil",
						JOptionPane.INFORMATION_MESSAGE, null, prueba, "Seleccione")).toString();

				if ("Ver tu información".equals(pUbicacion)) {

					JOptionPane.showMessageDialog(null,
							apostadorDAO.verApostador(alApostador, ventanaApostador.getCedula().getText()));

				} else if ("Editar tu información".equals(pUbicacion)) {

					ventanaApostador.getPanelApostador().setVisible(false);
					ventanaApostador.getPanelEditarApostador().setVisible(true);

					ventanaApostador.getPanelEditarApostador().getSede().removeAllItems();
					ventanaApostador.getPanelEditarApostador().getSede().addItem(new String("Escoja una sede..."));

					for (int i = 0; i < alSede.size(); i++) {

						ventanaApostador.getPanelEditarApostador().getSede()
								.addItem(new String(alSede.get(i).getUbicacion()));
					}

				} else if ("Eliminar Perfil".equals(pUbicacion)) {

					int confirmado = JOptionPane.showConfirmDialog(null,
							"¿Está seguro que desea eliminar su usuario?\n(Los cambios realizados no se podrán revertir.");

					if (JOptionPane.OK_OPTION == confirmado) {

						if (apostadorDAO.eliminarApostador(ventanaApostador.getCedula().getText(), alApostador,
								fileApostador)) {

							JOptionPane.showMessageDialog(null, "Eliminado correctamente");

							ventanaApostador.getPanelApostador().setVisible(false);
							ventanaApostador.getCedula().setVisible(true);
							ventanaApostador.getIngresar().setVisible(true);
							ventanaApostador.getRegistrar().setVisible(true);

						} else {

							JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
						}
					}

					else {

					}

				}

			} catch (Exception error) {

			}

//-----------------------------------------------------SELECCION DEL JUEGO-----------------------------------------

		} else if (comando.equals("SELECCIONARJUEGOAPOSTADOR")) {

			if (!"Seleccione el tipo de juego..."
					.equals(ventanaApostador.getPanelApostador().getTipo().getSelectedItem().toString())
					&& !"Seleccione una sede..."
							.equals(ventanaApostador.getPanelApostador().getSede().getSelectedItem().toString())) {

				if (ventanaApostador.getPanelApostador().getTipo().getSelectedItem().toString() == "Baloto") {
					ventanaApostador.getPanelApostador().setVisible(false);
					ventanaApostador.getPanelApostador().getTipo().setSelectedIndex(0);
					ventanaApostador.getPanelJuegoBaloto().setVisible(true);
					String pCedula = ventanaApostador.getCedula().getText();
					ventanaApostador.getPanelJuegoBaloto().getCedula().setText(String.valueOf("Cédula: " + pCedula));
					for (int i = 0; i < alApostador.size(); i++) {

						if (alApostador.get(i).getCedula().equals(pCedula)) {
							String pNombre = alApostador.get(i).getNombre();
							ventanaApostador.getPanelJuegoBaloto().getUsuario()
									.setText(String.valueOf("Nombre: " + pNombre));
						}
					}

				} else if (ventanaApostador.getPanelApostador().getTipo().getSelectedItem()
						.toString() == "Super Astro") {

					ventanaApostador.getPanelApostador().setVisible(false);
					ventanaApostador.getPanelApostador().getTipo().setSelectedIndex(0);
					ventanaApostador.getPanelJuegoSuperAstro().setVisible(true);

					String pCedula = ventanaApostador.getCedula().getText();
					ventanaApostador.getPanelJuegoSuperAstro().getCedula()
							.setText(String.valueOf("Cédula: " + pCedula));
					for (int i = 0; i < alApostador.size(); i++) {

						if (alApostador.get(i).getCedula().equals(pCedula)) {
							String pNombre = alApostador.get(i).getNombre();
							ventanaApostador.getPanelJuegoSuperAstro().getUsuario()
									.setText(String.valueOf("Nombre: " + pNombre));
						}
					}

				} else if (ventanaApostador.getPanelApostador().getTipo().getSelectedItem()
						.toString() == "Champions League") {

					ventanaApostador.getPanelApostador().setVisible(false);
					ventanaApostador.getPanelApostador().getTipo().setSelectedIndex(0);
					ventanaApostador.getPanelJuegoFutbol().setVisible(true);
					String pCedula = ventanaApostador.getCedula().getText();

					ventanaApostador.getPanelJuegoFutbol().getCedula().setText(String.valueOf("Cédula: " + pCedula));
					for (int i = 0; i < alApostador.size(); i++) {

						if (alApostador.get(i).getCedula().equals(pCedula)) {
							String pNombre = alApostador.get(i).getNombre();
							ventanaApostador.getPanelJuegoFutbol().getUsuario()
									.setText(String.valueOf("Nombre: " + pNombre));
						}
					}

					ventanaApostador.getPanelJuegoFutbol().getPartidos().removeAllItems();
					ventanaApostador.getPanelJuegoFutbol().getPartidos()
							.addItem(new String("Seleccione un partido..."));

					for (int i = 0; i < alPremioPartido.size(); i++) {

						ventanaApostador.getPanelJuegoFutbol().getPartidos()
								.addItem(new String(alPremioPartido.get(i).getEquipoLocal() + "-"
										+ alPremioPartido.get(i).getEquipoVisitante()));
					}

				}

			} else {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una sede o juego", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

//-----------------------------------------------------APUESTA BALOTO-------------------------------------------------------

		} else if (comando.equals("FAQBALOTO")) {

			JTextArea textArea = new JTextArea(
					"¡Bienvenido a Baloto!, has que tus sueños se cumplan acertando, recuerda que la suerte está en todas partes y todos pueden ganar.\r\n"
							+ "\r\n" + "Para jugar, podrás hacerlo de dos formas muy simples: \r\n"
							+ "1.) BALOTO MANUAL: Tendrás la opción de ingresar los números por los que confiaras para conseguir el gran bote y así poderte convertir en millonario.\r\n"
							+ "RECUERDA que los valores ingresados, deben estar en el rango de 1-45, y no se deben repetir.\r\n\n"
							+ "2.) BALOTO AUTOMÁTICO: Usando el botón que se encuentra junto a los campos donde puedes escribir tu número, se generaran aleatorios, si alguno de estos números no te convence, podrás modificarlo directamente y así apostar por una elección más propia, claro, cumpliendo con las restricciones mencionadas en el BALOTO MANUAL.\r\n"
							+ "\r\n" + "¿CÓMO GANAR?\r\n"
							+ "- Este Baloto no es como el que estamos acostumbrados a jugar, aquí se requiere una mayor precisión y no hay espacio para errores porque solo podrás ganar si ACIERTAS LOS 6 NÚMEROS EN EL ORDEN CORRECTO, así que medita tu decisión y consúltala con la almohada.\r\n"
							+ "\r\n" + "¿CUÁNTO PUEDES GANAR?\r\n"
							+ "El presupuesto asignado para este juego corresponde al 40% de esta, tu casa de apuestas favorita, actualmente con el presupuesto determinado por nuestro administrador, podras llevarte el gran bote: 500.000.000.\r\n\n"
							+ "Autorizado por Coljuegos.\r\n" + "");
			JScrollPane scrollPane = new JScrollPane(textArea);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setEditable(false);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(null, scrollPane, "FAQ de Baloto", JOptionPane.INFORMATION_MESSAGE);

		} else if (comando.equals("APOSTARBALOTO")) {

			if (!"".equals(ventanaApostador.getPanelJuegoBaloto().getValorApuesta().getText())
					&& !"".equals(ventanaApostador.getPanelJuegoBaloto().getNumero1().getText())
					&& !"".equals(ventanaApostador.getPanelJuegoBaloto().getNumero2().getText())
					&& !"".equals(ventanaApostador.getPanelJuegoBaloto().getNumero3().getText())
					&& !"".equals(ventanaApostador.getPanelJuegoBaloto().getNumero4().getText())
					&& !"".equals(ventanaApostador.getPanelJuegoBaloto().getNumero5().getText())
					&& !"".equals(ventanaApostador.getPanelJuegoBaloto().getNumero6().getText())) {

				try {

					String pSede = ventanaApostador.getPanelApostador().getSede().getSelectedItem().toString();
					String pCedula = ventanaApostador.getCedula().getText();

					String inFecha = ventanaApostador.getPanelJuegoBaloto().getFecha().getText();
					SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
					formateador.setLenient(false);
					Date pFecha = formateador.parse(inFecha);

					String pApuesta = ventanaApostador.getPanelJuegoBaloto().getValorApuesta().getText();
					String pPremio = "Acertar 4 numeros: " + alPremioBaloto.get(0).getPorcentaje4()
							+ "\nAcierta 5 numeros: " + alPremioBaloto.get(0).getPorcentaje4() + "\nAcierta todos: "
							+ alPremioBaloto.get(0).getPorcentaje6() + "\nPresupuesto total para el Baloto: "
							+ alPremioBaloto.get(0).getPresupuesto();
					String pNumero1 = ventanaApostador.getPanelJuegoBaloto().getNumero1().getText();
					String pNumero2 = ventanaApostador.getPanelJuegoBaloto().getNumero2().getText();
					String pNumero3 = ventanaApostador.getPanelJuegoBaloto().getNumero3().getText();
					String pNumero4 = ventanaApostador.getPanelJuegoBaloto().getNumero4().getText();
					String pNumero5 = ventanaApostador.getPanelJuegoBaloto().getNumero5().getText();
					String pNumero6 = ventanaApostador.getPanelJuegoBaloto().getNumero6().getText();

					ArrayList<String> numeros = new ArrayList<String>();
					numeros.add(pNumero1);
					numeros.add(pNumero2);
					numeros.add(pNumero3);
					numeros.add(pNumero4);
					numeros.add(pNumero5);
					numeros.add(pNumero6);
					int c = 0;
					for (int i = 0; i < numeros.size(); i++) {

						for (int j = 0; j < numeros.size(); j++) {

							if (numeros.get(i).equals(numeros.get(j)) && i != j) {

								c++;
								break;
							}

						}
						if (c == 1) {

							break;
						}

					}

					try {
						baloto.excepcionNumero(pNumero1);
						baloto.excepcionNumero(pNumero2);
						baloto.excepcionNumero(pNumero3);
						baloto.excepcionNumero(pNumero4);
						baloto.excepcionNumero(pNumero5);
						baloto.excepcionNumero(pNumero6);
						baloto.excepcionApuesta(pApuesta);

						if (c < 1) {

							String pNumero = pNumero1 + "-" + pNumero2 + "-" + pNumero3 + "-" + pNumero4 + "-"
									+ pNumero5 + "-" + pNumero6;

							balotoDAO.agregarBaloto(pSede, pCedula, pFecha, pApuesta, pPremio, pNumero, alBaloto,
									fileBaloto);

							JOptionPane.showMessageDialog(null, "Apuesta registrada correctamente");
							JOptionPane.showMessageDialog(null, balotoDAO.verBalotoUltimo(alBaloto, alBaloto.size()));

							ventanaApostador.getPanelJuegoBaloto().getValorApuesta().setText("");
							ventanaApostador.getPanelJuegoBaloto().getNumero1().setText("");
							ventanaApostador.getPanelJuegoBaloto().getNumero2().setText("");
							ventanaApostador.getPanelJuegoBaloto().getNumero3().setText("");
							ventanaApostador.getPanelJuegoBaloto().getNumero4().setText("");
							ventanaApostador.getPanelJuegoBaloto().getNumero5().setText("");
							ventanaApostador.getPanelJuegoBaloto().getNumero6().setText("");

						} else {

							JOptionPane.showMessageDialog(null, "Los numeros estan repetidos", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}

					} catch (ExcepcionApuesta e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Le faltaron campos por llenar", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (comando.equals("VOLVERJUEGOBALOTO")) {

			ventanaApostador.getPanelJuegoBaloto().setVisible(false);
			ventanaApostador.getPanelApostador().setVisible(true);
			ventanaApostador.getPanelApostador().getSede().setSelectedIndex(0);

		} else if (comando.equals("MINIZARJUEGOBALOTO")) {

			ventanaApostador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARJUEGOBALOTO")) {
			System.exit(0);

		} else if (comando.equals("ALEATORIOJUEGOBALOTO")) {

			String numeros = baloto.calcularAleatorio();
			String num1, num2, num3, num4, num5;
			num1 = numeros.substring(0, numeros.indexOf("-"));
			numeros = numeros.substring(numeros.indexOf("-") + 1, numeros.length());
			num2 = numeros.substring(0, numeros.indexOf("-"));
			numeros = numeros.substring(numeros.indexOf("-") + 1, numeros.length());
			num3 = numeros.substring(0, numeros.indexOf("-"));
			numeros = numeros.substring(numeros.indexOf("-") + 1, numeros.length());
			num4 = numeros.substring(0, numeros.indexOf("-"));
			numeros = numeros.substring(numeros.indexOf("-") + 1, numeros.length());
			num5 = numeros.substring(0, numeros.indexOf("-"));
			numeros = numeros.substring(numeros.indexOf("-") + 1, numeros.length());

			ventanaApostador.getPanelJuegoBaloto().getNumero1().setText(num1);
			ventanaApostador.getPanelJuegoBaloto().getNumero2().setText(num2);
			ventanaApostador.getPanelJuegoBaloto().getNumero3().setText(num3);
			ventanaApostador.getPanelJuegoBaloto().getNumero4().setText(num4);
			ventanaApostador.getPanelJuegoBaloto().getNumero5().setText(num5);
			ventanaApostador.getPanelJuegoBaloto().getNumero6().setText(numeros);

//-----------------------------------------------------APUESTA SUPER ASTRO-------------------------------------------------------

		} else if (comando.equals("FAQSUPERASTRO")) {

			JTextArea textArea = new JTextArea("SUPER ASTRO\r\n"
					+ "Que las constelaciones y el destino se acomoden a tu favor... y a favor de tu bolcillo.\r\n"
					+ "La forma más fácil de ganar, pero como todo en la vida, tienes que arriesgar. \r\n"
					+ "El trascendental juego que nos identifica, llega a tu casa de apuestas favorita, aquí te explicamos los términos y condiciones, además de la información necesaria para jugar y ganar.!\r\n"
					+ "Tienes que acertar 4 números y el signo zodiacal para hacerte millonario, los números están comprendidos entre el rango de 0-9, no hay restricción para los números repetidos.\r\n"
					+ "Para jugar, contamos con dos modalidades para el ingreso de tus números y tu signo.\r\n"
					+ "1.)    Súper Astro Manual: Tendrás la opción de poder ingresar en los campos de texto los números de tu preferencia, estos deben cumplir con los requisitos mencionados anteriormente.\r\n"
					+ "2.)    Súper Astro Automático: Usando el botón “Aleatorio” ubicado junto a los campos de texto, se generarán aleatoriamente los números, si alguno no es de tu agrado, no hay problema, puedes modificarlo antes de generar tu ticket. El signo zodiacal no se generará aleatoriamente, este tienes que seleccionarlo de la lista, antes o después de generar o ingresar los números.\r\n"
					+ "¡PREMIOS!\r\n"
					+ "Premio Grande: Tendrás la oportunidad de llevarte los 500.000.000 y convertir tus sueños en realidad.\r\n"
					+ "Premio Chico: Aunque de chico no tiene nada, al acertar únicamente los números, podrás llevarte el 20% del gran bote a repartir, aquí somos generosos con todos y esperamos que no te vayas con las manos vacías.");
			JScrollPane scrollPane = new JScrollPane(textArea);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setEditable(false);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(null, scrollPane, "FAQ de Super Astro", JOptionPane.INFORMATION_MESSAGE);

		} else if (comando.equals("APOSTARSUPERASTRO")) {

			if (!"".equals(ventanaApostador.getPanelJuegoSuperAstro().getValorApuesta().getText())
					&& !"".equals(ventanaApostador.getPanelJuegoSuperAstro().getNumero1().getText())
					&& !"".equals(ventanaApostador.getPanelJuegoSuperAstro().getNumero2().getText())
					&& !"".equals(ventanaApostador.getPanelJuegoSuperAstro().getNumero3().getText())
					&& !"".equals(ventanaApostador.getPanelJuegoSuperAstro().getNumero4().getText())
					&& !"Seleccione su signo...".equals(
							ventanaApostador.getPanelJuegoSuperAstro().getSigno().getSelectedItem().toString())) {

				try {

					String pSede = ventanaApostador.getPanelApostador().getSede().getSelectedItem().toString();
					String pCedula = ventanaApostador.getCedula().getText();

					String inFecha = ventanaApostador.getPanelJuegoSuperAstro().getFecha().getText();
					SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
					formateador.setLenient(false);
					Date pFecha = formateador.parse(inFecha);

					String pApuesta = ventanaApostador.getPanelJuegoSuperAstro().getValorApuesta().getText();
					String pPremio = "Acertar los numeros: " + alPremioSuperAstro.get(0).getPorcentajenumeros()
							+ "\nAcierta todos: " + alPremioSuperAstro.get(0).getPorcentajetodo()
							+ "\nPresupuesto total para el Super Astro: " + alPremioSuperAstro.get(0).getPresupuesto();
					String pNumero1 = ventanaApostador.getPanelJuegoSuperAstro().getNumero1().getText();
					String pNumero2 = ventanaApostador.getPanelJuegoSuperAstro().getNumero2().getText();
					String pNumero3 = ventanaApostador.getPanelJuegoSuperAstro().getNumero3().getText();
					String pNumero4 = ventanaApostador.getPanelJuegoSuperAstro().getNumero4().getText();
					String pZodiaco = ventanaApostador.getPanelJuegoSuperAstro().getSigno().getSelectedItem()
							.toString();

					try {
						superAstro.excepcionNumero(pNumero1);
						superAstro.excepcionNumero(pNumero2);
						superAstro.excepcionNumero(pNumero3);
						superAstro.excepcionNumero(pNumero4);
						superAstro.excepcionApuesta(pApuesta);

						String pNumero = pNumero1 + "-" + pNumero2 + "-" + pNumero3 + "-" + pNumero4;

						superAstroDAO.agregarSuperAstro(pSede, pCedula, pFecha, pApuesta, pPremio, pNumero, pZodiaco,
								alSuperAstro, fileSuperAstro);

						JOptionPane.showMessageDialog(null, "Apuesta registrada correctamente");

						JOptionPane.showMessageDialog(null,
								superAstroDAO.verSuperAstroUltimo(alSuperAstro, alSuperAstro.size()));

						ventanaApostador.getPanelJuegoBaloto().getValorApuesta().setText("");
						ventanaApostador.getPanelJuegoSuperAstro().getNumero1().setText("");
						ventanaApostador.getPanelJuegoSuperAstro().getNumero2().setText("");
						ventanaApostador.getPanelJuegoSuperAstro().getNumero3().setText("");
						ventanaApostador.getPanelJuegoSuperAstro().getNumero4().setText("");
						ventanaApostador.getPanelJuegoSuperAstro().getSigno().setSelectedIndex(0);

					} catch (ExcepcionApuesta e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Le faltaron campos por llenar", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (comando.equals("VOLVERJUEGOSUPERASTRO")) {

			ventanaApostador.getPanelJuegoSuperAstro().setVisible(false);
			ventanaApostador.getPanelApostador().setVisible(true);
			ventanaApostador.getPanelApostador().getSede().setSelectedIndex(0);

		} else if (comando.equals("MINIZARJUEGOSUPERASTRO")) {

			ventanaApostador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARJUEGOSUPERASTRO")) {

			System.exit(0);

		} else if (comando.equals("ALEATORIOSUPERASTRO")) {

			String numeros = superAstro.calcularAleatorio();
			String num1, num2, num3, num4;
			num1 = numeros.substring(0, numeros.indexOf("-"));
			numeros = numeros.substring(numeros.indexOf("-") + 1, numeros.length());
			num2 = numeros.substring(0, numeros.indexOf("-"));
			numeros = numeros.substring(numeros.indexOf("-") + 1, numeros.length());
			num3 = numeros.substring(0, numeros.indexOf("-"));
			numeros = numeros.substring(numeros.indexOf("-") + 1, numeros.length());
			num4 = numeros.substring(0, numeros.indexOf("-"));
			numeros = numeros.substring(numeros.indexOf("-") + 1, numeros.length());

			ventanaApostador.getPanelJuegoSuperAstro().getNumero1().setText(num1);
			ventanaApostador.getPanelJuegoSuperAstro().getNumero2().setText(num2);
			ventanaApostador.getPanelJuegoSuperAstro().getNumero3().setText(num3);
			ventanaApostador.getPanelJuegoSuperAstro().getNumero4().setText(num4);

//-----------------------------------------------------APUESTA FUTBOL-------------------------------------------------------		
		} else if (comando.equals("FAQFUTBOL")) {

			JTextArea textArea = new JTextArea("ENCUENTROS CHAMPIONS LEAGUE\r\n"
					+ "Para disfrutar mejor los partidos del mejor torneo del mundo, puedes acompañar tus agradables tardes con una pequeña cantidad extra de dinero solo por apostar. El juego ideal para el amigo gurú del futbol.\r\n"
					+ "Actualmente contamos con una variada lista de los próximos 14 partidos del torneo, los cuales representan la recta final de la fase de grupos, donde se vienen los partidos mas intensos y determinantes para el futuro de los equipos.\r\n"
					+ "Para participar, debes ubicarte en la lista de partidos, escoger por el que quieres apostar, seleccionar del otro menú disponible, el resultado, si gana el equipo local, el visitante o si hay un empate. \r\n"
					+ "¡¿COMO PUEDO GANAR?!\r\n"
					+ "Tienes que acertar el resultado del partido, recuerda que cada partido tiene un momio asignado por cada posible apuesta, este momio está basado en las estadísticas recientes de los encuentros de cada equipo… en ocasiones una apuesta arriesgada puede ser la decisión mas sensata. \r\n"
					+ "\r\n" + "¿COMO FUNCIONA EL MOMIO EN EL PREMIO?\r\n"
					+ "Es un porcentaje extra que te podrás llevar si aciertas el resultado.");
			JScrollPane scrollPane = new JScrollPane(textArea);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setEditable(false);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(null, scrollPane, "FAQ de Champions League", JOptionPane.INFORMATION_MESSAGE);

		} else if (comando.equals("APOSTARFUTBOL")) {

			if (!"".equals(ventanaApostador.getPanelJuegoFutbol().getValorApuesta().getText())
					&& !"Seleccione un partido..."
							.equals(ventanaApostador.getPanelJuegoFutbol().getPartidos().getSelectedItem().toString())
					&& !"Seleccione un resultado..."
							.equals(ventanaApostador.getPanelJuegoFutbol().getModo().getSelectedItem().toString())) {

				try {

					String pSede = ventanaApostador.getPanelApostador().getSede().getSelectedItem().toString();
					String pCedula = ventanaApostador.getCedula().getText();

					String inFecha = ventanaApostador.getPanelJuegoFutbol().getFecha().getText();
					SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
					formateador.setLenient(false);
					Date pFecha = formateador.parse(inFecha);

					String pApuesta = ventanaApostador.getPanelJuegoFutbol().getValorApuesta().getText();

					int posicion = ventanaApostador.getPanelJuegoFutbol().getPartidos().getSelectedIndex() - 1;

					String pPremio = "Gana " + alPremioPartido.get(posicion).getEquipoLocal() + ": "
							+ +alPremioPartido.get(posicion).getPorcentajeGanador() + "\nGana "
							+ alPremioPartido.get(posicion).getEquipoVisitante() + ": "
							+ alPremioPartido.get(posicion).getPorcentajePerdedor() + "\nEmpata: "
							+ alPremioPartido.get(posicion).getPorcentajeEmpate()
							+ "\nPresupuesto total para el Partido: " + alPremioPartido.get(posicion).getPresupuesto();
					String presultado = ventanaApostador.getPanelJuegoFutbol().getModo().getSelectedItem().toString();

					String pLocal = alPremioPartido.get(posicion).getEquipoLocal();
					String pVisitante = alPremioPartido.get(posicion).getEquipoVisitante();

					try {

						partido.excepcionApuesta(pApuesta);

						partidoDAO.agregarPartido(pSede, pCedula, pFecha, pApuesta, pPremio, presultado, pLocal,
								pVisitante, alPartido, filePartido);

						JOptionPane.showMessageDialog(null, "Apuesta registrada correctamente");

						JOptionPane.showMessageDialog(null, partidoDAO.verPartidoUltimo(alPartido, alPartido.size()));

						ventanaApostador.getPanelJuegoFutbol().getValorApuesta().setText("");
						ventanaApostador.getPanelJuegoFutbol().getModo().setSelectedIndex(0);
						ventanaApostador.getPanelJuegoFutbol().getPartidos().setSelectedIndex(0);

					} catch (ExcepcionApuesta e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Le faltaron campos por llenar", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (comando.equals("VOLVERJUEGOFUTBOL")) {

			ventanaApostador.getPanelJuegoFutbol().setVisible(false);
			ventanaApostador.getPanelApostador().setVisible(true);
			ventanaApostador.getPanelApostador().getSede().setSelectedIndex(0);

		} else if (comando.equals("MINIMIZARJUEGOFUTBOL")) {

			ventanaApostador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARJUEGOFUTBOL")) {

			System.exit(0);

		} else if (comando.equals("VOLVERELECCIONAPOSTADOR")) {

			ventanaApostador.getPanelApostador().setVisible(false);
			ventanaApostador.getCedula().setText("");
			ventanaApostador.getCedula().setVisible(true);
			ventanaApostador.getIngresar().setVisible(true);
			ventanaApostador.getRegistrar().setVisible(true);

		} else if (comando.equals("MINIMIZARELECCIONAPOSTADOR")) {

			ventanaApostador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARELECCIONAPOSTADOR")) {

			System.exit(0);
//-------------------------------------------GESTION REGISTRO APOSTADOR-----------------------------------------------------

		} else if (comando.equals("REGISTRARAPOSTADOR")) {

			ventanaApostador.getIngresar().setVisible(false);
			ventanaApostador.getRegistrar().setVisible(false);
			ventanaApostador.getCedula().setText("");
			ventanaApostador.getCedula().setVisible(false);
			ventanaApostador.getVolver().setVisible(false);
			ventanaApostador.getMinimizar().setVisible(false);
			ventanaApostador.getCerrar().setVisible(false);
			ventanaApostador.getPanelRegistrarApostador().getSede().removeAllItems();
			ventanaApostador.getPanelRegistrarApostador().getSede().addItem(new String("Escoja una sede..."));

			for (int i = 0; i < alSede.size(); i++) {

				ventanaApostador.getPanelRegistrarApostador().getSede()
						.addItem(new String(alSede.get(i).getUbicacion()));
			}
			ventanaApostador.getPanelRegistrarApostador().setVisible(true);

		} else if (comando.equals("TERMINARREGISTROAPOSTADOR")) {

			if (!"".equals(ventanaApostador.getPanelRegistrarApostador().getNombre().getText())
					&& !"".equals(ventanaApostador.getPanelRegistrarApostador().getApellido().getText())
					&& !"Escoja una sede...".equals(
							ventanaApostador.getPanelRegistrarApostador().getSede().getSelectedItem().toString())
					&& !"".equals(ventanaApostador.getPanelRegistrarApostador().getCedula().getText())
					&& !"".equals(ventanaApostador.getPanelRegistrarApostador().getTelefono().getText())) {

				String nombre = ventanaApostador.getPanelRegistrarApostador().getNombre().getText() + " "
						+ ventanaApostador.getPanelRegistrarApostador().getApellido().getText();
				String sede = ventanaApostador.getPanelRegistrarApostador().getSede().getSelectedItem().toString();
				String cedula = ventanaApostador.getPanelRegistrarApostador().getCedula().getText();
				String direccion = ventanaApostador.getPanelRegistrarApostador().getDireccion().getText();
				String celular = ventanaApostador.getPanelRegistrarApostador().getTelefono().getText();
				double pGanacias = 0;
				Date pFecha = new Date();

				try {

					apostador.excepcionNombre(nombre);
					apostador.excepcionCedula(cedula);
					apostador.excepcionCelular(celular);

					if (apostadorDAO.agregarApostador(nombre, cedula, sede, direccion, celular, pGanacias, pFecha,
							alApostador, fileApostador)) {

						JOptionPane.showMessageDialog(null, "Registro con éxito", "Información",
								JOptionPane.INFORMATION_MESSAGE);

						ventanaApostador.getPanelRegistrarApostador().getNombre().setText("");
						ventanaApostador.getPanelRegistrarApostador().getApellido().setText("");
						ventanaApostador.getPanelRegistrarApostador().getSede().setSelectedIndex(0);
						ventanaApostador.getPanelRegistrarApostador().getCedula().setText("");
						ventanaApostador.getPanelRegistrarApostador().getDireccion().setText("");
						ventanaApostador.getPanelRegistrarApostador().getTelefono().setText("");

					} else {

						JOptionPane.showMessageDialog(null, "Ya se encuentra registrada esa cédula", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (ExcepcionNombre e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (ExcepcionNumero e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "No puede dejar campos sin llenar", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
//--------------------------------------------------EDITAR APOSTADOR------------------------------------------------------

		} else if (comando.equals("EDITARAPOSTADOR")) {

			if (!"".equals(ventanaApostador.getPanelEditarApostador().getNombre().getText())
					&& !"".equals(ventanaApostador.getPanelEditarApostador().getApellido().getText())
					&& !"".equals(ventanaApostador.getPanelEditarApostador().getDireccion().getText())
					&& !"".equals(ventanaApostador.getPanelEditarApostador().getSede().getSelectedItem().toString())
					&& !"".equals(ventanaApostador.getPanelEditarApostador().getTelefono().getText())) {

				String pNombre = ventanaApostador.getPanelEditarApostador().getNombre().getText() + " "
						+ ventanaApostador.getPanelEditarApostador().getApellido().getText();
				String pDireccion = ventanaApostador.getPanelEditarApostador().getDireccion().getText();
				String pTelefono = ventanaApostador.getPanelEditarApostador().getTelefono().getText();
				String pSede = ventanaApostador.getPanelEditarApostador().getSede().getSelectedItem().toString();

				try {

					apostador.excepcionNombre(pNombre);
					apostador.excepcionCelular(pTelefono);

					if (apostadorDAO.editarApostador(pNombre, ventanaApostador.getCedula().getText(), pSede, pDireccion,
							pTelefono, alApostador, fileApostador)) {

						JOptionPane.showMessageDialog(null, "Se ha editado correctamente", "Información",
								JOptionPane.INFORMATION_MESSAGE);

						ventanaApostador.getPanelEditarApostador().getNombre().setText("");
						ventanaApostador.getPanelEditarApostador().getApellido().setText("");
						ventanaApostador.getPanelEditarApostador().getDireccion().setText("");
						ventanaApostador.getPanelEditarApostador().getTelefono().setText("");

						ventanaApostador.getPanelEditarApostador().setVisible(false);
						ventanaApostador.getPanelApostador().getCedula()
								.setText(String.valueOf("Cédula: " + ventanaApostador.getCedula().getText()));
						for (int i = 0; i < alApostador.size(); i++) {

							if (alApostador.get(i).getCedula().equals(ventanaApostador.getCedula().getText())) {
								String pNombre2 = alApostador.get(i).getNombre();
								ventanaApostador.getPanelApostador().getUsuario()
										.setText(String.valueOf("Nombre: " + pNombre2));
							}
						}
						ventanaApostador.getPanelApostador().setVisible(true);

					} else {

						JOptionPane.showMessageDialog(null, "No se pudo editar", "Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (ExcepcionNombre e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (ExcepcionNumero e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "No puede dejar campos sin llenar", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		} else if (comando.equals("VOLVERDEEDITAR")) {

			ventanaApostador.getPanelEditarApostador().getNombre().setText("");
			ventanaApostador.getPanelEditarApostador().getApellido().setText("");
			ventanaApostador.getPanelEditarApostador().getDireccion().setText("");
			ventanaApostador.getPanelEditarApostador().getTelefono().setText("");

			ventanaApostador.getPanelEditarApostador().setVisible(false);
			ventanaApostador.getPanelApostador().getCedula()
					.setText(String.valueOf("Cédula: " + ventanaApostador.getCedula().getText()));
			for (int i = 0; i < alApostador.size(); i++) {

				if (alApostador.get(i).getCedula().equals(ventanaApostador.getCedula().getText())) {
					String pNombre2 = alApostador.get(i).getNombre();
					ventanaApostador.getPanelApostador().getUsuario().setText(String.valueOf("Nombre: " + pNombre2));
				}
			}
			ventanaApostador.getPanelApostador().setVisible(true);

		} else if (comando.equals("MINIMIZAREDITAR")) {

			ventanaApostador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRAREDITAR")) {

			System.exit(0);

//------------------------------------------REGRESAR-CERRAR-MINIMIZAR APOSTADOR------------------------------------------
		} else if (comando.equals("VOLVERAPRINCIPAL")) {

			ventanaApostador.getCedula().setText("");
			ventanaApostador.getVolver().setVisible(true);
			ventanaApostador.getMinimizar().setVisible(true);
			ventanaApostador.getCerrar().setVisible(true);
			ventanaApostador.setVisible(false);
			ventanaPrincipal.setVisible(true);

		} else if (comando.equals("MINIMIZARVENTANAAPOSTADOR")) {

			ventanaApostador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARVENTANAAPOSTADOR")) {

			System.exit(0);

		} else if (comando.equals("VOLVERINICIOAPOSTADOR")) {

			ventanaApostador.getIngresar().setVisible(true);
			ventanaApostador.getRegistrar().setVisible(true);
			ventanaApostador.getCedula().setText("");
			ventanaApostador.getCedula().setVisible(true);
			ventanaApostador.getVolver().setVisible(true);
			ventanaApostador.getMinimizar().setVisible(true);
			ventanaApostador.getCerrar().setVisible(true);
			ventanaApostador.getPanelRegistrarApostador().setVisible(false);

		} else if (comando.equals("MINIMIZARREGISTROAPOSTADOR")) {

			ventanaApostador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARREGISTROAPOSTADOR")) {

			System.exit(0);

		}

//-----------------------------------------GESTION ADMINISTRADOR----------------------------------------------

		if (comando.equals("INGRESOADMINISTRADOR")) {
			ventanaPrincipal.setVisible(false);
			sesionAdministrador.setVisible(true);

		} else if (comando.equals("ENTRARADMIN")) {

			String usuario = sesionAdministrador.getCampoUsuario().getText();
			String contraseña = sesionAdministrador.getCampoContraseña().getText();

			if (sesionAdministrador.getCampoUsuario().getText().contentEquals("")
					|| sesionAdministrador.getCampoContraseña().getText().contentEquals("")) {
				JOptionPane.showMessageDialog(null, "Faltan campos por llenar", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (usuario.equals("admin") && contraseña.equals("admin")) {
				JOptionPane.showMessageDialog(null, "Inicio de sesión como administrador correcto", "Información",
						JOptionPane.INFORMATION_MESSAGE);
				sesionAdministrador.getCampoContraseña().setText("");
				sesionAdministrador.setVisible(false);
				ventanaAdministrador.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

///------------------------------------------ADMINISTRAR CASAS - ADMINISTRADOR------------------------------------------	

		} else if (comando.equals("ADMINISTRARCASAS")) {

			ventanaAdministrador.getVolver().setVisible(false);
			ventanaAdministrador.getMinimizar().setVisible(false);
			ventanaAdministrador.getCerrar().setVisible(false);
			ventanaAdministrador.getBoton1().setVisible(false);
			ventanaAdministrador.getBoton2().setVisible(false);
			ventanaAdministrador.getBoton3().setVisible(false);
			ventanaAdministrador.getBoton4().setVisible(false);
			ventanaAdministrador.getBoton5().setVisible(false);
			ventanaAdministrador.getBoton6().setVisible(false);
			ventanaAdministrador.getBoton7().setVisible(false);
			ventanaAdministrador.getBoton8().setVisible(false);
			ventanaAdministrador.getPanelAdministrarCasa().setVisible(true);

		} else if (comando.equals("TERMINARADMINCASA")) {

			String pNombreCasa = ventanaAdministrador.getPanelAdministrarCasa().getNombreCasa().getText();
			String pPresupuesto = ventanaAdministrador.getPanelAdministrarCasa().getPresupuesto().getText();
			String pSedes = ventanaAdministrador.getPanelAdministrarCasa().getNumeroSedes().getText();

			try {

				casa.excepcionPresupuesto(pPresupuesto);
				casa.excepcionPresupuesto(pSedes);

				if (propiedades.escribirPropiedades(pNombreCasa, pPresupuesto, pSedes, pDatos)) {

					JOptionPane.showMessageDialog(null, "La casa se ha modificado correctamente", "Información",
							JOptionPane.INFORMATION_MESSAGE);

					String informacion = "Información actualizada de la casa de apuestas: \n\n\n";

					for (int i = 0; i < alCasa.size(); i++) {

						informacion += "Nombre de la casa: " + alCasa.get(i).getNombre() + "\n" + "Número de sedes: "
								+ alCasa.get(i).getNumeroSedes() + "\n" + "Presupuesto de la casa: "
								+ alCasa.get(i).getPresupuesto() + "\n";
					}
					
					JOptionPane.showMessageDialog(null, informacion, "Información",
							JOptionPane.INFORMATION_MESSAGE);

					ventanaAdministrador.getPanelAdministrarCasa().getNombreCasa().setText("");
					ventanaAdministrador.getPanelAdministrarCasa().getPresupuesto().setText("");
					ventanaAdministrador.getPanelAdministrarCasa().getNumeroSedes().setText("");

				} else {

					JOptionPane.showMessageDialog(null, "No se ha podido modificar la casa", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (ExcepcionNumero e1) {

				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (comando.equals("VOLVERAVENTANAADMIN")) {

			ventanaAdministrador.getPanelAdministrarCasa().setVisible(false);
			ventanaAdministrador.getVolver().setVisible(true);
			ventanaAdministrador.getMinimizar().setVisible(true);
			ventanaAdministrador.getCerrar().setVisible(true);
			ventanaAdministrador.getBoton1().setVisible(true);
			ventanaAdministrador.getBoton2().setVisible(true);
			ventanaAdministrador.getBoton3().setVisible(true);
			ventanaAdministrador.getBoton4().setVisible(true);
			ventanaAdministrador.getBoton5().setVisible(true);
			ventanaAdministrador.getBoton6().setVisible(true);
			ventanaAdministrador.getBoton7().setVisible(true);
			ventanaAdministrador.getBoton8().setVisible(true);

		} else if (comando.equals("MINIMIZARPANELADMINCASA")) {

			ventanaAdministrador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARPANELADMINCASA")) {

			System.exit(0);

//------------------------------------------ADMINISTRAR SEDES - ADMINISTRADOR------------------------------------------

		} else if (comando.equals("AGREGARSEDE")) {

			ventanaAdministrador.getVolver().setVisible(false);
			ventanaAdministrador.getMinimizar().setVisible(false);
			ventanaAdministrador.getCerrar().setVisible(false);
			ventanaAdministrador.getBoton1().setVisible(false);
			ventanaAdministrador.getBoton2().setVisible(false);
			ventanaAdministrador.getBoton3().setVisible(false);
			ventanaAdministrador.getBoton4().setVisible(false);
			ventanaAdministrador.getBoton5().setVisible(false);
			ventanaAdministrador.getBoton6().setVisible(false);
			ventanaAdministrador.getBoton7().setVisible(false);
			ventanaAdministrador.getBoton8().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().setVisible(true);
			ventanaAdministrador.getPanelAdministrarSede().getUbicacion().setVisible(true);
			ventanaAdministrador.getPanelAdministrarSede().getNumeroEmpleados().setVisible(true);
			ventanaAdministrador.getPanelAdministrarSede().getAñadir().setVisible(true);
			ventanaAdministrador.getPanelAdministrarSede().getImagenFondo().setVisible(true);

//------------------------------------------AÑADIR SEDES — ADMIN------------------------------------------		

		} else if (comando.equals("AÑADIRSEDE")) {

			if (!"".equals(ventanaAdministrador.getPanelAdministrarSede().getUbicacion().getText())
					&& !"".equals(ventanaAdministrador.getPanelAdministrarSede().getNumeroEmpleados().getText())) {

				String pUbicacion = ventanaAdministrador.getPanelAdministrarSede().getUbicacion().getText();
				String pEmpleados = ventanaAdministrador.getPanelAdministrarSede().getNumeroEmpleados().getText();

				try {

					sede.excepcionUbicacion(pUbicacion);
					sede.excepcionEmpleado(pEmpleados);

					if (sedeDAO.agregarSede(pUbicacion, pEmpleados, alSede, fileSede)) {

						JOptionPane.showMessageDialog(null, "La sede se ha agregado correctamente", "Información",
								JOptionPane.INFORMATION_MESSAGE);

						ventanaAdministrador.getPanelAdministrarSede().getUbicacion().setText("");
						ventanaAdministrador.getPanelAdministrarSede().getNumeroEmpleados().setText("");

					} else {

						JOptionPane.showMessageDialog(null, "No se logró agregar la sede. Inténtelo de nuevo",
								"Información", JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (ExcepcionNombre e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (ExcepcionNumero e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "No puede dejar campos sin llenar", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

//------------------------------------------EDITAR SEDES — ADMIN------------------------------------------

		} else if (comando.equals("EDITARSEDE")) {

			ventanaAdministrador.getVolver().setVisible(false);
			ventanaAdministrador.getMinimizar().setVisible(false);
			ventanaAdministrador.getCerrar().setVisible(false);
			ventanaAdministrador.getBoton1().setVisible(false);
			ventanaAdministrador.getBoton2().setVisible(false);
			ventanaAdministrador.getBoton3().setVisible(false);
			ventanaAdministrador.getBoton4().setVisible(false);
			ventanaAdministrador.getBoton5().setVisible(false);
			ventanaAdministrador.getBoton6().setVisible(false);
			ventanaAdministrador.getBoton7().setVisible(false);
			ventanaAdministrador.getBoton8().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().setVisible(true);
			ventanaAdministrador.getPanelAdministrarSede().getUbicacion().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getNumeroEmpleados().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getAñadir().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getImagenFondo().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getEditar().setVisible(true);
			ventanaAdministrador.getPanelAdministrarSede().getUbicacion2().setVisible(true);
			ventanaAdministrador.getPanelAdministrarSede().getNuevaUbicacion().setVisible(true);
			ventanaAdministrador.getPanelAdministrarSede().getNumeroEmpleados2().setVisible(true);
			ventanaAdministrador.getPanelAdministrarSede().getImagenFondo2().setVisible(true);

			ventanaAdministrador.getPanelAdministrarSede().getUbicacion2().removeAllItems();
			ventanaAdministrador.getPanelAdministrarSede().getUbicacion2()
					.addItem(new String("Seleccione una ubicación..."));

			for (int i = 0; i < alSede.size(); i++) {

				ventanaAdministrador.getPanelAdministrarSede().getUbicacion2()
						.addItem(new String(alSede.get(i).getUbicacion()));
			}

		} else if (comando.equals("EDITARSD")) {

			String pUbicacion = ventanaAdministrador.getPanelAdministrarSede().getUbicacion2().getSelectedItem()
					.toString();
			String pNuevaUbicacion = ventanaAdministrador.getPanelAdministrarSede().getNuevaUbicacion().getText();
			String pEmpleados = ventanaAdministrador.getPanelAdministrarSede().getNumeroEmpleados2().getText();

			try {

				sede.excepcionUbicacion(pNuevaUbicacion);
				sede.excepcionEmpleado(pEmpleados);

				if (sedeDAO.editarSede(pUbicacion, pNuevaUbicacion, pEmpleados, alSede, fileSede)) {

					JOptionPane.showMessageDialog(null, "La sede se ha editado correctamente", "Información",
							JOptionPane.INFORMATION_MESSAGE);

					String informacion = "\tInformación actualizada de la sede: \n\n\n";

					for (int i = 0; i < alSede.size(); i++) {

						informacion += "Ubicación de la sede: " + alSede.get(i).getUbicacion() + "\n"
								+ "Números de empleados: " + alSede.get(i).getnEmpleados() + "\n";
					}

					JOptionPane.showMessageDialog(null, informacion, "Información", JOptionPane.INFORMATION_MESSAGE);

					ventanaAdministrador.getPanelAdministrarSede().getNuevaUbicacion().setText("");
					ventanaAdministrador.getPanelAdministrarSede().getNumeroEmpleados2().setText("");

					ventanaAdministrador.getPanelAdministrarSede().getUbicacion2().removeAllItems();
					ventanaAdministrador.getPanelAdministrarSede().getUbicacion2()
							.addItem(new String("Seleccione una ubicación..."));

					for (int i = 0; i < alSede.size(); i++) {

						ventanaAdministrador.getPanelAdministrarSede().getUbicacion2()
								.addItem(new String(alSede.get(i).getUbicacion()));
					}

				} else {

					JOptionPane.showMessageDialog(null, "No fue posible encontrar la sede. Inténtelo de nuevo", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (ExcepcionNombre e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			} catch (ExcepcionNumero e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

//-----------------------------------------ELIMINAR SEDE-------------------------------------------------------------------

		} else if (comando.equals("ELIMINARSEDE")) {

			try {

				String[] prueba = new String[alSede.size()];

				for (int i = 0; i < alSede.size(); i++) {

					prueba[i] = new String(alSede.get(i).getUbicacion());
				}

				String pUbicacion = (JOptionPane.showInputDialog(null, "Selecciona la sede que deseas eliminar",
						"Eliminar Sede", JOptionPane.YES_OPTION, null, prueba, "Seleccione")).toString();

				if (sedeDAO.eliminarSede(pUbicacion, alSede, fileSede)) {

					JOptionPane.showMessageDialog(null, "Eliminado correctamente");

				} else {

					JOptionPane.showMessageDialog(null, "No se ha podido eliminar");

				}

			} catch (Exception error) {

			}

		} else if (comando.equals("VOLVERAVENTANAADMIN2")) {

			ventanaAdministrador.getPanelAdministrarSede().getAñadir().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getEditar().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getUbicacion().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getNumeroEmpleados().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getUbicacion2().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getNuevaUbicacion().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getNumeroEmpleados2().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getImagenFondo().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().getImagenFondo2().setVisible(false);
			ventanaAdministrador.getPanelAdministrarSede().setVisible(false);
			ventanaAdministrador.getVolver().setVisible(true);
			ventanaAdministrador.getMinimizar().setVisible(true);
			ventanaAdministrador.getCerrar().setVisible(true);
			ventanaAdministrador.getBoton1().setVisible(true);
			ventanaAdministrador.getBoton2().setVisible(true);
			ventanaAdministrador.getBoton3().setVisible(true);
			ventanaAdministrador.getBoton4().setVisible(true);
			ventanaAdministrador.getBoton5().setVisible(true);
			ventanaAdministrador.getBoton6().setVisible(true);
			ventanaAdministrador.getBoton7().setVisible(true);
			ventanaAdministrador.getBoton8().setVisible(true);

		} else if (comando.equals("MINIMIZARPANELADMINSEDE")) {

			ventanaAdministrador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARPANELADMINSEDE")) {

			System.exit(0);

//------------------------------------------REGISTRO DE RESULTADOS DE ADMIN------------------------------------------

		} else if (comando.equals("REGISTRARRESULTADOS")) {

			ventanaAdministrador.getVolver().setVisible(false);
			ventanaAdministrador.getMinimizar().setVisible(false);
			ventanaAdministrador.getCerrar().setVisible(false);
			ventanaAdministrador.getBoton1().setVisible(false);
			ventanaAdministrador.getBoton2().setVisible(false);
			ventanaAdministrador.getBoton3().setVisible(false);
			ventanaAdministrador.getBoton4().setVisible(false);
			ventanaAdministrador.getBoton5().setVisible(false);
			ventanaAdministrador.getBoton6().setVisible(false);
			ventanaAdministrador.getBoton7().setVisible(false);
			ventanaAdministrador.getBoton8().setVisible(false);
			ventanaAdministrador.getPanelRegistroResultados().setVisible(true);

//------------------------------------------REGISTRAR RESULTADOS BALOTO - ADMIN------------------------------------------

		} else if (comando.equals("REGISTRARBALOTO")) {

			ventanaAdministrador.getPanelRegistroResultados().setVisible(false);
			ventanaAdministrador.getPanelRegistrarBaloto().setVisible(true);

		} else if (comando.equals("REGISTRARRESULTADOBALOTO")) {

			if (!"".equals(ventanaAdministrador.getPanelRegistrarBaloto().getNumero1().getText())
					&& !"".equals(ventanaAdministrador.getPanelRegistrarBaloto().getNumero2().getText())
					&& !"".equals(ventanaAdministrador.getPanelRegistrarBaloto().getNumero3().getText())
					&& !"".equals(ventanaAdministrador.getPanelRegistrarBaloto().getNumero4().getText())
					&& !"".equals(ventanaAdministrador.getPanelRegistrarBaloto().getNumero5().getText())
					&& !"".equals(ventanaAdministrador.getPanelRegistrarBaloto().getNumero6().getText())) {

				String pNumero1 = ventanaAdministrador.getPanelRegistrarBaloto().getNumero1().getText();
				String pNumero2 = ventanaAdministrador.getPanelRegistrarBaloto().getNumero2().getText();
				String pNumero3 = ventanaAdministrador.getPanelRegistrarBaloto().getNumero3().getText();
				String pNumero4 = ventanaAdministrador.getPanelRegistrarBaloto().getNumero4().getText();
				String pNumero5 = ventanaAdministrador.getPanelRegistrarBaloto().getNumero5().getText();
				String pNumero6 = ventanaAdministrador.getPanelRegistrarBaloto().getNumero6().getText();

				ArrayList<String> numeros = new ArrayList<String>();
				numeros.add(pNumero1);
				numeros.add(pNumero2);
				numeros.add(pNumero3);
				numeros.add(pNumero4);
				numeros.add(pNumero5);
				numeros.add(pNumero6);
				int c = 0;
				for (int i = 0; i < numeros.size(); i++) {

					for (int j = 0; j < numeros.size(); j++) {

						if (numeros.get(i).equals(numeros.get(j)) && i != j) {

							c++;
							break;
						}

					}
					if (c == 1) {

						break;
					}

				}

				try {

					baloto.excepcionNumero(pNumero1);
					baloto.excepcionNumero(pNumero2);
					baloto.excepcionNumero(pNumero3);
					baloto.excepcionNumero(pNumero4);
					baloto.excepcionNumero(pNumero5);
					baloto.excepcionNumero(pNumero6);

					if (c < 1) {

						String pNumeros = pNumero1 + "-" + pNumero2 + "-" + pNumero3 + "-" + pNumero4 + "-" + pNumero5
								+ "-" + pNumero6;

						String pCedula = baloto.determinarGanador2(pNumeros, alBaloto);

						ganadorBaloto = pCedula;

						apostadorDAO.editarApostadorGanancia(pCedula, alPremioBaloto.get(0).getPresupuesto(),
								alApostador, fileApostador);

						JOptionPane.showMessageDialog(null, "Agregado correctamente");

						ventanaAdministrador.getPanelRegistrarBaloto().getNumero1().setText("");
						ventanaAdministrador.getPanelRegistrarBaloto().getNumero2().setText("");
						ventanaAdministrador.getPanelRegistrarBaloto().getNumero3().setText("");
						ventanaAdministrador.getPanelRegistrarBaloto().getNumero4().setText("");
						ventanaAdministrador.getPanelRegistrarBaloto().getNumero5().setText("");
						ventanaAdministrador.getPanelRegistrarBaloto().getNumero6().setText("");

					} else {

						JOptionPane.showMessageDialog(null, "Los numeros estan repetidos", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (ExcepcionApuesta e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			} else {

				JOptionPane.showMessageDialog(null, "No puede dejar campos sin llenar", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (comando.equals("VOLVERREGISTROBALOTO")) {

			ventanaAdministrador.getPanelRegistrarBaloto().setVisible(false);
			ventanaAdministrador.getPanelRegistroResultados().setVisible(true);

		} else if (comando.equals("MINIMIZARREGISTROBALOTO")) {

			ventanaAdministrador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARREGISTROBALOTO")) {

			System.exit(0);

//------------------------------------------REGISTRAR RESULTADOS SUPERASTRO - ADMIN------------------------------------------

		} else if (comando.equals("REGISTRARSUPERASTRO")) {

			ventanaAdministrador.getPanelRegistroResultados().setVisible(false);
			ventanaAdministrador.getPanelRegistrarSuperAstro().setVisible(true);

		} else if (comando.equals("REGISTRARRESULTADOSUPERASTRO")) {

			if (!"".equals(ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero1().getText())
					&& !"".equals(ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero2().getText())
					&& !"".equals(ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero3().getText())
					&& !"".equals(ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero4().getText())
					&& !"Seleccione su signo...".equals(ventanaAdministrador.getPanelRegistrarSuperAstro().getSigno()
							.getSelectedItem().toString())) {

				String pNumero1 = ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero1().getText();
				String pNumero2 = ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero2().getText();
				String pNumero3 = ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero3().getText();
				String pNumero4 = ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero4().getText();
				String pZodiaco = ventanaAdministrador.getPanelRegistrarSuperAstro().getSigno().getSelectedItem()
						.toString();

				try {
					superAstro.excepcionNumero(pNumero1);
					superAstro.excepcionNumero(pNumero2);
					superAstro.excepcionNumero(pNumero3);
					superAstro.excepcionNumero(pNumero4);

					String pNumeros = pNumero1 + "-" + pNumero2 + "-" + pNumero3 + "-" + pNumero4;

					String pCedula = superAstro.determinarGanador2(pZodiaco, pNumeros, alSuperAstro);

					ganadorSuperAstro = pCedula;

					apostadorDAO.editarApostadorGanancia(pCedula, alPremioSuperAstro.get(0).getPresupuesto(),
							alApostador, fileApostador);

					JOptionPane.showMessageDialog(null, "Agregado correctamente");

					ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero1().setText("");
					ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero2().setText("");
					ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero3().setText("");
					ventanaAdministrador.getPanelRegistrarSuperAstro().getNumero4().setText("");
					ventanaAdministrador.getPanelRegistrarSuperAstro().getSigno().setSelectedIndex(0);

				} catch (ExcepcionApuesta e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			} else {

				JOptionPane.showMessageDialog(null, "No puede dejar campos sin llenar", "Error",
						JOptionPane.WARNING_MESSAGE);

			}

		} else if (comando.equals("VOLVERREGISTROSUPERASTRO")) {

			ventanaAdministrador.getPanelRegistrarSuperAstro().setVisible(false);
			ventanaAdministrador.getPanelRegistroResultados().setVisible(true);

		} else if (comando.equals("MINIMIZARREGISTROSUPERASTRO")) {

			ventanaAdministrador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARREGISTROSUPERASTRO")) {

			System.exit(0);

//------------------------------------------REGISTRAR RESULTADOS PARTIDOS - ADMIN------------------------------------------

		} else if (comando.equals("REGISTRARFUTBOL")) {

			ventanaAdministrador.getPanelRegistroResultados().setVisible(false);
			ventanaAdministrador.getPanelRegistrarPartido().setVisible(true);

			ventanaAdministrador.getPanelRegistrarPartido().getPartidos().removeAllItems();
			ventanaAdministrador.getPanelRegistrarPartido().getPartidos()
					.addItem(new String("Seleccione un partido..."));

			for (int i = 0; i < alPremioPartido.size(); i++) {

				ventanaAdministrador.getPanelRegistrarPartido().getPartidos().addItem(new String(
						alPremioPartido.get(i).getEquipoLocal() + "-" + alPremioPartido.get(i).getEquipoVisitante()));
			}

		} else if (comando.equals("REGISTRARRESULTADOPARTIDO")) {

			if (!"Seleccione un partido..."
					.equals(ventanaAdministrador.getPanelRegistrarPartido().getPartidos().getSelectedItem().toString())
					&& !"Seleccione un resultado...".equals(
							ventanaAdministrador.getPanelRegistrarPartido().getModo().getSelectedItem().toString())) {

				String pPartido = ventanaAdministrador.getPanelRegistrarPartido().getPartidos().getSelectedItem()
						.toString();
				String nModo = ventanaAdministrador.getPanelRegistrarPartido().getModo().getSelectedItem().toString();

				int posicion = ventanaAdministrador.getPanelRegistrarPartido().getPartidos().getSelectedIndex();

				String pLocal = alPremioPartido.get(posicion).getEquipoLocal();
				String pVisitante = alPremioPartido.get(posicion).getEquipoVisitante();

				double porcentaje = 0;

				String pCedula = "";

				for (int i = 0; i < alPartido.size(); i++) {

					pCedula = partido.determinarGanador2(pLocal, pVisitante, nModo, alPartido);

					if (nModo.equals("Local")) {

						if (pLocal.equals(alPartido.get(i).getEquipoLocal())
								&& pVisitante.equals(alPartido.get(i).getEquipoVisitante())) {

							int pApuesta = Integer.parseInt(alPartido.get(i).getValorApuesta());

							porcentaje = pApuesta * alPremioPartido.get(posicion).getPorcentajeGanador() + pApuesta;
						}

					} else if (nModo.equals("Empate")) {

						if (pLocal.equals(alPartido.get(i).getEquipoLocal())
								&& pVisitante.equals(alPartido.get(i).getEquipoVisitante())) {

							int pApuesta = Integer.parseInt(alPartido.get(i).getValorApuesta());

							porcentaje = pApuesta * alPremioPartido.get(posicion).getPorcentajeEmpate() + pApuesta;
						}

					} else if (nModo.equals("Visitante")) {

						if (pLocal.equals(alPartido.get(i).getEquipoLocal())
								&& pVisitante.equals(alPartido.get(i).getEquipoVisitante())) {

							int pApuesta = Integer.parseInt(alPartido.get(i).getValorApuesta());

							porcentaje = pApuesta * alPremioPartido.get(posicion).getPorcentajePerdedor() + pApuesta;
						}
					}

				}

				apostadorDAO.editarApostadorGanancia(pCedula, porcentaje, alApostador, fileApostador);

				JOptionPane.showMessageDialog(null, "Resultado agregado correctamente");

				ventanaAdministrador.getPanelRegistrarPartido().getPartidos().setSelectedIndex(0);
				ventanaAdministrador.getPanelRegistrarPartido().getModo().setSelectedIndex(0);

			} else {

				JOptionPane.showMessageDialog(null, "No puede dejar campos sin seleccionar", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (comando.equals("VOLVERREGISTROPARTIDOS")) {

			ventanaAdministrador.getPanelRegistrarPartido().setVisible(false);
			ventanaAdministrador.getPanelRegistroResultados().setVisible(true);

		} else if (comando.equals("MINIMIZARREGISTROPARTIDOS")) {

			ventanaAdministrador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARREGISTROPARTIDOS")) {

			System.exit(0);

//------------------------------------------VOLVER SELECCION DE REGISTRO DE RESULTADOS------------------------------------------			

		} else if (comando.equals("VOLVERAVENTANAADMIN3")) {

			ventanaAdministrador.getPanelRegistroResultados().setVisible(false);
			ventanaAdministrador.getVolver().setVisible(true);
			ventanaAdministrador.getMinimizar().setVisible(true);
			ventanaAdministrador.getCerrar().setVisible(true);
			ventanaAdministrador.getBoton1().setVisible(true);
			ventanaAdministrador.getBoton2().setVisible(true);
			ventanaAdministrador.getBoton3().setVisible(true);
			ventanaAdministrador.getBoton4().setVisible(true);
			ventanaAdministrador.getBoton5().setVisible(true);
			ventanaAdministrador.getBoton6().setVisible(true);
			ventanaAdministrador.getBoton7().setVisible(true);
			ventanaAdministrador.getBoton8().setVisible(true);

		} else if (comando.equals("MINIMIZARPANELADMINRESULTADOS")) {

			ventanaAdministrador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARPANELADMINRESULTADOS")) {

			System.exit(0);

//------------------------------------------EXPORTAR PDF Y EXCEL------------------------------------------
		} else if (comando.equals("EXPORTARPDF")) {

			pdf.imprimirPDF();
			JOptionPane.showMessageDialog(null, "Archivo PDF creado correctamente");

		} else if (comando.equals("EXPORTAREXCEL")) {

			exel.imprimirExcel();

			JOptionPane.showMessageDialog(null, "Archivo Excel creado correctamente");

		} else if (comando.equals("VERINFORMACIONADMIN")) {

			Apostador[] numeros = new Apostador[alApostador.size()];

			numeros = apostador.ordenamientoPorFechaApostador(alApostador, alSede);
			ArrayList<String> listaApostadores = new ArrayList<String>();
			listaApostadores = apostador.ordenamientoPorApuesta(alApostador, alBaloto, alSuperAstro, alPartido);
			String informacion1 = "— Listado de clientes por sede por fecha discriminada por día y/o por mes y/o por año —\n";
			String informacion2 = "— Valor total de apuestas por cliente por fecha discriminada por día y/o por mes y/o por año —\n";

			for (int i = 0; i < numeros.length; i++) {

				String numeross = listaApostadores.get(i);
				String nombre, cedula;
				nombre = numeross.substring(0, numeross.indexOf(","));
				numeross = numeross.substring(numeross.indexOf(",") + 1, numeross.length());
				cedula = numeross.substring(0, numeross.indexOf(","));
				numeross = numeross.substring(numeross.indexOf(",") + 1, numeross.length());

				informacion1 += "Fecha: " + numeros[i].getFecha() + "\n" + "Nombre: " + numeros[i].getNombre() + "\n"
						+ "Cedula: " + numeros[i].getCedula() + "\n" + "Dirección: " + numeros[i].getDireccion() + "\n"
						+ "Celular: " + numeros[i].getCelular() + "\n" + "Celular: " + numeros[i].getSede() + "\n"
						+ "Ganancias: " + numeros[i].getGanancias() + "\n";

				informacion2 += "\nNombre: " + nombre + "\n" + "\nCédula: " + cedula + "\nValor de apuestas: "
						+ numeross + "\n";

			}

			JTextArea textArea = new JTextArea(informacion1 + "\n" + informacion2);
			JScrollPane scrollPane = new JScrollPane(textArea);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setEditable(false);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(null, scrollPane, "FAQ de Champions League", JOptionPane.INFORMATION_MESSAGE);

//------------------------------------------REGRESAR-CERRAR-MINIMIZAR ADMINISTRADOR------------------------------------------

		} else if (comando.equals("VOLVERPRINCIPALDEADMIN")) {
			ventanaAdministrador.setVisible(false);
			ventanaPrincipal.setVisible(true);

		} else if (comando.equals("MINIMIZARVENTANAADMIN")) {
			ventanaAdministrador.setExtendedState(JFrame.ICONIFIED);

		} else if (comando.equals("CERRARVENTANAADMIN")) {
			System.exit(0);

		} else if (comando.equals("VOLVERADMIN")) {
			sesionAdministrador.getCampoContraseña().setText("");
			sesionAdministrador.setVisible(false);
			ventanaPrincipal.setVisible(true);

		}

	}

}
