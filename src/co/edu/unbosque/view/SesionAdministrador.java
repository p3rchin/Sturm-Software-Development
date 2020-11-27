/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
/**
 * Clase SesionAdministrador.
 * 
 * Clase donde se el inicio de sesión del administrador para que pueda ingresar a realizar las diferentes 
 * modificaciones en la casa de apuestas.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class SesionAdministrador extends JFrame {
	/*
	 * fondo, recursoFondo, imagen1, imagenRecurso1, imagen2, imagenRecurso2, imagen3, 
	 * imagenRecurso3,imagenBoton1, imagenBotonRecurso1, imagenBoton2, imagenBotonRecurso2 son 
	 * de tipo ImageIcon.
	 */
	private ImageIcon fondo, recursoFondo, imagen1, imagenRecurso1, imagen2, imagenRecurso2, imagen3, imagenRecurso3,
			imagenBoton1, imagenBotonRecurso1, imagenBoton2, imagenBotonRecurso2;
	/*
	 * fuente1, fuente2, fuente3 son de tipo Font.
	 */
	private Font fuente1, fuente2, fuente3;
	/*
	 * imagenFondo, etiquetaImagen1, etiquetaImagen2, etiquetaImagen3, titulo, usuario, contraseña son
	 * de tipo JLabel.
	 */
	private JLabel imagenFondo, etiquetaImagen1, etiquetaImagen2, etiquetaImagen3, titulo, usuario, contraseña;
	/*
	 * campoUsuario, campoContraseña son de tipo JTextField.
	 */
	private JTextField campoUsuario, campoContraseña;
	/*
	 * ingresar, salir son de tipo Boton.
	 */
	private Boton ingresar, salir;
	
	/*
	 * Constructor de la clase el cuál se inicializan los diferentes componentes junto con el método de
	 * inicializar componentes para su funcionamiento, estos componentes son de JFrame y los del método.
	 */
	public SesionAdministrador() {

		setTitle("Inicio de sesión administrador");
		setSize(460, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("recursos/icon.png").getImage());
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
		inicializarComponentes();

	}
	/**
	 * Este método se le ingresan los diferentes componentes que van a estar incluidos en la ventana y que 
	 * provienen de los atributos junto con componentes del JFrame.
	 * <b>pre</b> Se deben agregar los atributos en el método para inicializarlos y agregarlos en la ventana, juento
	 * con ello debe inicializarse los paneles.<br>
	 * <b>post</b> Se agregarán los componentes inicializados en la ventana para poder 
	 * seleccionar y tener una interfaz.<br>
	 */
	public void inicializarComponentes() {

		imagen1 = new ImageIcon(getClass().getResource("/imagenes/iconoTituloAdmin.png"));
		imagenRecurso1 = new ImageIcon(imagen1.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));

		etiquetaImagen1 = new JLabel(imagenRecurso1);
		etiquetaImagen1.setBounds(15, 25, 35, 35);
		etiquetaImagen1.setVisible(true);
		add(etiquetaImagen1);

		imagen2 = new ImageIcon(getClass().getResource("/imagenes/iconoUsuarioAdmin.png"));
		imagenRecurso2 = new ImageIcon(imagen2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

		etiquetaImagen2 = new JLabel(imagenRecurso2);
		etiquetaImagen2.setBounds(38, 100, 20, 20);
		etiquetaImagen2.setVisible(true);
		add(etiquetaImagen2);

		imagen3 = new ImageIcon(getClass().getResource("/imagenes/iconoContraseñaAdmin.png"));
		imagenRecurso3 = new ImageIcon(imagen3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

		etiquetaImagen3 = new JLabel(imagenRecurso3);
		etiquetaImagen3.setBounds(38, 160, 20, 20);
		etiquetaImagen3.setVisible(true);
		add(etiquetaImagen3);

		fuente1 = new Font("Arial", Font.CENTER_BASELINE, 22);
		fuente2 = new Font("Arial", Font.BOLD, 15);
		fuente3 = new Font("Arial", Font.ITALIC, 15);

		titulo = new JLabel("Iniciar sesión como administrador");
		titulo.setFont(fuente1);
		titulo.setBounds(60, 23, 400, 40);
		titulo.setVisible(true);
		add(titulo);

		usuario = new JLabel("Usuario: ");
		usuario.setFont(fuente2);
		usuario.setBounds(60, 100, 150, 20);
		usuario.setVisible(true);
		add(usuario);

		contraseña = new JLabel("Contraseña: ");
		contraseña.setFont(fuente2);
		contraseña.setBounds(60, 160, 150, 20);
		contraseña.setVisible(true);
		add(contraseña);

		campoUsuario = new JTextField("admin");
		campoUsuario.setFont(fuente3);
		campoUsuario.setBounds(170, 96, 210, 35);
		campoUsuario.setVisible(true);
		add(campoUsuario);

		campoContraseña = new JPasswordField(30);
		campoUsuario.setFont(fuente3);
		campoContraseña.setBounds(170, 156, 210, 35);
		campoContraseña.setVisible(true);
		add(campoContraseña);

		imagenBoton1 = new ImageIcon("recursos/botonIngresar.png");
		imagenBotonRecurso1 = new ImageIcon(imagenBoton1.getImage().getScaledInstance(130, 40, Image.SCALE_SMOOTH));
		ingresar = new Boton();
		ingresar.setBounds(55, 250, 130, 40);
		ingresar.setBorderPainted(false);
		ingresar.setContentAreaFilled(false);
		ingresar.setFocusPainted(false);
		ingresar.setIcon(imagenBotonRecurso1);
		ingresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ingresar.setActionCommand("ENTRARADMIN");
		ingresar.setVisible(true);
		add(ingresar);

		imagenBoton2 = new ImageIcon("recursos/botonRegresar.png");
		imagenBotonRecurso2 = new ImageIcon(imagenBoton2.getImage().getScaledInstance(130, 40, Image.SCALE_SMOOTH));
		salir = new Boton();
		salir.setBounds(250, 250, 130, 40);
		salir.setBorderPainted(false);
		salir.setContentAreaFilled(false);
		salir.setFocusPainted(false);
		salir.setIcon(imagenBotonRecurso2);
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		salir.setActionCommand("VOLVERADMIN");
		salir.setVisible(true);
		add(salir);

		fondo = new ImageIcon(getClass().getResource("/imagenes/sesionadmin.jpg"));
		recursoFondo = new ImageIcon(fondo.getImage().getScaledInstance(460, 400, Image.SCALE_SMOOTH));
		imagenFondo = new JLabel(recursoFondo);
		imagenFondo.setSize(460, 400);
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
	 * @return the imagen1
	 */
	public ImageIcon getImagen1() {
		return imagen1;
	}

	/**
	 * @param imagen1 the imagen1 to set
	 */
	public void setImagen1(ImageIcon imagen1) {
		this.imagen1 = imagen1;
	}

	/**
	 * @return the imagenRecurso1
	 */
	public ImageIcon getImagenRecurso1() {
		return imagenRecurso1;
	}

	/**
	 * @param imagenRecurso1 the imagenRecurso1 to set
	 */
	public void setImagenRecurso1(ImageIcon imagenRecurso1) {
		this.imagenRecurso1 = imagenRecurso1;
	}

	/**
	 * @return the imagen2
	 */
	public ImageIcon getImagen2() {
		return imagen2;
	}

	/**
	 * @param imagen2 the imagen2 to set
	 */
	public void setImagen2(ImageIcon imagen2) {
		this.imagen2 = imagen2;
	}

	/**
	 * @return the imagenRecurso2
	 */
	public ImageIcon getImagenRecurso2() {
		return imagenRecurso2;
	}

	/**
	 * @param imagenRecurso2 the imagenRecurso2 to set
	 */
	public void setImagenRecurso2(ImageIcon imagenRecurso2) {
		this.imagenRecurso2 = imagenRecurso2;
	}

	/**
	 * @return the imagen3
	 */
	public ImageIcon getImagen3() {
		return imagen3;
	}

	/**
	 * @param imagen3 the imagen3 to set
	 */
	public void setImagen3(ImageIcon imagen3) {
		this.imagen3 = imagen3;
	}

	/**
	 * @return the imagenRecurso3
	 */
	public ImageIcon getImagenRecurso3() {
		return imagenRecurso3;
	}

	/**
	 * @param imagenRecurso3 the imagenRecurso3 to set
	 */
	public void setImagenRecurso3(ImageIcon imagenRecurso3) {
		this.imagenRecurso3 = imagenRecurso3;
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
	 * @return the imagenBotonRecurso1
	 */
	public ImageIcon getImagenBotonRecurso1() {
		return imagenBotonRecurso1;
	}

	/**
	 * @param imagenBotonRecurso1 the imagenBotonRecurso1 to set
	 */
	public void setImagenBotonRecurso1(ImageIcon imagenBotonRecurso1) {
		this.imagenBotonRecurso1 = imagenBotonRecurso1;
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
	 * @return the imagenBotonRecurso2
	 */
	public ImageIcon getImagenBotonRecurso2() {
		return imagenBotonRecurso2;
	}

	/**
	 * @param imagenBotonRecurso2 the imagenBotonRecurso2 to set
	 */
	public void setImagenBotonRecurso2(ImageIcon imagenBotonRecurso2) {
		this.imagenBotonRecurso2 = imagenBotonRecurso2;
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
	 * @return the fuente3
	 */
	public Font getFuente3() {
		return fuente3;
	}

	/**
	 * @param fuente3 the fuente3 to set
	 */
	public void setFuente3(Font fuente3) {
		this.fuente3 = fuente3;
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
	 * @return the etiquetaImagen1
	 */
	public JLabel getEtiquetaImagen1() {
		return etiquetaImagen1;
	}

	/**
	 * @param etiquetaImagen1 the etiquetaImagen1 to set
	 */
	public void setEtiquetaImagen1(JLabel etiquetaImagen1) {
		this.etiquetaImagen1 = etiquetaImagen1;
	}

	/**
	 * @return the etiquetaImagen2
	 */
	public JLabel getEtiquetaImagen2() {
		return etiquetaImagen2;
	}

	/**
	 * @param etiquetaImagen2 the etiquetaImagen2 to set
	 */
	public void setEtiquetaImagen2(JLabel etiquetaImagen2) {
		this.etiquetaImagen2 = etiquetaImagen2;
	}

	/**
	 * @return the etiquetaImagen3
	 */
	public JLabel getEtiquetaImagen3() {
		return etiquetaImagen3;
	}

	/**
	 * @param etiquetaImagen3 the etiquetaImagen3 to set
	 */
	public void setEtiquetaImagen3(JLabel etiquetaImagen3) {
		this.etiquetaImagen3 = etiquetaImagen3;
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
	 * @return the contraseña
	 */
	public JLabel getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(JLabel contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * @return the campoUsuario
	 */
	public JTextField getCampoUsuario() {
		return campoUsuario;
	}

	/**
	 * @param campoUsuario the campoUsuario to set
	 */
	public void setCampoUsuario(JTextField campoUsuario) {
		this.campoUsuario = campoUsuario;
	}

	/**
	 * @return the campoContraseña
	 */
	public JTextField getCampoContraseña() {
		return campoContraseña;
	}

	/**
	 * @param campoContraseña the campoContraseña to set
	 */
	public void setCampoContraseña(JTextField campoContraseña) {
		this.campoContraseña = campoContraseña;
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
	 * @return the salir
	 */
	public Boton getSalir() {
		return salir;
	}

	/**
	 * @param salir the salir to set
	 */
	public void setSalir(Boton salir) {
		this.salir = salir;
	}
	//
}