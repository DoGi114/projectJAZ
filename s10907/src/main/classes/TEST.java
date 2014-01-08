package main.classes;

import java.sql.SQLException;
import java.text.ParseException;

import main.implementations.PersonManagerPSQL;
import main.implementations.PositionManagerPSQL;

public class TEST {

	public static void main(String[] args) throws ParseException, SQLException {

		Position c = new Position();
		PositionManagerPSQL d = new PositionManagerPSQL();
		c.setName("Manager");
		c.setSallary(5600);
		d.addPosition(c);
		
		Person a = new Person();
		PersonManagerPSQL b = new PersonManagerPSQL();
		a.setName("Damian");
		a.setSurname("Nguyen");
		a.setPhoneNr(535361034);
		a.setDateOfBirth(b.convertToDate("1993-07-08"));
		a.setPin("93070805734");
		a.setPositionId(1);

		b.addPerson(a);
	}

}
