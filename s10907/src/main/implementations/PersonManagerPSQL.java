package main.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;

import main.classes.Person;
import main.dataBase.PSQL;
import main.interfaces.PersonManagerInt;

@RequestScoped
public class PersonManagerPSQL implements PersonManagerInt {

	
	
	
	
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
	public void deletePerson(Person person) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String deletePerson = "DELETE FROM person WHERE name = '"+ person.getName() + "' AND surname = '" + person.getSurname()+"'";
		try {
			dbConnection =  PSQL.getConnection();
			preparedStatement = dbConnection.prepareStatement(deletePerson);
 
			// execute delete SQL stetement
			preparedStatement.executeUpdate();
  
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 		
	}

	@Override
	public void updatePerson(Person person) throws SQLException {
		Connection dbConnection = null;
		java.sql.Statement statement = null;
		try {
			
			dbConnection = PSQL.getConnection();
			statement = dbConnection.createStatement();
			String positionUpdate = "UPDATE person SET phone_number = "+ person.getPhoneNr() +" , pin = "+ person.getPin() +" , date_of_birth = "+ person.getDateOfBirth() +" , position_id = "+ person.getPositionId() +" WHERE surname = "+ person.getSurname() +" AND name = "+ person.getName();
			statement.executeUpdate(positionUpdate); 
 
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
	public void getAll() throws SQLException {
		Connection dbConnection = null;
		java.sql.Statement statement = null;
		String selectCourses = "SELECT id_person, name, surname, date_of_birth, pin, phone_number, position_id FROM person";
		try {
			dbConnection = PSQL.getConnection();
			statement = dbConnection.createStatement(); 
			ResultSet rs = statement.executeQuery(selectCourses);
 
			while (rs.next()) {
 
				int id = rs.getInt("id_person");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				Date date = rs.getDate("date_of_birth");
				String pin = rs.getString("pin");
				int phoneNr = rs.getInt("phone_number");
				int positionId = rs.getInt("position_id");
			}
 
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

	
}
