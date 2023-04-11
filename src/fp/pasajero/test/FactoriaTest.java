package fp.pasajero.test;
import java.util.List;

import fp.pasajero.*;


public class FactoriaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testPasajerosFactoria("./data/Titanic.csv");
	}
		private static void testPasajerosFactoria(String fichero) {
			System.out.println("Test de los pasajeros del Titanic: ");
			Pasajeros pasajero = Factoria.leePasajero2(fichero);
			System.out.println("Pasajeros del Titanic: " + pasajero);
		}

}
