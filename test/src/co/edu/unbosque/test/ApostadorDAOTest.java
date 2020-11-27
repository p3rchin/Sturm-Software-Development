package co.edu.unbosque.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Apostador;
import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.Archivo;
import junit.framework.TestCase;

public class ApostadorDAOTest extends TestCase {

	ApostadorDAO apostadorDAO;
	Apostador apostador1, apostador2, apostador3, apostador4;
	File file = new File("datos\\apostadoresTest.dat");
	ArrayList<Apostador> alApostadores;
	Archivo archivo;
	Date fecha = new Date();

	private void verificarInvariante() {
		assert file != null : "El archivo no puede ser igual a null";
	}

	private void setupEscenario() {
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		archivo = new Archivo();
		apostadorDAO = new ApostadorDAO(archivo);
		alApostadores = new ArrayList<Apostador>();
		apostador1 = new Apostador("Afedo", "321321321", "Usaquen", "Av. Siempre Viva 123", "301987654", 2847382,
				fecha);
		apostador2 = new Apostador("Fedoa", "111222333", "Usaquen", "Av. wakala", "981761541", 84732, fecha);
		apostador3 = new Apostador("Rodrigo", "100234234", "Usaquen", "Av. Massa", "301302305", 3846729, fecha);
		alApostadores.add(apostador1);
		alApostadores.add(apostador3);
		verificarInvariante();
	}

	public void testApostadorDAO() {
		setupEscenario();
		assertEquals("La cantidad de apostadores debe ser de 2", 2, alApostadores.size());
	}

	public void testBuscarApostador() {
		setupEscenario();
		assertNull("El Apostador no se encuentra", apostadorDAO.buscarApostador(apostador2.getCedula(), alApostadores));
		assertNotNull("El Apostador si se encuentra",
				apostadorDAO.buscarApostador(apostador1.getCedula(), alApostadores));
	}

	public void testAgregarApostador() {
		setupEscenario();
		assertFalse("No se puede registrar un apostador con la misma cedula",
				apostadorDAO.agregarApostador(apostador1.getNombre(), apostador1.getCedula(), apostador1.getSede(),
						apostador1.getDireccion(), apostador1.getCelular(), apostador1.getGanancias(), fecha,
						alApostadores, file));
		assertTrue("El Apostador se ha registrado",
				apostadorDAO.agregarApostador(apostador2.getNombre(), apostador2.getCedula(), apostador2.getSede(),
						apostador2.getDireccion(), apostador2.getCelular(), apostador2.getGanancias(), fecha,
						alApostadores, file));
	}

	public void testEliminarApostador() {
		setupEscenario();
		assertFalse("El apostador no se encuentra registrado",
				apostadorDAO.eliminarApostador(apostador2.getCedula(), alApostadores, file));
		assertTrue("El apostador se ha eliminado",
				apostadorDAO.eliminarApostador(apostador3.getCedula(), alApostadores, file));
	}

	public void testEditarApostador() {

		setupEscenario();
		assertFalse("El apostador no se encuentra registrado", apostadorDAO.editarApostador("Andres",
				apostador2.getCedula(), "Keneddy", "Carrera 6 N° 17-90", "3103205668", alApostadores, file));
		assertTrue("El apostador se ha editado", apostadorDAO.editarApostador("Andres", apostador3.getCedula(),
				"Keneddy", "Carrera 6 N° 17-90", "3103205668", alApostadores, file));
	}

	public void testMostrarApostador() {
		setupEscenario();
		String esperado = apostadorDAO.verApostadorTotal(alApostadores);
		assertEquals("Se muestra la información de los apostadores", esperado,
				apostadorDAO.verApostadorTotal(alApostadores));
		assertNotSame("No se muestra la información de los apostadores", esperado, "");
	}

	public void testMostrarApostadorBusqueda() {
		setupEscenario();
		assertEquals("Se muestra la información de el apostador",
				apostadorDAO.verApostador(alApostadores, apostador1.getCedula()),
				apostadorDAO.verApostador(alApostadores, apostador1.getCedula()));
		assertEquals("No se ha encontrado el apostador", "",
				apostadorDAO.verApostador(alApostadores, apostador2.getCedula()));
	}

}
