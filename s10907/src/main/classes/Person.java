package main.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person extends EntitiBase {

	private int id;
	private String name;
	private String Surname;
	private String pin;
	private int phoneNr;
	private int positionId;
	private Date DateOfBirth;
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(int phoneNr) {
		this.phoneNr = phoneNr;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	
	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) throws ParseException {
		this.DateOfBirth = dateOfBirth;
	}

	public Date convertToDate(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dateOfBirth = sdf.parse(date);
		return dateOfBirth;
	}
	
}
