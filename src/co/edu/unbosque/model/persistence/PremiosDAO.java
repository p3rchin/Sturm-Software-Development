package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.Baloto;
import co.edu.unbosque.model.Partido;
import co.edu.unbosque.model.SuperAstro;

public class PremiosDAO {

	private Archivo archivo;

	public PremiosDAO(Archivo archivo) {

		this.archivo = archivo;
	}

	PremiosDAO() {

	}

	public Baloto buscarBaloto(String pCedula, ArrayList<Baloto> alBaloto) {

		Baloto encontrado = null;

		if (!alBaloto.isEmpty()) {

			for (int i = 0; i < alBaloto.size(); i++) {

				if (alBaloto.get(i).getCedula().equals(pCedula)) {

					encontrado = alBaloto.get(i);
				}
			}
		}

		return encontrado;
	}

	public SuperAstro buscarSuperAstro(String pCedula, ArrayList<SuperAstro> alSuperAstro) {

		SuperAstro encontrado = null;

		if (!alSuperAstro.isEmpty()) {

			for (int i = 0; i < alSuperAstro.size(); i++) {

				if (alSuperAstro.get(i).getCedula().equals(pCedula)) {

					encontrado = alSuperAstro.get(i);
				}
			}
		}

		return encontrado;
	}

	public Partido buscarPartido(String pCedula, ArrayList<Partido> alBaloto) {

		Partido encontrado = null;

		if (!alBaloto.isEmpty()) {

			for (int i = 0; i < alBaloto.size(); i++) {

				if (alBaloto.get(i).getCedula().equals(pCedula)) {

					encontrado = alBaloto.get(i);
				}
			}
		}

		return encontrado;
	}

	public void agregarPremioBaloto(File file) {

		ArrayList<Baloto> alBaloto = new ArrayList<Baloto>();
		Baloto agregarBaloto = new Baloto(0.10f, 0.20f, "Premio Mayor", 500000000);
		alBaloto.add(agregarBaloto);

		archivo.escribirEnArchivoBaloto(alBaloto, file);

	}

	public void agregarPremioSuperAstro(File file) {
		ArrayList<SuperAstro> alSuperAstro = new ArrayList<SuperAstro>();
		SuperAstro agregarAstro = new SuperAstro(0.20f, "Premio Mayor", 500000000);
		alSuperAstro.add(agregarAstro);
		archivo.escribirEnArchivoSuperAstro(alSuperAstro, file);

	}

	public void agregarPremioPartido(File file) {

		ArrayList<Partido> alPartido = new ArrayList<Partido>();

		Partido agregarPartido1 = new Partido("Celtic", "Liverpool", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido2 = new Partido("Mönchengladbach", "Porto", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido3 = new Partido("Chelsea", "Ararat-Armenia", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido4 = new Partido("Celtic", "Atalanta", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido5 = new Partido("Barcelona", "Real Madrid", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido6 = new Partido("Manchester City", "Zenit", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido7 = new Partido("Inter de Milan", "PSG", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido8 = new Partido("Manchester United", "Liverpool", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido9 = new Partido("Dortmund", "Ajax", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido10 = new Partido("Manchester City", "Porto", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido11 = new Partido("Real Madrid", "Chelsea", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido12 = new Partido("Atletico de Madrid", "Bayern", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido13 = new Partido("Juventus", "Porto", 0.2f, 0.4f, 0.7f, 500000000);
		Partido agregarPartido14 = new Partido("Manchester United", "Inter de Milan", 0.2f, 0.4f, 0.7f, 250000000f);

		alPartido.add(agregarPartido1);
		alPartido.add(agregarPartido2);
		alPartido.add(agregarPartido3);
		alPartido.add(agregarPartido4);
		alPartido.add(agregarPartido5);
		alPartido.add(agregarPartido6);
		alPartido.add(agregarPartido7);
		alPartido.add(agregarPartido8);
		alPartido.add(agregarPartido9);
		alPartido.add(agregarPartido10);
		alPartido.add(agregarPartido11);
		alPartido.add(agregarPartido12);
		alPartido.add(agregarPartido13);
		alPartido.add(agregarPartido14);
		archivo.escribirEnArchivoPartido(alPartido, file);

	}

	public String verBalotoTotal(ArrayList<Baloto> alBaloto) {

		String texto = "";

		for (int i = 0; i < alBaloto.size(); i++) {

			texto = (alBaloto.get(i).getPorcentaje4() + "\n" + alBaloto.get(i).getPorcentaje5() + "\n"
					+ alBaloto.get(i).getPorcentaje6() + "\n" + alBaloto.get(i).getPresupuesto() + "\n"
					+ "------------------------------" + "\n");

		}

		return texto;

	}

	public String verSuperAstroTotal(ArrayList<SuperAstro> alSuperAstro) {

		String texto = "";

		for (int i = 0; i < alSuperAstro.size(); i++) {

			texto = (alSuperAstro.get(i).getPorcentajenumeros() + "\n" + alSuperAstro.get(i).getPorcentajetodo() + "\n"
					+ alSuperAstro.get(i).getPresupuesto() + "\n" + "------------------------------" + "\n");

		}

		return texto;

	}

	public String verPartidoTotal(ArrayList<Partido> alPartido) {

		String texto = "";

		for (int i = 0; i < alPartido.size(); i++) {

			texto = (alPartido.get(i).getEquipoLocal() + "\n" + alPartido.get(i).getEquipoVisitante() + "\n"
					+ alPartido.get(i).getPorcentajeGanador() + "\n" + alPartido.get(i).getPorcentajeEmpate() + "\n"
					+ alPartido.get(i).getPorcentajePerdedor() + "\n" + alPartido.get(i).getPresupuesto() + "\n"
					+ "------------------------------" + "\n");

		}

		return texto;

	}

	public String verTotal(ArrayList<Baloto> alBaloto, ArrayList<SuperAstro> alSuperAstro,
			ArrayList<Partido> alPartido) {

		String texto = "";

		for (int i = 0; i < alBaloto.size(); i++) {

			texto = (alBaloto.get(i).getPorcentaje4() + "\n" + alBaloto.get(i).getPorcentaje5() + "\n"
					+ alBaloto.get(i).getPorcentaje6() + "\n" + alBaloto.get(i).getPresupuesto() + "\n"
					+ "------------------------------" + "\n");

		}

		for (int i = 0; i < alSuperAstro.size(); i++) {

			texto = (alSuperAstro.get(i).getPorcentajenumeros() + "\n" + alSuperAstro.get(i).getPorcentajetodo() + "\n"
					+ alSuperAstro.get(i).getPresupuesto() + "\n" + "------------------------------" + "\n");

		}

		for (int i = 0; i < alPartido.size(); i++) {

			texto = (alPartido.get(i).getEquipoLocal() + "\n" + alPartido.get(i).getEquipoVisitante() + "\n"
					+ alPartido.get(i).getPorcentajeGanador() + "\n" + alPartido.get(i).getPorcentajeEmpate() + "\n"
					+ alPartido.get(i).getPorcentajePerdedor() + "\n" + alPartido.get(i).getPresupuesto() + "\n"
					+ "------------------------------" + "\n");

		}

		return texto;

	}

}
