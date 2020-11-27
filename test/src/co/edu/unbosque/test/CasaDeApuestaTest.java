package co.edu.unbosque.test;

import co.edu.unbosque.model.CasaDeApuesta;
import co.edu.unbosque.model.ExcepcionNumero;
import junit.framework.TestCase;

public class CasaDeApuestaTest extends TestCase {

	CasaDeApuesta casa = new CasaDeApuesta();
	CasaDeApuesta casa1, casa2;

	private void setupEscenario() {
		casa1 = new CasaDeApuesta("1", "1", "10000");
		casa2 = new CasaDeApuesta("Normandia", "1", "milMillones");
	}

	
	//-------------------------------------------------------
	public void testSoloNumeros() {
		setupEscenario();
		assertTrue("Se ingreso un caracter correcto ", casa1.soloNumeros(casa1.getNumeroSedes()));
		assertFalse("Se ingreso un caracter diferente a un digito o se ingreso un número negativo",
				casa1.soloNumeros(casa2.getPresupuesto()));
	}

	public void testExcepcionSede() throws ExcepcionNumero {
		setupEscenario();
		assertTrue("Se ingreso correctamente el numero de la sede", casa.excepcionSede(casa1.getNumeroSedes()));
	}

	public void testExcepcionPresupuesto() throws ExcepcionNumero {
		setupEscenario();
		assertTrue("Se ingreso correctamente el presupuesto", casa.excepcionPresupuesto(casa1.getPresupuesto()));
	}

}
