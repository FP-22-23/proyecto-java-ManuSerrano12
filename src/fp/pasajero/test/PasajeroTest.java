package fp.pasajero.test;

import java.time.LocalTime;

import fp.common.Genero;
import fp.pasajero.Pasajero;

public class PasajeroTest {

	public static void main(String[] args) {
		Pasajero p1 = new Pasajero(1,"Manuel", true ,1,19, "C8292", "B11", Genero.MALE, LocalTime.of(12, 22, 11));
		System.out.println(p1.toString());
		System.out.println("\nEl pasajero embarcó a las " + p1.getHourBoarding());
	}

}
