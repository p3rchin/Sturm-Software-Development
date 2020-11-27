package co.edu.unbosque.test;

import co.edu.unbosque.model.ExcepcionApuesta;
import co.edu.unbosque.model.SuperAstro;
import junit.framework.TestCase;

public class SuperAstroTest extends TestCase {
	SuperAstro superA = new SuperAstro();
	SuperAstro superA1;

	private void setupEscenario() {
		superA1 = new SuperAstro();
	}

	public void testExcepcionNumeros() throws ExcepcionApuesta {
		setupEscenario();
		assertFalse("Se ingreso correctamente la cedula", superA1.excepcionNumero("6"));
	}

	public void testExcepcionApuesta() throws ExcepcionApuesta {
		setupEscenario();
		assertFalse("Se ingreso correctamente la apuesta", superA1.excepcionNumero("2"));
	}

	public void testAleatorio() {
		setupEscenario();
		assertTrue("El numero generado cumple con los requisitos", superA1.calcularAleatorio().contains("-"));
	}
}
