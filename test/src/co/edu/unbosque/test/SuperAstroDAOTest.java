package co.edu.unbosque.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Partido;
import co.edu.unbosque.model.SuperAstro;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.PartidoDAO;
import co.edu.unbosque.model.persistence.SuperAstroDAO;
import junit.framework.TestCase;

public class SuperAstroDAOTest extends TestCase {

	SuperAstroDAO superAstroDAO;
	SuperAstro superAstro1, superAstro2, superAstro3, superAstro4;
	File file = new File("datos\\apuestas-superastroTest.dat");
	ArrayList<SuperAstro> alSuperAstro;
	Archivo archivo;
	Date fecha;

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
		superAstroDAO = new SuperAstroDAO(archivo);
		alSuperAstro = new ArrayList<SuperAstro>();
		alSuperAstro = archivo.leerArchivoSuperAstro(file);
		fecha = new Date();

		superAstro1 = new SuperAstro("Usaquen", "321321321", fecha, "500000", "GANA UNA VEZ 15%", "12-23-42-23",
				"Picis");
		superAstro2 = new SuperAstro("Fontibon", "111222333", fecha, "10000000", "GANA DOS VECES 20%", "4-6-34-16",
				"Cancer");
		superAstro3 = new SuperAstro("Kennedy", "100234234", fecha, "50000000", "GANA TODAS 70%", "8-3-2-38",
				"Acuario");
		superAstro4 = new SuperAstro("Suba", "1000519146", fecha, "10000", "GANA DOS VECES 20%", "16-43-23-8",
				"Capricornio");

		alSuperAstro.add(superAstro1);
		alSuperAstro.add(superAstro3);
		verificarInvariante();
	}

	public void testSuperAstro() {
		setupEscenario();
		assertEquals("La cantidad de apuestas del superAstro debe ser de 2", 2, alSuperAstro.size());
	}

	public void testBuscarSuperAstro() {
		setupEscenario();
		assertNull("El superAstro no se encuentra",
				superAstroDAO.buscarSuperAstro(superAstro4.getCedula(), alSuperAstro));
		assertNotNull("El superAstro si se encuentra",
				superAstroDAO.buscarSuperAstro(superAstro1.getCedula(), alSuperAstro));
	}

	public void testAgregarSuperAstro() {
		setupEscenario();

		superAstroDAO.agregarSuperAstro(superAstro2.getSede(), superAstro2.getCedula(), superAstro2.getFecha(),
				superAstro2.getValorApuesta(), superAstro2.getPremio(), superAstro2.getNumero(),
				superAstro2.getZodiaco(), alSuperAstro, file);

		assertNotSame("No se puede registrar el superAstro", 2, alSuperAstro.size());

		assertEquals("El superAstro se ha registrado", 3, alSuperAstro.size());

	}

	public void testEliminarsuperAstro() {
		setupEscenario();
		assertFalse("El superAstro no se encuentra registrado",
				superAstroDAO.eliminarSuperAstro(superAstro4.getCedula(), alSuperAstro, file));
		assertTrue("El partido se ha eliminado",
				superAstroDAO.eliminarSuperAstro(superAstro3.getCedula(), alSuperAstro, file));
	}

	public void testEditarsuperAstro() {

		setupEscenario();
		assertFalse("El superAstro no se encuentra registrado",
				superAstroDAO.editarSuperAstro("Usaquen", superAstro4.getCedula(), superAstro4.getFecha(), "20000",
						superAstro4.getPremio(), "32-2-12-3", "Cancer", alSuperAstro, file));
		assertTrue("El superAstro se encuentra ha editado",
				superAstroDAO.editarSuperAstro("Usaquen", superAstro3.getCedula(), superAstro3.getFecha(), "20000",
						superAstro3.getPremio(), "32-2-12-3", "Cancer", alSuperAstro, file));
	}

	public void testMostrarSuperAstro() {
		setupEscenario();
		String esperado = superAstroDAO.verSuperAstroTotal(alSuperAstro);
		assertEquals("Se muestra la información del superAstro", esperado,
				superAstroDAO.verSuperAstroTotal(alSuperAstro));
		assertNotSame("No se muestra la información del superAstro", esperado, "");
	}

	public void testVersuperAstroUltimo() {

		setupEscenario();
		setupEscenario();
		String esperado = superAstroDAO.verSuperAstroUltimo(alSuperAstro, alSuperAstro.size());
		assertEquals("Se muestra la factura", esperado,
				superAstroDAO.verSuperAstroUltimo(alSuperAstro, alSuperAstro.size()));
		assertNotSame("No se muestra la factura", esperado, "");

	}

	public void testMostrarSuperAstroBusqueda() {
		setupEscenario();
		assertEquals("Se muestra la información del superAstro",
				superAstroDAO.verSuperAstro(alSuperAstro, superAstro1.getCedula()),
				superAstroDAO.verSuperAstro(alSuperAstro, superAstro1.getCedula()));
		assertNotSame("No se muestra la información del superAstro", "",
				superAstroDAO.verSuperAstro(alSuperAstro, superAstro1.getCedula()));
	}

}
