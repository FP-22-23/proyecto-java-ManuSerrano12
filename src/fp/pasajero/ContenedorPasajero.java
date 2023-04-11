package fp.pasajero;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class ContenedorPasajero implements Pasajeros{
	
	//ATRIBUTO
	private List<Pasajero> passenger;
	
	//CONSTRUCTOR
	public ContenedorPasajero() {
		passenger = new ArrayList<Pasajero>();
	}
	public ContenedorPasajero(Stream<Pasajero> passenger) {
		this.passenger = passenger.collect(Collectors.toList());
	}
	public ContenedorPasajero(Collection<Pasajero> passenger) {
		this.passenger = new ArrayList<Pasajero>(passenger);
	}

	
	
	//METODOS
	//Añade un pasajero
	public void añadirPasajero(Pasajero persona) {
		passenger.add(persona);
	}
	
	//Borra un pasajero
	public void borrarPasajero(Pasajero persona) {
		if(!passenger.contains(persona)) {
            throw new IllegalArgumentException("El episodio no existe");
		}
          else {
        		passenger.remove(persona);
        }	
	}
	
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(passenger);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContenedorPasajero other = (ContenedorPasajero) obj;
		return Objects.equals(passenger, other.passenger);
	}
	@Override
	public String toString() {
		return "ContenedorPasajero [passenger=" + passenger + "]";
	}
	@Override
	public List<Pasajero> getPasajero() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getNumeroPasajeros() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void añadirCollecionPasajero(Collection<Pasajero> p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminarPasajero(Pasajero p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminarPasajero(int n) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
