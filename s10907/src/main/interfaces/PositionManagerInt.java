package main.interfaces;

import java.sql.SQLException;
import java.util.List;

import javax.faces.model.ListDataModel;

import main.classes.Position;

public interface PositionManagerInt {

	void addPosition(Position position) throws SQLException;
	void deletePosition(Position position) throws SQLException;
	void updateSallary(Position position) throws SQLException;
	List<Position> getAll() throws SQLException;
}
