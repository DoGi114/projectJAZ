package main.interfaces;

import java.sql.SQLException;

import main.classes.Position;

public interface PositionManagerInt {

	void addPosition(Position position) throws SQLException;
	void deletePosition(Position position);
	void updatePosition(Position position);
	void getAll();
}
