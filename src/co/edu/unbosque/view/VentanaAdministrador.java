/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Clase VentanaAdministrador.
 * 
 * Clase donde se le dan los diferentes componentes para la ventana del
 * administrador, que se pueda ingresar diferentes tipos de sedes, la cantidad
 * de empleados que desea ingresar, modificar las sedes y modificar la casa de
 * apuestas.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class VentanaAdministrador extends JFrame {
	/*
	 * panelAdministrarCasa es de tipo PanelAdministrarCasa.
	 */
	private PanelAdministrarCasa panelAdministrarCasa;
	/*
	 * panelAdministrarSede es de tipo PanelAdministrarSede.
	 */
	private PanelAdministrarSede panelAdministrarSede;
	/*
	 * panelRegistroResultados es de tipo PanelRegistroResultados.
	 */
	private PanelRegistroResultados panelRegistroResultados;
	/*
	 * panelRegistrarBaloto es de tipo PanelRegistrarBaloto.
	 */
	private PanelRegistrarBaloto panelRegistrarBaloto;
	/*
	 * panelRegistrarSuperAstro es de tipo PanelRegistrarSuperAstro.
	 */
	private PanelRegistrarSuperAstro panelRegistrarSuperAstro;
	/*
	 * panelRegistrarPartido es de tipo PanelRegistrarPartido.
	 */
	private PanelRegistrarPartido panelRegistrarPartido;
	/*
	 * fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2,
	 * recursoImagenBoton2, imagenBoton3, recursoImagenBoton3, imagenBoton4,
	 * recursoImagenBoton4, imagenBoton5, recursoImagenBoton5, imagenBoton6,
	 * recursoImagenBoton6, imagenBoton7, recursoImagenBoton7, imagenBoton8,
	 * recursoImagenBoton8, imagenBoton9, recursoImagenBoton9, imagenBoton10,
	 * recursoImagenBoton10, imagenBoton11, recursoImagenBoton11, son de tipo
	 * ImageIcon.
	 */
	private ImageIcon fondo, recursoFondo, imagenBoton1, recursoImagenBoton1, imagenBoton2, recursoImagenBoton2,
			imagenBoton3, recursoImagenBoton3, imagenBoton4, recursoImagenBoton4, imagenBoton5, recursoImagenBoton5,
			imagenBoton6, recursoImagenBoton6, imagenBoton7, recursoImagenBoton7, imagenBoton8, recursoImagenBoton8,
			imagenBoton9, recursoImagenBoton9, imagenBoton10, recursoImagenBoton10, imagenBoton11, recursoImagenBoton11;
	/*
	 * imagenFondo es de tipo JLabel.
	 */
	private JLabel imagenFondo;
	/*
	 * volver, minimizar, cerrar son de tipo JButton.
	 */
	private JButton volver, minimizar, cerrar;
	/*
	 * boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, son de tipo
	 * Boton.
	 */
	private Boton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8;

	/**
	 * Constructor de la clase el cuál se inicializan los diferentes componentes
	 * junto con el método de inicializar componentes para su funcionamiento, estos
	 * componentes son de JFrame y los del método. <b>pre</b> Debe contener los
	 * componentes del frame para que se pueda ver la ventana.<br>
	 * <b>post</b> Se muestran los componentes que se ingresaron en el
	 * constructor.<br>
	 */
	public VentanaAdministrador() {

		setTitle("Administrador de Sturm play");
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
	 * Este método se le ingresan los diferentes componentes que van a estar
	 * incluidos en la ventana y que provienen de los atributos junto con
	 * componentes del JFrame. <b>pre</b> Se deben agregar los atributos en el
	 * método para inicializarlos y agregarlos en la ventana, juento con ello debe
	 * inicializarse los paneles.<br>
	 * <b>post</b> Se agregarán los componentes inicializados en la ventana para
	 * poder seleccionar y tener una interfaz.<br>
	 */
	public void inicializarComponentes() {

		panelAdministrarCasa = new PanelAdministrarCasa();
		getContentPane().add(panelAdministrarCasa);

		panelAdministrarSede = new PanelAdministrarSede();
		getContentPane().add(panelAdministrarSede);

		panelRegistroResultados = new PanelRegistroResultados();
		getContentPane().add(panelRegistroResultados);

		panelRegistrarBaloto = new PanelRegistrarBaloto();
		getContentPane().add(panelRegistrarBaloto);

		panelRegistrarSuperAstro = new PanelRegistrarSuperAstro();
		getContentPane().add(panelRegistrarSuperAstro);

		panelRegistrarPartido = new PanelRegistrarPartido();
		getContentPane().add(panelRegistrarPartido);

		imagenBoton1 = new ImageIcon("recursos/volver.png");
		recursoImagenBoton1 = new ImageIcon(imagenBoton1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		volver = new JButton();
		volver.setBounds(4, 5, 30, 30);
		volver.setBorderPainted(false);
		volver.setContentAreaFilled(false);
		volver.setFocusPainted(false);
		volver.setIcon(recursoImagenBoton1);
		volver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		volver.setActionCommand("VOLVERPRINCIPALDEADMIN");
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
		minimizar.setActionCommand("MINIMIZARVENTANAADMIN");
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
		cerrar.setActionCommand("CERRARVENTANAADMIN");
		add(cerrar);

		imagenBoton4 = new ImageIcon("recursos/administrarCasas.png");
		recursoImagenBoton4 = new ImageIcon(imagenBoton4.getImage().getScaledInstance(236, 50, Image.SCALE_DEFAULT));
		boton1 = new Boton();
		boton1.setBounds(20, 150, 236, 50);
		boton1.setBorderPainted(false);
		boton1.setContentAreaFilled(false);
		boton1.setFocusPainted(false);
		boton1.setIcon(recursoImagenBoton4);
		boton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton1.setActionCommand("ADMINISTRARCASAS");
		add(boton1);

		imagenBoton5 = new ImageIcon("recursos/agregarSede.png");
		recursoImagenBoton5 = new ImageIcon(imagenBoton5.getImage().getScaledInstance(202, 50, Image.SCALE_DEFAULT));
		boton2 = new Boton();
		boton2.setBounds(20, 220, 202, 50);
		boton2.setBorderPainted(false);
		boton2.setContentAreaFilled(false);
		boton2.setFocusPainted(false);
		boton2.setIcon(recursoImagenBoton5);
		boton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton2.setActionCommand("AGREGARSEDE");
		add(boton2);

		imagenBoton6 = new ImageIcon("recursos/editarSede.png");
		recursoImagenBoton6 = new ImageIcon(imagenBoton6.getImage().getScaledInstance(182, 50, Image.SCALE_DEFAULT));
		boton3 = new Boton();
		boton3.setBounds(20, 290, 182, 50);
		boton3.setBorderPainted(false);
		boton3.setContentAreaFilled(false);
		boton3.setFocusPainted(false);
		boton3.setIcon(recursoImagenBoton6);
		boton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton3.setActionCommand("EDITARSEDE");
		add(boton3);

		imagenBoton7 = new ImageIcon("recursos/eliminarSede.png");
		recursoImagenBoton7 = new ImageIcon(imagenBoton7.getImage().getScaledInstance(204, 50, Image.SCALE_DEFAULT));
		boton4 = new Boton();
		boton4.setBounds(20, 360, 204, 50);
		boton4.setBorderPainted(false);
		boton4.setContentAreaFilled(false);
		boton4.setFocusPainted(false);
		boton4.setIcon(recursoImagenBoton7);
		boton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton4.setActionCommand("ELIMINARSEDE");
		add(boton4);

		imagenBoton8 = new ImageIcon("recursos/registrarResultados.png");
		recursoImagenBoton8 = new ImageIcon(imagenBoton8.getImage().getScaledInstance(268, 50, Image.SCALE_DEFAULT));
		boton5 = new Boton();
		boton5.setBounds(515, 150, 268, 50);
		boton5.setBorderPainted(false);
		boton5.setContentAreaFilled(false);
		boton5.setFocusPainted(false);
		boton5.setIcon(recursoImagenBoton8);
		boton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton5.setActionCommand("REGISTRARRESULTADOS");
		add(boton5);
		
		imagenBoton9 = new ImageIcon("recursos/exportarPDF.png");
		recursoImagenBoton9 = new ImageIcon(imagenBoton9.getImage().getScaledInstance(230, 50, Image.SCALE_DEFAULT));
		boton6 = new Boton();
		boton6.setBounds(553, 220, 230, 50);
		boton6.setBorderPainted(false);
		boton6.setContentAreaFilled(false);
		boton6.setFocusPainted(false);
		boton6.setIcon(recursoImagenBoton9);
		boton6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton6.setActionCommand("EXPORTARPDF");
		add(boton6);
		
		imagenBoton10 = new ImageIcon("recursos/exportarExcel.png");
		recursoImagenBoton10 = new ImageIcon(imagenBoton10.getImage().getScaledInstance(248, 50, Image.SCALE_DEFAULT));
		boton7 = new Boton();
		boton7.setBounds(535, 290, 248, 50);
		boton7.setBorderPainted(false);
		boton7.setContentAreaFilled(false);
		boton7.setFocusPainted(false);
		boton7.setIcon(recursoImagenBoton10);
		boton7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton7.setActionCommand("EXPORTAREXCEL");
		add(boton7);
		
		imagenBoton11 = new ImageIcon("recursos/verInformacion.png");
		recursoImagenBoton11 = new ImageIcon(imagenBoton11.getImage().getScaledInstance(230, 50, Image.SCALE_DEFAULT));
		boton8 = new Boton();
		boton8.setBounds(553, 360, 230, 50);
		boton8.setBorderPainted(false);
		boton8.setContentAreaFilled(false);
		boton8.setFocusPainted(false);
		boton8.setIcon(recursoImagenBoton11);
		boton8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		boton8.setActionCommand("VERINFORMACIONADMIN");
		add(boton8);
		
		fondo = new ImageIcon(getClass().getResource("/imagenes/fondoVentanaAdministrador.jpg"));
		recursoFondo = new ImageIcon(fondo.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH));
		imagenFondo = new JLabel(recursoFondo);
		imagenFondo.setSize(800, 500);
		add(imagenFondo);

	}

	/**
	 * @return the panelAdministrarCasa
	 */
	public PanelAdministrarCasa getPanelAdministrarCasa() {
		return panelAdministrarCasa;
	}

	/**
	 * @param panelAdministrarCasa the panelAdministrarCasa to set
	 */
	public void setPanelAdministrarCasa(PanelAdministrarCasa panelAdministrarCasa) {
		this.panelAdministrarCasa = panelAdministrarCasa;
	}

	/**
	 * @return the panelAdministrarSede
	 */
	public PanelAdministrarSede getPanelAdministrarSede() {
		return panelAdministrarSede;
	}

	/**
	 * @param panelAdministrarSede the panelAdministrarSede to set
	 */
	public void setPanelAdministrarSede(PanelAdministrarSede panelAdministrarSede) {
		this.panelAdministrarSede = panelAdministrarSede;
	}

	/**
	 * @return the panelRegistroResultados
	 */
	public PanelRegistroResultados getPanelRegistroResultados() {
		return panelRegistroResultados;
	}

	/**
	 * @param panelRegistroResultados the panelRegistroResultados to set
	 */
	public void setPanelRegistroResultados(PanelRegistroResultados panelRegistroResultados) {
		this.panelRegistroResultados = panelRegistroResultados;
	}

	/**
	 * @return the panelRegistrarBaloto
	 */
	public PanelRegistrarBaloto getPanelRegistrarBaloto() {
		return panelRegistrarBaloto;
	}

	/**
	 * @param panelRegistrarBaloto the panelRegistrarBaloto to set
	 */
	public void setPanelRegistrarBaloto(PanelRegistrarBaloto panelRegistrarBaloto) {
		this.panelRegistrarBaloto = panelRegistrarBaloto;
	}

	/**
	 * @return the panelRegistrarSuperAstro
	 */
	public PanelRegistrarSuperAstro getPanelRegistrarSuperAstro() {
		return panelRegistrarSuperAstro;
	}

	/**
	 * @param panelRegistrarSuperAstro the panelRegistrarSuperAstro to set
	 */
	public void setPanelRegistrarSuperAstro(PanelRegistrarSuperAstro panelRegistrarSuperAstro) {
		this.panelRegistrarSuperAstro = panelRegistrarSuperAstro;
	}

	/**
	 * @return the panelRegistrarPartido
	 */
	public PanelRegistrarPartido getPanelRegistrarPartido() {
		return panelRegistrarPartido;
	}

	/**
	 * @param panelRegistrarPartido the panelRegistrarPartido to set
	 */
	public void setPanelRegistrarPartido(PanelRegistrarPartido panelRegistrarPartido) {
		this.panelRegistrarPartido = panelRegistrarPartido;
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
	 * @return the imagenBoton7
	 */
	public ImageIcon getImagenBoton7() {
		return imagenBoton7;
	}

	/**
	 * @param imagenBoton7 the imagenBoton7 to set
	 */
	public void setImagenBoton7(ImageIcon imagenBoton7) {
		this.imagenBoton7 = imagenBoton7;
	}

	/**
	 * @return the recursoImagenBoton7
	 */
	public ImageIcon getRecursoImagenBoton7() {
		return recursoImagenBoton7;
	}

	/**
	 * @param recursoImagenBoton7 the recursoImagenBoton7 to set
	 */
	public void setRecursoImagenBoton7(ImageIcon recursoImagenBoton7) {
		this.recursoImagenBoton7 = recursoImagenBoton7;
	}

	/**
	 * @return the imagenBoton8
	 */
	public ImageIcon getImagenBoton8() {
		return imagenBoton8;
	}

	/**
	 * @param imagenBoton8 the imagenBoton8 to set
	 */
	public void setImagenBoton8(ImageIcon imagenBoton8) {
		this.imagenBoton8 = imagenBoton8;
	}

	/**
	 * @return the recursoImagenBoton8
	 */
	public ImageIcon getRecursoImagenBoton8() {
		return recursoImagenBoton8;
	}

	/**
	 * @param recursoImagenBoton8 the recursoImagenBoton8 to set
	 */
	public void setRecursoImagenBoton8(ImageIcon recursoImagenBoton8) {
		this.recursoImagenBoton8 = recursoImagenBoton8;
	}

	/**
	 * @return the imagenBoton9
	 */
	public ImageIcon getImagenBoton9() {
		return imagenBoton9;
	}

	/**
	 * @param imagenBoton9 the imagenBoton9 to set
	 */
	public void setImagenBoton9(ImageIcon imagenBoton9) {
		this.imagenBoton9 = imagenBoton9;
	}

	/**
	 * @return the recursoImagenBoton9
	 */
	public ImageIcon getRecursoImagenBoton9() {
		return recursoImagenBoton9;
	}

	/**
	 * @param recursoImagenBoton9 the recursoImagenBoton9 to set
	 */
	public void setRecursoImagenBoton9(ImageIcon recursoImagenBoton9) {
		this.recursoImagenBoton9 = recursoImagenBoton9;
	}

	/**
	 * @return the imagenBoton10
	 */
	public ImageIcon getImagenBoton10() {
		return imagenBoton10;
	}

	/**
	 * @param imagenBoton10 the imagenBoton10 to set
	 */
	public void setImagenBoton10(ImageIcon imagenBoton10) {
		this.imagenBoton10 = imagenBoton10;
	}

	/**
	 * @return the recursoImagenBoton10
	 */
	public ImageIcon getRecursoImagenBoton10() {
		return recursoImagenBoton10;
	}

	/**
	 * @param recursoImagenBoton10 the recursoImagenBoton10 to set
	 */
	public void setRecursoImagenBoton10(ImageIcon recursoImagenBoton10) {
		this.recursoImagenBoton10 = recursoImagenBoton10;
	}

	/**
	 * @return the imagenBoton11
	 */
	public ImageIcon getImagenBoton11() {
		return imagenBoton11;
	}

	/**
	 * @param imagenBoton11 the imagenBoton11 to set
	 */
	public void setImagenBoton11(ImageIcon imagenBoton11) {
		this.imagenBoton11 = imagenBoton11;
	}

	/**
	 * @return the recursoImagenBoton11
	 */
	public ImageIcon getRecursoImagenBoton11() {
		return recursoImagenBoton11;
	}

	/**
	 * @param recursoImagenBoton11 the recursoImagenBoton11 to set
	 */
	public void setRecursoImagenBoton11(ImageIcon recursoImagenBoton11) {
		this.recursoImagenBoton11 = recursoImagenBoton11;
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
	 * @return the boton3
	 */
	public Boton getBoton3() {
		return boton3;
	}

	/**
	 * @param boton3 the boton3 to set
	 */
	public void setBoton3(Boton boton3) {
		this.boton3 = boton3;
	}

	/**
	 * @return the boton4
	 */
	public Boton getBoton4() {
		return boton4;
	}

	/**
	 * @param boton4 the boton4 to set
	 */
	public void setBoton4(Boton boton4) {
		this.boton4 = boton4;
	}

	/**
	 * @return the boton5
	 */
	public Boton getBoton5() {
		return boton5;
	}

	/**
	 * @param boton5 the boton5 to set
	 */
	public void setBoton5(Boton boton5) {
		this.boton5 = boton5;
	}

	/**
	 * @return the boton6
	 */
	public Boton getBoton6() {
		return boton6;
	}

	/**
	 * @param boton6 the boton6 to set
	 */
	public void setBoton6(Boton boton6) {
		this.boton6 = boton6;
	}

	/**
	 * @return the boton7
	 */
	public Boton getBoton7() {
		return boton7;
	}

	/**
	 * @param boton7 the boton7 to set
	 */
	public void setBoton7(Boton boton7) {
		this.boton7 = boton7;
	}

	/**
	 * @return the boton8
	 */
	public Boton getBoton8() {
		return boton8;
	}

	/**
	 * @param boton8 the boton8 to set
	 */
	public void setBoton8(Boton boton8) {
		this.boton8 = boton8;
	}
	
}