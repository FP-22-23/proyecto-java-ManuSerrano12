package fp.pasajero;

import java.time.LocalTime;

import fp.common.Genero;

public class Pasajero {
	
	//ATRIBUTOS
	private Integer passengerId;
	private Boolean survived;
	private Integer pclass, age;
	private String name, ticketN,cabin;
	private Genero Sex;
	private LocalTime boardingTime;

	//CONSTRUCTOR Y RESTRICCIONES
	public Pasajero(Integer passengerId, String name , Boolean survived,Integer pclass,Integer age, String ticketN, 
			String cabin, Genero sex, LocalTime boardingTime) {
		this.passengerId = passengerId;
		this.survived = survived;
		this.pclass = pclass;
		this.age = age;
		this.name = name;
		this.ticketN = ticketN;
		this.cabin = cabin;
		this.Sex = sex;
		this.boardingTime = boardingTime;
	}
	
	
	//PROPIEDADES DERIVADAS
	public Integer getHourBoarding() {
		return this.boardingTime.getHour();
	}
	

	
	
	//METODO TOSTRING
	@Override
	public String toString() {
		return "Pasajero [passengerId=" + passengerId + ", survived=" + survived + ", pclass=" + pclass + ", age=" + age
				+ ", name=" + name + ", ticketN=" + ticketN + ", cabin=" + cabin + ", Sex=" + Sex + ", boardingTime="
				+ boardingTime + "]";
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

	public String getTicketN() {
		return ticketN;
	}

	public void setTicketN(String ticketN) {
		this.ticketN = ticketN;
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
	
	
	
	
}
