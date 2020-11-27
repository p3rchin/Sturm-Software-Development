package co.edu.unbosque.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Baloto;
import co.edu.unbosque.model.Partido;
import co.edu.unbosque.model.SuperAstro;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.PremiosDAO;
import junit.framework.TestCase;

public class PremiosDAOTest extends TestCase {

	PremiosDAO premiosDAO;
	Baloto baloto1, baloto2, baloto3, baloto4;
	SuperAstro superAstro1, superAstro2, superAstro3, superAstro4;
	Partido partido1, partido2, partido3, partido4;
	File fileBaloto = new File("datos\\premio-balotoTest.dat");
	File fileSuperAstro = new File("datos\\premio-superastroTest.dat");
	File filePartido = new File("datos\\premio-partidoTest.dat");
	ArrayList<Baloto> alBaloto;
	ArrayList<SuperAstro> alSuperAstro;
	ArrayList<Partido> alPartido;
	Archivo archivo;
	Date fecha;

	private void verificarInvariante() {
		assert fileBaloto != null : "El archivo no puede ser igual a null";
		assert fileSuperAstro != null : "El archivo no puede ser igual a null";
		assert filePartido != null : "El archivo no puede ser igual a null";
	}

	private void setupEscenario() {
		fileBaloto.delete();
		fileSuperAstro.delete();
		filePartido.delete();
		try {
			fileBaloto.createNewFile();
			fileSuperAstro.createNewFile();
			filePartido.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		archivo = new Archivo();
		premiosDAO = new PremiosDAO(archivo);
		alBaloto = new ArrayList<Baloto>();
		alSuperAstro = new ArrayList<SuperAstro>();
		alPartido = new ArrayList<Partido>();
		alBaloto = archivo.leerArchivoBaloto(fileBaloto);
		alSuperAstro = archivo.leerArchivoSuperAstro(fileSuperAstro);
		alPartido = archivo.leerArchivoPartido(filePartido);
		fecha = new Date();

		baloto1 = new Baloto("Usaquen", "321321321", fecha, "500000", "GANA UNA VEZ 15%", "12-23-42-23");
		baloto2 = new Baloto("Fontibon", "111222333", fecha, "10000000", "GANA DOS VECES 20%", "4-6-34-16");
		baloto3 = new Baloto("Kennedy", "100234234", fecha, "50000000", "GANA TODAS 70%", "8-3-2-38");
		baloto4 = new Baloto("Suba", "1000519146", fecha, "10000", "GANA DOS VECES 20%", "16-43-23-8");

		superAstro1 = new SuperAstro("Usaquen", "321321321", fecha, "500000", "GANA UNA VEZ 15%", "12-23-42-23",
				"Picis");
		superAstro2 = new SuperAstro("Fontibon", "111222333", fecha, "10000000", "GANA DOS VECES 20%", "4-6-34-16",
				"Cancer");
		superAstro3 = new SuperAstro("Kennedy", "100234234", fecha, "50000000", "GANA TODAS 70%", "8-3-2-38",
				"Acuario");
		superAstro4 = new SuperAstro("Suba", "1000519146", fecha, "10000", "GANA DOS VECES 20%", "16-43-23-8",
				"Capricornio");

		partido1 = new Partido("Usaquen", "321321321", fecha, "500000", "GANA UNA VEZ 15%", "Local", "Celtic",
				"Liverpool");
		partido2 = new Partido("Fontibon", "111222333", fecha, "10000000", "GANA DOS VECES 20%", "Visitante",
				"Mönchengladbach", "Porto");
		partido3 = new Partido("Kennedy", "100234234", fecha, "50000000", "GANA TODAS 70%", "Empate", "Chelsea",
				"Ararat-Armenia");
		partido4 = new Partido("Suba", "1000519146", fecha, "10000", "GANA DOS VECES 20%", "Visitante", "Celtic",
				"Atalanta");

		alBaloto.add(baloto1);
		alBaloto.add(baloto3);

		alSuperAstro.add(superAstro1);
		alSuperAstro.add(superAstro3);

		alPartido.add(partido1);
		alPartido.add(partido3);

		verificarInvariante();
	}

	public void testApostadorBaloto() {
		setupEscenario();
		assertEquals("La cantidad de apuestas del baloto debe ser de 2", 2, alPartido.size());
		assertEquals("La cantidad de apuestas del super astro debe ser de 2", 2, alSuperAstro.size());
		assertEquals("La cantidad de apuestas del partido debe ser de 2", 2, alPartido.size());
	}

	public void testBuscarBaloto() {
		setupEscenario();
		assertNull("El Baloto no se encuentra", premiosDAO.buscarBaloto(partido4.getCedula(), alBaloto));
		assertNotNull("El Baloto si se encuentra", premiosDAO.buscarBaloto(partido1.getCedula(), alBaloto));
	}

	public void testBuscarSuperAstro() {
		setupEscenario();
		assertNull("El superAstro no se encuentra", premiosDAO.buscarSuperAstro(partido4.getCedula(), alSuperAstro));
		assertNotNull("El superAstro si se encuentra", premiosDAO.buscarSuperAstro(partido1.getCedula(), alSuperAstro));
	}

	public void testBuscarPartido() {
		setupEscenario();
		assertNull("El partido no se encuentra", premiosDAO.buscarPartido(partido4.getCedula(), alPartido));
		assertNotNull("El partido si se encuentra", premiosDAO.buscarPartido(partido1.getCedula(), alPartido));
	}

	public void testAgregarPremioBaloto() {
		setupEscenario();
		
		System.out.println(alBaloto.size());

		premiosDAO.agregarPremioBaloto(fileBaloto);
		
		System.out.println(alBaloto.size());

		assertNotSame("No se puede registrar el baloto", 3, alBaloto.size());

		assertEquals("El partido se ha registrado", 2, alBaloto.size());

	}

	public void testAgregarPremioSuperAstro() {
		setupEscenario();

		premiosDAO.agregarPremioSuperAstro(fileSuperAstro);

		assertNotSame("No se puede registrar el super astro", 3, alSuperAstro.size());

		assertEquals("El partido se ha registrado", 2, alSuperAstro.size());

	}

	public void testAgregarPremioPartido() {
		setupEscenario();

		premiosDAO.agregarPremioPartido(filePartido);

		assertNotSame("No se puede registrar el partido", 16, alPartido.size());

		assertEquals("El partido se ha registrado", 2, alPartido.size());

	}

	public void testMostrarTotal() {
		setupEscenario();
		String esperado = premiosDAO.verTotal(alBaloto, alSuperAstro, alPartido);
		assertEquals("Se muestra la información de todo", esperado,
				premiosDAO.verTotal(alBaloto, alSuperAstro, alPartido));
		assertNotSame("No se muestra la información de todo", esperado, "");
	}

	public void testVerBalotoTotal() {
		setupEscenario();
		assertEquals("Se muestra la información del baloto", premiosDAO.verBalotoTotal(alBaloto),
				premiosDAO.verBalotoTotal(alBaloto));
		assertNotSame("No se muestra la información del baloto", "", premiosDAO.verBalotoTotal(alBaloto));
	}

	public void testVerSuperAstroTotal() {
		setupEscenario();
		assertEquals("Se muestra la información del super astro", premiosDAO.verSuperAstroTotal(alSuperAstro),
				premiosDAO.verSuperAstroTotal(alSuperAstro));
		assertNotSame("No se muestra la información del super astro", "", premiosDAO.verSuperAstroTotal(alSuperAstro));
	}

	public void testVerPartidoTotal() {
		setupEscenario();
		assertEquals("Se muestra la información del partido", premiosDAO.verPartidoTotal(alPartido),
				premiosDAO.verPartidoTotal(alPartido));
		assertNotSame("No se muestra la información del partido", "", premiosDAO.verPartidoTotal(alPartido));
	}

}
