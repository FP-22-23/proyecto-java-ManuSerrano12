package fp.pasajero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	public void eliminarPasajero(Pasajero persona) {
		if(!passenger.contains(persona)) {
            throw new IllegalArgumentException("El pasajero no existe");
		}
          else {
        		passenger.remove(persona);
        }	
	}
	
	
	//METODOS DE IGUALDAD
	
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
	
	//METODO TOSTRING
	@Override
	public String toString() {
		return "ContenedorPasajero [passenger=" + passenger + "]";
	}

	
	//TRATAMIENTOS SECUENCIALES:
	
	//1.- EXISTE
	
	public Boolean existePasajeroPorEdad(Integer age) {
		Boolean res = false;
		for(Pasajero a: this.passenger) {
			if(Arrays.asList(a.getAge()).contains(age)){
				res = true;
				break;
			}
		}
		return res;
	}
	
	//2.- SUMA
	
	public Double getCosteTotal() {
		Double res = 0.;
		for(Pasajero a: this.passenger) {
			res = res + a.getTicketCost();
		}
		return res;
	}
	
	//3.- FILTRADO
	
	public List<String> getPasajerosVivos() {
		List<String> res = new ArrayList <> ();
		for (Pasajero a: this.passenger) {
			if(a.getSurvived().equals(true)) {
				res.add(a.getName());
			}		
		}
		return res;
	}
	
	//4.- MAP EN EL QUE LAS CLAVES SON UNA PROPIEDAD DEL TIPO BASE Y LOS VALORES UNA COLECCIÓN
	
	public Map <Integer, List <String>> agrupaJugadoresPorEquipo(){
		Map <Integer, List <String>> res = new HashMap<>();
		for (Pasajero a: this.passenger) {
			if (!res.containsKey(a.getPclass())) {
				List <String> jugadores = new ArrayList<>();
				jugadores.add(a.getName());
				res.put(a.getPclass(), jugadores);
			}else {
				res.get(a.getPclass()).add(a.getName());
			}
			
			
		}
		return res;
		
	}
	
	// 5.- MAP EN EL QUE LAS CLAVES SON UNA PROPIEDAD DEL TIPO BASE Y LOS VALORES EL CONTEO DE LOS OBJETOS DEL TIPO BASE
	
	public Map<Genero, Integer> numeroPasajerosPorSexo(){
		Map <Genero, List<String>> res = new HashMap<>();
		Map <Genero, Integer> res1 = new HashMap <>();
		for (Pasajero a: this.passenger) {
			if (!res.containsKey(a.getSex())) {
				List <String> lista = new ArrayList <>();
				lista.add(a.getName());
				res.put(a.getSex(), lista);
			}else {
				res.get(a.getSex()).add(a.getName());
				
			}
			
			res1.put(a.getSex(), res.get(a.getSex()).size());
		}
		return res1;
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
	public void eliminarPasajero(int n) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
