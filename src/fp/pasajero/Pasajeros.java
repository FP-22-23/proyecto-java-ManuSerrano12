package fp.pasajero;

import java.util.Collection;
import java.util.List;

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

	void eliminarPasajero(int n);

	Double getCosteTotal();

	Boolean existePasajeroPorEdad(Integer age);

	List<String> getPasajerosVivos();

	//Boolean existePartidaDondeRivalesMatadosDeUnEquipoSupere(Equipo equipo, Integer rivales_matados);

	//Integer cantidadOroEquipoConMasOroPorRango(Rango rango, Equipo equipo);

	//Map<Rango, List<Partida>> agruparPartidasPorRango();

	//SortedMap<Month,Integer> contarPartidasPorMeses();

	

	//Double mediaRivalesMatadosPorEquipoYRango(Rango rango, Equipo equipo);

}