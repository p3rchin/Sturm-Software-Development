package co.edu.unbosque.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Partido;
import co.edu.unbosque.model.Sede;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.PartidoDAO;
import co.edu.unbosque.model.persistence.SedeDAO;
import junit.framework.TestCase;

public class SedeDAOTest extends TestCase {

	SedeDAO sedeDAO;
	Sede sede1, sede2, sede3, sede4;
	File file = new File("datos\\sedesTest.dat");
	ArrayList<Sede> alSede;
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
		sedeDAO = new SedeDAO(archivo);
		alSede = new ArrayList<Sede>();
		alSede = archivo.leerArchivoSede(file);
		;

		sede1 = new Sede("Usaquen", "7");
		sede2 = new Sede("Fontibon", "10");
		sede3 = new Sede("Kennedy", "15");
		sede4 = new Sede("Usaquen", "20");

		alSede.add(sede1);
		alSede.add(sede3);
		verificarInvariante();
	}

	public void testSede() {
		setupEscenario();
		assertEquals("La cantidad de sedes debe ser de 2", 2, alSede.size());
	}

	public void testBuscarSede() {
		setupEscenario();
		assertNull("La sede no se encuentra", sedeDAO.buscarSede(sede2.getUbicacion(), alSede));
		assertNotNull("La sede si se encuentra", sedeDAO.buscarSede(sede3.getUbicacion(), alSede));
	}

	public void testAgregarSede() {
		setupEscenario();
		assertFalse("Ya existe la sede",
				sedeDAO.agregarSede(sede1.getUbicacion(), sede1.getnEmpleados(), alSede, file));
		assertTrue("La sede se ha registrado",
				sedeDAO.agregarSede(sede2.getUbicacion(), sede2.getnEmpleados(), alSede, file));
	}

	public void testEliminarSede() {
		setupEscenario();
		assertFalse("La sede no se encuentra registrado", sedeDAO.eliminarSede(sede2.getUbicacion(), alSede, file));
		assertTrue("La sede se ha eliminado", sedeDAO.eliminarSede(sede3.getUbicacion(), alSede, file));
	}

	public void testEditarSede() {

		setupEscenario();
		assertFalse("La sede no se encuentra registrado",
				sedeDAO.editarSede(sede2.getUbicacion(), "Suba", "1", alSede, file));
		assertTrue("La sede se ha editado", sedeDAO.editarSede(sede1.getUbicacion(), "Suba", "55", alSede, file));
	}

	public void testMostrarSede() {
		setupEscenario();
		String esperado = sedeDAO.verSedeTotal(alSede);
		assertEquals("Se muestra la información de las sedes", esperado, sedeDAO.verSedeTotal(alSede));
		assertNotSame("No se muestra la información de las sedes", esperado, "");
	}

	public void testMostrarSedeBusqueda() {
		setupEscenario();
		assertEquals("Se muestra la información de el apostador", sedeDAO.verSede(alSede, sede3.getUbicacion()),
				sedeDAO.verSede(alSede, sede3.getUbicacion()));
		assertNotSame("No se ha encontrado el apostador", "", sedeDAO.verSede(alSede, sede3.getUbicacion()));
	}

}
