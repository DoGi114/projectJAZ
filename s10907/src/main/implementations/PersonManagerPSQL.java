package main.implementations;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.classes.Person;
import main.dataBase.PSQL;
import main.interfaces.PersonManagerInt;

public class PersonManagerPSQL implements PersonManagerInt {

	public Date convertToDate(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		Date dateOfBirth = sdf.parse(date);
		return dateOfBirth;
	}
	
	@Override
	public void addPerson(Person person) throws SQLException {
		Connection dbConnection = null;
		java.sql.Statement statement = null;
		try {
			
			dbConnection = PSQL.getConnection();
			statement = dbConnection.createStatement();
			String addPerson = "insert into person(name, surname, date_of_birth, pin, phone_number, position_id) values ('"+ person.getName() +"' , '"+ person.getSurname() +"' , '"+ person.getDateOfBirth()  +"' , '"+ person.getPin()  +"' , '"+ person.getPhoneNr()  +"' , '"+ person.getPositionId() +"')";    
			statement.executeUpdate(addPerson);  
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
		
	}

	@Override
	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}

	
}
