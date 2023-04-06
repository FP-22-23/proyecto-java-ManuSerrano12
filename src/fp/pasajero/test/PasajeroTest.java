package fp.pasajero.test;

import java.time.LocalTime;
import java.util.List;

import fp.common.Genero;
import fp.pasajero.Pasajero;

public class PasajeroTest {

	public static void main(String[] args) {
		
		//CONSTRUCTORES
		Pasajero p1 = new Pasajero(21,"Manuel", true ,1,28, "B11",300, Genero.MALE, LocalTime.of(12, 22, 11) , "abrigo,botas,sombrero");
		Pasajero p2 = new Pasajero(982,23,"Susana",Genero.FEMALE);
		Pasajero p3 = new Pasajero(982,23,"Susana",Genero.FEMALE);
		
		//METODOS SET
		System.out.println(p1);
		p1.setAge(50);
		p1.setPclass(1);
		p1.setName("Juan Pérez");
		p1.setBoardingTime(LocalTime.of(22, 22, 22));
		p1.setSurvived(false);
		p1.setPassengerId(99);
		System.out.println(p1);
		System.out.println(p1.getName() + " " + p1.getAge());
		
		//METODOS GET
		System.out.println("\nID del pasajero:" + p1.getPassengerId());
		System.out.println("Sobrevivió el pasajero:" + p1.getSurvived());
		System.out.println("Clase del pasajero:" + p1.getPclass());
		System.out.println("Edad del pasajero:" + p1.getAge());
		System.out.println("Nombre del pasajero:" + p1.getName());
		System.out.println("Coste del Ticket del pasajero:" + p1.getTicketCost());
		System.out.println("Cabina del pasajero:" + p1.getCabin());
		System.out.println("Genero del pasajero:" + p1.getSex());
		System.out.println("Hora de abordaje del pasajero:" + p1.getBoardingTime());
		System.out.println("Ropas que usaba el pasajero:" + p1.getClothes());

		
		//METODO DET DE LA PROPIEDAD DERIVADA
		System.out.println("\n" + p1.getName()+" embarcó a las " + p1.getHourBoarding() + " horas.");
		
		//PROBANDO EL EQUALS
		System.out.println("\nEl resultado de  p1.equals(p2)= " + p1.equals(p2));
		System.out.println("El resultado de  p2.equals(p3)= " + p2.equals(p3)); 
		
		//PROBANDO EL COMPARE TO
		if (p1.compareTo(p3) > 0) {
			System.out.println("\nEl pasajero " + p1.getName() + " va antes que el pasajero " + p3.getName());
		}else {
			System.out.println("\nEl pasajero " + p3.getName() + " va antes que el pasajero " + p1.getName());
		}
	}

	
	
}
