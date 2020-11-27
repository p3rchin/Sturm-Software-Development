/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * Clase VentaApostador.
 * 
 * Clase donde se le dan los diferentes componentes para la ventana del apostador, que se pueda ingresar el texto y
 * tenga la posibilidad de agregar apuestas, se inicializan los paneles que se contienen para
 * realizar las diferentes acciones.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class VentanaApostador extends JFrame {
	/*
	 * panelRegistrarApostador es de tipo PanelRegistrarApostador.
	 */
	private PanelRegistrarApostador panelRegistrarApostador;
	/*
	 * panelApostador es de tipo PanelApostador.
	 */
	private PanelApostador panelApostador;
	/*
	 * panelJuegoBaloto es de tipo PanelJuegoBaloto.
	 */
	private PanelJuegoBaloto panelJuegoBaloto;
	/*
	 * panelJuegoSuperAstro es de tipo PanelJuegoSuperAstro.
	 */
	private PanelJuegoSuperAstro panelJuegoSuperAstro;
	/*
	 * panelJuegoFutbol es de tipo PanelJuegoFutbol.
	 */
	private PanelJuegoFutbol panelJuegoFutbol;
	private PanelEditarApostador panelEditarApostador;
	/*
	 * fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2, recursoImagenBoton2,
	 * imagenBoton3, recursoImagenBoton3, imagenBoton4, recursoImagenBoton4, imagenBoton5, recursoImagenBoton5
	 * son de tipo ImageIcon.
	 */
	private ImageIcon fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2, recursoImagenBoton2,
			imagenBoton3, recursoImagenBoton3, imagenBoton4, recursoImagenBoton4, imagenBoton5, recursoImagenBoton5;
	/*
	 * imagenFondo es de tipo JLabel.
	 */
	private JLabel imagenFondo;
	/*
	 * volver, minimizar, cerrar es de tipo JButton.
	 */
	private JButton volver, minimizar, cerrar;
	/*
	 * fuente1 es de tipo Font.
	 */
	private Font fuente1;
	/*
	 * cedula es de tipo JTextField.
	 */
	private JTextField cedula;
	/*
	 * ingresar, registrar es de tipo Boton.
	 */
	private Boton ingresar, registrar;
	
	/**
	 * Constructor de la clase el cuál se inicializan los diferentes componentes junto con el método de
	 * inicializar componentes para su funcionamiento, estos componentes son de JFrame y los del método.
	 * <b>pre</b> Debe contener los componentes del frame para que se pueda ver la ventana.<br>
	 * <b>post</b> Se muestran los componentes que se ingresaron en el constructor.<br>
	 */
	public VentanaApostador() {

		setTitle("Sturm play");
		setSize(800, 500);
		setUndecorated(true);
		setIconImage(new ImageIcon("recursos/icon.png").getImage());
		inicializarComponentes();
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(false);

	}
	/**
	 * Este método se le ingresan los diferentes componentes que van a estar incluidos en la ventana.
	 * <b>pre</b> Se deben agregar los atributos en el método para inicializarlos y agregarlos en la ventana, junto
	 * con ello se debe inicializar los paneles.<br>
	 * <b>post</b> Se agregarán los componentes inicializados en la ventana para poder 
	 * seleccionar y tener una interfaz.<br>
	 */
	public void inicializarComponentes() {

		panelRegistrarApostador = new PanelRegistrarApostador();
		getContentPane().add(panelRegistrarApostador);

		panelApostador = new PanelApostador();
		getContentPane().add(panelApostador);

		panelJuegoBaloto = new PanelJuegoBaloto();
		getContentPane().add(panelJuegoBaloto);

		panelJuegoSuperAstro = new PanelJuegoSuperAstro();
		getContentPane().add(panelJuegoSuperAstro);

		panelJuegoFutbol = new PanelJuegoFutbol();
		getContentPane().add(panelJuegoFutbol);
		
		panelEditarApostador = new PanelEditarApostador();
		getContentPane().add(panelEditarApostador);

		imagenBoton1 = new ImageIcon("recursos/volver.png");
		recursoImagenBoton1 = new ImageIcon(imagenBoton1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		volver = new JButton();
		volver.setBounds(4, 5, 30, 30);
		volver.setBorderPainted(false);
		volver.setContentAreaFilled(false);
		volver.setFocusPainted(false);
		volver.setIcon(recursoImagenBoton1);
		volver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		volver.setActionCommand("VOLVERAPRINCIPAL");
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
		minimizar.setActionCommand("MINIMIZARVENTANAAPOSTADOR");
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
		cerrar.setActionCommand("CERRARVENTANAAPOSTADOR");
		add(cerrar);

		fuente1 = new Font("Arial", Font.ITALIC, 15);

		cedula = new JTextField();
		cedula.setBounds(245, 222, 296, 35);
		cedula.setFont(fuente1);
		cedula.setVisible(true);
		add(cedula);

		imagenBoton3 = new ImageIcon("recursos/entrarApostar.png");
		recursoImagenBoton3 = new ImageIcon(imagenBoton3.getImage().getScaledInstance(132, 50, Image.SCALE_DEFAULT));
		ingresar = new Boton();
		ingresar.setBounds(326, 280, 132, 50);
		ingresar.setBorderPainted(false);
		ingresar.setContentAreaFilled(false);
		ingresar.setFocusPainted(false);
		ingresar.setIcon(recursoImagenBoton3);
		ingresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ingresar.setActionCommand("INGRESOAPUESTAS");
		add(ingresar);

		imagenBoton4 = new ImageIcon("recursos/botonRegistrarApostador.png");
		recursoImagenBoton4 = new ImageIcon(imagenBoton4.getImage().getScaledInstance(184, 50, Image.SCALE_DEFAULT));
		registrar = new Boton();
		registrar.setBounds(300, 400, 184, 50);
		registrar.setBorderPainted(false);
		registrar.setContentAreaFilled(false);
		registrar.setFocusPainted(false);
		registrar.setIcon(recursoImagenBoton4);
		registrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registrar.setActionCommand("REGISTRARAPOSTADOR");
		add(registrar);

		fondo = new ImageIcon(getClass().getResource("/imagenes/iniciarSesionApostador.jpg"));
		recursoFondo = new ImageIcon(fondo.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH));
		imagenFondo = new JLabel(recursoFondo);
		imagenFondo.setSize(800, 500);
		add(imagenFondo);

	}

	/**
	 * @return the panelEditarApostador
	 */
	public PanelEditarApostador getPanelEditarApostador() {
		return panelEditarApostador;
	}
	/**
	 * @param panelEditarApostador the panelEditarApostador to set
	 */
	public void setPanelEditarApostador(PanelEditarApostador panelEditarApostador) {
		this.panelEditarApostador = panelEditarApostador;
	}
	/**
	 * @return the panelRegistrarApostador
	 */
	public PanelRegistrarApostador getPanelRegistrarApostador() {
		return panelRegistrarApostador;
	}

	/**
	 * @param panelRegistrarApostador the panelRegistrarApostador to set
	 */
	public void setPanelRegistrarApostador(PanelRegistrarApostador panelRegistrarApostador) {
		this.panelRegistrarApostador = panelRegistrarApostador;
	}

	/**
	 * @return the panelApostador
	 */
	public PanelApostador getPanelApostador() {
		return panelApostador;
	}

	/**
	 * @param panelApostador the panelApostador to set
	 */
	public void setPanelApostador(PanelApostador panelApostador) {
		this.panelApostador = panelApostador;
	}

	/**
	 * @return the panelJuegoBaloto
	 */
	public PanelJuegoBaloto getPanelJuegoBaloto() {
		return panelJuegoBaloto;
	}

	/**
	 * @param panelJuegoBaloto the panelJuegoBaloto to set
	 */
	public void setPanelJuegoBaloto(PanelJuegoBaloto panelJuegoBaloto) {
		this.panelJuegoBaloto = panelJuegoBaloto;
	}

	/**
	 * @return the panelJuegoSuperAstro
	 */
	public PanelJuegoSuperAstro getPanelJuegoSuperAstro() {
		return panelJuegoSuperAstro;
	}

	/**
	 * @param panelJuegoSuperAstro the panelJuegoSuperAstro to set
	 */
	public void setPanelJuegoSuperAstro(PanelJuegoSuperAstro panelJuegoSuperAstro) {
		this.panelJuegoSuperAstro = panelJuegoSuperAstro;
	}

	/**
	 * @return the panelJuegoFutbol
	 */
	public PanelJuegoFutbol getPanelJuegoFutbol() {
		return panelJuegoFutbol;
	}

	/**
	 * @param panelJuegoFutbol the panelJuegoFutbol to set
	 */
	public void setPanelJuegoFutbol(PanelJuegoFutbol panelJuegoFutbol) {
		this.panelJuegoFutbol = panelJuegoFutbol;
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
	 * @return the cedula
	 */
	public JTextField getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the ingresar
	 */
	public Boton getIngresar() {
		return ingresar;
	}

	/**
	 * @param ingresar the ingresar to set
	 */
	public void setIngresar(Boton ingresar) {
		this.ingresar = ingresar;
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

}