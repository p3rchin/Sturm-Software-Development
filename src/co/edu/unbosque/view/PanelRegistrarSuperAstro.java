/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;

/**
 * Clase PanelRegistrarSuperAstro.
 * 
 * Clase donde tiene los componentes para hacer el panel de registro del juego
 * Super Astro.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class PanelRegistrarSuperAstro extends JPanel {
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
	 * fuente1 es de tipo Font.
	 */
	private Font fuente1;
	/*
	 * numero1, numero2, numero3, numero4 son de tipo JTextField.
	 */
	private JTextField numero1, numero2, numero3, numero4;
	/*
	 * signo es de tipo JComboBox con parámetro String.
	 */
	private JComboBox<String> signo;
	/*
	 * registrarSuperAstro es de tipo Boton.
	 */
	private Boton registrarSuperAstro;

	/*
	 * Constructor de la clase donde se inicia el método para inicializar los
	 * componentes y donde se le agregan los compnentes de JPanel para que se pueda
	 * ver en la ventana.
	 */
	public PanelRegistrarSuperAstro() {

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
		volver.setActionCommand("VOLVERREGISTROSUPERASTRO");
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
		minimizar.setActionCommand("MINIMIZARREGISTROSUPERASTRO");
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
		cerrar.setActionCommand("CERRARREGISTROSUPERASTRO");
		add(cerrar);
		
		fuente1 = new Font("Arial", Font.ITALIC, 15);
		
		numero1 = new JTextField();
		numero1.setBounds(280, 204, 45, 25);
		numero1.setFont(fuente1);
		add(numero1);

		numero2 = new JTextField();
		numero2.setBounds(330, 204, 45, 25);
		numero2.setFont(fuente1);
		add(numero2);

		numero3 = new JTextField();
		numero3.setBounds(380, 204, 45, 25);
		numero3.setFont(fuente1);
		add(numero3);

		numero4 = new JTextField();
		numero4.setBounds(430, 204, 45, 25);
		numero4.setFont(fuente1);
		add(numero4);

		signo = new JComboBox<String>();
		signo.setBounds(295, 258, 270, 25);
		signo.setFont(fuente1);
		signo.addItem("Seleccione su signo...");
		signo.addItem("Acuario");
		signo.addItem("Piscis");
		signo.addItem("Aries");
		signo.addItem("Tauro");
		signo.addItem("Géminis");
		signo.addItem("Cáncer");
		signo.addItem("Leo");
		signo.addItem("Virgo");
		signo.addItem("Libra");
		signo.addItem("Escorpio");
		signo.addItem("Sagitario");
		signo.addItem("Capricornio");
		add(signo);

		imagenBoton4 = new ImageIcon("recursos/registrarResultSuperAstro.png");
		recursoImagenBoton4 = new ImageIcon(imagenBoton4.getImage().getScaledInstance(280, 50, Image.SCALE_DEFAULT));
		registrarSuperAstro = new Boton();
		registrarSuperAstro.setBounds(255, 388, 280, 50);
		registrarSuperAstro.setBorderPainted(false);
		registrarSuperAstro.setContentAreaFilled(false);
		registrarSuperAstro.setFocusPainted(false);
		registrarSuperAstro.setIcon(recursoImagenBoton4);
		registrarSuperAstro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registrarSuperAstro.setActionCommand("REGISTRARRESULTADOSUPERASTRO");
		add(registrarSuperAstro);

		fondo = new ImageIcon(getClass().getResource("/imagenes/registrarResultadosSuperAstro.jpg"));
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
	 * @return the numero1
	 */
	public JTextField getNumero1() {
		return numero1;
	}

	/**
	 * @param numero1 the numero1 to set
	 */
	public void setNumero1(JTextField numero1) {
		this.numero1 = numero1;
	}

	/**
	 * @return the numero2
	 */
	public JTextField getNumero2() {
		return numero2;
	}

	/**
	 * @param numero2 the numero2 to set
	 */
	public void setNumero2(JTextField numero2) {
		this.numero2 = numero2;
	}

	/**
	 * @return the numero3
	 */
	public JTextField getNumero3() {
		return numero3;
	}

	/**
	 * @param numero3 the numero3 to set
	 */
	public void setNumero3(JTextField numero3) {
		this.numero3 = numero3;
	}

	/**
	 * @return the numero4
	 */
	public JTextField getNumero4() {
		return numero4;
	}

	/**
	 * @param numero4 the numero4 to set
	 */
	public void setNumero4(JTextField numero4) {
		this.numero4 = numero4;
	}

	/**
	 * @return the signo
	 */
	public JComboBox<String> getSigno() {
		return signo;
	}

	/**
	 * @param signo the signo to set
	 */
	public void setSigno(JComboBox<String> signo) {
		this.signo = signo;
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
}
