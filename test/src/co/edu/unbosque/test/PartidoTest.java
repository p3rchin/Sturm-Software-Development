package co.edu.unbosque.test;

import co.edu.unbosque.model.ExcepcionApuesta;
import co.edu.unbosque.model.Partido;
import junit.framework.TestCase;

public class PartidoTest extends TestCase {
	Partido partido = new Partido();
	Partido partido1;

	private void setupEscenario() {
		partido1 = new Partido();
	}
	
	public void testExcepcionApuesta() throws ExcepcionApuesta {
		setupEscenario();
		assertFalse("Se ingreso correctamente la apuesta", partido1.excepcionApuesta("2000"));
	}

}
