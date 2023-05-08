package fp.pasajero.test;

import java.util.List;
import java.util.Map;

import fp.pasajero.Factoria;
import fp.pasajero.Genero;
import fp.pasajero.Pasajeros;

public class ContenedorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pasajeros pasajero = Factoria.leePasajero2("./data/Titanic.csv");
		
		
		testExistePasajeroPorEdad(pasajero, 22);
		testGetCosteTotal(pasajero);
		testGetPasajerosVivos(pasajero);
		testAgrupaPasajerosPorClases(pasajero);
		testNumeroPasajerosPorSexo(pasajero);
		testExistePasajeroPorEdadSTREAM(pasajero,22);
		testGetCosteTotalSTREAM(pasajero);
		testGetPasajerosVivosSTREAM(pasajero);
		testMaxPasajeroPorCosteTicketYSurvivedSTREAM(pasajero);
		testFiltradoPorSurvivedOrdenadoPorEdadSTREAM(pasajero);
		testAgrupaPasajerosPorClasesSTREAM(pasajero) ;
		testAgruparRopasPorEdadSTREAM(pasajero);
	}

	private static void testExistePasajeroPorEdad(Pasajeros pasajero, Integer age) {
		System.out.println("ENTREGA 2\nHubo algun pasajero con " + age + " años? : " + pasajero.existePasajeroPorEdad(age));
	}
	private static void testGetCosteTotal(Pasajeros pasajero) {
		System.out.println("\nLa suma de todo el coste es de: " + pasajero.getCosteTotal() + "€");
	}
	private static void testGetPasajerosVivos(Pasajeros pasajero) {
		System.out.println("\nDevuelve una lista con el nombre de los pasajeros que sobrevivieron:" + pasajero.getPasajerosVivos());
	}
	private static void testAgrupaPasajerosPorClases(Pasajeros pasajero) {
		System.out.println("\nAgrupa pasajeros por clases (P Class): " + pasajero.agrupaPasajerosPorClases());
	}
	private static void testNumeroPasajerosPorSexo(Pasajeros pasajero) {
		System.out.println("\nAgrupa y cuenta los pasajeros según su género: " + pasajero.numeroPasajerosPorSexo());
	}
	
	//ENTREGA 3
	//Bloque 1
	private static void testExistePasajeroPorEdadSTREAM(Pasajeros pasajero,Integer age) {
		System.out.println("\nENTREGA 3\n\nBloque 1\nHubo algun pasajero con " + age + " años? : " + pasajero.existePasajeroPorEdadSTREAM(age));
	}
	private static void testGetCosteTotalSTREAM(Pasajeros pasajero) {
		System.out.println("\nLa suma de todo el coste es de: " + pasajero.getCosteTotalSTREAM() + "€");
	}
	private static void testGetPasajerosVivosSTREAM(Pasajeros pasajero) {
		System.out.println("\nDevuelve una lista con el nombre de los pasajeros que sobrevivieron: " + pasajero.getPasajerosVivosSTREAM());
	}
	private static void testMaxPasajeroPorCosteTicketYSurvivedSTREAM(Pasajeros pasajero) {
		System.out.println("\nDevuelve el pasajero que mas gasto por su billete y sobrevivio: " + pasajero.maxPasajeroPorCosteTicketYSurvivedSTREAM());
	}
	private static void testFiltradoPorSurvivedOrdenadoPorEdadSTREAM(Pasajeros pasajero) {
		System.out.println("\nLista de pasajeros que sobrevivieron ordenados por edad: " + pasajero.filtradoPorSurvivedOrdenadoPorEdadSTREAM());
	}
	
	//Bloque 2
	private static void testAgrupaPasajerosPorClasesSTREAM(Pasajeros pasajero) {
		System.out.println("\nBloque 2\nAgrupa pasajeros por clases (P Class): " + pasajero.agrupaPasajerosPorClasesSTREAM());
	}
	private static void testAgruparRopasPorEdadSTREAM(Pasajeros pasajero) {
		System.out.println("\nAgrupa la edad de los pasajeros segun el genero: " + pasajero.agruparRopasPorEdadSTREAM());
	}
	}

