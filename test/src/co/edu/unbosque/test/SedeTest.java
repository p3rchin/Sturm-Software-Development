package co.edu.unbosque.test;

import co.edu.unbosque.model.ExcepcionNombre;
import co.edu.unbosque.model.ExcepcionNumero;
import co.edu.unbosque.model.Sede;
import junit.framework.TestCase;

public class SedeTest extends TestCase {
	Sede sede = new Sede();
	Sede sede1, sede2;

	private void setupEscenario() {
		sede1 = new Sede("Norte", "12");
		sede2 = new Sede("Sur45", "f12");
	}

	public void testSoloNumeros() {
		setupEscenario();
		assertFalse("Se ingreso un caracter diferente a un digito o se ingreso un número negativo",
				sede.soloNumeros(sede2.getnEmpleados()));
		assertTrue("Se ingreso correctamente el número", sede.soloNumeros(sede1.getnEmpleados()));
	}

	public void testSoloLetras() {
		setupEscenario();
		assertFalse("Se ingreso un número", sede.soloLetras(sede2.getUbicacion()));
		assertTrue("Se ingresaron correctamente las letras", sede.soloLetras(sede1.getUbicacion()));
	}

	public void testExcepcionUbicacion() throws ExcepcionNombre {
		setupEscenario();
		assertTrue("Se ingreso correctamente la ubicacion", sede.excepcionUbicacion(sede1.getUbicacion()));
	}

	public void testExcepcionEmpleados() throws ExcepcionNumero {
		setupEscenario();
		assertTrue("Se ingreso correctamente la cantidad de empleados", sede.excepcionEmpleado(sede1.getnEmpleados()));
	}

}
