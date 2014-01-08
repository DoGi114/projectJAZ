package main.beans;

import java.io.Serializable;
import java.sql.SQLException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import main.classes.Person;
import main.implementations.PersonManagerPSQL;

@SessionScoped
@Named("personBean")
public class PersonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Person person = new Person();
	
	@Inject
	private PersonManagerPSQL pm;
	
	public Person getPerson(){
		return person;
	}
	
	public void setPerson(Person person){
		this.person = person;
	}
	
	public void getAll() throws SQLException{
		pm.getAll();
	}
	
	public String addPerson() throws SQLException{
		pm.addPerson(person);
		return null;
	}
	

}
