package main.interfaces;

import java.sql.SQLException;

import main.classes.Person;

public interface PersonManagerInt {

	void addPerson(Person person) throws SQLException;
	void deletePerson(Person person);
	void updatePerson(Person person);
	void getAll();
}

