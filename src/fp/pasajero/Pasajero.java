package fp.pasajero;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fp.common.Genero;
import fp.utiles.Checkers;

/**
 * @author Manuel
 *
 */

//DECLARACIÓN DE LAS PROPIEDADES BÁSICAS
public class Pasajero implements Comparable<Pasajero>{
	private Integer passengerId;
	private Boolean survived;
	private Integer pclass, age,ticketCost;
	private String name,cabin;
	private Genero Sex;
	private LocalTime boardingTime;
	private List <String> clothes;

	//CONSTRUCTOR Y RESTRICCIONES
	public Pasajero(Integer passengerId, String name , Boolean survived,Integer pclass,Integer age, 
			String cabin,Integer ticketCost, Genero sex, LocalTime boardingTime, String clothes) {
		
		Checkers.check("La persona tiene que tener entre 25 y 40 años", 
				age <= 40 && age >= 25);
		Checkers.check("La persona tiene que haber embarcado entre las 12:00 y las 22:00", 
				boardingTime.isAfter(LocalTime.of(10,00,00)) && boardingTime.isBefore(LocalTime.of(22, 00, 00)));
		
		this.passengerId = passengerId;
		this.survived = survived;
		this.pclass = pclass;
		this.age = age;
		this.name = name;
		this.cabin = cabin;
		this.ticketCost = ticketCost;
		this.Sex = sex;
		this.boardingTime = boardingTime;
		this.setClothes(Arrays.asList(clothes.split(",")));
	}
	
	
	//CONSTRUCTOR CON 1 SOLO ARGUMENTO
	public Pasajero(String name) {
		this.passengerId = null;
		this.survived = null;
		this.pclass = null;
		this.age = null;
		this.name = name;
		this.ticketCost = null;
		this.cabin = null;
		this.Sex = null;
		this.boardingTime = null;
		this.clothes = null;
	}
	
	
	
	//PROPIEDAD DERIVADAS
	public Integer getHourBoarding() {
		return this.boardingTime.getHour();
	}
	
	
	//LISTA
	public List<Pasajero> listaDePasajeros() {
		List<Pasajero> listaDePasajeros = new ArrayList<Pasajero>();
		return listaDePasajeros;
	}
	
	
	//REPRESENTACION COMO CADENA
	@Override
	public String toString() {
		return "Pasajero [passengerId=" + passengerId + ", survived=" + survived + ", pclass=" + pclass + ", age=" + age
				+ ", ticketCost=" + ticketCost + ", name=" + name + ", cabin=" + cabin + ", Sex=" + Sex
				+ ", boardingTime=" + boardingTime + ", clothes=" + clothes + "]";
	}


	//GETTERS Y SETTERS
	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public Boolean getSurvived() {
		return survived;
	}

	public void setSurvived(Boolean survived) {
		this.survived = survived;
	}

	public Integer getPclass() {
		return pclass;
	}

	public void setPclass(Integer pclass) {
		this.pclass = pclass;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Integer ticketCost) {
		this.ticketCost = ticketCost;
	}

	public String getCabin() {
		return cabin;
	}

	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	public Genero getSex() {
		return Sex;
	}

	public void setSex(Genero sex) {
		Sex = sex;
	}

	public LocalTime getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(LocalTime boardingTime) {
		this.boardingTime = boardingTime;
	}
	
	public List <String> getClothes() {
		return clothes;
	}


	public void setClothes(List <String> clothes) {
		this.clothes = clothes;
	}
	
	


	@Override
	public int hashCode() {
		return Objects.hash(Sex, age, boardingTime, cabin, clothes, name, passengerId, pclass, survived, ticketCost);
	}

	//IGUALDAD
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return Sex == other.Sex && Objects.equals(age, other.age) && Objects.equals(boardingTime, other.boardingTime)
				&& Objects.equals(cabin, other.cabin) && Objects.equals(clothes, other.clothes)
				&& Objects.equals(name, other.name) && Objects.equals(passengerId, other.passengerId)
				&& Objects.equals(pclass, other.pclass) && Objects.equals(survived, other.survived)
				&& Objects.equals(ticketCost, other.ticketCost);
	}


	// ORDEN NATURAL
	@Override    
	public int compareTo(Pasajero o) {
		int r = getName().compareTo(o.getName());
		if (r == 0) {
			r = getPassengerId().compareTo(o.getPassengerId());
			if (r == 0) {
				r = getSurvived().compareTo(o.getSurvived());
				if (r == 0) {
					r = getName().compareTo(o.getName());
					if (r == 0) {
						r = getAge().compareTo(o.getAge());
						if (r == 0) {
							r = getPclass().compareTo(o.getPclass());
							if (r == 0) {
								r = getCabin().compareTo(o.getCabin());
								if (r == 0) {
									r = getSex().compareTo(o.getSex());
									if (r == 0) {
										r = getTicketCost().compareTo(o.getTicketCost());
										if (r == 0) {
											r = getBoardingTime().compareTo(o.getBoardingTime());
											}
										}
									}
								}
							}
						}
					}
				}
			}
		return r;
	}

	
	
}
