package co.edu.unbosque.test;

import java.util.Date;

import co.edu.unbosque.model.Apostador;
import co.edu.unbosque.model.ExcepcionNombre;
import co.edu.unbosque.model.ExcepcionNumero;
import junit.framework.TestCase;

public class ApostadorTest extends TestCase {
	Apostador apostador = new Apostador();
	Apostador apostador1, apostador2;
	Date fecha = new Date();

	private void setupEscenario() {
		apostador1 = new Apostador("Af3do", "cedula", "Usaquen", "Av. Siempre Viva 123", "3019876542", 8374392, fecha);
		apostador2 = new Apostador("Pepe", "11923002", "Usaquen", "Av.Colorado123", "3043023054", 7473294, fecha);
	}

	public void testSoloNumeros() {
		setupEscenario();
		assertFalse("Se ingreso un caracter diferente a un digito o se ingreso un número negativo",
				apostador.soloNumeros(apostador1.getCedula()));
		assertTrue("Se ingreso correctamente el número", apostador.soloNumeros(apostador2.getCelular()));
	}

	public void testSoloLetras() {
		setupEscenario();
		assertFalse("Se ingreso un número", apostador.soloLetras(apostador1.getNombre()));
		assertTrue("Se ingresaron correctamente las letras", apostador.soloLetras(apostador2.getNombre()));
	}

	public void testExcepcionNombre() throws ExcepcionNombre {
		setupEscenario();
		assertFalse("Se ingreso correctamente el nombre", apostador.excepcionNombre(apostador2.getNombre()));
	}

	public void testExcepcionCedula() throws ExcepcionNumero {
		setupEscenario();
		assertTrue("Se ingreso correctamente la cedula", apostador.excepcionCedula(apostador2.getCedula()));
	}

	public void testExcepcionCelular() throws ExcepcionNumero {
		setupEscenario();
		assertTrue("Se ingreso correctamente la cedula", apostador.excepcionCedula(apostador2.getCelular()));
	}
}
