package co.edu.unbosque.test;

import co.edu.unbosque.model.Baloto;
import co.edu.unbosque.model.ExcepcionApuesta;
import junit.framework.TestCase;

public class BalotoTest extends TestCase {

	Baloto baloto = new Baloto();
	Baloto baloto1;

	private void setupEscenario() {
		baloto1 = new Baloto();
	}

	public void testExcepcionNumeros() throws ExcepcionApuesta {
		setupEscenario();
		assertFalse("Se ingreso correctamente la cedula", baloto1.excepcionNumero("12"));
	}

	public void testExcepcionApuesta() throws ExcepcionApuesta {
		setupEscenario();
		assertFalse("Se ingreso correctamente la apuesta", baloto1.excepcionNumero("6"));
	}

	public void testAleatorio() {
		setupEscenario();
		assertTrue("El numero generado cumple con los requisitos", baloto1.calcularAleatorio().contains("-"));
	}

}
