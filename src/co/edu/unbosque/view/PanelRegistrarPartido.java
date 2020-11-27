/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;

/**
 * Clase PanelRegistrarPartido.
 * 
 * Clase donde tiene los componentes para hacer el panel de registro del
 * partido.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class PanelRegistrarPartido extends JPanel {
	/*
	 * fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2,
	 * recursoImagenBoton2, imagenBoton3, recursoImagenBoton3, imagenBoton4,
	 * recursoImagenBoton4 son de tipo ImageIcon.
	 */
	private ImageIcon fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2, recursoImagenBoton2,
			imagenBoton3, recursoImagenBoton3, imagenBoton4, recursoImagenBoton4;
	/*
	 * imagenFondo es de tipo JLabel.
	 */
	private JLabel imagenFondo;
	/*
	 * volver, minimizar, cerrar son de tipo JButton.
	 */
	private JButton volver, minimizar, cerrar;
	/*
	 * partidos, modo son de tipo JComboBox con parámetro String.
	 */
	private JComboBox<String> partidos, modo;
	/*
	 * registrar es de tipo Boton.
	 */
	private Boton registrar;
	/*
	 * fuente1 es de tipo Font.
	 */
	private Font fuente1;

	/*
	 * Constructor de la clase donde se inicia el método para inicializar los
	 * componentes y donde se le agregan los compnentes de JPanel para que se pueda
	 * ver en la ventana.
	 */
	public PanelRegistrarPartido() {

		setLayout(null);
		setVisible(false);
		setSize(800, 500);
		inicializarComponentes();

	}

	/*
	 * Método donde se inicializan los atributos y se utilizan los diferentes
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
		volver.setActionCommand("VOLVERREGISTROPARTIDOS");
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
		minimizar.setActionCommand("MINIMIZARREGISTROPARTIDOS");
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
		cerrar.setActionCommand("CERRARREGISTROPARTIDOS");
		add(cerrar);

		fuente1 = new Font("Arial", Font.ITALIC, 15);
		
		partidos = new JComboBox<String>();
		partidos.setBounds(280, 204, 270, 25);
		partidos.setFont(fuente1);
		partidos.addItem("Seleccione un partido...");
		add(partidos);

		modo = new JComboBox<String>();
		modo.setBounds(280, 258, 270, 25);
		modo.setFont(fuente1);
		modo.addItem("Seleccione un resultado...");
		modo.addItem("Local");
		modo.addItem("Visitante");
		modo.addItem("Empate");
		add(modo);

		imagenBoton4 = new ImageIcon("recursos/registrarResultPartidos.png");
		recursoImagenBoton4 = new ImageIcon(imagenBoton4.getImage().getScaledInstance(236, 50, Image.SCALE_DEFAULT));
		registrar = new Boton();
		registrar.setBounds(295, 388, 236, 50);
		registrar.setBorderPainted(false);
		registrar.setContentAreaFilled(false);
		registrar.setFocusPainted(false);
		registrar.setIcon(recursoImagenBoton4);
		registrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registrar.setActionCommand("REGISTRARRESULTADOPARTIDO");
		add(registrar);

		fondo = new ImageIcon(getClass().getResource("/imagenes/registrarResultadosPartidos.jpg"));
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
	 * @return the registrar
	 */
	public Boton getRegistrar() {
		return registrar;
	}

	/**
	 * @param registrar the registrar to set
	 */
	public void setRegistrar(Boton registrar) {
		this.registrar = registrar;
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
}