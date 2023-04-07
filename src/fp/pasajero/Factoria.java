package fp.pasajero;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.common.Genero;
import fp.pasajero.Pasajero;

public class Factoria {

		private static Pasajero parsearPasajeros(String linea) {
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
			LocalTime boardingTime = LocalTime.parse(trozos[7].trim());
			Integer ticketCost = Integer.parseInt(trozos[8].trim());
			
			List<String> clothes = new ArrayList<>();
	        for (String valor : trozos[9]) {
	            clothes.add(valor.trim());
	        }
			return new Pasajero(passengerId,survived,pClass,name,sex,age,cabin,boardingTime,ticketCost,clothes);
		}
}

