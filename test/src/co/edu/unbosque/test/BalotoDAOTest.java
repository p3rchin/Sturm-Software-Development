package co.edu.unbosque.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Baloto;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.BalotoDAO;
import junit.framework.TestCase;

public class BalotoDAOTest extends TestCase {

	BalotoDAO balotoDAO;
	Baloto baloto1, baloto2, baloto3, baloto4;
	File file = new File("datos\\apuestas-balotoTest.dat");
	ArrayList<Baloto> alBaloto;
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
		balotoDAO = new BalotoDAO(archivo);
		alBaloto = new ArrayList<Baloto>();
		alBaloto = archivo.leerArchivoBaloto(file);
		fecha = new Date();

		baloto1 = new Baloto("Usaquen", "321321321", fecha, "500000", "GANA UNA VEZ 15%", "12-23-42-23");
		baloto2 = new Baloto("Fontibon", "111222333", fecha, "10000000", "GANA DOS VECES 20%", "4-6-34-16");
		baloto3 = new Baloto("Kennedy", "100234234", fecha, "50000000", "GANA TODAS 70%", "8-3-2-38");
		baloto4 = new Baloto("Suba", "1000519146", fecha, "10000", "GANA DOS VECES 20%", "16-43-23-8");
		alBaloto.add(baloto1);
		alBaloto.add(baloto3);
		verificarInvariante();
	}

	public void testApostadorBaloto() {
		setupEscenario();
		assertEquals("La cantidad de apuestas de baloto debe ser de 2", 2, alBaloto.size());
	}

	public void testBuscarBaloto() {
		setupEscenario();
		assertNull("El baloto no se encuentra", balotoDAO.buscarBaloto(baloto4.getCedula(), alBaloto));
		assertNotNull("El baloto si se encuentra", balotoDAO.buscarBaloto(baloto1.getCedula(), alBaloto));
	}

	public void testAgregarBaloto() {
		setupEscenario();

		balotoDAO.agregarBaloto(baloto2.getSede(), baloto2.getCedula(), baloto2.getFecha(), baloto2.getValorApuesta(),
				baloto2.getPremio(), baloto2.getNumero(), alBaloto, file);

		assertNotSame("No se puede registrar el baloto", 2, alBaloto.size());

		assertEquals("El baloto se ha registrado", 3, alBaloto.size());

	}

	public void testEliminarBaloto() {
		setupEscenario();
		assertFalse("El baloto no se encuentra registrado",
				balotoDAO.eliminarBaloto(baloto4.getCedula(), alBaloto, file));
		assertTrue("El baloto se ha eliminado", balotoDAO.eliminarBaloto(baloto3.getCedula(), alBaloto, file));
	}

	public void testEditarBaloto() {

		setupEscenario();
		assertFalse("El baloto no se encuentra registrado", balotoDAO.editarBaloto("Usaquen", baloto4.getCedula(),
				baloto4.getFecha(), "20000", baloto4.getPremio(), "31-42-58-90-00", alBaloto, file));
		assertTrue("El baloto no se ha editado", balotoDAO.editarBaloto("Usaquen", baloto3.getCedula(),
				baloto3.getFecha(), "20000", baloto3.getPremio(), "34-25-90-00", alBaloto, file));
	}

	public void testMostrarBaloto() {
		setupEscenario();
		String esperado = balotoDAO.verBalotoTotal(alBaloto);
		assertEquals("Se muestra la información del Baloto", esperado, balotoDAO.verBalotoTotal(alBaloto));
		assertNotSame("No se muestra la información del Baloto", esperado, "");
	}

	public void testVerBalotoUltimo() {

		setupEscenario();
		setupEscenario();
		String esperado = balotoDAO.verBalotoUltimo(alBaloto, alBaloto.size());
		assertEquals("Se muestra la factura", esperado, balotoDAO.verBalotoUltimo(alBaloto, alBaloto.size()));
		assertNotSame("No se muestra la factura", esperado, "");

	}

	public void testMostrarBalotoBusqueda() {
		setupEscenario();
		assertEquals("Se muestra la información del baloto", balotoDAO.verBaloto(alBaloto, baloto1.getCedula()),
				balotoDAO.verBaloto(alBaloto, baloto1.getCedula()));
		assertNotSame("No se muestra la información del baloto", "",
				balotoDAO.verBaloto(alBaloto, baloto1.getCedula()));
	}

}
