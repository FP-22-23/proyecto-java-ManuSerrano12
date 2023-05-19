package fp.pasajero;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface Pasajeros {


	List<Pasajero> getPasajero();

	String toString();

	int hashCode();

	boolean equals(Object obj);

	//	Obtener el n�mero de elementos.
	Integer getNumeroPasajeros();

	//	A�adir un elemento.
	void a�adirPasajero(Pasajero p);

	//	A�adir una colecci�n de elementos.
	void a�adirCollecionPasajero(Collection<Pasajero> p);

	//	Eliminar un elemento.
	void eliminarPasajero(Pasajero p);

	
	//TRATAMIENTOS SECUENCIALES:
	
	//ENTREGA I
	Double getCosteTotal();
	Boolean existePasajeroPorEdad(Integer age);
	List<String> getPasajerosVivos();
	Map <Integer, List <String>> agrupaPasajerosPorClases();
	Map<Genero, Integer> numeroPasajerosPorSexo();
	
	//ENTREGA II
	Boolean existePasajeroPorEdadSTREAM(Integer age);
	Integer  getCosteTotalSTREAM();
	List<String> getPasajerosVivosSTREAM();
	Pasajero maxPasajeroPorCosteTicketYSurvivedSTREAM();
	List<Pasajero> filtradoPorSurvivedOrdenadoPorEdadSTREAM();
	Map <Integer, List <String>> agrupaPasajerosPorClasesSTREAM();
	Map <Genero, List<Integer>> agruparEdadSegunGeneroSTREAM();
	Map <Integer, Pasajero> agruparMaxPasajeroPorEdadSTREAM();
	SortedMap<Genero, List<String>> getNPrimerosPasajerosPorGeneroSTREAM(Integer n);
	Genero getMayorNumeroDeGeneroABordoSTREAM();
 
	
}