package fp.pasajero.test;

import java.time.LocalTime;

import fp.common.Genero;
import fp.pasajero.Pasajero;

public class PasajeroTest {

	public static void main(String[] args) {
		Pasajero p1 = new Pasajero(21,"Manuel", true ,1,28, "C8292", "B11", Genero.MALE, LocalTime.of(12, 22, 11));
		Pasajero p2 = new Pasajero("Manuel");
		Pasajero p3 = new Pasajero("Manuel");
		System.out.println(p1.toString());
		System.out.println(p2);
		System.out.println(" \n" +p1.habitacion());
		System.out.println( p1.getName()+" embarcó a las " + p1.getHourBoarding() + " horas.");
		System.out.println("\nEl resultado de  p1.equals(p2)= " + p1.equals(p2));
		System.out.println("El resultado de  p2.equals(p3)= " + p2.equals(p3));
	}

}
