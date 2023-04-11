package fp.pasajero;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class Factoria{
	
	public static List<Pasajero> leePasajero(String rutaFichero){
		List<Pasajero> res = new ArrayList<>();
		List<String> lineas = Ficheros.leeFichero("No se ha encontrado el fichero",rutaFichero);	
		lineas.remove(0);
		for (String linea:lineas) {
			Pasajero p = parsearPasajero(linea);
			res.add(p);
		}
		return res;
	}

	public static Pasajeros leePasajero2(String rutaFichero) {
		Pasajeros res=null;
		try {
			Stream<Pasajero> sv=Files.lines(Paths.get(rutaFichero)).skip(1).map(Factoria::parsearPasajero);
			res= new ContenedorPasajero(sv);
		}
		catch(IOException e) {
			System.out.println("No se ha encontrado el fichero"+ rutaFichero);
		}
		return res;
		
	}
	
		private static Pasajero parsearPasajero(String linea) {
			String[] trozos=linea.split(";");
			Checkers.check("Error en elementos Pasajero", trozos.length==10);
			Integer passengerId = Integer.valueOf(trozos[0].trim());
			Boolean survived = parseaBooleano(Integer.parseInt(trozos[1].trim()));
			Integer pClass = Integer.valueOf(trozos[2].trim());
			String name = String.valueOf(trozos[3].trim());
			Genero sex = Genero.valueOf(trozos[4].toUpperCase().trim());
			Integer age = Integer.valueOf(trozos[5].trim());
			String cabin = String.valueOf(trozos[6].trim());
			LocalTime boardingTime = LocalTime.parse(trozos[7].trim(),DateTimeFormatter.ofPattern("HH:mm:ss"));
			Integer ticketCost = Integer.valueOf(trozos[8].trim());
			List<String> clothes=parseLista(trozos[9]);
			
			return new Pasajero(passengerId,survived,pClass,name,sex,age,cabin,boardingTime,ticketCost,clothes);
		}
		
		
		
		private static Boolean parseaBooleano(Integer a) {
			Boolean res = null;
			if (a.equals(1)) {
				res = true;
			}else {
				res = false;
			}
			return res;
		}
		
		public static  List<String> parseLista(String cadena){
			String [] trozos=cadena.split(",");
			List<String> lista=new ArrayList<>();
			for(String t:trozos) {
				lista.add(t.trim());	
			}
			return lista;
		}
		
		public static ContenedorPasajero leePasajero4(String rutaFichero) {
			Stream<Pasajero> res = null;
			try {
				res = Files.lines(Paths.get(rutaFichero)).skip(1).map(Factoria::parsearPasajero);
			} catch(IOException e) {
				e.printStackTrace();
			}
			return new ContenedorPasajero(res);
		}
		
		
}

