package fp.pasajero.test;

import fp.pasajero.ContenedorPasajero;
import fp.pasajero.Factoria;
import fp.pasajero.Pasajero;
import fp.pasajero.Pasajeros;

public class ContenedorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pasajeros pasajero = Factoria.leePasajero2("./data/Titanic.csv");
		
		
		testExistePasajeroPorEdad(pasajero, 22);
		testGetCosteTotal(pasajero);
		testGetPasajerosVivos(pasajero);
		//testAgrupaJugadoresPorEquipo(nba);
		//testNumeroJugadoresRetiradosOno(nba);

	}

	private static void testExistePasajeroPorEdad(Pasajeros pasajero, Integer age) {
		System.out.println("Hubo algun pasajero con " + age + " años? : " + pasajero.existePasajeroPorEdad(age));
	}
	private static void testGetCosteTotal(Pasajeros pasajero) {
		System.out.println("La suma de todo el coste es de: " + pasajero.getCosteTotal() + "€");
	}
	private static void testGetPasajerosVivos(Pasajeros pasajero) {
		System.out.println("Devuelve una lista con el nombre de los pasajeros que sobrevivieron:" + pasajero.getPasajerosVivos());
	}
	}

