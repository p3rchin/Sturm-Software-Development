/*
 * Paquete donde est� contenida la clase.
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
 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
 *
 */
public class Boton extends JButton {
	/*
	 * opacity es de tipo float.
	 */
	float opacity = 0.9f;

	/**
	 * Constructor espec�fico de la clase Boton donde tiene un par�metro tipo String
	 * y contiene un m�todo. <b>pre</b> Se debe ingresar el par�metro de tipo
	 * String.<br>
	 * <b>post</b> Se le agrega un escuchador al bot�n al momento de pasar sobre
	 * �l.<br>
	 * 
	 * @param text de tipo String: text debe ser != de null y != de " ".
	 */
	public Boton(String text) {
		super(text);
		addMouseListener(new EventButton());
	}

	/**
	 * Constructor espec�fico de la clase Boton donde contiene un m�todo para la
	 * escucha del mouse. <b>pre</b> Se debe agregar el m�todo dentro del
	 * constructor para su funcionamiento.<br>
	 * <b>post</b> Se le agrega un escuchador al bot�n.<br>
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
	 * M�todo que recibe un par�metro de tipo Graphics. Este le da las gr�ficas
	 * necesarias a los botones para que se pueda ver su opacidad. <b>pre</b> Se le
	 * tiene que mandar el par�metro para que funcione su opacidad<br>
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
	 * que se le agregan al bot�n
	 * 
	 * @author Grupo de trabajo: Jhoan Ricardo Cuevas Pati�o, Fabi�n Camilo G�mez
	 *         C�spedes, Omar Felipe Ladino Guezguan y Juan Felipe Rojas Rodr�guez.
	 *
	 */
	public class EventButton extends MouseAdapter {
		/**
		 * M�todo que recibe un par�metro para ver si el mouse ha salido del bot�n y
		 * volverlo opaco. <b>pre</b> Se debe agregar el m�todo la variable me para su
		 * funcionamiento.<br>
		 * <b>post</b> Se le agrega el efecto de opacidad al momento de salir del
		 * bot�n.<br>
		 */
		@Override
		public void mouseExited(MouseEvent me) {
			efectHover(1f, 0.5f, 0.03f, 10, false);
		}

		/**
		 * M�todo que recibe un par�metro para ver si el mouse ha entrado al bot�n y
		 * volverlo claro. <b>pre</b> Se debe agregar el m�todo la variable me para su
		 * funcionamiento.<br>
		 * <b>post</b> Se le agrega el efecto de claridad al momento de salir del
		 * bot�n.<br>
		 */
		@Override
		public void mouseEntered(MouseEvent me) {
			efectHover(0.5f, 1f, 0.03f, 10, true);
		}

		/**
		 * M�todo que recibe un par�metro para ver si el mouse ha seleccionado el bot�n
		 * y darle la animaci�n. <b>pre</b> Se debe agregar el m�todo la variable me
		 * para su funcionamiento.<br>
		 * <b>post</b> Se le agrega el efecto al momento de ser seleccionado del
		 * bot�n.<br>
		 */
		@Override
		public void mousePressed(MouseEvent me) {
			efectHover(1f, 0.6f, 0.1f, 1, false);
		}

		/**
		 * M�todo para verificar los par�metros que se le est�n ingresando y que puedan
		 * cumplir con los m�todos antereiores. <b>pre</b> Se le deben ingresar los
		 * par�metros para que el m�todo realice las acciones<br>
		 * <b>post</b> Se le aplica la animaci�n que necesite el bot�n.<br>
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