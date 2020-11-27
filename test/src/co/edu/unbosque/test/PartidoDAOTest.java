package co.edu.unbosque.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Partido;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.PartidoDAO;
import junit.framework.TestCase;

public class PartidoDAOTest extends TestCase {

	PartidoDAO partidoDAO;
	Partido partido1, partido2, partido3, partido4;
	File file = new File("datos\\apuestas-marcadoresTest.dat");
	ArrayList<Partido> alPartido;
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
		partidoDAO = new PartidoDAO(archivo);
		alPartido = new ArrayList<Partido>();
		alPartido = archivo.leerArchivoPartido(file);
		fecha = new Date();

		partido1 = new Partido("Usaquen", "321321321", fecha, "500000", "GANA UNA VEZ 15%", "Local", "Celtic",
				"Liverpool");
		partido2 = new Partido("Fontibon", "111222333", fecha, "10000000", "GANA DOS VECES 20%", "Visitante",
				"Mönchengladbach", "Porto");
		partido3 = new Partido("Kennedy", "100234234", fecha, "50000000", "GANA TODAS 70%", "Empate", "Chelsea",
				"Ararat-Armenia");
		partido4 = new Partido("Suba", "1000519146", fecha, "10000", "GANA DOS VECES 20%", "Visitante", "Celtic",
				"Atalanta");
		alPartido.add(partido1);
		alPartido.add(partido3);
		verificarInvariante();
	}

	public void testApostadorPartido() {
		setupEscenario();
		assertEquals("La cantidad de apuestas del partido debe ser de 2", 2, alPartido.size());
	}

	public void testBuscarPartido() {
		setupEscenario();
		assertNull("El partido no se encuentra", partidoDAO.buscarPartido(partido4.getCedula(), alPartido));
		assertNotNull("El partido si se encuentra", partidoDAO.buscarPartido(partido1.getCedula(), alPartido));
	}

	public void testAgregarPartido() {
		setupEscenario();

		partidoDAO.agregarPartido(partido2.getSede(), partido2.getCedula(), partido2.getFecha(),
				partido2.getValorApuesta(), partido2.getPremio(), partido2.getResultado(), partido2.getEquipoLocal(),
				partido2.getEquipoVisitante(), alPartido, file);

		assertNotSame("No se puede registrar el partido", 2, alPartido.size());

		assertEquals("El partido se ha registrado", 3, alPartido.size());

	}

	public void testEliminarPartido() {
		setupEscenario();
		assertFalse("El partido no se encuentra registrado",
				partidoDAO.eliminarPartido(partido4.getCedula(), alPartido, file));
		assertTrue("El partido se ha eliminado", partidoDAO.eliminarPartido(partido3.getCedula(), alPartido, file));
	}

	public void testEditarPartido() {

		setupEscenario();
		assertFalse("El partido no se encuentra registrado",
				partidoDAO.editarPartido("Usaquen", partido4.getCedula(), partido4.getFecha(), "20000",
						partido4.getPremio(), "Local", "Manchester United", "Inter de Milan", alPartido, file));
		assertTrue("El partido se encuentra ha editado",
				partidoDAO.editarPartido("Kennedy", partido3.getCedula(), partido3.getFecha(), "400000",
						partido3.getPremio(), "Visitante", "Juventus", "Porto", alPartido, file));
	}

	public void testMostrarPartido() {
		setupEscenario();
		String esperado = partidoDAO.verPartidoTotal(alPartido);
		assertEquals("Se muestra la información del Partido", esperado, partidoDAO.verPartidoTotal(alPartido));
		assertNotSame("No se muestra la información del Partido", esperado, "");
	}

	public void testVerPartidoUltimo() {

		setupEscenario();
		setupEscenario();
		String esperado = partidoDAO.verPartidoUltimo(alPartido, alPartido.size());
		assertEquals("Se muestra la factura", esperado, partidoDAO.verPartidoUltimo(alPartido, alPartido.size()));
		assertNotSame("No se muestra la factura", esperado, "");

	}

	public void testMostrarPartidoBusqueda() {
		setupEscenario();
		assertEquals("Se muestra la información del partido", partidoDAO.verPartido(alPartido, partido1.getCedula()),
				partidoDAO.verPartido(alPartido, partido1.getCedula()));
		assertNotSame("No se muestra la información del partido", "",
				partidoDAO.verPartido(alPartido, partido1.getCedula()));
	}

}
