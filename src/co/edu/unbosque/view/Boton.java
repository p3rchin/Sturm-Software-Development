/*
 * Paquete donde está contenida la clase.
 */
package co.edu.unbosque.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * Clase Boton.
 * 
 * Clase que da diferentes efectos a los botones que se tienen en la vista.
 * 
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
 *
 */
public class Boton extends JButton {
	/*
	 * opacity es de tipo float.
	 */
	float opacity = 0.9f;

	/**
	 * Constructor específico de la clase Boton donde tiene un parámetro tipo String
	 * y contiene un método. <b>pre</b> Se debe ingresar el parámetro de tipo
	 * String.<br>
	 * <b>post</b> Se le agrega un escuchador al botón al momento de pasar sobre
	 * él.<br>
	 * 
	 * @param text de tipo String: text debe ser != de null y != de " ".
	 */
	public Boton(String text) {
		super(text);
		addMouseListener(new EventButton());
	}

	/**
	 * Constructor específico de la clase Boton donde contiene un método para la
	 * escucha del mouse. <b>pre</b> Se debe agregar el método dentro del
	 * constructor para su funcionamiento.<br>
	 * <b>post</b> Se le agrega un escuchador al botón.<br>
	 */
	public Boton() {
		super();
		addMouseListener(new EventButton());
	}

	/**
	 * @return the opacity
	 */
	public float getOpacity() {
		return opacity;
	}

	/**
	 * @param opacity the opacity to set
	 */
	public void setOpacity(float opacity) {
		this.opacity = opacity;
		repaint();
	}

	/**
	 * Método que recibe un parámetro de tipo Graphics. Este le da las gráficas
	 * necesarias a los botones para que se pueda ver su opacidad. <b>pre</b> Se le
	 * tiene que mandar el parámetro para que funcione su opacidad<br>
	 * <b>post</b> Se le agrega la opacidad.<br>
	 * 
	 * @param g es de tipo Graphics.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
		super.paintComponent(g2);
	}

	/**
	 * Clase EventButton que extiende de MouseAdapter para completar las acciones
	 * que se le agregan al botón
	 * 
	 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Patiño, Fabián Camilo Gómez
	 *         Céspedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodríguez.
	 *
	 */
	public class EventButton extends MouseAdapter {
		/**
		 * Método que recibe un parámetro para ver si el mouse ha salido del botón y
		 * volverlo opaco. <b>pre</b> Se debe agregar el método la variable me para su
		 * funcionamiento.<br>
		 * <b>post</b> Se le agrega el efecto de opacidad al momento de salir del
		 * botón.<br>
		 */
		@Override
		public void mouseExited(MouseEvent me) {
			efectHover(1f, 0.5f, 0.03f, 10, false);
		}

		/**
		 * Método que recibe un parámetro para ver si el mouse ha entrado al botón y
		 * volverlo claro. <b>pre</b> Se debe agregar el método la variable me para su
		 * funcionamiento.<br>
		 * <b>post</b> Se le agrega el efecto de claridad al momento de salir del
		 * botón.<br>
		 */
		@Override
		public void mouseEntered(MouseEvent me) {
			efectHover(0.5f, 1f, 0.03f, 10, true);
		}

		/**
		 * Método que recibe un parámetro para ver si el mouse ha seleccionado el botón
		 * y darle la animación. <b>pre</b> Se debe agregar el método la variable me
		 * para su funcionamiento.<br>
		 * <b>post</b> Se le agrega el efecto al momento de ser seleccionado del
		 * botón.<br>
		 */
		@Override
		public void mousePressed(MouseEvent me) {
			efectHover(1f, 0.6f, 0.1f, 1, false);
		}

		/**
		 * Método para verificar los parámetros que se le están ingresando y que puedan
		 * cumplir con los métodos antereiores. <b>pre</b> Se le deben ingresar los
		 * parámetros para que el método realice las acciones<br>
		 * <b>post</b> Se le aplica la animación que necesite el botón.<br>
		 * 
		 * @param index es de tipo float: index es 0 <= i.
		 * @param range es de tipo float: range es 0 <= i.
		 * @param cont  es de tipo float: cont es 0 <= i.
		 * @param sleep es de tipo int: debe ser != 0.
		 * @param event es de tipo boolean: puede tener los valores de verdadero o
		 *              falso.
		 */
		private void efectHover(float index, float range, float cont, int sleep, boolean event) {
			new Thread(() -> {
				for (float i = index; (event) ? i <= range : i >= range; i = (event) ? i + cont : i - cont) {
					setOpacity(i);
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
					}

				}
			}).start();
		}
	}

}