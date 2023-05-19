package fp.pasajero;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class ContenedorPasajero implements Pasajeros{
	
	//ATRIBUTO
	private List<Pasajero> passenger;
	
	//CONSTRUCTOR
	public ContenedorPasajero() {
		passenger = new ArrayList<Pasajero>();
	}
	public ContenedorPasajero(Collection<Pasajero> passenger) {
		this.passenger = new ArrayList<Pasajero>(passenger);
	}
		public ContenedorPasajero(Stream<Pasajero> passenger) {
		this.passenger = passenger.collect(Collectors.toList());
	}
	
	//METODOS
	
	//Añadir un elemento.
	@Override
	public Integer getNumeroPasajeros() {
		// TODO Auto-generated method stub
		return passenger.size();
	}
	
	
	//Añade un pasajero
	public void añadirPasajero(Pasajero persona) {
		passenger.add(persona);
	}

	//Añadir una colección de elementos.
	@Override
	public void añadirCollecionPasajero(Collection<Pasajero> p) {
		this.passenger.addAll(p);
		
	}

	
	//Eliminar un elemento
	public void eliminarPasajero(Pasajero persona) {
		if(!passenger.contains(persona)) {
            throw new IllegalArgumentException("El pasajero no existe");
		}
          else {
        		passenger.remove(persona);
        }	
	}
	
	
	@Override
	public List<Pasajero> getPasajero() {
		// TODO Auto-generated method stub
		return passenger;
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
	
	//4.- MAP EN EL QUE LAS CLAVES SON UNA PROPIEDAD DEL TIPO BASE Y LOS VALORES UNA LISTA
	
	public Map <Integer, List <String>> agrupaPasajerosPorClases(){
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
	
	
	//ENTREGA 3
	//Bloque 1
	
	// 1.- EXISTE (stream)
	public Boolean existePasajeroPorEdadSTREAM(Integer age) {
		return getPasajero().stream()
				.anyMatch(x -> x.getAge().equals(age));
	}
	
	// 2.- SUMA (stream)
	public Integer getCosteTotalSTREAM() {
		return getPasajero().stream()
				.mapToInt(x -> x.getTicketCost()).sum();
	}
	
	// 3.- FILTRADO (stream)
	public List<String> getPasajerosVivosSTREAM() {
		return getPasajero().stream()
				.filter(x -> x.getSurvived().equals(true)).map(x -> x.getName()).collect(Collectors.toList());
	}
	
	// 4.- MAXIMO CON FILTRADO
	public Pasajero maxPasajeroPorCosteTicketYSurvivedSTREAM() {
		return getPasajero().stream()
				.filter(x -> x.getSurvived().equals(true))
				.max(Comparator.comparing(Pasajero::getTicketCost))
				.get();
	}
	
	// 5.- SELECCION CON FILTRADO Y SELECCION
	public List<Pasajero> filtradoPorSurvivedOrdenadoPorEdadSTREAM() {
		return getPasajero().stream()
				.filter(x -> x.getSurvived().equals(true)).sorted(Comparator.comparing(Pasajero::getAge)).collect(Collectors.toList());
	}
	
	
	//Bloque 2
	
	//6.- MAP EN EL QUE LAS CLAVES SON UNA PROPIEDAD DEL TIPO BASE Y LOS VALORES UNA LISTA (stream)
	public Map <Integer, List <String>> agrupaPasajerosPorClasesSTREAM(){
		return getPasajero().stream()
				.collect(Collectors.groupingBy(
						Pasajero::getPclass, Collectors.mapping(Pasajero::getName, Collectors.toList())));		
	}
	
	// 7.- USO DE groupingBy
	public Map <Genero, List<Integer>> agruparEdadSegunGeneroSTREAM(){
		return getPasajero().stream()
				.collect(Collectors.groupingBy(
						Pasajero::getSex, Collectors.mapping(Pasajero::getAge, Collectors.toList())));		
	}
	
	// 8.- MAP CON ATRIBUTO COMO CLAVE Y VALORES COMO VALOR MAXIMO
	public Map <Integer, Pasajero> agruparMaxPasajeroPorEdadSTREAM(){
		return getPasajero().stream()
				.collect(Collectors.groupingBy(Pasajero::getAge,
	                    Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Pasajero::getTicketCost)), x -> x.get())));
	}
	
	// 9.- SORTED MAP CON ATRIBUTO COMO CLAVE Y VALOR CON LISTA DE n MEJORES VALORES
	public SortedMap<Genero, List<String>> getNPrimerosPasajerosPorGeneroSTREAM(Integer n){
		return getPasajero().stream()
				.collect(Collectors.groupingBy(
						Pasajero::getSex,
						TreeMap::new,
						Collectors.collectingAndThen(
								Collectors.toList(), 
								t -> fAux(t, n))));
	}
	private static List<String> fAux(List<Pasajero> lista, Integer n){
		return lista.stream()
				.sorted(Comparator.comparing(Pasajero::getBoardingTime))
				.limit(n)
				.map(Pasajero::getName)
				.collect(Collectors.toList());
	}
	
	// 10.- MAXIMO DE UN MAP
	public Genero getMayorNumeroDeGeneroABordoSTREAM() {
		Map<Genero, Integer> map = getPasajero().stream()
												.collect(Collectors.groupingBy(
														Pasajero::getSex, 
														Collectors.collectingAndThen(
																Collectors.counting(), 
																l -> l.intValue())));
		return map.entrySet().stream()
					.max(Comparator.comparing(entry -> entry.getValue()))
					.get()
					.getKey();
		
	}
	 

}
