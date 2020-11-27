package co.edu.unbosque.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Juego;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.JuegoDAO;
import junit.framework.TestCase;

public class JuegoDAOTest extends TestCase {

	JuegoDAO juegoDAO;
	Juego juego1, juego2, juego3, juego4;
	File file = new File("datos\\juegosTest.dat");
	ArrayList<Juego> alJuego;
	Archivo archivo;

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
		juegoDAO = new JuegoDAO(archivo);
		alJuego = new ArrayList<Juego>();
		alJuego = archivo.leerArchivoJuego(file);

		juego1 = new Juego("Superastro", "chance", 0);
		juego2 = new Juego("Baloto", "loteria", 0);
		juego3 = new Juego("Bet-Hat-Trick", "deportivo", 0);
		alJuego.add(juego1);
		alJuego.add(juego3);
		verificarInvariante();
	}

	public void testApostadorJuego() {
		setupEscenario();
		assertEquals("La cantidad de juegos debe ser de 2", 2, alJuego.size());
	}

	public void testBuscarBaloto() {
		setupEscenario();
		assertNull("El juego no se encuentra", juegoDAO.buscarJuego(juego2.getNombreJuego(), alJuego));
		assertNotNull("El juego si se encuentra", juegoDAO.buscarJuego(juego1.getNombreJuego(), alJuego));
	}

	public void testAgregarBaloto() {
		setupEscenario();

		juegoDAO.agregarJuego(file);

		assertNotSame("No se puede registrar el juego", 3, alJuego.size());

		assertEquals("El juego se ha registrado", 2, alJuego.size());
	}

	public void testEditarBaloto() {

		setupEscenario();
		assertFalse("El juego no se encuentra registrado",
				juegoDAO.editarJuego(juego2.getNombreJuego(), 800000000, alJuego, file));
		assertTrue("El juego se ha editado", juegoDAO.editarJuego(juego3.getNombreJuego(), 800000000, alJuego, file));
	}

	public void testMostrarBaloto() {
		setupEscenario();
		String esperado = juegoDAO.verJuegoTotal(alJuego);
		assertEquals("Se muestra la información del juego", esperado, juegoDAO.verJuegoTotal(alJuego));
		assertNotSame("No se muestra la información del juego", esperado, "");
	}

	public void testMostrarApostadorBusqueda() {
		setupEscenario();
		assertEquals("Se muestra la información de el apostador", juegoDAO.verJuego(alJuego, juego1.getNombreJuego()),
				juegoDAO.verJuego(alJuego, juego1.getNombreJuego()));
		assertNotSame("No se muestra la información de el apostador", "",
				juegoDAO.verJuego(alJuego, juego1.getNombreJuego()));
	}

}
