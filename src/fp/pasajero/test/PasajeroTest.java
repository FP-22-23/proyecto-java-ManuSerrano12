package fp.pasajero.test;

import java.time.LocalTime;
import java.util.List;

import fp.common.Genero;
import fp.pasajero.Pasajero;

public class PasajeroTest {

	public static void main(String[] args) {
		
		//CREACION DE PASAJEROS
		Pasajero p1 = new Pasajero(21,"Manuel", true ,1,28, "C8292", "B11", Genero.MALE, LocalTime.of(12, 22, 11));
		Pasajero p2 = new Pasajero("Manuel");
		Pasajero p3 = new Pasajero("Manuel");
		
		System.out.println(p1);
		p1.setAge(50);
		p1.setName("Juan Pérez");
		p1.setBoardingTime(LocalTime.of(22, 22, 22));
		p1.setSurvived(false);
		p1.setPassengerId(99);
		
		System.out.println(p1);
		System.out.println(p1.getName() + " " + p1.getAge());
		
		//USO DE LA VARIABLE DERIVADA
		System.out.println("\n" + p1.getName()+" embarcó a las " + p1.getHourBoarding() + " horas.");
		
		//USO DEL CRITERIO DE IGUALDAD
		System.out.println("\nEl resultado de  p1.equals(p2)= " + p1.equals(p2));
		System.out.println("El resultado de  p2.equals(p3)= " + p2.equals(p3)); 
		
		//USO DEL CRITERIO DE ORDEN NATURAL
		System.out.println(p1.listaDePasajeros());
		List<Pasajero> lista = p1.listaDePasajeros();
		lista.add(p1);
		lista.add(p2);
		System.out.println(lista);
		
		
	}

	
}
