package fp.pasajero.test;
import java.util.List;

import fp.pasajero.*;


public class FactoriaTest {

	public static void main(String[] args) {

		
		testLecturaFactoria2("./data/Titanic.csv");
		testLecturaFactoria("./data/Titanic.csv");
		
	}
		private static void testLecturaFactoria(String fichero) {
			System.out.println("\nTest de los pasajeros del Titanic: ");
			List<Pasajero> pasajero = Factoria.leePasajero(fichero);
			System.out.println("\nPasajeros del Titanic: "+ pasajero);
		}
		private static void testLecturaFactoria2(String fichero) {
			System.out.println("Test de los pasajeros del Titanic: ");
			Pasajeros pasajero = Factoria.leePasajero2(fichero);
			System.out.println("\nPasajeros del Titanic: " + pasajero);

		}

		
}
