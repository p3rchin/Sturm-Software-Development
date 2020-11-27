package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

import co.edu.unbosque.model.*;

public class Archivo {

	private ObjectInputStream entrada;
	private ObjectOutputStream salida;

	public Archivo() {

	}

	public Archivo(File archivo) {

		if (archivo.exists()) {

		} else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void escribirEnArchivoJuego(ArrayList<Juego> alJuegos, File archivo) {

		try {

			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(alJuegos);
			salida.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void escribirEnArchivoBaloto(ArrayList<Baloto> alBaloto, File archivo) {

		try {

			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(alBaloto);
			salida.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void escribirEnArchivoSuperAstro(ArrayList<SuperAstro> alSuperAstro, File archivo) {

		try {

			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(alSuperAstro);
			salida.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void escribirEnArchivoPartido(ArrayList<Partido> alPartido, File archivo) {

		try {

			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(alPartido);
			salida.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void escribirEnArchivoApostador(ArrayList<Apostador> alPersona, File archivo) {

		try {

			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(alPersona);
			salida.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void escribirEnArchivoSede(ArrayList<Sede> alSede, File archivo) {

		try {

			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(alSede);
			salida.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<Juego> leerArchivoJuego(File archivo) {

		ArrayList<Juego> alJuego = new ArrayList<Juego>();

		if (archivo.length() != 0)

		{
			try {

				entrada = new ObjectInputStream(new FileInputStream(archivo));
				alJuego = (ArrayList<Juego>) entrada.readObject();

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
		}

		return alJuego;
	}

	public ArrayList<Baloto> leerArchivoBaloto(File archivo) {

		ArrayList<Baloto> alBaloto = new ArrayList<Baloto>();

		if (archivo.length() != 0) {

			try {

				entrada = new ObjectInputStream(new FileInputStream(archivo));
				alBaloto = (ArrayList<Baloto>) entrada.readObject();

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
		}

		return alBaloto;
	}

	public ArrayList<SuperAstro> leerArchivoSuperAstro(File archivo) {

		ArrayList<SuperAstro> alSuperAstro = new ArrayList<SuperAstro>();

		if (archivo.length() != 0) {

			try {

				entrada = new ObjectInputStream(new FileInputStream(archivo));
				alSuperAstro = (ArrayList<SuperAstro>) entrada.readObject();

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
		}

		return alSuperAstro;
	}

	public ArrayList<Partido> leerArchivoPartido(File archivo) {

		ArrayList<Partido> alPartido = new ArrayList<Partido>();

		if (archivo.length() != 0) {

			try {

				entrada = new ObjectInputStream(new FileInputStream(archivo));
				alPartido = (ArrayList<Partido>) entrada.readObject();

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
		}

		return alPartido;
	}

	public ArrayList<Apostador> leerArchivoApostador(File archivo) {

		ArrayList<Apostador> alApostador = new ArrayList<Apostador>();

		if (archivo.length() != 0) {

			try {

				entrada = new ObjectInputStream(new FileInputStream(archivo));
				alApostador = (ArrayList<Apostador>) entrada.readObject();

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
		}

		return alApostador;
	}

	public ArrayList<Sede> leerArchivoSede(File archivo) {

		ArrayList<Sede> alSede = new ArrayList<Sede>();

		if (archivo.length() != 0) {

			try {

				entrada = new ObjectInputStream(new FileInputStream(archivo));
				alSede = (ArrayList<Sede>) entrada.readObject();

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
		}

		return alSede;
	}

}
