package fp.common;

import java.util.Objects;

import fp.utiles.Checkers;

public record Billete(Integer passengerId, Integer pClass, String cabin, Integer ticketCost) {

	
	//CONSTRUCTOR CON 1 RESTRICCION
	public Billete{
		
		Checkers.check("El precio del ticket tiene que ser positivo", 
				ticketCost > 0);
	}
	
	
	
	//CRITERIO DE IGUALDAD
	
	//se considera el mismo billete si tiene el mismo ID de pasajero y la misma cabina.
	@Override
	public int hashCode() {
		return Objects.hash(passengerId , cabin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billete other = (Billete) obj;
		return Objects.equals(cabin, other.cabin) && Objects.equals(passengerId, other.passengerId);
	}


	

}
