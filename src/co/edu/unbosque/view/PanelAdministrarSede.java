/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;

/**
 * Clase PanelAdministrarSede.
 * 
 * Clase del panel donde se crean los diferentes atributos para que se pueda
 * administrar las diferentes sedes de la casa de apuestas.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class PanelAdministrarSede extends JPanel {
	/*
	 * fondo, recursoFondo, fondo2, recursoFondo2, imagenBoton1,
	 * recursoImagenBoton1, imagenBoton2, recursoImagenBoton2, imagenBoton3,
	 * recursoImagenBoton3, imagenBoton4, recursoImagenBoton4, imagenBoton5,
	 * recursoImagenBoton5 son de tipo ImageIcon.
	 */
	private ImageIcon fondo, recursoFondo, fondo2, recursoFondo2, imagenBoton1, recursoImagenBoton1, imagenBoton2,
			recursoImagenBoton2, imagenBoton3, recursoImagenBoton3, imagenBoton4, recursoImagenBoton4, imagenBoton5,
			recursoImagenBoton5;
	/*
	 * imagenFondo, imagenFondo2 son de tipo JLabel.
	 */
	private JLabel imagenFondo, imagenFondo2;
	/*
	 * fuente1 es de tipo Font.
	 */
	private Font fuente1;
	/*
	 * ubicacion, numeroEmpleados, nuevaUbicacion, numeroEmpleados2 son de tipo JTextField.
	 */
	private JTextField ubicacion, numeroEmpleados, nuevaUbicacion, numeroEmpleados2;
	/*
	 * ubicacion2 es de tipo JComboBox con parámetro String.
	 */
	private JComboBox<String> ubicacion2;
	/*
	 * volver, minimizar, cerrar son de tipo JButton.
	 */
	private JButton volver, minimizar, cerrar;
	/*
	 * añadir, editar son de tipo Boton.
	 */
	private Boton añadir, editar;
	/*
	 * Constructor de la clase donde se inicia el método para inicializar los
	 * componentes y donde se le agregan los compnentes de JPanel para que se pueda
	 * ver en la ventana.
	 */
	public PanelAdministrarSede() {

		setLayout(null);
		setVisible(false);
		setSize(800, 500);
		inicializarComponentes();
	}
	/*
	 * Método donde se inicializan los atributos que contienen el botón para
	 * añadir o editar junto con los campos de texto y se utilizan los diferentes
	 * componentes que son provenientes de la clase JPanel.
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
		volver.setActionCommand("VOLVERAVENTANAADMIN2");
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
		minimizar.setActionCommand("MINIMIZARPANELADMINSEDE");
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
		cerrar.setActionCommand("CERRARPANELADMINSEDE");
		add(cerrar);

		fuente1 = new Font("Arial", Font.ITALIC, 15);

		ubicacion = new JTextField();
		ubicacion.setBounds(270, 165, 270, 30);
		ubicacion.setFont(fuente1);
		add(ubicacion);

		numeroEmpleados = new JTextField();
		numeroEmpleados.setBounds(270, 255, 270, 30);
		numeroEmpleados.setFont(fuente1);
		add(numeroEmpleados);

		ubicacion2 = new JComboBox<String>();
		ubicacion2.setBounds(270, 165, 270, 30);
		ubicacion2.setFont(fuente1);
		ubicacion2.addItem("Seleccione una ubicación...");
		ubicacion2.setVisible(false);
		add(ubicacion2);

		nuevaUbicacion = new JTextField();
		nuevaUbicacion.setBounds(270, 255, 270, 30);
		nuevaUbicacion.setFont(fuente1);
		nuevaUbicacion.setVisible(false);
		add(nuevaUbicacion);

		numeroEmpleados2 = new JTextField();
		numeroEmpleados2.setBounds(270, 345, 270, 30);
		numeroEmpleados2.setFont(fuente1);
		numeroEmpleados2.setVisible(false);
		add(numeroEmpleados2);

		imagenBoton4 = new ImageIcon("recursos/añadirSD.png");
		recursoImagenBoton4 = new ImageIcon(imagenBoton4.getImage().getScaledInstance(138, 50, Image.SCALE_DEFAULT));
		añadir = new Boton();
		añadir.setBounds(330, 350, 138, 50);
		añadir.setBorderPainted(false);
		añadir.setContentAreaFilled(false);
		añadir.setFocusPainted(false);
		añadir.setIcon(recursoImagenBoton4);
		añadir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		añadir.setActionCommand("AÑADIRSEDE");
		add(añadir);

		imagenBoton5 = new ImageIcon("recursos/editarSD.png");
		recursoImagenBoton5 = new ImageIcon(imagenBoton5.getImage().getScaledInstance(130, 50, Image.SCALE_DEFAULT));
		editar = new Boton();
		editar.setBounds(330, 400, 130, 50);
		editar.setBorderPainted(false);
		editar.setContentAreaFilled(false);
		editar.setFocusPainted(false);
		editar.setIcon(recursoImagenBoton5);
		editar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editar.setActionCommand("EDITARSD");
		editar.setVisible(false);
		add(editar);

		fondo = new ImageIcon(getClass().getResource("/imagenes/añadirSede.jpg"));
		recursoFondo = new ImageIcon(fondo.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH));
		imagenFondo = new JLabel(recursoFondo);
		imagenFondo.setSize(800, 500);
		add(imagenFondo);

		fondo2 = new ImageIcon(getClass().getResource("/imagenes/editarSede.jpg"));
		recursoFondo2 = new ImageIcon(fondo2.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH));
		imagenFondo2 = new JLabel(recursoFondo2);
		imagenFondo2.setSize(800, 500);
		imagenFondo2.setVisible(false);
		add(imagenFondo2);

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
	 * @return the fondo2
	 */
	public ImageIcon getFondo2() {
		return fondo2;
	}

	/**
	 * @param fondo2 the fondo2 to set
	 */
	public void setFondo2(ImageIcon fondo2) {
		this.fondo2 = fondo2;
	}

	/**
	 * @return the recursoFondo2
	 */
	public ImageIcon getRecursoFondo2() {
		return recursoFondo2;
	}

	/**
	 * @param recursoFondo2 the recursoFondo2 to set
	 */
	public void setRecursoFondo2(ImageIcon recursoFondo2) {
		this.recursoFondo2 = recursoFondo2;
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
	 * @return the imagenFondo2
	 */
	public JLabel getImagenFondo2() {
		return imagenFondo2;
	}

	/**
	 * @param imagenFondo2 the imagenFondo2 to set
	 */
	public void setImagenFondo2(JLabel imagenFondo2) {
		this.imagenFondo2 = imagenFondo2;
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
	 * @return the ubicacion
	 */
	public JTextField getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(JTextField ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the numeroEmpleados
	 */
	public JTextField getNumeroEmpleados() {
		return numeroEmpleados;
	}

	/**
	 * @param numeroEmpleados the numeroEmpleados to set
	 */
	public void setNumeroEmpleados(JTextField numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	/**
	 * @return the nuevaUbicacion
	 */
	public JTextField getNuevaUbicacion() {
		return nuevaUbicacion;
	}

	/**
	 * @param nuevaUbicacion the nuevaUbicacion to set
	 */
	public void setNuevaUbicacion(JTextField nuevaUbicacion) {
		this.nuevaUbicacion = nuevaUbicacion;
	}

	/**
	 * @return the numeroEmpleados2
	 */
	public JTextField getNumeroEmpleados2() {
		return numeroEmpleados2;
	}

	/**
	 * @param numeroEmpleados2 the numeroEmpleados2 to set
	 */
	public void setNumeroEmpleados2(JTextField numeroEmpleados2) {
		this.numeroEmpleados2 = numeroEmpleados2;
	}

	/**
	 * @return the ubicacion2
	 */
	public JComboBox<String> getUbicacion2() {
		return ubicacion2;
	}

	/**
	 * @param ubicacion2 the ubicacion2 to set
	 */
	public void setUbicacion2(JComboBox<String> ubicacion2) {
		this.ubicacion2 = ubicacion2;
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
	 * @return the añadir
	 */
	public Boton getAñadir() {
		return añadir;
	}

	/**
	 * @param añadir the añadir to set
	 */
	public void setAñadir(Boton añadir) {
		this.añadir = añadir;
	}

	/**
	 * @return the editar
	 */
	public Boton getEditar() {
		return editar;
	}

	/**
	 * @param editar the editar to set
	 */
	public void setEditar(Boton editar) {
		this.editar = editar;
	}
}