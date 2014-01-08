package main.interfaces;

import java.sql.SQLException;

import main.classes.Position;

public interface PositionManagerInt {

	void addPosition(Position position) throws SQLException;
	void deletePosition(Position position) throws SQLException;
	void updateSallary(Position position) throws SQLException;
	void getAll() throws SQLException;
}
