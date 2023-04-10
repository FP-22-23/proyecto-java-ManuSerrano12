package fp.pasajero.test;
import fp.pasajero.*;


public class FactoriaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testPasajerosFactoria("./data/titanic.csv");
	}
		private static void testPasajerosFactoria(String fichero) {
			System.out.println("Test de los episodios de la serie Friends: ");
			ContenedorPasajero pasajero = Factoria.leePasajero(fichero);
			System.out.println("Capítulo Friends: " + pasajero);
		}

}
