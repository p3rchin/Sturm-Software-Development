/*
 * Paquete donde est� contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

/**
 * Clase PanelJuegoFutbol.
 * 
 * Clase donde tiene los componentes para hacer el panel de juego para realizar
 * la apuesta de los partidos.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class PanelJuegoFutbol extends JPanel {
	/*
	 * fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2,
	 * recursoImagenBoton2, imagenBoton3, recursoImagenBoton3, imagenBoton4,
	 * recursoImagenBoton4 son de tipo ImageIcon.
	 */
	private ImageIcon fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2, recursoImagenBoton2,
			imagenBoton3, recursoImagenBoton3, imagenBoton4, recursoImagenBoton4, imagenBoton5, recursoImagenBoton5;
	/*
	 * imagenFondo, titulo, usuario, cedula son de tipo JLabel.
	 */
	private JLabel imagenFondo, titulo, usuario, cedula;
	
	/*
	 * volver, minimizar, cerrar son de tipo JButton.
	 */

	private JButton volver, minimizar, cerrar;
	/*
	 * fuente1, fuente2 son de tipo Font.
	 */
	private Font fuente1, fuente2;
	/*
	 * fecha es de tipo JTextArea
	 */
	private JTextArea fecha;
	/*
	 * valorApuesta es de tipo JTextField.
	 */
	private JTextField valorApuesta;
	/*
	 * partidos, modo son de tipo JComboBox con par�metro String.
	 */
	private JComboBox<String> partidos, modo;
	/*
	 * informacion, apostar es de tipo Boton.
	 */
	private Boton informacion, apostar;
	/*
	 * Constructor de la clase donde se inicia el m�todo para inicializar los
	 * componentes y donde se le agregan los compnentes de JPanel para que se pueda
	 * ver en la ventana.
	 */
	public PanelJuegoFutbol() {

		setLayout(null);
		setVisible(false);
		setSize(800, 500);
		inicializarComponentes();
	}
	/*
	 * M�todo donde se inicializan los atributos que contienen el bot�n para
	 * realizar el juego de los partidos junto con los campos de texto y se utilizan
	 * los diferentes componentes que son provenientes de la clase JPanel.
	 */
	public void inicializarComponentes() {

		imagenBoton1 = new ImageIcon("recursos/volver.png");
		recursoImagenBoton1 = new ImageIcon(imagenBoton1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		volver = new JButton();
		volver.setBounds(4, 5, 30, 30);
		volver.setBorderPainted(false);
		volver.setContentAreaFilled(false);
		volver.setFocusPainted(false);
		volver.setIcon(recursoImagenBoton1);
		volver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		volver.setActionCommand("VOLVERJUEGOFUTBOL");
		add(volver);

		imagenBoton2 = new ImageIcon("recursos/minimizar.png");
		recursoImagenBoton2 = new ImageIcon(imagenBoton2.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		minimizar = new JButton();
		minimizar.setBounds(720, 5, 30, 30);
		minimizar.setBorderPainted(false);
		minimizar.setContentAreaFilled(false);
		minimizar.setFocusPainted(false);
		minimizar.setIcon(recursoImagenBoton2);
		minimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		minimizar.setActionCommand("MINIMIZARJUEGOFUTBOL");
		add(minimizar);

		imagenBoton3 = new ImageIcon("recursos/cerrar.png");
		recursoImagenBoton3 = new ImageIcon(imagenBoton3.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		cerrar = new JButton();
		cerrar.setBounds(765, 5, 30, 30);
		cerrar.setBorderPainted(false);
		cerrar.setContentAreaFilled(false);
		cerrar.setFocusPainted(false);
		cerrar.setIcon(recursoImagenBoton3);
		cerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cerrar.setActionCommand("CERRARJUEGOFUTBOL");
		add(cerrar);

		fuente1 = new Font("Arial", Font.ITALIC, 15);
		fuente2 = new Font("Arial", Font.BOLD, 18);

		titulo = new JLabel("Sesi�n de usuario: ");
		titulo.setBounds(63, 10, 300, 20);
		titulo.setFont(fuente2);
		add(titulo);

		usuario = new JLabel();
		usuario.setBounds(55, 35, 250, 20);
		usuario.setFont(fuente1);
		usuario.setVisible(true);
		add(usuario);

		cedula = new JLabel();
		cedula.setBounds(55, 60, 200, 20);
		cedula.setFont(fuente1);
		add(cedula);
		
		imagenBoton5 = new ImageIcon("recursos/informacionJuegos.png");
		recursoImagenBoton5 = new ImageIcon(imagenBoton5.getImage().getScaledInstance(128, 33, Image.SCALE_DEFAULT));
		informacion = new Boton();
		informacion.setBounds(560, 140, 128, 33);
		informacion.setBorderPainted(false);
		informacion.setContentAreaFilled(false);
		informacion.setFocusPainted(false);
		informacion.setIcon(recursoImagenBoton5);
		informacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		informacion.setActionCommand("FAQFUTBOL");
		add(informacion);
		
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		formateador.setLenient(false);
		String fechaFor = formateador.format(new Date());
		fecha = new JTextArea(fechaFor);
		fecha.setBounds(280, 178, 270, 25);
		fecha.setEditable(false);
		fecha.setEnabled(false);
		fecha.setBackground(null);
		fecha.setFont(fuente1);
		add(fecha);

		valorApuesta = new JTextField();
		valorApuesta.setBounds(280, 233, 270, 25);
		valorApuesta.setFont(fuente1);
		add(valorApuesta);

		partidos = new JComboBox<String>();
		partidos.setBounds(280, 285, 270, 25);
		partidos.setFont(fuente1);
		partidos.addItem("Seleccione un partido...");
		add(partidos);

		modo = new JComboBox<String>();
		modo.setBounds(280, 338, 270, 25);
		modo.setFont(fuente1);
		modo.addItem("Seleccione un resultado...");
		modo.addItem("Local");
		modo.addItem("Visitante");
		modo.addItem("Empate");
		add(modo);

		imagenBoton4 = new ImageIcon("recursos/apostarJuegoChampions.png");
		recursoImagenBoton4 = new ImageIcon(imagenBoton4.getImage().getScaledInstance(340, 50, Image.SCALE_DEFAULT));
		apostar = new Boton();
		apostar.setBounds(220, 388, 340, 50);
		apostar.setBorderPainted(false);
		apostar.setContentAreaFilled(false);
		apostar.setFocusPainted(false);
		apostar.setIcon(recursoImagenBoton4);
		apostar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		apostar.setActionCommand("APOSTARFUTBOL");
		add(apostar);

		fondo = new ImageIcon(getClass().getResource("/imagenes/juegoFutbol.jpg"));
		recursoFondo = new ImageIcon(fondo.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH));
		imagenFondo = new JLabel(recursoFondo);
		imagenFondo.setSize(800, 500);
		add(imagenFondo);
	}
	/**
	 * @return the fondo
	 */
	public ImageIcon getFondo() {
		return fondo;
	}
	/**
	 * @param fondo the fondo to set
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}
	/**
	 * @return the recursoFondo
	 */
	public ImageIcon getRecursoFondo() {
		return recursoFondo;
	}
	/**
	 * @param recursoFondo the recursoFondo to set
	 */
	public void setRecursoFondo(ImageIcon recursoFondo) {
		this.recursoFondo = recursoFondo;
	}
	/**
	 * @return the imagenBoton1
	 */
	public ImageIcon getImagenBoton1() {
		return imagenBoton1;
	}
	/**
	 * @param imagenBoton1 the imagenBoton1 to set
	 */
	public void setImagenBoton1(ImageIcon imagenBoton1) {
		this.imagenBoton1 = imagenBoton1;
	}
	/**
	 * @return the recursoImagenBoton1
	 */
	public ImageIcon getRecursoImagenBoton1() {
		return recursoImagenBoton1;
	}
	/**
	 * @param recursoImagenBoton1 the recursoImagenBoton1 to set
	 */
	public void setRecursoImagenBoton1(ImageIcon recursoImagenBoton1) {
		this.recursoImagenBoton1 = recursoImagenBoton1;
	}
	/**
	 * @return the imagenBoton2
	 */
	public ImageIcon getImagenBoton2() {
		return imagenBoton2;
	}
	/**
	 * @param imagenBoton2 the imagenBoton2 to set
	 */
	public void setImagenBoton2(ImageIcon imagenBoton2) {
		this.imagenBoton2 = imagenBoton2;
	}
	/**
	 * @return the recursoImagenBoton2
	 */
	public ImageIcon getRecursoImagenBoton2() {
		return recursoImagenBoton2;
	}
	/**
	 * @param recursoImagenBoton2 the recursoImagenBoton2 to set
	 */
	public void setRecursoImagenBoton2(ImageIcon recursoImagenBoton2) {
		this.recursoImagenBoton2 = recursoImagenBoton2;
	}
	/**
	 * @return the imagenBoton3
	 */
	public ImageIcon getImagenBoton3() {
		return imagenBoton3;
	}
	/**
	 * @param imagenBoton3 the imagenBoton3 to set
	 */
	public void setImagenBoton3(ImageIcon imagenBoton3) {
		this.imagenBoton3 = imagenBoton3;
	}
	/**
	 * @return the recursoImagenBoton3
	 */
	public ImageIcon getRecursoImagenBoton3() {
		return recursoImagenBoton3;
	}
	/**
	 * @param recursoImagenBoton3 the recursoImagenBoton3 to set
	 */
	public void setRecursoImagenBoton3(ImageIcon recursoImagenBoton3) {
		this.recursoImagenBoton3 = recursoImagenBoton3;
	}
	/**
	 * @return the imagenBoton4
	 */
	public ImageIcon getImagenBoton4() {
		return imagenBoton4;
	}
	/**
	 * @param imagenBoton4 the imagenBoton4 to set
	 */
	public void setImagenBoton4(ImageIcon imagenBoton4) {
		this.imagenBoton4 = imagenBoton4;
	}
	/**
	 * @return the recursoImagenBoton4
	 */
	public ImageIcon getRecursoImagenBoton4() {
		return recursoImagenBoton4;
	}
	/**
	 * @param recursoImagenBoton4 the recursoImagenBoton4 to set
	 */
	public void setRecursoImagenBoton4(ImageIcon recursoImagenBoton4) {
		this.recursoImagenBoton4 = recursoImagenBoton4;
	}
	/**
	 * @return the imagenBoton5
	 */
	public ImageIcon getImagenBoton5() {
		return imagenBoton5;
	}
	/**
	 * @param imagenBoton5 the imagenBoton5 to set
	 */
	public void setImagenBoton5(ImageIcon imagenBoton5) {
		this.imagenBoton5 = imagenBoton5;
	}
	/**
	 * @return the recursoImagenBoton5
	 */
	public ImageIcon getRecursoImagenBoton5() {
		return recursoImagenBoton5;
	}
	/**
	 * @param recursoImagenBoton5 the recursoImagenBoton5 to set
	 */
	public void setRecursoImagenBoton5(ImageIcon recursoImagenBoton5) {
		this.recursoImagenBoton5 = recursoImagenBoton5;
	}
	/**
	 * @return the imagenFondo
	 */
	public JLabel getImagenFondo() {
		return imagenFondo;
	}
	/**
	 * @param imagenFondo the imagenFondo to set
	 */
	public void setImagenFondo(JLabel imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
	/**
	 * @return the titulo
	 */
	public JLabel getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the usuario
	 */
	public JLabel getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(JLabel usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the cedula
	 */
	public JLabel getCedula() {
		return cedula;
	}
	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(JLabel cedula) {
		this.cedula = cedula;
	}
	/**
	 * @return the volver
	 */
	public JButton getVolver() {
		return volver;
	}
	/**
	 * @param volver the volver to set
	 */
	public void setVolver(JButton volver) {
		this.volver = volver;
	}
	/**
	 * @return the minimizar
	 */
	public JButton getMinimizar() {
		return minimizar;
	}
	/**
	 * @param minimizar the minimizar to set
	 */
	public void setMinimizar(JButton minimizar) {
		this.minimizar = minimizar;
	}
	/**
	 * @return the cerrar
	 */
	public JButton getCerrar() {
		return cerrar;
	}
	/**
	 * @param cerrar the cerrar to set
	 */
	public void setCerrar(JButton cerrar) {
		this.cerrar = cerrar;
	}
	/**
	 * @return the fuente1
	 */
	public Font getFuente1() {
		return fuente1;
	}
	/**
	 * @param fuente1 the fuente1 to set
	 */
	public void setFuente1(Font fuente1) {
		this.fuente1 = fuente1;
	}
	/**
	 * @return the fuente2
	 */
	public Font getFuente2() {
		return fuente2;
	}
	/**
	 * @param fuente2 the fuente2 to set
	 */
	public void setFuente2(Font fuente2) {
		this.fuente2 = fuente2;
	}
	/**
	 * @return the fecha
	 */
	public JTextArea getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(JTextArea fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the valorApuesta
	 */
	public JTextField getValorApuesta() {
		return valorApuesta;
	}
	/**
	 * @param valorApuesta the valorApuesta to set
	 */
	public void setValorApuesta(JTextField valorApuesta) {
		this.valorApuesta = valorApuesta;
	}
	/**
	 * @return the partidos
	 */
	public JComboBox<String> getPartidos() {
		return partidos;
	}
	/**
	 * @param partidos the partidos to set
	 */
	public void setPartidos(JComboBox<String> partidos) {
		this.partidos = partidos;
	}
	/**
	 * @return the modo
	 */
	public JComboBox<String> getModo() {
		return modo;
	}
	/**
	 * @param modo the modo to set
	 */
	public void setModo(JComboBox<String> modo) {
		this.modo = modo;
	}
	/**
	 * @return the informacion
	 */
	public Boton getInformacion() {
		return informacion;
	}
	/**
	 * @param informacion the informacion to set
	 */
	public void setInformacion(Boton informacion) {
		this.informacion = informacion;
	}
	/**
	 * @return the apostar
	 */
	public Boton getApostar() {
		return apostar;
	}
	/**
	 * @param apostar the apostar to set
	 */
	public void setApostar(Boton apostar) {
		this.apostar = apostar;
	}
}