package fp.pasajero;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import fp.common.Genero;
import fp.utiles.Checkers;

public class Factoria {

		private static Pasajero parsearPasajero(String linea) {
			Checkers.checkNoNull(linea);
			String[] trozos=linea.split(";");
			
			Integer passengerId = Integer.parseInt(trozos[0].trim());
			Boolean survived = null;
				if(Integer.valueOf(trozos[1].trim()).equals(1)) {
					survived = true;
				}
				else {
					survived = false;
					}
				
			Integer pClass = Integer.parseInt(trozos[2].trim());
			String name = trozos[3].trim();
			Genero sex = Genero.valueOf(trozos[4].toUpperCase().trim());
			Integer age = Integer.parseInt(trozos[5].trim());
			String cabin = trozos[6].trim();
			LocalTime boardingTime = LocalTime.parse(trozos[7].trim(),DateTimeFormatter.ofPattern("HH:mm:ss"));
			Integer ticketCost = Integer.parseInt(trozos[8].trim());
			return new Pasajero(passengerId,survived,pClass,name,sex,age,cabin,boardingTime,ticketCost);
		}
		
		public static ContenedorPasajero leePasajero(String rutaFichero) {
			ContenedorPasajero res = null;
			try {
				Stream<Pasajero> st = Files.lines(Paths.get(rutaFichero)).skip(1).map(Factoria::parsearPasajero);
				res = new ContenedorPasajero(st);
			} catch(IOException e) {
				e.printStackTrace();
			}
			return res;
		}
		
		
}

