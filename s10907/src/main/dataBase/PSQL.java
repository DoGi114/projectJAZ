package main.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PSQL {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/JAZPROJEKT";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "dq9rh1b";
	
	public static Connection getConnection(){
		Connection dbConnection = null;
		try{
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
	}
	
	
}
