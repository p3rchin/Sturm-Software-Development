/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase PanelRegistroResultados.
 * 
 * Clase donde se ponen los componentes para hacer el registro de resultados de
 * los diferentes juegos de apuestas que se mostraran al momento de el usuario
 * seleccionar el botón de registrar las apuestas.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class PanelRegistroResultados extends JPanel {
	/*
	 * fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2,
	 * recursoImagenBoton2, imagenBoton3, recursoImagenBoton3, imagenBoton4,
	 * recursoImagenBoton4, imagenBoton5, recursoImagenBoton5, imagenBoton6,
	 * recursoImagenBoton6 son de tipo ImageIcon
	 */
	private ImageIcon fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2, recursoImagenBoton2,
			imagenBoton3, recursoImagenBoton3, imagenBoton4, recursoImagenBoton4, imagenBoton5, recursoImagenBoton5,
			imagenBoton6, recursoImagenBoton6;
	/*
	 * imagenFondo es de tipo JLabel.
	 */
	private JLabel imagenFondo;
	/*
	 * volver, minimizar, cerrar son de tipo JButton.
	 */
	private JButton volver, minimizar, cerrar;
	/*
	 * registrarBaloto, registrarSuperAstro, registrarFutbol son de tipo Buton.
	 */
	private Boton registrarBaloto, registrarSuperAstro, registrarFutbol;
	/*
	 * Constructor de la clase donde se inicia el método para inicializar los componentes y 
	 * donde se le agregan los compnentes de JPanel para que se pueda ver en la ventana.
	 */
	public PanelRegistroResultados() {

		setLayout(null);
		setVisible(false);
		setSize(800, 500);
		inicializarComponentes();
	}
	/*
	 * Método donde se inicializan los atributos y se utilizan los diferentes componentes
	 * que son provenientes de la clase JPanel.
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
		volver.setActionCommand("VOLVERAVENTANAADMIN3");
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
		minimizar.setActionCommand("MINIMIZARPANELADMINRESULTADOS");
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
		cerrar.setActionCommand("CERRARPANELADMINRESULTADOS");
		add(cerrar);

		imagenBoton4 = new ImageIcon("recursos/registrarBaloto.png");
		recursoImagenBoton4 = new ImageIcon(imagenBoton4.getImage().getScaledInstance(236, 50, Image.SCALE_DEFAULT));
		registrarBaloto = new Boton();
		registrarBaloto.setBounds(325, 128, 236, 50);
		registrarBaloto.setBorderPainted(false);
		registrarBaloto.setContentAreaFilled(false);
		registrarBaloto.setFocusPainted(false);
		registrarBaloto.setIcon(recursoImagenBoton4);
		registrarBaloto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registrarBaloto.setActionCommand("REGISTRARBALOTO");
		add(registrarBaloto);

		imagenBoton5 = new ImageIcon("recursos/registrarAstro.png");
		recursoImagenBoton5 = new ImageIcon(imagenBoton5.getImage().getScaledInstance(224, 50, Image.SCALE_DEFAULT));
		registrarSuperAstro = new Boton();
		registrarSuperAstro.setBounds(330, 223, 224, 50);
		registrarSuperAstro.setBorderPainted(false);
		registrarSuperAstro.setContentAreaFilled(false);
		registrarSuperAstro.setFocusPainted(false);
		registrarSuperAstro.setIcon(recursoImagenBoton5);
		registrarSuperAstro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registrarSuperAstro.setActionCommand("REGISTRARSUPERASTRO");
		add(registrarSuperAstro);

		imagenBoton6 = new ImageIcon("recursos/registrarPartidos.png");
		recursoImagenBoton6 = new ImageIcon(imagenBoton6.getImage().getScaledInstance(246, 50, Image.SCALE_DEFAULT));
		registrarFutbol = new Boton();
		registrarFutbol.setBounds(330, 338, 246, 50);
		registrarFutbol.setBorderPainted(false);
		registrarFutbol.setContentAreaFilled(false);
		registrarFutbol.setFocusPainted(false);
		registrarFutbol.setIcon(recursoImagenBoton6);
		registrarFutbol.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registrarFutbol.setActionCommand("REGISTRARFUTBOL");
		add(registrarFutbol);

		fondo = new ImageIcon(getClass().getResource("/imagenes/registrarResultados.jpg"));
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
	 * @return the imagenBoton6
	 */
	public ImageIcon getImagenBoton6() {
		return imagenBoton6;
	}

	/**
	 * @param imagenBoton6 the imagenBoton6 to set
	 */
	public void setImagenBoton6(ImageIcon imagenBoton6) {
		this.imagenBoton6 = imagenBoton6;
	}

	/**
	 * @return the recursoImagenBoton6
	 */
	public ImageIcon getRecursoImagenBoton6() {
		return recursoImagenBoton6;
	}

	/**
	 * @param recursoImagenBoton6 the recursoImagenBoton6 to set
	 */
	public void setRecursoImagenBoton6(ImageIcon recursoImagenBoton6) {
		this.recursoImagenBoton6 = recursoImagenBoton6;
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
	 * @return the registrarBaloto
	 */
	public Boton getRegistrarBaloto() {
		return registrarBaloto;
	}

	/**
	 * @param registrarBaloto the registrarBaloto to set
	 */
	public void setRegistrarBaloto(Boton registrarBaloto) {
		this.registrarBaloto = registrarBaloto;
	}

	/**
	 * @return the registrarSuperAstro
	 */
	public Boton getRegistrarSuperAstro() {
		return registrarSuperAstro;
	}

	/**
	 * @param registrarSuperAstro the registrarSuperAstro to set
	 */
	public void setRegistrarSuperAstro(Boton registrarSuperAstro) {
		this.registrarSuperAstro = registrarSuperAstro;
	}

	/**
	 * @return the registrarFutbol
	 */
	public Boton getRegistrarFutbol() {
		return registrarFutbol;
	}

	/**
	 * @param registrarFutbol the registrarFutbol to set
	 */
	public void setRegistrarFutbol(Boton registrarFutbol) {
		this.registrarFutbol = registrarFutbol;
	}
}
