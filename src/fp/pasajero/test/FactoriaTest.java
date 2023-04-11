package fp.pasajero.test;
import java.util.List;

import fp.pasajero.*;


public class FactoriaTest {

	public static void main(String[] args) {

		
		testLecturaFactoria("./data/Titanic.csv");
		
	}
		private static void testLecturaFactoria(String fichero) {
			System.out.println("Test de los pasajeros del Titanic: ");
			List<Pasajero> pasajero = Factoria.leePasajero(fichero); 
			System.out.println("Pasajeros del Titanic: "+ pasajero);
		}
		private static void testLeturaFactoria2(String fichero) {
			System.out.println("Test de los pasajeros del Titanic: ");
			Pasajeros pasajero = Factoria.leePasajero2(fichero);
			System.out.println("Pasajeros del Titanic: " + pasajero);
		}

}
