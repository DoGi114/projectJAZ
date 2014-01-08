package main.implementations;

import java.sql.Connection;
import java.sql.SQLException;

import main.classes.Position;
import main.dataBase.PSQL;
import main.interfaces.PositionManagerInt;

public class PositionManagerPSQL implements PositionManagerInt {

	@Override
	public void addPosition(Position position) throws SQLException {
		Connection dbConnection = null;
		java.sql.Statement statement = null;
		try {
			
			dbConnection = PSQL.getConnection();
			statement = dbConnection.createStatement();
			String addPosition = "insert into position(name, sallary) values ('"+ position.getName() +"' , '"+ position.getSallary()  +"')";    
			statement.executeUpdate(addPosition);  
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
	public void deletePosition(Position position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePosition(Position position) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub

	}

}
