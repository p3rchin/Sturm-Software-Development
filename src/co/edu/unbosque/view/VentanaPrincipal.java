/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
/**
 * Clase VentaPrincipal.
 * 
 * Clase donde se le dan los diferentes componentes para la vista principal donde el usuario tiene
 * la opcioón de escoger entre apostador y administrador.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class VentanaPrincipal extends JFrame {
	/*
	 * fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2, recursoImagenBoton2,
	 * imagenBoton3, recursoImagenBoton3, imagenBoton4, recursoImagenBoton4 son de tipo ImageIcon.
	 */
	private ImageIcon fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2, recursoImagenBoton2,
			imagenBoton3, recursoImagenBoton3, imagenBoton4, recursoImagenBoton4;
	/*
	 * imagenFondo es de tipo JLabel.
	 */
	private JLabel imagenFondo;
	/*
	 * boton1, boton2 es de tipo Boton.
	 */
	private Boton boton1, boton2;
	/*
	 * minimizar, cerrar es de tipo JButton.
	 */
	private JButton minimizar, cerrar;

	/**
	 * Constructor de la clase el cuál se inicializan los diferentes componentes junto con el método de
	 * inicializar componentes para su funcionamiento, estos componentes son de JFrame y los del método.
	 * <b>pre</b> Debe contener los componentes del frame para que se pueda ver la ventana.<br>
	 * <b>post</b> Se muestran los componentes que se ingresaron en el constructor.<br>
	 */
	public VentanaPrincipal() {

		setTitle("Sturm play");
		setSize(800, 500);
		setUndecorated(true);
		setIconImage(new ImageIcon("recursos/icon.png").getImage());
		inicializarComponentes();
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	/**
	 * Este método se le ingresan los diferentes componentes que van a estar incluidos en la ventana.
	 * <b>pre</b> Se deben agregar los atributos en el método para inicializarlos y agregarlos en la ventana.<br>
	 * <b>post</b> Se agregarán los componentes inicializados en la ventana para poder seleccionar y tener una interfaz.<br>
	 */
	public void inicializarComponentes() {

		imagenBoton1 = new ImageIcon("recursos/minimizar.png");
		recursoImagenBoton1 = new ImageIcon(imagenBoton1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		minimizar = new JButton();
		minimizar.setBounds(720, 5, 30, 30);
		minimizar.setBorderPainted(false);
		minimizar.setContentAreaFilled(false);
		minimizar.setFocusPainted(false);
		minimizar.setIcon(recursoImagenBoton1);
		minimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		minimizar.setActionCommand("MINIMIZARVENTANA");
		add(minimizar);
		
		imagenBoton2 = new ImageIcon("recursos/cerrar.png");
		recursoImagenBoton2 = new ImageIcon(imagenBoton2.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		cerrar = new JButton();
		cerrar.setBounds(765, 5, 30, 30);
		cerrar.setBorderPainted(false);
		cerrar.setContentAreaFilled(false);
		cerrar.setFocusPainted(false);
		cerrar.setIcon(recursoImagenBoton2);
		cerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cerrar.setActionCommand("CERRARVENTANA");
		add(cerrar);

		imagenBoton3 = new ImageIcon("recursos/apostador.png");
		recursoImagenBoton3 = new ImageIcon(imagenBoton3.getImage().getScaledInstance(276, 56, Image.SCALE_DEFAULT));
		boton1 = new Boton();
		boton1.setBounds(400, 150, 276, 56);
		boton1.setBorderPainted(false);
		boton1.setContentAreaFilled(false);
		boton1.setFocusPainted(false);
		boton1.setIcon(recursoImagenBoton3);
		boton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton1.setActionCommand("INGRESOAPOSTADOR");
		add(boton1);

		imagenBoton4 = new ImageIcon("recursos/administrador.png");
		recursoImagenBoton4 = new ImageIcon(imagenBoton4.getImage().getScaledInstance(276, 56, Image.SCALE_DEFAULT));
		boton2 = new Boton();
		boton2.setBounds(400, 250, 276, 56);
		boton2.setBorderPainted(false);
		boton2.setContentAreaFilled(false);
		boton2.setFocusPainted(false);
		boton2.setIcon(recursoImagenBoton4);
		boton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton2.setActionCommand("INGRESOADMINISTRADOR");
		add(boton2);

		fondo = new ImageIcon(getClass().getResource("/imagenes/banner1.jpg"));
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
	 * @return the boton1
	 */
	public Boton getBoton1() {
		return boton1;
	}

	/**
	 * @param boton1 the boton1 to set
	 */
	public void setBoton1(Boton boton1) {
		this.boton1 = boton1;
	}

	/**
	 * @return the boton2
	 */
	public Boton getBoton2() {
		return boton2;
	}

	/**
	 * @param boton2 the boton2 to set
	 */
	public void setBoton2(Boton boton2) {
		this.boton2 = boton2;
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
}